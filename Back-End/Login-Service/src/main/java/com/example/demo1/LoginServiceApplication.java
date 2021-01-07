package com.example.demo1;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

import com.example.demo1.repository.UserRepository;

@SpringBootApplication
@EnableWebSecurity
@EnableEurekaClient
@EnableFeignClients("com")
@ComponentScan(basePackages="com")
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
