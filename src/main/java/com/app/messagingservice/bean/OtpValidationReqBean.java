package com.app.messagingservice.bean;

public class OtpValidationReqBean {

	private String sap_code;
	private String mobile_number;
	private String uuid;
	private int otpValue;
	
	public OtpValidationReqBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OtpValidationReqBean(String sap_code, String mobile_number, String uuid, int otpValue) {
		super();
		this.sap_code = sap_code;
		this.mobile_number = mobile_number;
		this.uuid = uuid;
		this.otpValue = otpValue;
	}
	
	public String getSap_code() {
		return sap_code;
	}
	public void setSap_code(String sap_code) {
		this.sap_code = sap_code;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getOtpValue() {
		return otpValue;
	}
	public void setOtpValue(int otpValue) {
		this.otpValue = otpValue;
	}
	
	@Override
	public String toString() {
		return "OtpValidationReqBean [sap_code=" + sap_code + ", mobile_number=" + mobile_number + ", uuid=" + uuid
				+ ", otpValue=" + otpValue + "]";
	}	
	
}
