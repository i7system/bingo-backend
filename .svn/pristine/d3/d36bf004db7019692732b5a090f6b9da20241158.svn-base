package br.com.bingo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.PortListasBotoes;
import br.com.bingo.repository.port_listas_botoesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_listas_botaoController")
@CrossOrigin(origins="*")

public class port_listas_botoesController {

	@Autowired
	port_listas_botoesRepository port_listas_botoesRepository;
	
	@GetMapping("PortListasbotoes")
	@ApiOperation(value="lista todos os PortListasbotoes em ordem crescente")
	public List<PortListasBotoes> listarport_listas_botoes(){
		return port_listas_botoesRepository.findAll();		
	}
	
	
	@GetMapping("PortListasbotoes/{IDbotoes}")
	@ApiOperation(value="retorna 1 PortListasbotoes por IDBOTAO")
	public PortListasBotoes listarport_listas_botoesId(@PathVariable(value="IDBOTAO") int IDBOTAO){
		return port_listas_botoesRepository.findByIDBOTAO(IDBOTAO);
	}
	
	@PostMapping("PortListasBotao")
	@ApiOperation(value="cria um novo PortListasBotao")
	public PortListasBotoes salvarport_listas_botao(@RequestBody PortListasBotoes PortListasBotoes) {	
		return port_listas_botoesRepository.save(PortListasBotoes);
	}

	@DeleteMapping("PortListasBotao/{IDBOTAO}")
	@ApiOperation(value="Exclui um PortListasBotao")
	public void excluirport_listas_botao(@PathVariable int IDBOTAO) {	
		port_listas_botoesRepository.deleteById(IDBOTAO);
	}

	@PutMapping("PortListasBotao")
	@ApiOperation(value="atualiza um PortListasBotao")
	public PortListasBotoes atualizarport_listas_botao(@RequestBody PortListasBotoes PortListasBotoes) {	
		return port_listas_botoesRepository.save(PortListasBotoes);
	}

}
