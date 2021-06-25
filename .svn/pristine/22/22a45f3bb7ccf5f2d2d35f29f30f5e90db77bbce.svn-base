package br.com.bingo.controllers;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.views.NovoJogo;

@RestController
@RequestMapping(value="/bingo")
@Api("NovoJogo")
@CrossOrigin(origins="*")

public class Sorteios {
	
	@PostMapping("/NovoJogo")
	@ApiOperation(value = "cria um novo Jogo")
	public HashMap<Integer, Object> NovoJogo(@RequestBody NovoJogo jogo, @RequestHeader HttpHeaders header) {

		HashMap<Integer, Object> retorno = new HashMap<Integer, Object>();
		HashMap<String, Object> linha = new HashMap<String, Object>();
		
		//aqui precisa pegar no banco as informações que irão ser impressas sendo elas as definidas nas variaveis a seguir:

		String NomePrograma = "Mega Bingo";//Nome dado ao programa
		String Local="BarDoJao";//Nome do local, pegar pelo token do usuario qual o local dele?
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'as' HH:mm");
        Date date = new Date(System.currentTimeMillis());//Data e hora do jogo
        int Sorteio= (int) ((Math.random() * (5000 - 3000)) + 3000);//Numero do sorteio
        int Codigo= (int) ((Math.random() * (5000000 - 3000000)) + 3000000);//composto por 2 inteiros, nesse está chumbado o 194 e seguido por esse numero aleatorio
        int nJogo= (int) ((Math.random() * (500 - 100)) + 100);//Numero do jogo dentro do sorteio
        //Numeros sorteados, aqui foi gerado aleatoriamente e atribuido a uma string, possui regras a consultar.
        //Numero de validação do jogo, para cada impressão há um numero.
        //Token, mesma coisa da validação mais em formato de token com 32 caracteres.
        //CNPJ, no original não tem, ele vai apenas o xx.xxx.xxx/xxxx-xx, irá atribuir?
        
		try {				
			int qtde=jogo.getQtde_jogos();
			String valor = "R$ "+jogo.getValor_jogo().toString().replace(".",",");

	        String cupom=" CUPOM ";
	        if(qtde>1){
	            cupom=" CUPONS ";
	        }
	        int nLinha=1;
	        
			String cabecalho = NomePrograma+"\nLocal...: "+Local+"\nDATA....: "
	        +formatter.format(date)
	        +"\nSORTEIO.: "
	        +String.valueOf(Sorteio)
	        +"\nDOACAO..: "
	        +String.valueOf(valor)
			+"\nCODIGO..: 194 "
			+String.valueOf(Codigo)
			+"\n--------------------------------\nDOADO: "
	        +String.valueOf(valor)
	        +" - "
	        +String.valueOf(qtde)
	        +cupom
	        +"\nDE: "
	        +String.valueOf(nJogo)
	        +" ATE "
	        +String.valueOf(nJogo+qtde-1)
	        +"\n"
	        +"--------------------------------\n"
	        ;
			linha.put("tipo", 1);
			linha.put("alinhamento", "left");
			linha.put("texto", cabecalho);
			retorno.put(nLinha++, linha);
			
			for(int i=0;i<qtde;i++) {
				int nJogo2=nJogo+i;
				String[] bolas = new String[15];
				for(int arr=0;arr<bolas.length;arr++) {
					bolas[arr]=String.format("%02d", (int) ((Math.random() * (90 - 1)) + 1));
				}
				Arrays.sort(bolas);
			HashMap<String, Object> linha2 = new HashMap<String, Object>();
			linha2.put("tipo", 2);
			linha2.put("alinhamento", "middle");
			linha2.put("texto", "N. "+nJogo2+" SORTEIO: "+Sorteio+"\n");
			retorno.put(nLinha++,linha2);

			HashMap<String, Object> linha3 = new HashMap<String, Object>();
			linha3.put("tipo", 1);
			linha3.put("alinhamento", "middle");
			linha3.put("texto", "------------------------------\n");
			retorno.put(nLinha++,linha3);

			HashMap<String, Object> linha4 = new HashMap<String, Object>();
			linha4.put("tipo", 3);
			linha4.put("alinhamento", "middle");
			linha4.put("texto", bolas[0]+"|"+bolas[3]+"|"+bolas[6]+"|"+bolas[9]+"|"+bolas[12]+"\n");
			retorno.put(nLinha++,linha4);

			HashMap<String, Object> linha5 = new HashMap<String, Object>();
			linha5.put("tipo", 1);
			linha5.put("alinhamento", "middle");
			linha5.put("texto", "------------------------------\n");
			retorno.put(nLinha++,linha5);

			HashMap<String, Object> linha6 = new HashMap<String, Object>();
			linha6.put("tipo", 3);
			linha6.put("alinhamento", "middle");
			linha6.put("texto", bolas[1]+"|"+bolas[4]+"|"+bolas[7]+"|"+bolas[10]+"|"+bolas[13]+"\n");
			retorno.put(nLinha++,linha6);

			HashMap<String, Object> linha7 = new HashMap<String, Object>();
			linha7.put("tipo", 1);
			linha7.put("alinhamento", "middle");
			linha7.put("texto", "------------------------------\n");
			retorno.put(nLinha++,linha7);

			HashMap<String, Object> linha8 = new HashMap<String, Object>();
			linha8.put("tipo", 3);
			linha8.put("alinhamento", "middle");
			linha8.put("texto", bolas[2]+"|"+bolas[5]+"|"+bolas[8]+"|"+bolas[11]+"|"+bolas[14]+"\n");
			retorno.put(nLinha++,linha8);

			HashMap<String, Object> linha9 = new HashMap<String, Object>();
			linha9.put("tipo", 1);
			linha9.put("alinhamento", "middle");
			linha9.put("texto", "------------------------------\n\n");
			retorno.put(nLinha++,linha9);
			}

			HashMap<String, Object> linha10 = new HashMap<String, Object>();
			linha10.put("tipo", 2);
			linha10.put("alinhamento", "left");
			linha10.put("texto", "DOADO: "+valor+" - "+qtde+" "+cupom
					+"\nDE: "+String.valueOf(nJogo)+" ATE "+String.valueOf(nJogo+qtde-1));
			retorno.put(nLinha++,linha10);
			
			HashMap<String, Object> linha11 = new HashMap<String, Object>();
			linha11.put("tipo", 1);
			linha11.put("alinhamento", "left");
			linha11.put("texto", "\n--------------------------------\nVALIDACAO: 25347\n--------------------------------\nAQUI VAI O TOKEN\n--------------------------------\nCNPJ XX.XXX.XXX/XXXX-XX\nautorizado nos termos das leis\nn. 13.019/2014 com alteracoes\nintroduzidas pela lei\nn. 13.204/2015 art III\nparticipe, concorra a premios!\n--------------------------------\n");
			retorno.put(nLinha++,linha11);
			
			HashMap<String, Object> linha12 = new HashMap<String, Object>();
			linha12.put("tipo", 2);
			linha12.put("alinhamento", "left");
			linha12.put("texto", "TOTAL DOADO: "+valor);
			retorno.put(nLinha++,linha12);

			HashMap<String, Object> linha13 = new HashMap<String, Object>();
			linha13.put("tipo", 1);
			linha13.put("alinhamento", "left");
			linha13.put("texto", "\n--------------------------------");
			retorno.put(nLinha++,linha13);
			
			System.out.println(qtde);
			System.out.println(valor);
			System.out.println(header);
			
		} catch(Exception e) {

			String classe = "sorteios";
			String pacote = "br.com.bingo.controllers";
			sec_errosController erro = new sec_errosController();
			erro.SalvarErro(e, header, pacote, classe, "SalvarContrato");

			
		}	
	return retorno;
	}
	
}


