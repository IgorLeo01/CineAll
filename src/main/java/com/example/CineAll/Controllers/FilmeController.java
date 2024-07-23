package com.example.CineAll.Controllers;

import com.example.CineAll.Models.Filme;
import com.example.CineAll.Services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> listarTodosFilmes() {
        return filmeService.listarTodosFilmes();
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable Long id) {
        return filmeService.buscarPorId(id);
    }

    @PostMapping
    public Filme CadastrarFilme(@RequestBody Filme filme) {
        return filmeService.CadastrarFilme(filme);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        return filmeService.atualizarFilme(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        filmeService.deletarFilme(id);
    }
}

