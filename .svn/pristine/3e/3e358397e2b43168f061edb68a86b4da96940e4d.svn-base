package br.com.bingo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.PortMensagensCategorias;
import br.com.bingo.repository.port_mensagens_categoriasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("port_mensagens_categoriasController")

public class port_mensagens_categoriasController {

	@Autowired
	private port_mensagens_categoriasRepository servico01;
	
	@GetMapping("PortMensagensCategorias")
	@ApiOperation(value="lista todos as PortMensagensCategorias em ordem crescente")
	public List<PortMensagensCategorias> listarport_mensagens_categorias(){
		return servico01.findAll();		
	}
	
	@GetMapping("PortMensagensCategoriasAtivos")
	@ApiOperation(value="lista todos as PortMensagensCategorias em ordem crescente ativo")
	
	public List<PortMensagensCategorias> lista_DesCabelos() {			
		Pageable pagina = PageRequest.of(0, 100, Sort.by("IDCATEGORIA").ascending());
		return servico01.lista_ativos(pagina);
	}

	
	@GetMapping("PortMensagensCategorias/{IDCATEGORIA}")
	@ApiOperation(value="retorna 1 PortMensagensCategorias por IDCATEGORIA")
	public List<PortMensagensCategorias> listarport_mensagens_categoriasId(@PathVariable(value="IDCATEGORIA") int IDCATEGORIA){
		return servico01.findByIDCATEGORIA(IDCATEGORIA);
	}
	
	@PostMapping("PortMensagensCategorias")
	@ApiOperation(value="cria um novo PortMensagensCategorias")
	public PortMensagensCategorias salvarport_mensagens_categorias(@RequestBody PortMensagensCategorias PortMensagensCategorias) {	
		return servico01.save(PortMensagensCategorias);
	}

	@DeleteMapping("PortMensagensCategorias")
	@ApiOperation(value="Exclui um PortMensagensCategorias")
	public void excluirport_mensagens_categorias(@RequestBody PortMensagensCategorias PortMensagensCategorias) {	
		servico01.delete(PortMensagensCategorias);
	}

	@PutMapping("PortMensagensCategorias")
	@ApiOperation(value="atualiza um PortMensagensCategorias")
	public PortMensagensCategorias atualizarport_mensagens_categorias(@RequestBody PortMensagensCategorias PortMensagensCategorias) {	
		return servico01.save(PortMensagensCategorias);
	}
	
	
	

	
	
}
