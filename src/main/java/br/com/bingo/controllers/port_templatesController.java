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

import br.com.bingo.models.PortTemplates;
import br.com.bingo.repository.port_templatesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_templatesController")
@CrossOrigin(origins="*")

public class port_templatesController {

	@Autowired
	private port_templatesRepository servico01;
	
	@GetMapping("PortTemplates")
	@ApiOperation(value="lista todos as PortTemplates em ordem crescente")
	public List<PortTemplates> listarport_templates(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortTemplates/{IDTEMPLATE}")
	@ApiOperation(value="retorna 1 PortTemplates por IDTEMPLATE")
	public List<PortTemplates> listarport_templatesId(@PathVariable(value="IDTEMPLATE") int IDTEMPLATE){
		return servico01.findByIDTEMPLATE(IDTEMPLATE);
	}
	
	@PostMapping("PortTemplates")
	@ApiOperation(value="cria um novo PortTemplates")
	public PortTemplates salvarport_templates(@RequestBody PortTemplates PortTemplates) {	
		return servico01.save(PortTemplates);
	}

	@DeleteMapping("PortTemplates")
	@ApiOperation(value="Exclui um PortTemplates")
	public void excluirport_templates(@RequestBody PortTemplates PortTemplates) {	
		servico01.delete(PortTemplates);
	}

	@PutMapping("PortTemplates")
	@ApiOperation(value="atualiza um PortTemplates")
	public PortTemplates atualizarport_templates(@RequestBody PortTemplates PortTemplates) {	
		return servico01.save(PortTemplates);
	}
	
	
	

	
	
}
