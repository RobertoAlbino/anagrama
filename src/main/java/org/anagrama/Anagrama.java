package org.anagrama;

import java.util.HashSet;
import java.util.Set;

public class Anagrama {

    private static boolean entradaValida(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            return false;
        }
        return entrada.matches("[a-zA-Z]+");
    }

    private static Set<String> gerarAnagramas(String entrada) {
        Set<String> anagramasGerados = new HashSet<>();

        for (int i = 0; i < entrada.length(); i++) {
            char letraInicial = entrada.charAt(i);
            String letrasAntesAtual = entrada.substring(0, i);
            String letrasDepoisAtual = entrada.substring(i + 1);
            String restantes = letrasAntesAtual + letrasDepoisAtual;

            System.out.println("\n--- Processando índice: " + i + " (letra " + letraInicial + ") ---");
            System.out.println("Letra inicial antes de permutar: " + letraInicial);
            System.out.println("Restantes antes de permutar: " + restantes);

            permutar("" + letraInicial, restantes, anagramasGerados);
        }

        return anagramasGerados;
    }

    private static void permutar(String anagramaParcial, String letrasRestantes, Set<String> anagramasGerados) {
        if (letrasRestantes.isEmpty()) {
            System.out.println("Anagrama Gerado: " + anagramaParcial);
            anagramasGerados.add(anagramaParcial);
            return;
        }

        for (int i = 0; i < letrasRestantes.length(); i++) {

            char letraAtual = letrasRestantes.charAt(i);
            String letrasRestantesAntes = letrasRestantes.substring(0, i);
            String letrasRestantesDepois = letrasRestantes.substring(i + 1);

            System.out.println("Index permutação: " + i);
            System.out.println("Anagrama Parcial: " + anagramaParcial);
            System.out.println("Letra Atual: " + letraAtual);
            System.out.println("Letras restantes: " + letrasRestantes);
            System.out.println("Letras Restantes Antes: " + letrasRestantesAntes);
            System.out.println("Letras Restantes Depois: " + letrasRestantesDepois);

            permutar(
                    anagramaParcial + letraAtual,
                    letrasRestantesAntes + letrasRestantesDepois,
                    anagramasGerados
            );
        }
    }

    public static void main(String[] args) {
        var parametroEntradaNaoInformado = args.length == 0;
        if (parametroEntradaNaoInformado) {
            throw new IllegalArgumentException("O parâmetro de entrada não foi informado");
        }
        if (!entradaValida(args[0])) {
            throw new IllegalArgumentException("O parâmetro de entrada é inválido");
        }

        Set<String> anagramas = gerarAnagramas(args[0]);

        for (String s : anagramas) {
            System.out.println(s);
        }
    }

}