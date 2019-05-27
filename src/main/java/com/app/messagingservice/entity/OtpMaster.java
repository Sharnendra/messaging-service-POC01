package com.app.messagingservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OTP_MASTER")
public class OtpMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="OTP_ID")
	private long otpId;
	
	@Column(name="SAP_CODE")
	private String sapCode;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="UUID")
	private String uuid;
	
	@Column(name="OTP_VALUE")
	private int otpValue;
	
	@Column(name="CREATION_TIME")
	private Date creationTime;
	
	@Column(name="EXPIRE_TIME")
	private Date expireTime;

	public OtpMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OtpMaster(long otpId, String sapCode, String mobileNumber, String uuid, int otpValue, Date creationTime,
			Date expireTime) {
		super();
		this.otpId = otpId;
		this.sapCode = sapCode;
		this.mobileNumber = mobileNumber;
		this.uuid = uuid;
		this.otpValue = otpValue;
		this.creationTime = creationTime;
		this.expireTime = expireTime;
	}

	public long getOtpId() {
		return otpId;
	}

	public void setOtpId(long otpId) {
		this.otpId = otpId;
	}

	public String getSapCode() {
		return sapCode;
	}

	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString() {
		return "OtpEntity [otpId=" + otpId + ", sapCode=" + sapCode + ", mobileNumber=" + mobileNumber + ", uuid="
				+ uuid + ", otpValue=" + otpValue + ", creationTime=" + creationTime + ", expireTime=" + expireTime
				+ "]";
	}

}
