package classifier.detection.liqour;

import classifier.detection.DetectResponse;

/**

 */
public class LiqourDetectResponse extends DetectResponse {

	private Boolean code = Boolean.FALSE;
	private String message = "没有匹配到已知品牌";
	private Double matchingDegree;
	public Boolean getCode() {
		return code;
	}
	public void setCode(Boolean code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Double getMatchingDegree() {
		return matchingDegree;
	}
	public void setMatchingDegree(Double matchingDegree) {
		this.matchingDegree = matchingDegree;
	}
	@Override
	public String toString() {
		return "LiqourDetectResponse [code=" + code + ", message=" + message + ", matchingDegree=" + matchingDegree
				+ "]";
	}
	
	
	
}
