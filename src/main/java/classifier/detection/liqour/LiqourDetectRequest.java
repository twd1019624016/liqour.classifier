package classifier.detection.liqour;

import classifier.detection.DetectRequest;

/**
 * 检测数据 
 * voltage265nm double 265纳米电压 
 * voltage280nm double 280纳米电压 
 * voltage310nm double 310纳米电压 
 * mesureEquipID int32 测试设备编号
 *
 * 
 */
public class LiqourDetectRequest extends DetectRequest {
	
	/**
	 * 酒品ID
	 */
	private Integer sampleID;
	/**
	 * mesureEquipID int32 测试设备编号
	 * 
	 */
	private Integer mesureEquipID;
	/**
	 * voltage265nm double 265纳米电压
	 */
	private Double voltage265nm;
	/**
	 * voltage280nm double 280纳米电压
	 */
	private Double voltage280nm;
	/**
	 * voltage310nm double 310纳米电压
	 */
	private Double voltage310nm;
	
	public LiqourDetectRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LiqourDetectRequest(Integer sampleID, Integer mesureEquipID, Double voltage265nm, Double voltage280nm,
			Double voltage310nm) {
		super();
		this.sampleID = sampleID;
		this.mesureEquipID = mesureEquipID;
		this.voltage265nm = voltage265nm;
		this.voltage280nm = voltage280nm;
		this.voltage310nm = voltage310nm;
	}

	
	public Integer getSampleID() {
		return sampleID;
	}

	public void setSampleID(Integer sampleID) {
		this.sampleID = sampleID;
	}

	public Integer getMesureEquipID() {
		return mesureEquipID;
	}

	public void setMesureEquipID(Integer mesureEquipID) {
		this.mesureEquipID = mesureEquipID;
	}

	public Double getVoltage265nm() {
		return voltage265nm;
	}

	public void setVoltage265nm(Double voltage265nm) {
		this.voltage265nm = voltage265nm;
	}

	public Double getVoltage280nm() {
		return voltage280nm;
	}

	public void setVoltage280nm(Double voltage280nm) {
		this.voltage280nm = voltage280nm;
	}

	public Double getVoltage310nm() {
		return voltage310nm;
	}

	public void setVoltage310nm(Double voltage310nm) {
		this.voltage310nm = voltage310nm;
	}

	@Override
	public String toString() {
		return "LiqourDetectRequest [sampleID=" + sampleID + ", mesureEquipID=" + mesureEquipID + ", voltage265nm="
				+ voltage265nm + ", voltage280nm=" + voltage280nm + ", voltage310nm=" + voltage310nm + "]";
	}
	
	
	

}
