package com.edu.fatec.inviteme.model;

/**
 * Created by Usuario on 02/10/2017.
 */

public class Usuario {
    private String email;
    private String nome;
    private String senha;

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
