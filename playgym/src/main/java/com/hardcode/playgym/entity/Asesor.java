package com.hardcode.playgym.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@NoArgsConstructor
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

   /* @ManyToMany(fetch = EAGER)
    @JoinColumn(name = "lista_grupo_muscular", referencedColumnName = "id", nullable = false)
    private List<GrupoMuscular> listaGrupoMuscular;*/

    @ManyToMany(fetch = EAGER)
    @JoinColumn(name = "clientes", referencedColumnName = "id", nullable = false)
    private List<Cliente> clientes;
   // private Cliente clientes;


    @Column(nullable = false)
    private String imagen;

}
