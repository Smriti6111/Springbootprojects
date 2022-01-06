package com.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Test")

public class CustomerServiceTest {
	private static final Log LOGGER=LogFactory.getLog(CustomerServiceTest.class);

	public CustomerServiceTest() {
		LOGGER.info("CustomerServiceProd initilized");
		// TODO Auto-generated constructor stub
	}
	

}
