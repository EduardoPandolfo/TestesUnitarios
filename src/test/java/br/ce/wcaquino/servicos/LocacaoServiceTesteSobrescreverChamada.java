package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class LocacaoServiceTesteSobrescreverChamada {

    private LocacaoService service;

    @Before
    public void setup() {
        service = Mockito.mock(LocacaoService.class);
    }


    @Test
    public void testeDataDiferenteAtual() {
        Mockito.when(service.buscaDataLocacao()).thenReturn(LocalDate.now().minusDays(1));

        Assert.assertNotEquals(LocalDate.now(), service.buscaDataLocacao());
    }
}
