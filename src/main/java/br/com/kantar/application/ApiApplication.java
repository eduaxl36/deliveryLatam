package br.com.kantar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@SpringBootApplication
@EntityScan(basePackages = {"br.com.kantar.models"})
@EnableJpaRepositories(basePackages = {"br.com.kantar.repository"})
@ComponentScan(basePackages = {"br.com.kantar.services","br.com.kantar.controllers","br.com.kantar.exceptions.handlers"})

public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
