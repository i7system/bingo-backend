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

import br.com.bingo.models.PortTecnologias;
import br.com.bingo.repository.port_tecnologiasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_tecnologiasController")
@CrossOrigin(origins="*")

public class port_tecnologiasController {

	@Autowired
	port_tecnologiasRepository port_tecnologiasRepository;
	
	@GetMapping("PortTecnologias")
	@ApiOperation(value="lista todos os PortTecnologias em ordem crescente")
	public List<PortTecnologias> listarport_tecnologias(){
		return port_tecnologiasRepository.findAll();		
	}
	
	
	@GetMapping("PortTecnologias/{IDTECNOLOGIA}")
	@ApiOperation(value="retorna 1 PortTecnologias por IDTECNOLOGIA")
	public PortTecnologias listarport_tecnologiasId(@PathVariable(value="IDTECNOLOGIA") int IDTECNOLOGIA){
		return port_tecnologiasRepository.findByIDTECNOLOGIA(IDTECNOLOGIA);
	}
	
	@PostMapping("PortTecnologias")
	@ApiOperation(value="cria um novo PortTecnologias")
	public PortTecnologias salvarport_tecnologias(@RequestBody PortTecnologias PortTecnologias) {	
		return port_tecnologiasRepository.save(PortTecnologias);
	}

	@DeleteMapping("PortTecnologias/{IDTECNOLOGIA}")
	@ApiOperation(value="Exclui um PortTecnologias")
	public void excluirport_tecnologias(@PathVariable int IDTECNOLOGIA) {	
		port_tecnologiasRepository.deleteById(IDTECNOLOGIA);
	}

	@PutMapping("PortTecnologias")
	@ApiOperation(value="atualiza um PortTecnologias")
	public PortTecnologias atualizarport_tecnologias(@RequestBody PortTecnologias PortTecnologias) {	
		return port_tecnologiasRepository.save(PortTecnologias);
	}

	
}
