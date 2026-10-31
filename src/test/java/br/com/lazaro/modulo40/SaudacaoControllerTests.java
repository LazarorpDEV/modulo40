package br.com.lazaro.modulo40;

import br.com.lazaro.modulo40.controller.SaudacaoController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaudacaoControllerTests {
    private final SaudacaoController controller = new SaudacaoController();

    @Test
    void devePersonalizarSaudacaoERemoverEspacos() {
        var resposta = controller.saudar("  Lázaro  ");
        assertEquals("Olá, Lázaro! Meu projeto Spring Boot está funcionando.", resposta.mensagem());
        assertEquals(40, resposta.modulo());
    }

    @Test
    void deveUsarVisitanteParaNomeVazio() {
        assertEquals("Olá, Visitante! Meu projeto Spring Boot está funcionando.",
                controller.saudar("  ").mensagem());
    }
}
