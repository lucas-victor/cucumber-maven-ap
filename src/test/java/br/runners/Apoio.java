package br.runners;

public class Apoio {
	
	//metodo aguardar tempo em mili seconds
	public static void esperar(int tempo){
		
		try {
		Thread.sleep(tempo);
	     } catch (InterruptedException e) {
		 e.printStackTrace();
	    }
	}
	
	
	//testando se subir� o arquivo alterado para o repositorio. Testar se a integra��o com o projeto
		
}
