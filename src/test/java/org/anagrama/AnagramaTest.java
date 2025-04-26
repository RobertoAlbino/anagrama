package org.anagrama;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class AnagramaTest {

    private String executarMain(String... argumentos) {
        PrintStream original = System.out;
        ByteArrayOutputStream capturado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturado));
        try {
            Anagrama.main(argumentos);
        } finally {
            System.setOut(original);
        }
        return capturado.toString();
    }

    @Test
    void deveGerarAnagramaParaUmaLetra() {
        String saida = executarMain("a");
        assertTrue(saida.contains("a"));
    }

    @Test
    void deveGerarAnagramasParaDuasLetras() {
        String saida = executarMain("ab");
        assertTrue(saida.contains("ab"));
        assertTrue(saida.contains("ba"));
    }

    @Test
    void deveGerarAnagramasParaTresLetras() {
        String saida = executarMain("abc");
        assertTrue(saida.contains("abc"));
        assertTrue(saida.contains("acb"));
        assertTrue(saida.contains("bac"));
        assertTrue(saida.contains("bca"));
        assertTrue(saida.contains("cab"));
        assertTrue(saida.contains("cba"));
    }

    @Test
    void deveLancarExcecaoQuandoEntradaVazia() {
        assertThrows(IllegalArgumentException.class, () -> executarMain(""));
    }

    @Test
    void deveLancarExcecaoQuandoEntradaNumeros() {
        assertThrows(IllegalArgumentException.class, () -> executarMain("ab1"));
    }

    @Test
    void deveLancarExcecaoQuandoSemArgumentos() {
        assertThrows(IllegalArgumentException.class, this::executarMain);
    }
}
