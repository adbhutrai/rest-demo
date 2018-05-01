package com.adbhut.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${app.user.name}")
	private String user;

	@Value("${app.user.password}")
	private String password;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @// @formatter:off
		auth.inMemoryAuthentication()
		.withUser(user).password(password).roles("USER", "ACTUATOR")
		.and()
		 .withUser("admin")
         .password("admin")
         .roles("USER", "ADMIN");
		// @formatter:on
		//super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//@// @formatter:off
		httpSecurity
		.authorizeRequests().antMatchers("/", "/swagger-resources").permitAll()
		.antMatchers("/products/**").authenticated()
		.and()
        .httpBasic();
		// @formatter:on
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
	}
}
