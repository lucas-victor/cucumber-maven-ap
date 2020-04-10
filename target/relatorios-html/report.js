$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CriaMovimentacaoNaConta.feature");
formatter.feature({
  "line": 2,
  "name": "CRUD da movimentação da conta.",
  "description": "Como um usuario\r\neu quero cadastrar uma conta \r\ne inserir duas movimentações na conta\r\npara que possa altera-la, visualiza-la e exclui-la.",
  "id": "crud-da-movimentação-da-conta.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Funcionais"
    },
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.before({
  "duration": 102300,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "estou logado no site",
  "keyword": "Given "
});
formatter.match({
  "location": "CriaMovimentacaoSteps.estouLogadoNoSite()"
});
formatter.result({
  "duration": 10155413200,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 31,
      "value": "#  @ignore"
    }
  ],
  "line": 32,
  "name": "Consulta movimentações na conta.",
  "description": "",
  "id": "crud-da-movimentação-da-conta.;consulta-movimentações-na-conta.",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "eu acessar o menu Resumo Mensal",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "buscar pelo mes de abril",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "eu verei a movimentacao um",
  "keyword": "Then "
});
formatter.match({
  "location": "CriaMovimentacaoSteps.euAcessarOMenuResumoMensal()"
});
formatter.result({
  "duration": 334017200,
  "status": "passed"
});
formatter.match({
  "location": "CriaMovimentacaoSteps.buscarPeloMesDeAbril()"
});
formatter.result({
  "duration": 67959300,
  "status": "passed"
});
formatter.match({
  "location": "CriaMovimentacaoSteps.euVereiAsMovimentacoesExistentes()"
});
formatter.result({
  "duration": 53215300,
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[Movimentacao 1 03/04/2020 ContaCucumber 1000.65 Pago]\u003e but was:\u003c[]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat br.steps.ElementMap.ValidaMovimentacoesExistentes(ElementMap.java:191)\r\n\tat br.steps.CriaMovimentacaoSteps.euVereiAsMovimentacoesExistentes(CriaMovimentacaoSteps.java:83)\r\n\tat ✽.Then eu verei a movimentacao um(CriaMovimentacaoNaConta.feature:35)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1282001500,
  "status": "passed"
});
formatter.after({
  "duration": 3116875500,
  "status": "passed"
});
});