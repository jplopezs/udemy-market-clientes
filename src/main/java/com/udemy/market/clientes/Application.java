package com.udemy.market.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.udemy.market.clientes.model"})
@EnableJpaRepositories(basePackages = {"com.udemy.market.clientes.repository"})
@SpringBootApplication(scanBasePackages = {"com.udemy.market.clientes.service", "com.udemy.market.clientes.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
