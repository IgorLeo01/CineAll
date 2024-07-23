package com.example.CineAll.Controllers;

import com.example.CineAll.Models.DTOs.AuthenticationDTO;
import com.example.CineAll.Models.DTOs.LoginResponseDTO;
import com.example.CineAll.Models.Usuario;
import com.example.CineAll.Repository.UsuarioRepository;
import com.example.CineAll.Services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        Optional<Usuario> userDetailsOptional = usuarioRepository.findByEmail(data.getEmail());

        Usuario usuario = userDetailsOptional
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(data.getSenha(), usuario.getSenha())) {
            throw new UsernameNotFoundException("Senha incorreta");
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        Set<String> roles = auth.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toSet());

        var token = tokenService.generateToken(usuario);
        var response = new LoginResponseDTO(usuario.getNome(), roles, token, usuario.getDataNascimento());

        return ResponseEntity.ok(response);
    }
}