package com.example;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;



@SpringBootApplication
public class SpringbootProfileDemoApplication implements CommandLineRunner {
@Autowired
Environment environment;
private static final Log LOGGER=LogFactory.getLog(SpringbootProfileDemoApplication.class);
public static void main(String[] args) {
SpringApplication.run(SpringbootProfileDemoApplication.class, args);
}



@Override
public void run(String... args) throws Exception {
// TODO Auto-generated method stub
System.out.println(environment.getProperty("message"));
LOGGER.info(environment.getProperty("message"));

}



}