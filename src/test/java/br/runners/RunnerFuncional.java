package br.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/", //Caminho onde estão as features do cucumber.
	    glue = "br.steps",  //Pacote onde estão os testes.
		tags = {"@Funcionais", "~@ignore"}, //Teste marcados com a tag ser�o executados
		plugin = {"pretty", "html:target/relatorios-html"}, //formato do relatório.
		monochrome = true,
		snippets = SnippetType.CAMELCASE, //Muda escrita dos m�todos para camelcase.
		dryRun = false, //execuçãoo rápida para verificar erros sem executar os métodos.
		strict = false
		)

public class RunnerFuncional {

}