package com.example.CineAll.Repository;

import com.example.CineAll.Models.Ingresso;
import com.example.CineAll.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
    List<Ingresso> findByUsuarioId(Long usuarioId);
}

