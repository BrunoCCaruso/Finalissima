package com.hardcode.playgym.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Asesor implements Serializable {

    @Column(name = "asesor_id")
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
    private boolean eliminado;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<GrupoMuscular> listaGrupoMuscular;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Cliente> clientes;

    @Column(nullable = false)
    private String imagen;

}
