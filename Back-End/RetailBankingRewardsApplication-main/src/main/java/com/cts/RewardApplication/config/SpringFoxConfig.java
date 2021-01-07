package com.cts.RewardApplication.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequestMapping("/rewards")
public class SpringFoxConfig {

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com")).build().apiInfo(apiDetails());
	}

	public ApiInfo apiDetails() {
		return new ApiInfo("Rewards Micro Service", "documentaion", "2.0", "Free",
				new springfox.documentation.service.Contact("Rewards", "url", "xyz@xyz.com"), "license", "url",
				Collections.emptyList());
	}

}