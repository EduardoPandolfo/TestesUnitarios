package br.ekp.calculadora.servicos;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraServiceSomaTest {

    private CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    public void testeSoma() {
        Double resultado = calculadoraService.somar(1D, 4D);

        Assert.assertEquals(5D, resultado, 0.0D);
    }
}
