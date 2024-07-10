package com.example.CineAll.Services;

import com.example.CineAll.Models.Filme;
import com.example.CineAll.Repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public Filme CadastrarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public List<Filme> listarTodosFilmes() {
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}

