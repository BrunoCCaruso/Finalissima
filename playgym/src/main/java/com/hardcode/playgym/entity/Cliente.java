package com.hardcode.playgym.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Cliente {

    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String alias;

    @Column(name = "email", length = 60, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String contrasenia;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Asesor> asesores;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Ejercicio> ejerciciosCliente;

    @Column
    private String imagen;


}
