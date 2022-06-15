package com.hardcode.playgym.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Ejercicio implements Serializable {

    @Id
    @Column(name = "ejercicio_id")
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
