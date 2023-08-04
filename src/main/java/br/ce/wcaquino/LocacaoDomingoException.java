package br.ce.wcaquino;

public class LocacaoDomingoException extends RuntimeException {
    public final static String MSG = "Não é possível locar um filme no domingo.";

    public LocacaoDomingoException() {
        super(MSG);
    }
}
