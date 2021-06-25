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

import br.com.bingo.models.PortHomes;
import br.com.bingo.repository.port_homesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_homesController")
@CrossOrigin(origins="*")

public class port_homesController {

	@Autowired
	private port_homesRepository servico01;
	
	@GetMapping("PortHomes")
	@ApiOperation(value="lista todos as PortHomes em ordem crescente")
	public List<PortHomes> listarport_homes(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortHomes/{IDHOME}")
	@ApiOperation(value="retorna 1 PortHomes por IDHOME")
	public List<PortHomes> listarport_homesId(@PathVariable(value="IDHOME") int IDHOME){
		return servico01.findByIDHOME(IDHOME);
	}
	
	@PostMapping("PortHomes")
	@ApiOperation(value="cria um novo PortHomes")
	public PortHomes salvarport_homes(@RequestBody PortHomes PortHomes) {	
		return servico01.save(PortHomes);
	}

	@DeleteMapping("PortHomes")
	@ApiOperation(value="Exclui um PortHomes")
	public void excluirport_homes(@RequestBody PortHomes PortHomes) {	
		servico01.delete(PortHomes);
	}

	@PutMapping("PortHomes")
	@ApiOperation(value="atualiza um PortHomes")
	public PortHomes atualizarport_homes(@RequestBody PortHomes PortHomes) {	
		return servico01.save(PortHomes);
	}
	
}
