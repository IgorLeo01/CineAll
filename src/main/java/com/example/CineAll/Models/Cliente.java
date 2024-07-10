package com.example.CineAll.Models;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Cliente extends Usuario {

    private String cpf;
}

