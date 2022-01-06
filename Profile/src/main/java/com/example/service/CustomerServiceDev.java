package com.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")

public class CustomerServiceDev {
	private static final Log LOGGER=LogFactory.getLog(CustomerServiceDev.class);

	public CustomerServiceDev() {
		LOGGER.info("CustomerServiceDev initilized");
		// TODO Auto-generated constructor stub
	}
	
	
	

}
