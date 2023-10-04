package br.ce.wcaquino.servicos;

import br.ce.wcaquino.dao.LocacaoDAOFake;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.*;

public class LocacaoServiceTest01 {

    @Test
    public void teste() {

        //cenario

        LocacaoService service = new LocacaoService();
        service.setLocacaoDAO(new LocacaoDAOFake());
        service.setDataUtils(new DataUtils());

        //se utilizado no mesmo package pode habilitar acesso a variaveis de diferentes tipos de limitações
        System.out.println(service.vDefault);
        System.out.println(service.vProtegida);
        System.out.println(service.vPublico);

        Usuario usuario = new Usuario("Eduardo");
        Filme filme = new Filme("Filme 1", 1, 5.25D);

        // acao
        Locacao locacao = service.alugarFilme(usuario, Collections.singletonList(filme));

        // validacao
        System.out.println(locacao.getValor());
        System.out.println(locacao.getDataLocacao());
        System.out.println(locacao.getDataRetorno());

        Assert.assertTrue(locacao.getValor().equals(5.25D));
        //refatorado com ordem de expected, actual e modo assert adequado
        Assert.assertEquals(5.25D, locacao.getValor(), 0.001D);
        Assert.assertThat(locacao.getValor(), is(5.25D)); //ordem dos parametros invertida
        Assert.assertThat(locacao.getValor(), is(equalTo(5.25D)));
        Assert.assertThat(locacao.getValor(), is(not(6.0)));



        Assert.assertTrue(locacao.getDataLocacao().equals(LocalDate.now()));
        Assert.assertEquals(LocalDate.now(), locacao.getDataLocacao());
        Assert.assertThat(locacao.getDataLocacao(), is(LocalDate.now()));

        Assert.assertTrue(locacao.getDataRetorno().equals(LocalDate.now().plusDays(1)));
        Assert.assertEquals(LocalDate.now().plusDays(1), locacao.getDataRetorno());

    }


    @Test
    @Ignore
    public void testeIgnorado() {
        Assert.assertEquals(true, false);
    }
}
