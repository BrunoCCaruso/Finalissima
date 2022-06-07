package com.hardcode.playgym.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Data
@Entity
@Table
public class Cliente implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String alias;

    @Column(name = "email", length = 60, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String rol = "USUARIO";

    @Column(nullable = false)
    private boolean eliminado;

    @Column
    private Short edad;

    @Column
    private Double altura;

    @Column
    private Double peso;

    @Column
    private List<Asesor> asesores;

    @Column
    private List<Ejercicio> ejercicios;

    @Column
    private String imagen;


}
