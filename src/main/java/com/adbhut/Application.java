package com.adbhut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
//health check and readiness check detail is at following URL: http://zavyn.blogspot.ie/2017/05/kubernetes-readiness-and-liveness-with.html
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
