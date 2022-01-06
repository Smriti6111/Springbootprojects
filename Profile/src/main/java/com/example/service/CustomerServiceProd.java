package com.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Prod")

public class CustomerServiceProd {
	private static final Log LOGGER=LogFactory.getLog(CustomerServiceProd.class);

	public CustomerServiceProd() {
		LOGGER.info("CustomerServiceProd initilized");
		// TODO Auto-generated constructor stub
	}
	
	

}
