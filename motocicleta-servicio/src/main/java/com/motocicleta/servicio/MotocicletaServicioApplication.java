package com.motocicleta.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MotocicletaServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotocicletaServicioApplication.class, args);
	}

}
