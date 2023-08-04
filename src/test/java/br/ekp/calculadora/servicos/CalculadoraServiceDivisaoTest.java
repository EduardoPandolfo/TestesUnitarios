package br.ekp.calculadora.servicos;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class CalculadoraServiceDivisaoTest {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void testaDivisao01() {
        Double resultado = calculadoraService.dividir(15D, 5D);

        errorCollector.checkThat(resultado, Matchers.equalTo(3D));
    }

    @Test
    public void testaDivisao02() {
        Double resultado = calculadoraService.dividir(5D, 15D);

        errorCollector.checkThat(resultado, Matchers.closeTo(0.33, 0.01));
    }
}
