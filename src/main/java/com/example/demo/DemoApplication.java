package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.util.Random;
import java.util.concurrent.locks.Lock;

@SpringBootApplication
public class DemoApplication {


	@Bean
	public IRandom getRandom(){
		return new LockRandom();
	}

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		//ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext context =  new SpringApplicationBuilder()
				.sources(DemoApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

//		GreetingComponent greeting = context.getBean(GreetingComponent.class);
//		greeting.sayHi("Tomz");

//		String[] beans = context.getBeanDefinitionNames();
//		System.out.println("-------BEAN NAMES------");
//		for (String bean : beans) {
//			System.out.println(bean);
//		}
//		System.out.println("-------------");
//
//		int beanCount = context.getBeanDefinitionCount();
//		System.out.println(beanCount);

//		Lottery lottery = context.getBean(Lottery.class);
//		System.out.println("Lottery -> " +  lottery.lotto());

	}

}
