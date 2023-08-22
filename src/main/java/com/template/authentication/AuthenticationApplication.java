package com.template.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {

	ApplicationContext ctx =  SpringApplication.run(AuthenticationApplication.class, args);

	}

}
