package com.usuario.servicio.entidades;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementable
    private int id;
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Column(name = "email", nullable = false, length = 60)
    private String email;

}
