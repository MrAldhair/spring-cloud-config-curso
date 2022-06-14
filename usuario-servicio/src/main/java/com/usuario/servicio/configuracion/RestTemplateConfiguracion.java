package com.usuario.servicio.configuracion;

import com.usuario.servicio.entidades.Usuario;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration // Anotación encargada de definir que la clase es una clase de configuración para el framework
public class RestTemplateConfiguracion {

    @Bean // Anotación que marca como bean cada uno de los métodos de tal forma que esten disponibles para Spring
    @LoadBalanced // Al trabajar con LB es necesario para seleccionar al mejor postor
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Usuario usuario(){
        return new Usuario();
    }

}
