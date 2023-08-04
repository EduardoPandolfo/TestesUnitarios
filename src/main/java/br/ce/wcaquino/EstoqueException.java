package br.ce.wcaquino;

public class EstoqueException extends RuntimeException {
    public final static String MSG = "Filme sem exemplares em estoque.";

    public EstoqueException() {
        super(MSG);
    }
}
