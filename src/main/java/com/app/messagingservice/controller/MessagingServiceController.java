package com.app.messagingservice.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.messagingservice.bean.OtpDetailsReqBean;
import com.app.messagingservice.bean.OtpValidationReqBean;
import com.app.messagingservice.service.MessagingService;

@RestController
public class MessagingServiceController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(MessagingServiceController.class);
	
	@Autowired
	private MessagingService messageService;
	
	@GetMapping("/getSmS")
	public String startApp()
	{
		return "APP IS RUNNING!!";
	}
	

	@PostMapping("/sendSMS")
    public ResponseEntity<String> sendSMSOnPhone(@RequestBody OtpDetailsReqBean otpDetailsReqBean) 
	{
		log.info("=================in sendSMSOnPhone line 1 ==============");
		//SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
		log.info("=================in sendSMSOnPhone line 2 ==============");
		//Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.cognizant.com", 6050));
		log.info("=================in sendSMSOnPhone line 3 ==============");
		//clientHttpReq.setProxy(proxy);
		log.info("=================in sendSMSOnPhone line 4 ==============");
		//RestTemplate restTemplate = new RestTemplate(clientHttpReq);
		RestTemplate restTemplate = new RestTemplate();
		log.info("=================in sendSMSOnPhone line 5 ==============");
		ResponseEntity<String> response=null;
		try
		{
			log.info("=================in sendSMSOnPhone try 1 ==============");
			response=restTemplate.exchange(messageService.sendSMSOnPhone(otpDetailsReqBean),
			HttpMethod.GET, getHeaders(),String.class);
			log.info("=================in sendSMSOnPhone try 1 ==============");
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
        return new ResponseEntity<String>(response.getBody(), HttpStatus.OK);
    }
	
	
	@RequestMapping(value="/validateOtp",method=RequestMethod.POST)
	public ResponseEntity<String> generateOtp(@RequestBody OtpValidationReqBean otpdetails){
		if(messageService.validateOtp(otpdetails)) {
			return new ResponseEntity<String>("Otp successfully validated!!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Otp is Not valid!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	private static org.springframework.http.HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new org.springframework.http.HttpEntity<>(headers);
	}

}
