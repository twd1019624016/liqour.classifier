package classifier.detection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import classifier.detection.liqour.LiqourClassifier;
import classifier.detection.liqour.LiqourDetectRequest;
import classifier.detection.liqour.LiqourDetectResponse;
import classifier.detection.liqour.SampleStandard;

public class ClassifierFacade implements Classifier<LiqourDetectRequest, LiqourDetectResponse, SampleStandard> {
	
	private static LiqourClassifier liqourClassifier = new LiqourClassifier();
	private static List<SampleStandard> listSampleStandard = new ArrayList<>();
	private String path;
	
	private volatile static ClassifierFacade classifierFacade;
	
	public static ClassifierFacade getInstanceClassifierFacade(String path) {
		if(null == classifierFacade) {
			synchronized (ClassifierFacade.class) {
                if (null == classifierFacade) {
                	classifierFacade = new ClassifierFacade(path);
                }
            }
			
		}
		return classifierFacade;
	}
	
	private ClassifierFacade(String path) {
		super();
		this.path = path;
		SampleStandard sampleStandard;
		List<String> list = new ArrayList<>();
	
		if (new File(path).exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				String stemp;
				while ((stemp = reader.readLine()) != null) {
					list.add(stemp);
				}

				list.remove(0);
				for (String sampleString : list) {
					if(null == sampleString || "".equals(sampleString.trim())){
						continue;
					}
					String[] split = sampleString.split(",");
					sampleStandard = new SampleStandard();
					sampleStandard.setSampleName(split[0]);
					sampleStandard.setSampleID(Integer.parseInt(split[1]));
					sampleStandard.setMesureEquipID(Integer.parseInt(split[2]));
					sampleStandard.setVoltage265nmAvg(Double.parseDouble(split[3]));
					sampleStandard.setVoltage265nmStd(Double.parseDouble(split[4]));
					sampleStandard.setVoltage280nmAvg(Double.parseDouble(split[5]));
					sampleStandard.setVoltage280nmStd(Double.parseDouble(split[6]));
					sampleStandard.setVoltage310nmAvg(Double.parseDouble(split[7]));
					sampleStandard.setVoltage310nmStd(Double.parseDouble(split[8]));
					listSampleStandard.add(sampleStandard);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public LiqourDetectResponse detect(LiqourDetectRequest t) {
		return liqourClassifier.detect(t, listSampleStandard);
	}

	@Override
	public LiqourDetectResponse detect(LiqourDetectRequest t, List<SampleStandard> source) {
		return liqourClassifier.detect(t, source);
	}
}
