package br.com.bingo.funcoes;

import java.util.Random;
public class CodigoVerificacao {


	public static String GerarCodigo() {

		String Resultado="";
    	
        //instância um objeto da classe Random usando o construtor básico
        Random gerador = new Random();

        //imprime sequência de 10 números inteiros aleatórios entre 0 e 25
        for (int i = 0; i < 6; i++) {
        	Resultado=Resultado+gerador.nextInt(10);
         }
		
		return Resultado;
	}
	

}



