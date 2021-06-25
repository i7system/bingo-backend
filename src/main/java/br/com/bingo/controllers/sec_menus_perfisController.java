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
import br.com.bingo.models.SecMenusPerfis;
import br.com.bingo.repository.sec_empresasRepository;
import br.com.bingo.repository.sec_menus_perfisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_menus_perfisController")
@CrossOrigin(origins="*")

public class sec_menus_perfisController {

	@Autowired
	private sec_menus_perfisRepository sec_menus_perfisRepository;
	
	@GetMapping("SecMenusPerfis")
	@ApiOperation(value="lista todos as SecMenusPerfis em ordem crescente")
	public List<SecMenusPerfis> listarsec_empresas(){
		return sec_menus_perfisRepository.findAll();		
	}
	
	@GetMapping("SecMenusPerfis/{IDMENUPERFIL}")
	@ApiOperation(value="retorna 1 SecMenusPerfis por IDMENUPERFIL")
	public List<SecMenusPerfis> listarsec_empresasId(@PathVariable(value="IDMENUPERFIL") int IDMENUPERFIL){
		return sec_menus_perfisRepository.findByIDMENUPERFIL(IDMENUPERFIL);
	}
	
	@PostMapping("SecMenusPerfis")
	@ApiOperation(value="cria um novo SecMenusPerfis")
	public SecMenusPerfis salvarsec_empresas(@RequestBody SecMenusPerfis SecMenusPerfis) {	
		return sec_menus_perfisRepository.save(SecMenusPerfis);
	}

	@DeleteMapping("SecMenusPerfis")
	@ApiOperation(value="Exclui um SecMenusPerfis")
	public void excluirsec_empresas(@RequestBody SecMenusPerfis SecMenusPerfis) {	
		sec_menus_perfisRepository.delete(SecMenusPerfis);
	}

	@PutMapping("SecMenusPerfis")
	@ApiOperation(value="atualiza um SecMenusPerfis")
	public SecMenusPerfis atualizarsec_empresas(@RequestBody SecMenusPerfis SecMenusPerfis) {	
		return sec_menus_perfisRepository.save(SecMenusPerfis);
	}
	
}
