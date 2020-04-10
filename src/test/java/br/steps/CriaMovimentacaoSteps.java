package br.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CriaMovimentacaoSteps {

	@Given("^estou logado no site$")
	public void estouLogadoNoSite() throws Throwable {
	   	ElementMap.efetuaLogin();
	}

	@When("^eu acessar o menu criar movimentacao$")
	public void euAcessarOMenuCriarMovimentacao() throws Throwable {
	    ElementMap.clicaMenuCriarMovimentacao();
	}
	
	@When("^preencher o campo Tipo Movimentacao \"([^\"]*)\"$")
	public void preencherOCampoTipoMovimentacao(String tpMovimentacao) throws Throwable {
	    ElementMap.preencherOCampoTipoMovimentacao(tpMovimentacao);
	}

	@When("^preencher o campo Data Movimentacao \"([^\"]*)\"$")
	public void preencherOCampoDataMovimentacao(String dtMovimentacao) throws Throwable {
		ElementMap.preencherOCampoDataMovimentaO(dtMovimentacao);
	}
	
	@When("^preencher o campo Data Pagamento \"([^\"]*)\"$")
	public void preencherOCampoDataPagamento(String dtPagamento) throws Throwable {
	    ElementMap.preencherOCampoDataPagamento(dtPagamento);
	}

	@When("^preencher o campo Descricao \"([^\"]*)\"$")
	public void preencherOCampoDescricao(String descricao) throws Throwable {
		ElementMap.preencherOCampoDescriOMovimentacao(descricao);
	}

	@When("^preencher o campo Interessado \"([^\"]*)\"$")
	public void preencherOCampoInteressado(String interessado) throws Throwable {
	   ElementMap.preencherOCampoInteressadoInterTeste(interessado);
	}

	@When("^preencher o campo Valor \"([^\"]*)\"$")
	public void preencherOCampoValor(String valor) throws Throwable {
	    ElementMap.preencherOCampoValor(valor);
	}

	@When("^preencher o campo Conta \"([^\"]*)\"$")
	public void preencherOCampoConta(String conta) throws Throwable {
	    ElementMap.preencherOCampoConta(conta);
	}

	@When("^selecionar o campo Situacao \"([^\"]*)\"$")
	public void selecionarOCampoSituacao(String situacao) throws Throwable {
	    ElementMap.selecionarOCampoSitua(situacao);
	}

	@When("^eu clicar no botao salvar$")
	public void euClicarNoBotaoSalvar() throws Throwable {
	    ElementMap.btnSalvar();
	}
	
	@Then("^a mensagem \"([^\"]*)\" sera exibida$")
	public void aMensagemSeraExibida(String mensagem) throws Throwable {
	    ElementMap.validaMensagem(mensagem);
	}
	
// Consultar movimentações
	@When("^eu acessar o menu Resumo Mensal$")
	public void euAcessarOMenuResumoMensal() throws Throwable {
	    ElementMap.clicaMenuResumoMensal();
	}

	@When("^buscar pelo mes de abril$")
	public void buscarPeloMesDeAbril() throws Throwable {
	    ElementMap.buscarPeloMesDeAbril();
	}

	@Then("^eu verei a movimentacao um$")
	public void euVereiAsMovimentacoesExistentes() throws Throwable {
	    ElementMap.ValidaMovimentacoesExistentes();
	}

// Exclui movimentação	
	@When("^selecionar o mes <mess> e o ano <anoo>$")
	public void selecionarOMesMessEOAnoAnoo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^clicar no botao buscar$")
	public void clicarNoBotaoBuscar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
