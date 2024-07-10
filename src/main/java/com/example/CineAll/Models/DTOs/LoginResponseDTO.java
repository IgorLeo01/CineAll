package com.example.CineAll.Models.DTOs;

import java.time.LocalDate;
import java.util.Set;

public class LoginResponseDTO {
    private String nome;
    private Set<String> roles;
    private String token;
    private LocalDate dataNascimento;


    public LoginResponseDTO(String nome, Set<String> roles, String token, LocalDate dataNascimento) {
        this.nome = nome;
        this.roles = roles;
        this.token = token;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
