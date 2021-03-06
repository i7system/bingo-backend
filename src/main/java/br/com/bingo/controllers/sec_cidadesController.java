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
import br.com.bingo.models.SecUfs;
import br.com.bingo.models.SecCidades;
import br.com.bingo.repository.sec_empresasRepository;
import br.com.bingo.repository.sec_cidadesRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_cidadesController")
@CrossOrigin(origins="*")

public class sec_cidadesController {

	@Autowired
	private sec_cidadesRepository sec_cidadesRepository;
	
	@GetMapping("SecCidades")
	@ApiOperation(value="lista todos as SecCidades em ordem crescente")
	public List<SecCidades> listarsec_empresas(){
		return sec_cidadesRepository.findAll();		
	}
	
	@GetMapping("SecCidades/{IDCIDADE}")
	@ApiOperation(value="retorna 1 SecCidades por IDCIDADE")
	public SecCidades listarsec_empresasId(@PathVariable(value="IDCIDADE") int IDCIDADE){
		return sec_cidadesRepository.findByIDCIDADE(IDCIDADE);
	}
	
	@ResponseBody
	@PostMapping("SecCidades/UF")
	@ApiOperation(value="Listar cidades por iduf")
	public List<SecCidades> listarciadesuf(@RequestBody HashMap<String,Integer>JsonIduf) {	
		int IDUF = JsonIduf.get("iduf");
		List<SecCidades> listacidades = null;
		try {
			listacidades = sec_cidadesRepository.listarCidadesByIDUF(IDUF);
		}catch(Exception e) {
			System.out.println("Erro : "+e.getMessage());
		}
		
		return listacidades;
	}
	
	@ResponseBody
	@PostMapping("/BuscarCidade")
	@ApiOperation(value="retorna 1 SecUfs por IDUF")
	public SecCidades TrazerCidade(@RequestBody HashMap<String,Object> JsonIdcidade){
		
		int IDCIDADE = (int)JsonIdcidade.get("IDCIDADE");
		SecCidades cidade = null;
		
		try {
			cidade = sec_cidadesRepository.findByIDCIDADE(IDCIDADE);
		}catch(Exception e) {
			System.out.println("Erro : " + e.getMessage());
			
		}
		return cidade;
	}


	@DeleteMapping("SecCidades")
	@ApiOperation(value="Exclui um SecCidades")
	public void excluirsec_empresas(@RequestBody SecCidades SecCidades) {	
		sec_cidadesRepository.delete(SecCidades);
	}

	@PutMapping("SecCidades")
	@ApiOperation(value="atualiza um SecCidades")
	public SecCidades atualizarsec_empresas(@RequestBody SecCidades SecCidades) {	
		return sec_cidadesRepository.save(SecCidades);
	}
	
}
