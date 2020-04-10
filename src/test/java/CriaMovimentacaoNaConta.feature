@Funcionais @All
Feature: CRUD da movimentação da conta.
  Como um usuario
  eu quero cadastrar uma conta 
  e inserir duas movimentações na conta
  para que possa altera-la, visualiza-la e exclui-la.

  Background: 
    Given estou logado no site

  @ignore
  Scenario Outline: Cria movimentações na conta.
    When eu acessar o menu criar movimentacao
    And preencher o campo Tipo Movimentacao <tpMovimentacao>
    And preencher o campo Data Movimentacao <dtMovimentacao>
    And preencher o campo Data Pagamento <dtPagamento>
    And preencher o campo Descricao <descricao>
    And preencher o campo Interessado <interessado>
    And preencher o campo Valor <valor>
    And preencher o campo Conta <conta>
    And selecionar o campo Situacao <situacao>
    When eu clicar no botao salvar
    Then a mensagem <mensagem> sera exibida

    Examples: 
      | tpMovimentacao | dtMovimentacao | dtPagamento  | descricao        | interessado   | valor      | conta           | situacao   | mensagem                               |
      | "Receita"      | "01/04/2020"   | "03/04/2020" | "Movimentacao 1" | "InterTeste"  | "1000.65"  | "ContaCucumber" | "Pago"     | "Movimentação adicionada com sucesso!" |
      | "Despesa"      | "01/04/2020"   | "05/04/2020" | "Movimentacao 2" | "InterTeste2" | "5000.78"  | "ContaCucumber" | "Pendente" | "Movimentação adicionada com sucesso!" |
      | "Despesa"      | "01/04/2020"   | "05/04/2020" | "Movimentacao 3" | "InterTeste2" | "25000.78" | "ContaCucumber" | "Pendente" | "Movimentação adicionada com sucesso!" |

  #  @ignore
  Scenario: Consulta movimentações na conta.
    When eu acessar o menu Resumo Mensal
    And buscar pelo mes de abril
    Then eu verei a movimentacao um

  @ignore
  Scenario Outline: Exclui movimentações na conta.
    When eu acessar o menu Resumo Mensal
    And selecionar o mes <mes> e o ano <ano>
    When clicar no botao buscar
    Then eu verei as movimentacoes existentes

    Examples: 
      | mes   | ano  |
      | abril | 2020 |
