package com.example.CineAll.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int duracao;
    private String imagem;
    private String sala;
    private int quantidadeIngressos;
    private int quantidadeIngressosDisponivel;
    private String horario;

    @JsonIgnore
    @OneToMany(mappedBy = "filme")
    private List<Ingresso> ingressos;


}

