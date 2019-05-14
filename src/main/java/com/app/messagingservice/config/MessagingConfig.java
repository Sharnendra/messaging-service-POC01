package com.app.messagingservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessagingConfig {

	@Value("${smsconfig-apikey}")
	private String apiKey;
	
	@Override
	public String toString() {
		return "SmsConfig [apiKey=" + apiKey + "]";
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
}
