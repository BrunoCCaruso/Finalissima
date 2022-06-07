package com.hardcode.playgym.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Table
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private String rol = "ADMIN";

    @Column(nullable = false)
    private List<Asesor> asesores;

    @Column(nullable = false)
    private List<Cliente> clientes;
}
