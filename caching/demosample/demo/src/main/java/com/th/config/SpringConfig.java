package com.th.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.th.model.WelcomeBean;

@Configuration
public class SpringConfig {

	
	@Bean(value = "test")
	public WelcomeBean welcomeBean()
	{
		return new WelcomeBean();
	}
	
	/*
	 * @Bean public com.th.services.CustomerServiceImpl CustomerRepo() { return new
	 * com.th.services.CustomerServiceImpl();
	 * 
	 * }
	 */
}
