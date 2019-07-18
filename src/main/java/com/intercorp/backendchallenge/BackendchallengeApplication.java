package com.intercorp.backendchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.intercorp.backendchallenge.dao")
public class BackendchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendchallengeApplication.class, args);
	}
}
