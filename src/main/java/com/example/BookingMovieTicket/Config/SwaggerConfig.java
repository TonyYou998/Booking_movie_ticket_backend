package com.example.BookingMovieTicket.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.BookingMovieTicket"))
				.build()
				.apiInfo(apiInfo());
				
		
		
	}
	
	private ApiInfo apiInfo() {
		return  new ApiInfoBuilder()
				.title("Booking movie ticket api")
				.description("Booking movie ticket api for booking movie ticket web")
				.contact(new Contact( "Tan Vuu", "Hi, i'm a software engineer", "tanvuu998@gmail.com"))
				.license("MIT")
				.build();
		
	}

	
	
}
