package com.automovil.servicio.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Automovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String modelo;
    private int idUsuario;

}
