package com.app.messagingservice.service;

import java.net.URLEncoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messagingservice.bean.OtpDetailsReqBean;
import com.app.messagingservice.bean.OtpValidationReqBean;
import com.app.messagingservice.config.MessagingConfig;
import com.app.messagingservice.entity.OtpEntity;
import com.app.messagingservice.repository.OTP_intefarce;
import com.app.messagingservice.repository.OtpRepository;

@Service
public class MessagingService implements OTP_intefarce{
	
	@Autowired
	private MessagingConfig smsConfig;
	
	@Autowired
	private OtpRepository otpRepo;
	private OtpEntity otpEntity;
	
	public String sendSMSOnPhone(OtpDetailsReqBean otpDetailsReqBean) {
		if(saveOTP(otpDetailsReqBean))
		{
			try {
				// Send data
				return "http://api.textlocal.in/send/?" 
				+ "apikey=" + URLEncoder.encode(smsConfig.getApiKey(), "UTF-8") 
				+ "&numbers=" + URLEncoder.encode(otpDetailsReqBean.getMobile_number(), "UTF-8") 
				+ "&message=" + URLEncoder.encode("Your OTP is "+otpEntity.getOtpValue()+"!! Please do not share with anyone else.", "UTF-8");
			} catch (Exception e) {
				System.out.println("Error SMS "+e);
				return "Error "+e;
			}
		}
		else
		{
			throw new RuntimeException("ERROR OCCURED WHILE GENERATING OTP!!");
		}
	}
	
	private boolean saveOTP(OtpDetailsReqBean otpDetailsReqBean) {
		OtpEntity otpEntity= new OtpEntity();
		otpEntity.setSapCode(otpDetailsReqBean.getSap_code());
		otpEntity.setOtpValue(getOpt());
		otpEntity.setMobileNumber(otpDetailsReqBean.getMobile_number());
		otpEntity.setUuid(otpDetailsReqBean.getUuid());
		otpEntity.setCreationTime(new Date());
		otpEntity.setExpireTime(new Date(System.currentTimeMillis()+5*60*1000));
		if(otpRepo.save(otpEntity)!=null) {
			this.otpEntity=otpEntity;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validateOtp(OtpValidationReqBean otpdetails) {
		OtpEntity otpEntity=otpRepo.findByUserId(otpdetails.getSap_code(),otpdetails.getUuid(),otpdetails.getOtpValue());
		if(otpEntity!=null) {
			if (otpdetails.getOtpValue()==otpEntity.getOtpValue()) {
				System.err.println("df d "+otpdetails.getOtpValue());
				System.err.println("dfd "+otpEntity.getOtpValue());
				return true;
			}
		}
		return false;
	}
	
	
	

}
