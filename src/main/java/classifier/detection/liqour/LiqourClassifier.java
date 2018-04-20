package classifier.detection.liqour;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;

import classifier.detection.Classifier;

public class LiqourClassifier implements Classifier<LiqourDetectRequest, LiqourDetectResponse, SampleStandard> {

	/*
	 * (non-Javadoc) 2、 按照设备编号获取标准谱列表。包括三个波长的均值及方差； 3、
	 * 归一化。记输入为(x1,x2,x3)，归一化后为(y1,y2,y3)。其中yi = (xi-mi)/si； 4、 计算欧氏距离，d； 5、
	 * 换算相似度。L=1- inverseNormPDF(d)^p。这里的inverseNormalPDF是正态分布函数的反函数,P暂定8，会调整 6、
	 * 根据Threshold值，过滤L小于阈值的标准品。然后从大到小排列；阈值暂定0.17 7、
	 * 输出列表中第一位的标准品（酒）名称或者ID，同时输出L； 8、 返回名称或ID到移动设备；
	 * 
	 */
	@Override
	public LiqourDetectResponse detect(LiqourDetectRequest request, List<SampleStandard> source) {

		return match(request, source);

	}

	private LiqourDetectResponse match(LiqourDetectRequest request, List<SampleStandard> source) {
		LiqourDetectResponse detectResponse = new LiqourDetectResponse();
		try {
			// 2、 按照设备编号获取标准谱列表。包括三个波长的均值及方差；
			List<SampleStandard> list = equipSampleStandard(request, source);

			SampleStandard sample = null;
			double l = 0.0;
			for (SampleStandard sampleStandard : list) {
				// 相似度
				double standard = calcUclideanMetric(request, sampleStandard);
				if (standard > l) {
					l = standard;
					sample = sampleStandard;
				}
			}

			// 7、 输出列表中第一位的标准品（酒）名称或者ID，同时输出L；
			// 8、 返回名称或ID到移动设备；
			if (null != sample && l >= 0.25) {
				detectResponse.setCode(Boolean.TRUE);
				detectResponse.setMessage(sample.getSampleID().toString());
				detectResponse.setMatchingDegree(l);
			} else {
				detectResponse.setMessage("样品不在库中");
				detectResponse.setMatchingDegree(l);
			}
			return detectResponse;

		} catch (Exception e) {

			detectResponse.setMessage("匹配出错");
			detectResponse.setMatchingDegree(0.00);
		}
		return detectResponse;
	}

	/*
	 * private LiqourDetectResponse matchSimpleId(LiqourDetectRequest request,
	 * List<SampleStandard> source) { LiqourDetectResponse detectResponse = new
	 * LiqourDetectResponse(); try { List<SampleStandard> list =
	 * equipSampleStandard(request, source);
	 * 
	 * SampleStandard sample = null; for (SampleStandard sampleStandard : list)
	 * { if(sampleStandard.getSampleID().compareTo(request.getSampleID())==0){
	 * sample = sampleStandard; } } if(null == sample) {
	 * detectResponse.setMessage("样品不在库中"); return detectResponse; } //欧式距离
	 * double l = calcUclideanMetric(request, sample); // 6、
	 * 根据Threshold值，过滤L小于阈值的标准品。然后从大到小排列；阈值暂定0.17 if(l<0.25) {
	 * detectResponse.setMessage("匹配度太低"); return detectResponse; } // 7、
	 * 输出列表中第一位的标准品（酒）名称或者ID，同时输出L； // 8、 返回名称或ID到移动设备；
	 * detectResponse.setCode(true);
	 * detectResponse.setMessage(sample.getSampleName());
	 * detectResponse.setMatchingDegree(l);
	 * 
	 * return detectResponse;
	 * 
	 * } catch (Exception e) {
	 * 
	 * detectResponse.setMessage("匹配出错"); } return detectResponse; }
	 */
	private List<SampleStandard> equipSampleStandard(LiqourDetectRequest request, List<SampleStandard> source) {
		List<SampleStandard> list = new ArrayList<>();

		for (SampleStandard sampleStandard : source) {
			if (sampleStandard.getMesureEquipID().compareTo(request.getMesureEquipID()) == 0) {
				list.add(sampleStandard);
			}
		}
		return list;
	}

	private double calcUclideanMetric(LiqourDetectRequest request, SampleStandard sample) {
		// 3、 归一化。记输入为(x1,x2,x3)，归一化后为(y1,y2,y3)。其中yi = (xi-mi)/si；
		double voltage265nm = (request.getVoltage265nm() - sample.getVoltage265nmAvg()) / sample.getVoltage265nmStd();
		double voltage280nm = (request.getVoltage280nm() - sample.getVoltage280nmAvg()) / sample.getVoltage280nmStd();
		double voltage310nm = (request.getVoltage310nm() - sample.getVoltage310nmAvg()) / sample.getVoltage310nmStd();

		// 4、 计算欧氏距离，d；( 3 改为 /12--->48--->12--->48)

		double d = Math.sqrt((Math.pow(voltage265nm, 2) + Math.pow(voltage280nm, 2) + Math.pow(voltage310nm, 2)) / 48);
		// 5、 换算相似度。L=1-
		// (inverseNormPDF(d)*2-1)^p。这里的inverseNormalPDF是正态分布函数,P暂定6，会调整
		NormalDistribution normalDistributioin = new NormalDistribution(0, 1);
		double cumulativeProbability = normalDistributioin.cumulativeProbability(d) * 2 - 1;
		double pow = Math.pow(cumulativeProbability, 6);
		double l = 1 - pow;
		return l;
	}

}
