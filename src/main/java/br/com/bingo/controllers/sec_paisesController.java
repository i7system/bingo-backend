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

import br.com.bingo.models.SecEmpresas;
import br.com.bingo.models.SecPaises;
import br.com.bingo.repository.sec_empresasRepository;
import br.com.bingo.repository.sec_paisesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_paisesController")
@CrossOrigin(origins="*")

public class sec_paisesController {

	@Autowired
	private sec_paisesRepository sec_paisesRepository;
	
	@GetMapping("SecPaises")
	@ApiOperation(value="lista todos as SecPaises em ordem crescente")
	public List<SecPaises> listarsec_empresas(){
		return sec_paisesRepository.findAll();		
	}
	
	@GetMapping("SecPaises/{IDPAIS}")
	@ApiOperation(value="retorna 1 SecPaises por IDPAIS")
	public List<SecPaises> listarsec_empresasId(@PathVariable(value="IDPAIS") int IDPAIS){
		return sec_paisesRepository.findByIDPAIS(IDPAIS);
	}
	
	@PostMapping("SecPaises")
	@ApiOperation(value="cria um novo SecPaises")
	public SecPaises salvarsec_empresas(@RequestBody SecPaises SecPaises) {	
		return sec_paisesRepository.save(SecPaises);
	}

	@DeleteMapping("SecPaises")
	@ApiOperation(value="Exclui um SecPaises")
	public void excluirsec_empresas(@RequestBody SecPaises SecPaises) {	
		sec_paisesRepository.delete(SecPaises);
	}

	@PutMapping("SecPaises")
	@ApiOperation(value="atualiza um SecPaises")
	public SecPaises atualizarsec_empresas(@RequestBody SecPaises SecPaises) {	
		return sec_paisesRepository.save(SecPaises);
	}
	
}
