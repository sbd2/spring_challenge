package com.intercorp.backendchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.intercorp.backendchallenge.domain")
public class BackendchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendchallengeApplication.class, args);
	}
}
