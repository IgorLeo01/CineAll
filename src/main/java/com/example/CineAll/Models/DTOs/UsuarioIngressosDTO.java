package com.example.CineAll.Models.DTOs;

import com.example.CineAll.Models.Ingresso;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioIngressosDTO {
    private Long id;
    private String nome;
    private List<Ingresso> ingressos;
}
