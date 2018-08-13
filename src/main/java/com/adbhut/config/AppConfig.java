package com.adbhut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class AppConfig {
	@Bean
	public UriComponentsBuilder uriBuilder() {
		return UriComponentsBuilder.fromPath("Location:/products");
	}
	
	@Bean
	public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
	    return new CustomRestTemplateCustomizer();
	}
	
}
