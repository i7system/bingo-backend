package br.com.bingo.funcoes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCode {

	public static String GerarHash(int codigo) {
		// TODO Auto-generated method stub

		String chave="JavaMonster";
		
		String data_hora= DataHora.DataHoraMinutoSegundo();
		
		String palavra=data_hora+""+chave+""+codigo;
		
		
    	MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(palavra.getBytes()));
        return hash.toString(16);

		
		
	}
	
	public static String CriptografarSenha(String senha) {
		String chave="i7system";
		
		//String data_hora= DataHora.DataHoraMinutoSegundo();
		
		String palavra=chave+senha;
		
		
    	MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(palavra.getBytes()));
        return hash.toString(16);

		
		
	}

}



