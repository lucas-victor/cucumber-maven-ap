package br.steps;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import br.runners.Apoio;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ElementMap {

	public static WebDriver driver;
	
	//private static final Logger LOGGER = Logger.getLogger(ElementMap.class.getName());

	@Test
	public static void efetuaLogin() {

		// seta propriedades do driver
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver\\chromedriver.exe");

		// instancia o driver.
		driver = new ChromeDriver();

		// maximiza tela
		// driver.manage().window().maximize();

		// Acessa a url.
		driver.get("http://srbarriga.herokuapp.com/logout"); // Nova URL: https://10.58.1.104:7003/am/login URL ANTIGA:
		Apoio.esperar(2000);

		// digita o email
		driver.findElement(By.id("email")).sendKeys("selenium@squadra.com.br");

		// digita a senha
		WebElement elemSenha = driver.findElement(By.id("senha"));
		elemSenha.sendKeys("123");
		// submit no formulario
		elemSenha.submit();

		// Verifica mensagem de login
		WebElement element = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
		Assert.assertEquals("Bem vindo, Selenium+Cucumber+Java+Junit!", element.getText());


	}

	@Test
	public static void clicaMenuCriarMovimentacao() {

		driver.findElement(By.linkText("Criar Movimentação")).click();

	}

	// preenche combobox tipo Movimenta��o
	@Test
	public static void preencherOCampoTipoMovimentacao(String tpMovimentacao) {

		WebElement comboboxElement = driver.findElement(By.id("tipo"));
		Select combobox = new Select(comboboxElement);
		combobox.selectByVisibleText(tpMovimentacao);

	}

	// clica no bot�o Pesquisa
	@Test
	public static void preencherOCampoDataMovimentaO(String dtMovimentacao) {

		driver.findElement(By.id("data_transacao")).sendKeys(dtMovimentacao);
	}

	@Test
	public static void preencherOCampoDataPagamento(String dtPagamento) {

		driver.findElement(By.id("data_pagamento")).sendKeys(dtPagamento);

	}

	@Test
	public static void preencherOCampoDescriOMovimentacao(String descricao) {

		driver.findElement(By.id("descricao")).sendKeys(descricao);

	}

	@Test
	public static void preencherOCampoInteressadoInterTeste(String interessado) {

		driver.findElement(By.id("interessado")).sendKeys(interessado);
	}

	@Test
	public static void preencherOCampoValor(String valor) {

		driver.findElement(By.id("valor")).sendKeys(valor);

	}

	@Test
	public static void preencherOCampoConta(String conta) {

		WebElement comboboxElement = driver.findElement(By.id("conta"));
		Select combobox = new Select(comboboxElement);
		combobox.selectByVisibleText(conta);
	}

	@Test
	public static void selecionarOCampoSitua(String situacao) {

		if (situacao.equalsIgnoreCase("Pago")) {

			driver.findElement(By.id("status_pago")).click();
		} else {

			driver.findElement(By.id("status_pendente")).click();
		}

	}

	@Test
	public static void btnSalvar() {
		Apoio.esperar(300);
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

	}

	@Test
	public static void validaMensagem(String mensagem) {
		WebElement element = driver.findElement(By.xpath("//*[@class='alert alert-success']"));
		Apoio.esperar(1000);
		Assert.assertEquals("Movimentação adicionada com sucesso!", mensagem);
	}

//Consulta movimentações.

	public static void clicaMenuResumoMensal() {

		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[4]/a")).click();

	}

	public static void buscarPeloMesDeAbril() {
		// Seleciona combo do mes
		WebElement comboelementMes = driver.findElement(By.id("mes"));
		Select comboMes = new Select(comboelementMes);
		comboMes.selectByVisibleText("Abril");

		// Seleciona combo do ano.
		WebElement comboElementAno = driver.findElement(By.id("ano"));
		Select comboAno = new Select(comboElementAno);
		comboAno.selectByVisibleText("2020");
	}

	public static void ValidaMovimentacoesExistentes() {
		String resultExpected = "Movimentacao 1 03/04/2020 ContaCucumber 1000.65 Pago";

		WebElement tabela = driver.findElement(By.id("tabelaExtrato"));
		List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));

		boolean temlinha = false;
		for (WebElement linha : tr) {
			if (linha.getText().contains("Movimentacao 1")) {
				Assert.assertEquals(resultExpected, linha.getText());
				temlinha = true;
				break;
			}
		}

		// Se nao tem linha da falha no assert.
		if (!temlinha) {
			Assert.assertEquals(resultExpected, "");
		}

	}
	
	

	// Print screen
	@Test
	public static void print(String nomePrint) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Apoio.esperar(1000);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/_" + nomePrint + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Configuração dos HOOKs - Executam antes e/ou depois de cada cenário.
	@Before
	public static void msgStart() {
		System.out.println("iniciando teste.");
	}

	@After(order = 1, value = { "@Funcionais" }) // @After(order = 1)
	public static void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Apoio.esperar(1000);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = { "@Funcionais" }) // @After(order = 0) //
	public static void fecharBrowser() {
		Apoio.esperar(2500);
		driver.quit();
		// System.out.println("Fim do caso de teste!");
	}

}
