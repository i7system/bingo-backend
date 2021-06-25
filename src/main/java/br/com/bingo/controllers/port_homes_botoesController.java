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

import br.com.bingo.models.PortHomesBotoes;
import br.com.bingo.repository.port_homes_botoesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_homes_botoesController")
@CrossOrigin(origins="*")

public class port_homes_botoesController {

	@Autowired
	private port_homes_botoesRepository servico01;
	
	@GetMapping("PortHomesBotoes")
	@ApiOperation(value="lista todos as PortHomesBotoes em ordem crescente")
	public List<PortHomesBotoes> listarport_homes_botoes(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortHomesBotoes/{IDBOTAO}")
	@ApiOperation(value="retorna 1 PortHomesBotoes por IDBOTAO")
	public List<PortHomesBotoes> listarport_homes_botoesId(@PathVariable(value="IDBOTAO") int IDBOTAO){
		return servico01.findByIDBOTAO(IDBOTAO);
	}

	@GetMapping("PortHomesBotoesbyIDBOTAO/{IDBOTAO}")
	@ApiOperation(value="retorna 1 PortHomesBotoes por IDBOTAO")
	public List<PortHomesBotoes> listarPortHomesBotoesbyIDBOTAO(@PathVariable(value="IDBOTAO") int IDBOTAO){
		return servico01.findByIDBOTAO(IDBOTAO);
	}

	
	@PostMapping("PortHomesBotoes")
	@ApiOperation(value="cria um novo PortHomesBotoes")
	public PortHomesBotoes salvarport_homes_botoes(@RequestBody PortHomesBotoes PortHomesBotoes) {	
		return servico01.save(PortHomesBotoes);
	}

	@DeleteMapping("PortHomesBotoes")
	@ApiOperation(value="Exclui um PortHomesBotoes")
	public void excluirport_homes_botoes(@RequestBody PortHomesBotoes PortHomesBotoes) {	
		servico01.delete(PortHomesBotoes);
	}

	@PutMapping("PortHomesBotoes")
	@ApiOperation(value="atualiza um PortHomesBotoes")
	public PortHomesBotoes atualizarport_homes_botoes(@RequestBody PortHomesBotoes PortHomesBotoes) {	
		return servico01.save(PortHomesBotoes);
	}
	
}
