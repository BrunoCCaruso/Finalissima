package com.hardcode.playgym.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Cliente {

    @Id
    @Column
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

    @ManyToMany(fetch = EAGER)
    @JoinColumn(name = "asesores", referencedColumnName = "id", nullable = false)
    //private Asesor asesores;
    private List<Asesor> asesores;

    /*@OneToMany(fetch = EAGER)
    @JoinColumn(name = "ejercicios_cliente", referencedColumnName = "id", nullable = false)
    private List<Ejercicio> ejerciciosCliente;
    //private Ejercicio ejercicios;
*/
    @Column
    private String imagen;


}
