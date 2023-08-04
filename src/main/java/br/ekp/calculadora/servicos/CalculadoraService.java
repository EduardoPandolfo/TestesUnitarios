package br.ekp.calculadora.servicos;

import br.ekp.calculadora.exceptions.DivisaoPorZeroException;

public class CalculadoraService {

    public Double somar(Double a, Double b) {
        return a + b;
    }

    public Double subtrair(Double a, Double b) {
        return a - b;
    }

    public Double multiplicar(Double a, Double b) {
        return a * b;
    }

    public Double dividir(Double a, Double b) {
        if(b == 0D) {
            throw new DivisaoPorZeroException();
        }

        return a / b;
    }
}
