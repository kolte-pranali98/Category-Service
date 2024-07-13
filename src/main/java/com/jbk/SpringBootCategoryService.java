package com.jbk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class SpringBootCategoryService {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCategoryService.class, args);
	}

}
