package com.mercadolibre.springboot.services.dna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class MercadoLibreDnamutantsV1Application {

	public static void main(String[] args) {
		SpringApplication.run(MercadoLibreDnamutantsV1Application.class, args);
	}

}
