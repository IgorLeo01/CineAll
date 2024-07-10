package com.example.CineAll.Services;

import com.example.CineAll.Models.Cliente;
import com.example.CineAll.Models.Filme;
import com.example.CineAll.Models.Ingresso;
import com.example.CineAll.Models.Usuario;
import com.example.CineAll.Repository.FilmeRepository;
import com.example.CineAll.Repository.IngressoRepository;
import com.example.CineAll.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngressoService {
    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Ingresso comprarIngresso(Long filmeId, Long usuarioId, int quantidade) throws Exception {
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new Exception("Filme não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new Exception("Cliente não encontrado"));

        if (filme.getQuantidadeDisponivel() < quantidade) {
            throw new Exception("Quantidade de ingressos indisponível");
        }

        filme.setQuantidadeDisponivel(filme.getQuantidadeDisponivel() - quantidade);
        filmeRepository.save(filme);

        Ingresso ingresso = new Ingresso();
        ingresso.setFilme(filme);
        ingresso.setUsuario(usuario);
        ingresso.setQuantidade(quantidade);

        return ingressoRepository.save(ingresso);
    }

    public List<Ingresso> listarIngressosPorCliente(Long usuarioId) {
        return ingressoRepository.findByUsuarioId(usuarioId);
    }
}
