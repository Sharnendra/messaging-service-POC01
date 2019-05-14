package com.app.messagingservice.repository;

import java.util.Random;

public interface OTP_intefarce {
	
	default int getOpt()
	{
		return new Random().ints(100000,(999999+1)).findFirst().getAsInt();
	}

}
