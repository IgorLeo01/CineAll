package com.example.CineAll.Services;

import com.example.CineAll.Models.Filme;
import com.example.CineAll.Repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class FileService {

    @Autowired
    private FilmeRepository filmeRepository;

    public String storeFile(MultipartFile file) throws IOException {
        byte[] fileBytes = file.getBytes();
        String base64Image = Base64.getEncoder().encodeToString(fileBytes);
        return base64Image;
    }

    public void saveMovieWithImage(String titulo, String sinopse, String genero, int duracao, String imageBase64, int quantidadeIngressos, int quantidadeIngressosDisponivel, String horario, String sala) {
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setSinopse(sinopse);
        filme.setGenero(genero);
        filme.setDuracao(duracao);
        filme.setImagem(imageBase64);
        filme.setQuantidadeIngressos(quantidadeIngressos);
        filme.setQuantidadeIngressosDisponivel(quantidadeIngressosDisponivel);
        filme.setHorario(horario);
        filme.setSala(sala);
        filmeRepository.save(filme);
    }
}
