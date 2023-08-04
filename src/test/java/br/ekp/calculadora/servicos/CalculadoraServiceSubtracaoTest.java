package br.ekp.calculadora.servicos;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraServiceSubtracaoTest {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    public void testeSubtracao() {
        Double resultado = calculadoraService.subtrair(0D, 5D);

        Assert.assertEquals(-5D, resultado, 0.0D);
    }
}
