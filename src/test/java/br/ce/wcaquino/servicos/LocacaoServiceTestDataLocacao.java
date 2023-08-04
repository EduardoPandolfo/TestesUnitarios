package br.ce.wcaquino.servicos;

import br.ce.wcaquino.dao.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.matchers.DiaSemanaMatcher;
import br.ce.wcaquino.matchers.LocalDateMatcherFactory;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;

import static br.ce.wcaquino.matchers.LocalDateMatcherFactory.caiEmSegundaFeira;

@RunWith(MockitoJUnitRunner.class)
public class LocacaoServiceTestDataLocacao {

    private LocacaoService locacaoService;

    private DataUtils dataUtils;

    @Before
    public void setup() {
        locacaoService = new LocacaoService();
        LocacaoDAO dao = Mockito.mock(LocacaoDAO.class);
        locacaoService.setLocacaoDAO(dao);

        dataUtils = Mockito.mock(DataUtils.class);
        locacaoService.setDataUtils(dataUtils);

    }

    @Test
    public void testeLocacaoDomingo() {

        Usuario usuario = new Usuario("Usuário Teste");
        Filme filme = new Filme("Filme 5", 1, 3.5D);

        Mockito.when(dataUtils.dataAtual()).thenReturn(LocalDate.of(2023,6,3));
        Locacao locacao = locacaoService.alugarFilme(usuario, Collections.singletonList(filme));

        MatcherAssert.assertThat(locacao.getDataRetorno(), new DiaSemanaMatcher(DayOfWeek.MONDAY));
        MatcherAssert.assertThat(locacao.getDataRetorno(), LocalDateMatcherFactory.caiEm(DayOfWeek.MONDAY));
        MatcherAssert.assertThat(locacao.getDataRetorno(), caiEmSegundaFeira());

    }
}
