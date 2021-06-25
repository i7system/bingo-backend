package br.com.bingo.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.models.BingoParametros;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.bingo_parametrosRepository;

@RestController
@RequestMapping(value="/bingo")
@Api("bingo_parametrosController")
@CrossOrigin(origins="*")

public class bingo_parametrosController {

	@Autowired
	bingo_parametrosRepository bingo_parametrosRepository;
	
	@DeleteMapping("/DeletarParametro")
	@ApiOperation(value="Exclui um parametro")
	public HashMap<String,String> DeletarParametro(@RequestBody HashMap<String,Object>JsonIdparametro) {	
		HashMap<String,String> retorno = new  HashMap<String,String>();
		try {
			
			int IDPARAMETRO = (int)JsonIdparametro.get("idparametro");
			bingo_parametrosRepository.deleteById(IDPARAMETRO);
			retorno.put("mensagem", "OK");
			
		}catch(Exception erro){
				System.out.println("Erro: "+erro.getMessage());
		}
		return retorno;
	}

	
	@ResponseBody
	@PostMapping("/BuscarParametro")
	@ApiOperation(value="retorna 1 parâmetro por IDPARAMETRO")
	public BingoParametros BuscarParametro(@RequestBody HashMap<String,Object> JsonIdparametro){
		
		int IDPARAMETRO = (int)JsonIdparametro.get("IDPARAMETRO");
		BingoParametros parametro = null;
		
		try {
			parametro = bingo_parametrosRepository.findByIDPARAMETRO(IDPARAMETRO);
		}catch(Exception e) {
			System.out.println("Erro : " + e.getMessage());
			
		}
		return parametro;
	}

	
	@GetMapping("/BingoParametros")
	@ApiOperation(value="lista todos os BingoParametros em ordem crescente")
	public List<BingoParametros> listarbingo_parametros(){
		
		List retorno = null;
		try {
			retorno = bingo_parametrosRepository.findAll();
		}catch(Exception e) {
			System.out.println("Erro : "+e.getMessage());
		}
		
		return retorno;
	}
	
	@PostMapping("BingoParametros")
	@ApiOperation(value="cria um novo BingoParametros")
	public BingoParametros salvarbingo_parametros(@RequestBody BingoParametros BingoParametros) {	
		return bingo_parametrosRepository.save(BingoParametros);
	}

	@PutMapping("BingoParametros")
	@ApiOperation(value="atualiza um BingoParametros")
	public BingoParametros atualizarbingo_parametros(@RequestBody BingoParametros BingoParametros) {	
		return bingo_parametrosRepository.save(BingoParametros);
	}
	
	@PostMapping("/SalvarParametro")
	@ApiOperation(value="salvar parametro")
	public HashMap<String, Object> SalvarParametro(@RequestBody BingoParametros BingoParametros, @RequestHeader HttpHeaders header) {	
		
		HashMap<String, Object> retorno = new HashMap<String,Object>();
		
		String validacao = "S";
				
		try {
			
			if(BingoParametros.getNOMEPARAMETRO().length() == 0) {
				
				validacao = "N";
			}
			
			if(BingoParametros.getSTATUS()== 0) {
				validacao = "N";
			}
			
			if(BingoParametros.getVALORPADRAO().length() == 0) {
				validacao = "N";
			}

		
			//SE NAO TIVER IDPARAMETRO, CRIE UM NOVO PARAMETRO
			
			if(BingoParametros.getIDPARAMETRO() == 0) {
				
				BingoParametros parametro = new BingoParametros();
				
				if(validacao == "S") {
					
				parametro.setNOMEPARAMETRO(BingoParametros.getNOMEPARAMETRO());
				parametro.setSTATUS(BingoParametros.getSTATUS());
				parametro.setVALORPADRAO(BingoParametros.getVALORPADRAO());
				bingo_parametrosRepository.save(parametro);
				
				retorno.put("validacao", "S");
				retorno.put("mensagem", "novo parametro criado com sucesso !");
				}

				
			}else {
				//SE TIVER IDPARAMETRO, PEGUE O PARAMETRO POR IDPARAMETRO E ATUALIZE
				BingoParametros parametro = bingo_parametrosRepository.findByIDPARAMETRO(BingoParametros.getIDPARAMETRO());
				
				if(validacao == "S") {
					
					parametro.setNOMEPARAMETRO(BingoParametros.getNOMEPARAMETRO());
					parametro.setSTATUS(BingoParametros.getSTATUS());
					parametro.setVALORPADRAO(BingoParametros.getVALORPADRAO());
					bingo_parametrosRepository.save(parametro);
					
					retorno.put("validacao", "S");
					retorno.put("mensagem", "seu parametro foi atualizado com sucesso !");
					}

			}

		}catch(Exception e) {
				System.out.println("Erro : "+e.getMessage());
		}
		
		
			
		
		return retorno;
	}


	
}
