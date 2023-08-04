package br.ekp.calculadora.exceptions;

public class DivisaoPorZeroException extends RuntimeException {

    private static final String MSG = "Proibido divisão por zero.";

    public DivisaoPorZeroException() {
        super(MSG);
    }
}
