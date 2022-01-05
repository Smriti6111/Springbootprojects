package com.th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;

import com.th.config.MsgProp;
import com.th.config.SpringConfig;
import com.th.model.CustomerRepositoryImpl;
import com.th.model.WelcomeModel;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(MsgProp.class);
      CustomerRepositoryImpl w1 = ctx.getBean(CustomerRepositoryImpl.class);
      WelcomeModel w13 = ctx.getBean(WelcomeModel.class);
      w1.setName("c");
      CustomerRepositoryImpl w2 = ctx.getBean(CustomerRepositoryImpl.class);
       
       WelcomeModel t = (WelcomeModel) ctx.getBean("test");
       w2.setName("d");
       System.out.print(w1 == w2);
       System.out.println(" " + w1.equals(w13));

		Environment environment = ctx1.getEnvironment();
        System.out.println(environment.getProperty("fruit")); 
//        System.out.println(environment.getProperty("test"));
        

        
        


		
	}

}
