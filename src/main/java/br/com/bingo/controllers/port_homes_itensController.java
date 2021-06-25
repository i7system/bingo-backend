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

import br.com.bingo.models.PortHomesItens;
import br.com.bingo.repository.port_homes_itensRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_homesController")
@CrossOrigin(origins="*")

public class port_homes_itensController {

	@Autowired
	private port_homes_itensRepository servico01;
	
	@GetMapping("PortHomesItens")
	@ApiOperation(value="lista todos as PortHomesItens em ordem crescente")
	public List<PortHomesItens> listarport_homes_itens(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortHomesItens/{IDITEM}")
	@ApiOperation(value="retorna 1 PortHomesItens por IDITEM")
	public List<PortHomesItens> listarport_homes_itensId(@PathVariable(value="IDITEM") int IDITEM){
		return servico01.findByIDITEM(IDITEM);
	}

	@GetMapping("PortHomesItensbyIDHOME/{IDHOME}")
	@ApiOperation(value="retorna 1 PortHomesItens por IDITEM")
	public List<PortHomesItens> listarPortHomesItensbyIDHOME(@PathVariable(value="IDHOME") int IDHOME){
		return servico01.findByIDHOME(IDHOME);
	}

	
	@PostMapping("PortHomesItens")
	@ApiOperation(value="cria um novo PortHomesItens")
	public PortHomesItens salvarport_homes_itens(@RequestBody PortHomesItens PortHomesItens) {	
		return servico01.save(PortHomesItens);
	}

	@DeleteMapping("PortHomesItens")
	@ApiOperation(value="Exclui um PortHomesItens")
	public void excluirport_homes_itens(@RequestBody PortHomesItens PortHomesItens) {	
		servico01.delete(PortHomesItens);
	}

	@PutMapping("PortHomesItens")
	@ApiOperation(value="atualiza um PortHomesItens")
	public PortHomesItens atualizarport_homes_itens(@RequestBody PortHomesItens PortHomesItens) {	
		return servico01.save(PortHomesItens);
	}
	
}
