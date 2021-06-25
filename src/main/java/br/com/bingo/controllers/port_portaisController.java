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

import br.com.bingo.models.PortPortais;
import br.com.bingo.repository.port_portaisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_portaisController")
@CrossOrigin(origins="*")

public class port_portaisController {

	@Autowired
	private port_portaisRepository servico01;
	
	@GetMapping("PortPortais")
	@ApiOperation(value="lista todos as PortPortais em ordem crescente")
	public List<PortPortais> listarport_portais(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortPortais/{IDPORTAL}")
	@ApiOperation(value="retorna 1 PortPortais por IDPORTAL")
	public List<PortPortais> listarport_portaisId(@PathVariable(value="IDPORTAL") int IDPORTAL){
		return servico01.findByIDPORTAL(IDPORTAL);
	}
	
	@PostMapping("PortPortais")
	@ApiOperation(value="cria um novo PortPortais")
	public PortPortais salvarport_portais(@RequestBody PortPortais PortPortais) {	
		return servico01.save(PortPortais);
	}

	@DeleteMapping("PortPortais")
	@ApiOperation(value="Exclui um PortPortais")
	public void excluirport_portais(@RequestBody PortPortais PortPortais) {	
		servico01.delete(PortPortais);
	}

	@PutMapping("PortPortais")
	@ApiOperation(value="atualiza um PortPortais")
	public PortPortais atualizarport_portais(@RequestBody PortPortais PortPortais) {	
		return servico01.save(PortPortais);
	}
	
	
	

	
	
}
