package br.ekp.calculadora.servicos;

import br.ekp.calculadora.exceptions.DivisaoPorZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraServiceDivisaoPorZeroTest {

    private CalculadoraService calculadoraService;

    @Before
    public void init() {
        calculadoraService = new CalculadoraService();
    }

    @Test(expected = DivisaoPorZeroException.class)
    public void testeExceptionDivisaoPorZero() {
        Double resultado = calculadoraService.dividir(1D, 0D);

        Assert.fail();
    }

}
