package com.hardcode.playgym.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class GrupoMuscular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private boolean trenSup;

    @Column(nullable = false)
    private boolean trenInf;

    @ManyToMany(fetch = EAGER)
    @JoinColumn(name = "ejercicios", referencedColumnName = "id", nullable = false)
    private List<Ejercicio> ejercicios;
    //private Ejercicio ejercicios;


}
