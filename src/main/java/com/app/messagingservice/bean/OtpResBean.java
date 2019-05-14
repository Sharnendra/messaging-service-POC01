package com.app.messagingservice.bean;

public class OtpResBean {
	
	private String status_code;
	private String message;
	public OtpResBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OtpResBean(String status_code, String message) {
		super();
		this.status_code = status_code;
		this.message = message;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OtpGeneratorResBean [status_code=" + status_code + ", message=" + message + "]";
	}

}
