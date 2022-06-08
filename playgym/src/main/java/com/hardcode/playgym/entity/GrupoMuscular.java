package com.hardcode.playgym.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
public class GrupoMuscular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private boolean trenSup;

    @Column(nullable = false)
    private boolean trenInf;
/*
    @Column(nullable = false)
    private List<Ejercicio> ejercicios;

 */
}
