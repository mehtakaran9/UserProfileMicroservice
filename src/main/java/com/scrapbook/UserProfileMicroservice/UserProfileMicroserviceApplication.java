package com.scrapbook.UserProfileMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UserProfileMicroserviceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UserProfileMicroserviceApplication.class, args);
	}

}

