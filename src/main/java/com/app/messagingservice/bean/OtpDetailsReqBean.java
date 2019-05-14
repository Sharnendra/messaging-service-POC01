package com.app.messagingservice.bean;

public class OtpDetailsReqBean {

	private String sap_code;
	private String mobile_number;
	private String uuid;

	public String getSap_code() {
		return sap_code;
	}

	public void setSap_code(String userId) {
		this.sap_code = userId;
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

	@Override
	public String toString() {
		return "OtpDetails [sap_code=" + sap_code + ", mobile_number=" + mobile_number
				+ ", uuid=" + uuid + "]";
	}
	
	
}
