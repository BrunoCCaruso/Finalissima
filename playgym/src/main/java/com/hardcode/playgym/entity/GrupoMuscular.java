package com.hardcode.playgym.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class GrupoMuscular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grupo_muscular_id")
    private Long id;

    @Column(nullable = false)
    private boolean trenSup;

    @Column(nullable = false)
    private boolean trenInf;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    private List<Ejercicio> ejercicios;


}
