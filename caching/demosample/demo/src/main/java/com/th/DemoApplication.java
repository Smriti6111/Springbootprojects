package com.th;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import com.th.config.Msgprop;
import com.th.config.SpringConfig;
import com.th.model.Customer;
import com.th.model.WelcomeBean;
import com.th.services.CustomerServiceImpl;
import com.th.services.CustomerService;
@EnableCaching
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	CustomerService customerservice;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Customer cust=customerservice.getCustName(0);
		
		System.out.println(cust);
	}
	 }