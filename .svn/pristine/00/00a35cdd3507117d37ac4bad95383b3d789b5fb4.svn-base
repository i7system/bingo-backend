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

import br.com.bingo.models.PortTemplatesPaginas;
import br.com.bingo.repository.port_templatesRepository;
import br.com.bingo.repository.port_templates_paginasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_templates_paginasController")
@CrossOrigin(origins="*")

public class port_templates_paginasController {

	@Autowired
	private port_templates_paginasRepository servico01;
	
	@GetMapping("PortTemplatesPaginas")
	@ApiOperation(value="lista todos as PortTemplatesPaginas em ordem crescente")
	public List<PortTemplatesPaginas> listarport_templates_paginas(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortTemplatesPaginas/{IDPAGINA}")
	@ApiOperation(value="retorna 1 PortTemplatesPaginas por IDPAGINA")
	public List<PortTemplatesPaginas> listarport_templates_paginasId(@PathVariable(value="IDPAGINA") int IDPAGINA){
		return servico01.findByIDPAGINA(IDPAGINA);
	}
	
	@PostMapping("PortTemplatesPaginas")
	@ApiOperation(value="cria um novo PortTemplatesPaginas")
	public PortTemplatesPaginas salvarport_templates_paginas(@RequestBody PortTemplatesPaginas PortTemplatesPaginas) {	
		return servico01.save(PortTemplatesPaginas);
	}

	@DeleteMapping("PortTemplatesPaginas")
	@ApiOperation(value="Exclui um PortTemplatesPaginas")
	public void excluirport_templates_paginas(@RequestBody PortTemplatesPaginas PortTemplatesPaginas) {	
		servico01.delete(PortTemplatesPaginas);
	}

	@PutMapping("PortTemplatesPaginas")
	@ApiOperation(value="atualiza um PortTemplatesPaginas")
	public PortTemplatesPaginas atualizarport_templates_paginas(@RequestBody PortTemplatesPaginas PortTemplatesPaginas) {	
		return servico01.save(PortTemplatesPaginas);
	}
	
	
	

	
	
}
