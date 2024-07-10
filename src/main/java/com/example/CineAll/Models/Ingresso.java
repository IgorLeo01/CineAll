package com.example.CineAll.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private int quantidade;
}
