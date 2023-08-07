Anotações (https://www.udemy.com/course/testes-unitarios-em-java/)

Divididos em 3 etapas:
1 - Cenário: Criação dos objetos, preparação das variáveis.

2 - Ação: Execução da função/processo a ser testado utilizando os objetos do cenário.

3 - Validação: Criação das assertivas para validação do que foi executado na ação.


F - FAST

I - INDEPENDENT

R - REPEATABLE

S - SELF-VERIFYING

T - TIMELY (atemporal)


Quando executado uma classe de teste com várias funções que tem a notação @Test, caso algum teste falhe será apontado apenas os erros/acertos até a execução da função.
Para concluir todos os testes é possível utilizar o objeto ErrorColector:

public [MyClass] {
ErrorColector errorColector = new ErrorColector();

	@Test
	public Cenario1() {
		errorColector.CheckThat(Assert.assert...);
	}
	
	@Test
	public Cenario2() {
		errorColector.CheckThat(Assert.assert...);
	}
}


-- Teste para implementação
1. Validar campo estoque em filme, não permitir se estoque for igual a 0.
   
2. Tratar Exceptions na classe de teste, criar exception unica para melhor controle.

Assert.assetFail(); 

@Before 

@After 

@BeforeClass 

@AfterClass

@Test(expected = Exception.class) 

Assert.assertThat(e.getMessage(), "messagem de erro");

@Rule private ExpectedException = new ExpectedException();

3. Criar exemplo com count() static e não static();
	Utilizar na classe @FixedMethodOrder(..ascending)
    
4. Testes - Enviar mais de um filme, List<Filme> na locação


TDD ->
Fluxo normal:  Código, Teste, Refatora.

Fluxo proposto: Teste, código, Refatora.

--- Criar Exemplo para calculadora
(subtrair, adicionar, dividir - criar exception dividir por 0)
--Criar validação para não devolver filme no domingo

é possível colocar @Ignore em algum teste para deixar no estado skipped
Também usar Assume.AssumeTrue();


---Criar Exemplo de classe de teste parametrizada (aula 18) -> @RunWith(Parametized.class)

@Parameteres(name = "teste {index}, params: {0} - {1}")
public static Collection<Object[]> getParameters() {

}

nos campos utilizar @parameter( value = [posicao])

----desafio
Criar matcher com LocalDate para descobrir se a data é de determinado dia da semana


---depois do desafio criar @SuiteClasses em uma classe e colocar todas classes de juntas. (ou rodar o pacote inteiro - MELHOR)


--criar Builder (classe publica com um private objeto Builder dentro da classe publica)

seção 5: mocks (implementação de lógica do serviço)

TESTES UNITÁRIOS NÃO PODEM TER DEPENDÊNCIA EXTERNA, SEJA ELA BANCO DE DADOS, PERSISTÊNCIA... (FAST, INDEPENDENT, TDD NÃO PODE SER CRIADO)

@Before
public void setup() {
service = new LocacaoService();
locacaoDao dao = Mockito.mock(LocadaoDAO.class);
service.setLocacaoDAO(dao);
}

--teste não deve alugar filmes para pessoas com dividas

criar interface de pesquisa (SPCService.java) (public boolean(isNegativado(Usuario usuario)));

no @Test
Mockito.when(spc.isNegativo(usuario)).thenReturn(true);


metodo-> enviarEmailComNotificaAtraso na locacaoSertvice
-> emailService.java -> notificar
(usuario);


@Test
public void deveEnviarEmailParaLocacoesAtrasadas() {
//cenario
Usuario usuario = UsuarioBuilder.Padrao();
List<Locacao> = Arrays.asList(LocacaoBuilder.Padrao());

	when(dao.obterLocacoesPendentes()).thenReturn(locacoes);
	
	//acao
	
	service.notificarAtrasos();
	
	//verify
	Mockito.verify(email).notificarAtraso(usuario);
	Mockito.verify(email, Mockito.times(2)).notificarAtraso(usuario); //atleast 1, atmost 4
	Mockito.verify(email, Mockito.never()).notificarAtraso(usuario2);
	Mockito.verifyNoMoreInteractions(email);

}



	@Test
	public void teste() {
		Calculadora cal = Mockito.mock(Calculadora.class);
		Mockito.when(calc.somar(Mockito.anyInt(), Mockito.anyInt()).thenReturn(5);
		sout(calc.somar(1,9); //imprime 5
	}
	
	
	public void teste() {
		Calculadora cal = Mockito.mock(Calculadora.class);
		Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt()).thenReturn(5);
		sout(calc.somar(1,9); //imprime 5
	}
	
	Possível colocar notação @Mock no objeto (aula 31)
	
	
	
	---
	exemplo de validação com capture de objeto
	ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class);
	Mockito.verify(dao).salvar(argCaapt.capture());
	Locacao LocacaoRetornada = argCapt.getValue();
	
	Asssert.assertThat(locacaoRetornada.getValor(), is(4.0));
	assert.assertthat(locacaoRetornada.getDataLocacao(), ehHoje());
	Assert.assertThat(locacaoDataRetorno(), ehHojeComDiferencaDias(5));
	
	---
	
	Quando anotado com @Spy - que funciona apenas com classe concreta - utiliza a função normal
	Mockito.when(calcSpy.somar(1,2).thenReturn(5);
	Mockito.doReturn(5).when(calcspy).somar(1,2);
	
	
	
	-------------
	power mock possível mockar statics e privates.
	utilizar na classe @RunWith(PowerMockRunner.class) e @PrepareForTest(LocacaoService.class)
	PowerMockito.whenNew(Date.class).withNoArgumentes().thenReturn( [dataParaSerRemovida])
	
	
	---------
	
	
	<build>
	  <testSourceDirectory> src </>
	  <plugin> 
		<groupId> org.apachem.maven.plugins </>
		<artifactId> maven-surefire-plugin </>
		<version> 2.18.1 </>
		<configuration>
			<threadCount> 2</>
			<parallel>all</>
		</configuration>
	</plugin>
	</build>
			
	
	
	
	
	
	
	