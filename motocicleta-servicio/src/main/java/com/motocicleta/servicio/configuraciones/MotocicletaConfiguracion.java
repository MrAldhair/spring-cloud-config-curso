package com.motocicleta.servicio.configuraciones;

import com.motocicleta.servicio.entidades.Motocicleta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MotocicletaConfiguracion {

    @Bean
    public Motocicleta nuevaMotocicleta(){
        return new Motocicleta();
    }

}
