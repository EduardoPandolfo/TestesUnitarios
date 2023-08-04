package br.ekp.calculadora.servicos;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraServiceMultiplicacaoTest {

    public final CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    public void testeMultiplicacao() {
        Double resultado = calculadoraService.multiplicar(2.5D, 2D);

        Assert.assertEquals(5D, resultado, 0.0D);
    }
}
