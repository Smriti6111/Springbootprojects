package com.th.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.th.model.CustomerRepositoryImpl;
import com.th.model.WelcomeModel;

@Configuration
public class SpringConfig {
	@Bean(value = "test")
    public WelcomeModel welcomeBean() {
        return new WelcomeModel();
    }
 
    @Bean
    public CustomerRepositoryImpl customerRepository() {
        return new CustomerRepositoryImpl();
    }

}
