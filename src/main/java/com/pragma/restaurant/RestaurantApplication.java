package com.pragma.restaurant;

import com.pragma.restaurant.application.mapper.feign.SecurityFeignRequestInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	/*@Bean
	public RequestInterceptor securityFeignRequestInterceptor() {
		return new SecurityFeignRequestInterceptor();
	}*/
}
