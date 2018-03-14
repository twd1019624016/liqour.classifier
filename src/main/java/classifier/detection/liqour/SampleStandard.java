package classifier.detection.liqour;

/**
 * SampleName string 酒品名称 SampleID int32 酒品ID 265nmAvg double 265纳米电压均值简称m1
 * 280nmAvg double 280纳米电压均值简称m2 310nmAvg double 310纳米电压均值简称m3 265nmStd double
 * 265纳米电压方差简称s1 280nmStd double 280纳米电压方差简称s2 310nmStd double 310纳米电压方差简称s3
 * mesureEquipID int32 测试设备编号
 * 
 * 
 */
public class SampleStandard {

	/**
	 * 酒品名称
	 */
	private String sampleName;
	/**
	 * 酒品ID
	 */
	private Integer sampleID;
	
	/**
	 * mesureEquipID int32 测试设备编号
	 */
	private Integer mesureEquipID;

	/**
	 * 265nmAvg double 265纳米电压均值简称m1
	 */
	private Double voltage265nmAvg;
	/**
	 * 280nmAvg double 280纳米电压均值简称m2
	 */
	private Double voltage280nmAvg;
	/**
	 * 310nmAvg double 310纳米电压均值简称m3
	 */
	private Double voltage310nmAvg;

	/**
	 * 265nmStd double 265纳米电压方差简称s1
	 */
	private Double voltage265nmStd;
	/**
	 * 280nmStd double 280纳米电压方差简称s2
	 */
	private Double voltage280nmStd;
	/**
	 * 310nmStd double 310纳米电压方差简称s3
	 */
	private Double voltage310nmStd;
	

	public SampleStandard() {
		super();
	}

	

	public SampleStandard(String sampleName, Integer sampleID, Integer mesureEquipID, Double voltage265nmAvg,
			Double voltage280nmAvg, Double voltage310nmAvg, Double voltage265nmStd, Double voltage280nmStd,
			Double voltage310nmStd) {
		super();
		this.sampleName = sampleName;
		this.sampleID = sampleID;
		this.mesureEquipID = mesureEquipID;
		this.voltage265nmAvg = voltage265nmAvg;
		this.voltage280nmAvg = voltage280nmAvg;
		this.voltage310nmAvg = voltage310nmAvg;
		this.voltage265nmStd = voltage265nmStd;
		this.voltage280nmStd = voltage280nmStd;
		this.voltage310nmStd = voltage310nmStd;
	}



	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public Integer getSampleID() {
		return sampleID;
	}

	public void setSampleID(Integer sampleID) {
		this.sampleID = sampleID;
	}

	public Double getVoltage265nmAvg() {
		return voltage265nmAvg;
	}

	public void setVoltage265nmAvg(Double voltage265nmAvg) {
		this.voltage265nmAvg = voltage265nmAvg;
	}

	public Double getVoltage280nmAvg() {
		return voltage280nmAvg;
	}

	public void setVoltage280nmAvg(Double voltage280nmAvg) {
		this.voltage280nmAvg = voltage280nmAvg;
	}

	public Double getVoltage310nmAvg() {
		return voltage310nmAvg;
	}

	public void setVoltage310nmAvg(Double voltage310nmAvg) {
		this.voltage310nmAvg = voltage310nmAvg;
	}

	public Double getVoltage265nmStd() {
		return voltage265nmStd;
	}

	public void setVoltage265nmStd(Double voltage265nmStd) {
		this.voltage265nmStd = voltage265nmStd;
	}

	public Double getVoltage280nmStd() {
		return voltage280nmStd;
	}

	public void setVoltage280nmStd(Double voltage280nmStd) {
		this.voltage280nmStd = voltage280nmStd;
	}

	public Double getVoltage310nmStd() {
		return voltage310nmStd;
	}

	public void setVoltage310nmStd(Double voltage310nmStd) {
		this.voltage310nmStd = voltage310nmStd;
	}

	public Integer getMesureEquipID() {
		return mesureEquipID;
	}

	public void setMesureEquipID(Integer mesureEquipID) {
		this.mesureEquipID = mesureEquipID;
	}

	@Override
	public String toString() {
		return "SampleStandard [sampleName=" + sampleName + ", sampleID=" + sampleID + ", voltage265nmAvg="
				+ voltage265nmAvg + ", voltage280nmAvg=" + voltage280nmAvg + ", voltage310nmAvg=" + voltage310nmAvg
				+ ", voltage265nmStd=" + voltage265nmStd + ", voltage280nmStd=" + voltage280nmStd + ", voltage310nmStd="
				+ voltage310nmStd + ", mesureEquipID=" + mesureEquipID + "]";
	}

	
}
