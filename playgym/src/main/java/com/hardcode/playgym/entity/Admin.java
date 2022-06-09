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
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "asesores", referencedColumnName = "id", nullable = false)
    private List<Asesor> asesores;
    //private Asesor asesores;

   /* @OneToMany(fetch = EAGER)
    @JoinColumn(name = "clientes", referencedColumnName = "id", nullable = false)
    private List<Cliente> clientes;
    //private Cliente clientes;
*/
}
