package br.com.bingo.controllers;

import java.util.ArrayList;
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

import br.com.bingo.models.SecIdiomas;
import br.com.bingo.repository.sec_idiomasRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_idiomasController")
@CrossOrigin(origins="*")

public class sec_idiomasController {

	@Autowired
	sec_idiomasRepository sec_idiomasRepository;
	
	@PostMapping("/ListarIdiomas")
	@ApiOperation(value="lista todos os SecIdiomas em ordem crescente")
	public List<SecIdiomas> listarsec_idiomas(){
		return sec_idiomasRepository.findAll();		
	}
	
	
	@GetMapping("/SecIdiomas/{IDIDIOMA}")
	@ApiOperation(value="retorna 1 SecIdiomas por IDIDIOMA")
	public SecIdiomas listarsec_idiomasId(@PathVariable(value="IDIDIOMA") int IDIDIOMA){
		return sec_idiomasRepository.findByIDIDIOMA(IDIDIOMA);
	}
	
	@PostMapping("/SalvarSecIdiomas")
	@ApiOperation(value="cria um novo SecIdiomas")
	public SecIdiomas salvarsec_idiomas(@RequestBody SecIdiomas SecIdiomas) {	
		return sec_idiomasRepository.save(SecIdiomas);
	}



	@DeleteMapping("SecIdiomas/{IDIDIOMA}")
	@ApiOperation(value="Exclui um SecIdiomas")
	public void excluirsec_idiomas(@PathVariable int IDIDIOMA) {	
		sec_idiomasRepository.deleteById(IDIDIOMA);
	}


	
}
