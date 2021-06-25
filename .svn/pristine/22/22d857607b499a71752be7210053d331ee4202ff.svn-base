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

import br.com.bingo.models.PortAcoes;
import br.com.bingo.repository.port_acoesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_acoesController")
@CrossOrigin(origins="*")

public class port_acoesController {

	@Autowired
	private port_acoesRepository servico01;
	
	@GetMapping("PortAcoes")
	@ApiOperation(value="lista todos as PortAcoes em ordem crescente")
	public List<PortAcoes> listarport_acoes(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortAcoes/{IDACAO}")
	@ApiOperation(value="retorna 1 PortAcoes por IDACAO")
	public List<PortAcoes> listarport_acoesId(@PathVariable(value="IDACAO") int IDACAO){
		return servico01.findByIDACAO(IDACAO);
	}
	
	@PostMapping("PortAcoes")
	@ApiOperation(value="cria um novo PortAcoes")
	public PortAcoes salvarport_acoes(@RequestBody PortAcoes PortAcoes) {	
		return servico01.save(PortAcoes);
	}

	@DeleteMapping("PortAcoes")
	@ApiOperation(value="Exclui um PortAcoes")
	public void excluirport_acoes(@RequestBody PortAcoes PortAcoes) {	
		servico01.delete(PortAcoes);
	}

	@PutMapping("PortAcoes")
	@ApiOperation(value="atualiza um PortAcoes")
	public PortAcoes atualizarport_acoes(@RequestBody PortAcoes PortAcoes) {	
		return servico01.save(PortAcoes);
	}
	
	
	

	
	
}
