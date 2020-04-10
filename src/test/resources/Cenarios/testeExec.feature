#@ignore
Feature: Gerar relatorio no site
  Teste do relatorio Auditoria.

  @tag1
  Scenario: Teste do relatorio Auditoria.
    Given realizo o login no site
    When eu clicar no botao "pesquisar" 
    Then sera exibido o relatorio com os dados
    

