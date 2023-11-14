package com.login.LoginPage.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "administradores")
@Data
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 180, nullable = false)
    private String email;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @Column(name = "observacao", columnDefinition = "LONGTEXT")
    private String observacao;

    // public String getSenha() {
    //     String asteriscos = "*";
    //     for(int i = 0; i < senha.length()-4; i++) {
    //         asteriscos = asteriscos + "*";
    //     }
    //     return senha.substring(0, 3) + asteriscos;
        
    // }
}
