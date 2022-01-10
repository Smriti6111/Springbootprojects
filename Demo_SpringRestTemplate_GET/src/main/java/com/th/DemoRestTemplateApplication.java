package com.th;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.th.dto.CustomerDTO;

@SpringBootApplication
public class DemoRestTemplateApplication implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(DemoRestTemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoRestTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getCustomerDetails(2);
	}

	public void getCustomerDetails(Integer customerId) {
		String url = "http://localhost:8765/thbank/customers/{customerId}";
		RestTemplate restTemplate = new RestTemplate();
		CustomerDTO customerDTO = restTemplate.getForObject(url, CustomerDTO.class, customerId);
		LOGGER.info(customerDTO);
		LOGGER.info("\n");
	}

}