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

import br.com.bingo.models.PortHomesBreadcrumbs;
import br.com.bingo.repository.port_homes_breadcrumbsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_homesController")
@CrossOrigin(origins="*")

public class port_homes_breadcrumbsController {

	@Autowired
	private port_homes_breadcrumbsRepository servico01;
	
	@GetMapping("PortHomesBreadcrumbs")
	@ApiOperation(value="lista todos as PortHomesBreadcrumbs em ordem crescente")
	public List<PortHomesBreadcrumbs> listarport_homes_breadcrumbs(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortHomesBreadcrumbs/{IDBREADCRUMB}")
	@ApiOperation(value="retorna 1 PortHomesBreadcrumbs por IDBREADCRUMB")
	public List<PortHomesBreadcrumbs> listarport_homes_breadcrumbsId(@PathVariable(value="IDBREADCRUMB") int IDBREADCRUMB){
		return servico01.findByIDBREADCRUMB(IDBREADCRUMB);
	}

	@GetMapping("PortHomesBreadcrumbsbyIDHOME/{IDHOME}")
	@ApiOperation(value="retorna 1 PortHomesBreadcrumbs por IDHOME")
	public List<PortHomesBreadcrumbs> listarPortHomesBreadcrumbsbyIDHOME(@PathVariable(value="IDHOME") int IDHOME){
		return servico01.findByIDHOME(IDHOME);
	}

	
	@PostMapping("PortHomesBreadcrumbs")
	@ApiOperation(value="cria um novo PortHomesBreadcrumbs")
	public PortHomesBreadcrumbs salvarport_homes_breadcrumbs(@RequestBody PortHomesBreadcrumbs PortHomesBreadcrumbs) {	
		return servico01.save(PortHomesBreadcrumbs);
	}

	@DeleteMapping("PortHomesBreadcrumbs")
	@ApiOperation(value="Exclui um PortHomesBreadcrumbs")
	public void excluirport_homes_breadcrumbs(@RequestBody PortHomesBreadcrumbs PortHomesBreadcrumbs) {	
		servico01.delete(PortHomesBreadcrumbs);
	}

	@PutMapping("PortHomesBreadcrumbs")
	@ApiOperation(value="atualiza um PortHomesBreadcrumbs")
	public PortHomesBreadcrumbs atualizarport_homes_breadcrumbs(@RequestBody PortHomesBreadcrumbs PortHomesBreadcrumbs) {	
		return servico01.save(PortHomesBreadcrumbs);
	}
	
}
