
package br.com.bingo.controllers;

import java.util.HashMap;
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

import br.com.bingo.UsuariosLogados;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.models.SecUsuariosPerfis;
import br.com.bingo.repository.sec_usuarios_perfisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_usuarios_perfisController")
@CrossOrigin(origins="*")

public class sec_usuarios_perfisController {

	@Autowired
	sec_usuarios_perfisRepository sec_usuarios_perfisRepository;
	
	@DeleteMapping("/DeletarUsuarioPerfil")
	@ApiOperation(value="Exclui um usuario perfil")
	public HashMap<String,String> DeletarUsuarioPerfil(@RequestBody HashMap<String,Object>JsonIdusuarioperfil) {	
		HashMap<String,String> retorno = new  HashMap<String,String>();
		try {
			
			int IDUSUARIOPERFIL = (int)JsonIdusuarioperfil.get("idusuarioperfil");
			sec_usuarios_perfisRepository.deleteById(IDUSUARIOPERFIL);
			retorno.put("mensagem", "OK");
			
		}catch(Exception erro){
				System.out.println("Erro: "+erro.getMessage());
		}
		return retorno;
	}

	
	@GetMapping("ListarUsuarioPerfil/IDUSUARIO")
	@ApiOperation(value="lista todos os SecUsuariosPerfis em ordem crescente")
	public SecUsuariosPerfis ListarUsuarioPerfilIDUSUARIO(@RequestHeader HttpHeaders header){
		SecUsuariosPerfis retorno = null;
		int IDUSUARIO = UsuariosLogados.BuscarUsuario(header).getIDUSUARIO();
		try {
			retorno = sec_usuarios_perfisRepository.ListarUsuarioPerfilIDUSUARIO(IDUSUARIO);
		}catch(Exception e) {
			System.out.println("Erro : "+e.getMessage());
		}
		return retorno;
	}
	
	@GetMapping("SecUsuariosPerfis")
	@ApiOperation(value="lista todos os SecUsuariosPerfis em ordem crescente")
	public List<SecUsuariosPerfis> listarsec_usuarios_perfis(){
		return sec_usuarios_perfisRepository.findAll();		
	}
	
	@GetMapping("SecUsuariosPerfis/{IDUSUARIOPERFIL}")
	@ApiOperation(value="retorna 1 SecUsuariosPerfis por IDUSUARIOPERFIL")
	public List<SecUsuariosPerfis> listarsec_usuarios_perfisID(@PathVariable(value="IDUSUARIOPERFIL") int IDUSUARIOPERFIL){
		return sec_usuarios_perfisRepository.findByIDUSUARIOPERFIL(IDUSUARIOPERFIL);
	}
	

	
	@PostMapping("/SalvarUsuarioPerfil")
	@ApiOperation(value="salvar usuario perfil")
	public HashMap<String, Object> SalvarUsuarioPerfil(@RequestBody SecUsuariosPerfis SecUsuariosPerfis, @RequestHeader HttpHeaders header) {	
		
		HashMap<String, Object> retorno = new HashMap<String,Object>();
				
		try {
			
			SecUsuariosPerfis usuarioperfil = new SecUsuariosPerfis();
			usuarioperfil.setIDPERFIL(SecUsuariosPerfis.getIDPERFIL());
			usuarioperfil.setIDUSUARIO(SecUsuariosPerfis.getIDUSUARIO());
			usuarioperfil.setSTATUS(SecUsuariosPerfis.getSTATUS());
			sec_usuarios_perfisRepository.save(usuarioperfil);
			retorno.put("mensagem","OK");
		
		}catch(Exception e) {
				System.out.println("Erro : "+e.getMessage());
		}		
		return retorno;
	}


	@DeleteMapping("SecUsuariosPerfis")
	@ApiOperation(value="Exclui um SecUsuariosPerfis")
	public void excluirsec_usuarios_perfis(@RequestBody SecUsuariosPerfis SecUsuariosPerfis) {	
		sec_usuarios_perfisRepository.delete(SecUsuariosPerfis);
	}

	@PutMapping("SecUsuariosPerfis")
	@ApiOperation(value="atualiza um SecUsuariosPerfis")
	public SecUsuariosPerfis atualizarsec_usuarios_perfis(@RequestBody SecUsuariosPerfis SecUsuariosPerfis) {	
		return sec_usuarios_perfisRepository.save(SecUsuariosPerfis);
	}
	
}
