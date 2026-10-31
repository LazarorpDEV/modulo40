package br.com.lazaro.modulo40.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Exemplo de endpoint HTTP que devolve uma resposta JSON. */
@RestController
public class SaudacaoController {

    @GetMapping("/api/saudacao")
    public Saudacao saudar(@RequestParam(defaultValue = "Visitante") String nome) {
        String nomeTratado = nome == null || nome.isBlank() ? "Visitante" : nome.strip();
        return new Saudacao("Olá, " + nomeTratado + "! Meu projeto Spring Boot está funcionando.", 40);
    }

    public record Saudacao(String mensagem, int modulo) { }
}
