package com.hardcode.playgym.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Ejercicio implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreEjercicio;

    @Column(nullable = false)
    private boolean trenSup;

    @Column(nullable = false)
    private boolean trenInf;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private String detalle;


}
