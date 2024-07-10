package com.example.CineAll.Controllers;

import com.example.CineAll.Models.Ingresso;
import com.example.CineAll.Models.DTOs.ComprarIngressoRequest;
import com.example.CineAll.Services.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;

    @PostMapping("/comprar")
    public ResponseEntity<Ingresso> comprarIngresso(@RequestBody ComprarIngressoRequest request) {
        try {
            Ingresso ingresso = ingressoService.comprarIngresso(request.getFilmeId(), request.getUsuarioId(), request.getQuantidade());
            return ResponseEntity.ok(ingresso);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Ingresso>> listarIngressosPorCliente(@PathVariable Long clienteId) {
        List<Ingresso> ingressos = ingressoService.listarIngressosPorCliente(clienteId);
        return ResponseEntity.ok(ingressos);
    }
}
