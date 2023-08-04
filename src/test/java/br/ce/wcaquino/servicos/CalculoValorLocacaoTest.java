package br.ce.wcaquino.servicos;

import br.ce.wcaquino.dao.LocacaoDAOFake;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

    @Parameterized.Parameter(value = 0)
    public List<Filme> filmes;

    @Parameterized.Parameter(value = 1)
    public Double valorLocacao;

    private LocacaoService locacaoService;

    private final static Filme filme1 = new Filme("Filme 1", 1, 5D);
    private final static Filme filme2 = new Filme("Filme 2", 2, 7D);

    @Before
    public void setup() {
        locacaoService = new LocacaoService();
        locacaoService.setLocacaoDAO(new LocacaoDAOFake());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParametros() {
        return Arrays.asList(new Object[][]{
                        { Arrays.asList(filme1), 5D },
                        { Arrays.asList(filme1, filme2), 12D }
                }
        );
    }

    @Test
    public void testeParametrizado() {
        Locacao locacao = locacaoService.alugarFilme(new Usuario("Usuario 1"), filmes);

        Assert.assertEquals(valorLocacao, locacao.getValor());
    }

}
