package com.adbhut.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.adbhut.rest"))
				.paths(regex("/product.*"))
				.build()
				.apiInfo(metaData());
		// @formatter:on

		
	}

	private ApiInfo metaData() {
		
	    // @formatter:off
	    return new ApiInfoBuilder()
	            .title("Spring Boot REST API")
	            .description("Spring Boot REST API for Online Store")
	            .termsOfServiceUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Adbhut Rai", "https://springframework.guru/about/", "adbhut.rai@gmail.com"))
	            .version("1.0")
	            .build();
	    // @formatter:on
		}

}