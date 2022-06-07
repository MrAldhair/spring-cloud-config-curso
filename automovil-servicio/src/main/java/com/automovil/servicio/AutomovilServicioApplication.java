package com.automovil.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutomovilServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomovilServicioApplication.class, args);
	}

}
