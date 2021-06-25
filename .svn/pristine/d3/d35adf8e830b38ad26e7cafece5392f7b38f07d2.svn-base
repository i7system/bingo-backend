package br.com.bingo.config;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.SecErros;
import br.com.bingo.repository.sec_errosRepository;

@RestController
public class TratamentoErros {
	
	@Autowired
	 sec_errosRepository servico01;

	public void Tratamento(Exception excecao) {
		System.out.println("Erro : " + excecao);
		System.out.println("Request :" + excecao.getLocalizedMessage());
		System.out.println("Request :" + excecao.getCause());
	
		SecErros erro = new SecErros();
		Timestamp dataagora = new Timestamp(System.currentTimeMillis());


System.out.println("cheguei no set");


	erro.setIDERRO(0);
	erro.setERRO("erro");
	
	servico01.save(erro);
		
		
		
		
	}
}
