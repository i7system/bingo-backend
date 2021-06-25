package br.com.bingo.controllers;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.SecEmpresas;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUfs;
import br.com.bingo.repository.sec_empresasRepository;
import br.com.bingo.repository.sec_ufsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_ufsController")
@CrossOrigin(origins="*")

public class sec_ufsController {

	@Autowired
	private sec_ufsRepository sec_ufsRepository;
	
	@GetMapping("SecUfs")
	@ApiOperation(value="lista todos as SecUfs em ordem crescente")
	public List<SecUfs> listarsec_empresas(){
		return sec_ufsRepository.findAll();		
	}
	
	
	@ResponseBody
	@PostMapping("/BuscarUf")
	@ApiOperation(value="retorna 1 SecUfs por IDUF")
	public SecUfs TrazerUf(@RequestBody HashMap<String,Object> JsonIduf){
		
		int IDUF = (int)JsonIduf.get("IDUF");
		SecUfs uf = null;
		
		try {
			uf = sec_ufsRepository.findByIDUF(IDUF);
		}catch(Exception e) {
			System.out.println("Erro : " + e.getMessage());
			
		}
		return uf;
	}
	
	@PostMapping("SecUfs")
	@ApiOperation(value="cria um novo SecUfs")
	public SecUfs salvarsec_empresas(@RequestBody SecUfs SecUfs) {	
		return sec_ufsRepository.save(SecUfs);
	}

	@DeleteMapping("SecUfs")
	@ApiOperation(value="Exclui um SecUfs")
	public void excluirsec_empresas(@RequestBody SecUfs SecUfs) {	
		sec_ufsRepository.delete(SecUfs);
	}

	@PutMapping("SecUfs")
	@ApiOperation(value="atualiza um SecUfs")
	public SecUfs atualizarsec_empresas(@RequestBody SecUfs SecUfs) {	
		return sec_ufsRepository.save(SecUfs);
	}
	
}
