package com.hardcode.playgym.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Asesor implements Serializable {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String rol = "ASESOR";

    @Column(nullable = false)
    private boolean eliminado;

    @Column(nullable = false)
    private GrupoMuscular grupoMuscular;

    @Column(nullable = false)
    private List<Cliente> clientes;

    @Column(nullable = false)
    private String imagen;

}
