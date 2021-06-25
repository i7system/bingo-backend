package br.com.bingo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.models.PortMenus;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.port_menusRepository;
import br.com.bingo.views.MetisMenus;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.parametros;

@RestController
@RequestMapping(value="/bingo")
@Api("port_menus_oldController")

public class port_menusController {

	@Autowired
	private port_menusRepository servico01;
		
	@GetMapping("PortMenus")
	@ApiOperation(value="lista todos as PortMenus em ordem crescente")
	public List<PortMenus> listarport_menus(){
		return servico01.findAll();		
	}
		
	@GetMapping("PortMenus/Usuario")
	@ApiOperation(value="lista todos as PortMenus por usuario")
	public List<PortMenus> PortMenus_Usuario(@RequestHeader HttpHeaders headers){	
		List<PortMenus> listamenu = null;
		try {
			
			String token = headers.get("authorization").get(0);
			List<SecUsuarios> lista = new ArrayList<>();
			SecUsuarios retorno = UsuariosLogados.BuscarUsuario(headers);
			listamenu = servico01.lista_port_menus(retorno.getIDUSUARIO());

		}catch(Exception erro) {
				System.out.println("erro : "+erro);
		}
		return listamenu;
	}
	
	@GetMapping("PortMenus/{IDMENU}")
	@ApiOperation(value="retorna 1 PortMenus por IDMENU")
	public List<PortMenus> listarport_menusIdMENU(@PathVariable(value="IDMENU") int IDMENU){
		return servico01.findByIDMENU(IDMENU);
	}
	
	@PostMapping("PortMenus")
	@ApiOperation(value="cria um  PortMenus")
	public PortMenus salvarport_menus(@RequestBody PortMenus PortMenus) {	
		return servico01.save(PortMenus);
	}

	@DeleteMapping("PortMenus")
	@ApiOperation(value="Exclui um PortMenus")
	public void excluirport_menus(@RequestBody PortMenus PortMenus) {	
		servico01.delete(PortMenus);
	}

	@PutMapping("PortMenus")
	@ApiOperation(value="atualiza um PortMenus")
	public PortMenus atualizarport_menus(@RequestBody PortMenus PortMenus) {	
		return servico01.save(PortMenus);
	}
	
	
	

	
	
}
