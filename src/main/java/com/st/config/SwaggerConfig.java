package com.st.config;

import  static springfox.documentation.builders.PathSelectors.regex;
import  static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket  configDocket() {		
			return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(basePackage("com.st.controller.rest"))
			.paths(regex("/rest.*"))
			.build()
			.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RITURAJ SOLUTIONS...")
				.description("Devloped Highly Secured App...")
				.contact(new Contact("Rituraj", "https://nareshit.in/course-schedule/", "Riturajrawat123gmail.com"))
				.license("Apache-2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.version("2.0.0")
				.build()
				;	
	}	
}
