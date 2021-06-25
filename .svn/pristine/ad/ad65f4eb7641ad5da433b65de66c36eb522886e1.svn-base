package br.com.bingo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import br.com.bingo.models.PortUsuariosMensagens;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.port_usuarios_mensagensRepository;
import br.com.bingo.repository.sec_usuariosRepository;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.parametros;

@RestController
@RequestMapping(value="/bingo")
@Api("port_usuarios_mensagensController")

public class port_usuarios_mensagensController {
	@Autowired
	private port_usuarios_mensagensRepository port_usuarios_mensagensRepository;
	
	@Autowired
	private sec_usuariosRepository sec_usuariosRepository;
	
	@GetMapping("PortUsuariosMensagens")
	@ApiOperation(value="lista todos os SecUsuariosMensagens em ordem crescente")
	public List<PortUsuariosMensagens> listarport_usuarios_mensagens(){
		return port_usuarios_mensagensRepository.findAll();		
	}

	@PostMapping("PortUsuariosMensagens/Usuario")
	@ApiOperation(value="lista todos as PortUsuariosMensagens em ordem crescente ativo")	
	public List<PortUsuariosMensagens> PortUsuariosMensagens(@RequestHeader HttpHeaders headers) {	
		
		
		
		
		String token=headers.get("authorization").get(0);
		
		int idusuario = UsuariosLogados.BuscarUsuario(headers).getIDUSUARIO();
		
		Pageable pagina = PageRequest.of(0, 100, Sort.by("IDMENSAGEM").ascending().and(Sort.by("DATA").descending()));
		
		return port_usuarios_mensagensRepository.listar_mensagem_usuario(pagina,idusuario);
	}
	
	@GetMapping("PortUsuariosMensagens/{IDMENSAGEM}")
	@ApiOperation(value="retorna 1 SecUsuariosMensagens por IDMENSAGEM")
	public List<PortUsuariosMensagens> listarport_usuarios_mensagensID(@PathVariable(value="IDMENSAGEM") int IDMENSAGEM){
		return port_usuarios_mensagensRepository.findByIDMENSAGEM(IDMENSAGEM);
	}
	
	@PostMapping("SecUsuariosMensagens")
	@ApiOperation(value="cria um novo SecUsuariosMensagens")
	public PortUsuariosMensagens salvarport_usuarios_mensagens(@RequestBody PortUsuariosMensagens PortUsuariosMensagens) {	
		return port_usuarios_mensagensRepository.save(PortUsuariosMensagens);
	}

	@DeleteMapping("SecUsuariosMensagens")
	@ApiOperation(value="Exclui um SecUsuariosMensagens")
	public void excluirport_usuarios_mensagens(@RequestBody PortUsuariosMensagens PortUsuariosMensagens) {	
		port_usuarios_mensagensRepository.delete(PortUsuariosMensagens);
	}

	@PutMapping("SecUsuariosMensagens")
	@ApiOperation(value="atualiza um SecUsuariosMensagens")
	public PortUsuariosMensagens atualizarport_usuarios_mensagens(@RequestBody PortUsuariosMensagens PortUsuariosMensagens) {	
		return port_usuarios_mensagensRepository.save(PortUsuariosMensagens);
	}
	
}
