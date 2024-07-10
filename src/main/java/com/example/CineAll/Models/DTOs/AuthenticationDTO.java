package com.example.CineAll.Models.DTOs;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

}