package br.ce.wcaquino.servicos;

import br.ce.wcaquino.EstoqueException;
import br.ce.wcaquino.dao.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

public class LocacaoService {

	private LocacaoDAO locacaoDAO;
	private DataUtils dataUtils;

	public String vPublico;
	protected String vProtegida;
	private String vPrivada;
	String vDefault;
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) {

		if(filmes.stream().anyMatch(f -> f.getEstoque() == 0)) {
			throw new EstoqueException();
		}

		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		LocalDate dataAtual = dataUtils.dataAtual();

		locacao.setDataLocacao(dataAtual);

		locacao.setValor(filmes.stream().mapToDouble(Filme::getPrecoLocacao).sum());

		//Entrega no dia seguinte
		LocalDate dataEntrega = dataAtual;
		dataEntrega = dataEntrega.plusDays(1L);

		if(isDomingo(dataEntrega)) {
			dataEntrega = dataEntrega.plusDays(1L);
		}

		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		locacaoDAO.salvar(locacao);
		
		return locacao;
	}

	//pode ser sobrescrita pela classe de testes
	public LocalDate buscaDataLocacao() {
		return LocalDate.now();
	}


	private boolean isDomingo(LocalDate data) {
	 return DataUtils.verificarDiaSemana(data, DayOfWeek.SUNDAY);
	}

	public void setLocacaoDAO(LocacaoDAO locacaoDAO) {
		this.locacaoDAO = locacaoDAO;
	}

	public void setDataUtils(DataUtils dataUtils) {
		this.dataUtils = dataUtils;
	}
}