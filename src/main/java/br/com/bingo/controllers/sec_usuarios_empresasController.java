
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

import br.com.bingo.models.SecUsuariosEmpresas;
import br.com.bingo.repository.sec_usuarios_empresasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_usuarios_empresasController")
@CrossOrigin(origins="*")

public class sec_usuarios_empresasController {

	@Autowired
	sec_usuarios_empresasRepository sec_usuarios_empresasRepository;
	
	@GetMapping("SecUsuariosEmpresas")
	@ApiOperation(value="lista todos os SecUsuariosEmpresas em ordem crescente")
	public List<SecUsuariosEmpresas> listarsec_usuarios_empresas(){
		return sec_usuarios_empresasRepository.findAll();		
	}
	
	@GetMapping("SecUsuariosEmpresas/{IDUSUARIOEMPRESA}")
	@ApiOperation(value="retorna 1 SecUsuariosEmpresas por IDUSUARIOEMPRESA")
	public List<SecUsuariosEmpresas> listarsec_usuarios_empresasID(@PathVariable(value="IDUSUARIOEMPRESA") int IDUSUARIOEMPRESA){
		return sec_usuarios_empresasRepository.findByIDUSUARIOEMPRESA(IDUSUARIOEMPRESA);
	}
	
	@PostMapping("SecUsuariosEmpresas")
	@ApiOperation(value="cria um novo SecUsuariosEmpresas")
	public SecUsuariosEmpresas salvarsec_usuarios_empresas(@RequestBody SecUsuariosEmpresas SecUsuariosEmpresas) {	
		return sec_usuarios_empresasRepository.save(SecUsuariosEmpresas);
	}

	@DeleteMapping("SecUsuariosEmpresas")
	@ApiOperation(value="Exclui um SecUsuariosEmpresas")
	public void excluirsec_usuarios_empresas(@RequestBody SecUsuariosEmpresas SecUsuariosEmpresas) {	
		sec_usuarios_empresasRepository.delete(SecUsuariosEmpresas);
	}

	@PutMapping("SecUsuariosEmpresas")
	@ApiOperation(value="atualiza um SecUsuariosEmpresas")
	public SecUsuariosEmpresas atualizarsec_usuarios_empresas(@RequestBody SecUsuariosEmpresas SecUsuariosEmpresas) {	
		return sec_usuarios_empresasRepository.save(SecUsuariosEmpresas);
	}
	
}
