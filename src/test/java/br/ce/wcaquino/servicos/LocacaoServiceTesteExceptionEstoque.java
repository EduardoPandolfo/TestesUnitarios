package br.ce.wcaquino.servicos;

import br.ce.wcaquino.EstoqueException;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class LocacaoServiceTesteExceptionEstoque {



    @Test(expected = EstoqueException.class)
    public void testeFilmeEstoqueZerado01() {
        //cenario

        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.5d);

        LocacaoService locacaoService = new LocacaoService();

        //acao

        Locacao locacao = locacaoService.alugarFilme(usuario, Collections.singletonList(filme));

        Assert.fail();
    }

    @Test
    public void testeFilmeEstoqueZerado02() {
        //cenario

        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.5d);

        LocacaoService locacaoService = new LocacaoService();

        //acao

        try{
            Locacao locacao = locacaoService.alugarFilme(usuario, Collections.singletonList(filme));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(EstoqueException.MSG);
            Assert.assertEquals(e.getLocalizedMessage(), EstoqueException.MSG);
        }
    }



}
