package br.com.bingo.controllers;

import java.sql.Timestamp;
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
import br.com.bingo.models.SecEmpresas;
import br.com.bingo.models.SecErros;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.sec_empresasRepository;
import br.com.bingo.repository.sec_errosRepository;
import br.com.bingo.UsuariosLogados;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_errosController")
@CrossOrigin(origins="*")

public class sec_errosController {

	@Autowired
	private sec_errosRepository sec_errosRepository;
	
	@GetMapping("SecErros")
	@ApiOperation(value="lista todos as SecErros em ordem crescente")
	public List<SecErros> listarsec_empresas(){
		return sec_errosRepository.findAll();		
	}
	
	@GetMapping("SecErros/{IDERRO}")
	@ApiOperation(value="retorna 1 SecErros por IDERRO")
	public List<SecErros> listarsec_empresasId(@PathVariable(value="IDERRO") int IDERRO){
		return (List<SecErros>) sec_errosRepository.findByIDERRO(IDERRO);
	}
	
	@PostMapping("SecErros")
	@ApiOperation(value="cria um novo SecErros")
	public SecErros salvarsec_empresas(@RequestBody SecErros SecErros) {	
		return sec_errosRepository.save(SecErros);
	}

	@DeleteMapping("SecErros")
	@ApiOperation(value="Exclui um SecErros")
	public void excluirsec_empresas(@RequestBody SecErros SecErros) {	
		sec_errosRepository.delete(SecErros);
	}

	@PutMapping("SecErros")
	@ApiOperation(value="atualiza um SecErros")
	public SecErros atualizarsec_empresas(@RequestBody SecErros SecErros) {	
		return sec_errosRepository.save(SecErros);
	}
	

	public void SalvarErro(Exception excecao, @RequestHeader HttpHeaders header,String pacote, String classe, String metodo) {
		
		try {
			System.out.println("Erro : " + excecao);
			System.out.println("Request :" + excecao.getLocalizedMessage());
			System.out.println("Classe :" + excecao.getSuppressed());
			System.out.println("header: " + header);
			SecErros erro = new SecErros();
			Timestamp dataagora = new Timestamp(System.currentTimeMillis());
			
			SecUsuarios usuario=UsuariosLogados.BuscarUsuario(header);
			
			int idusuario = usuario.getIDUSUARIO();
			int idempresa = usuario.getIDEMPRESA();
			
		
		
		String mensagemerro = excecao.getMessage();
		
		if(excecao == null) {
			mensagemerro = "Erro de nulo, algumas informações foram passadas incorretamente, tente novamente";
			
		}
		
		erro.setCLASSE("aaaaaaaaa");
		erro.setDATAHORA(dataagora);
		erro.setERRO("aaaaaaa");
		erro.setIDEMPRESA(0);
		erro.setIDERRO(1);
		erro.setIDUSUARIO(1);
		erro.setMETODO("aaaaaaaaa");
		erro.setPACOTE("aaaaaaaaa");
		erro.setREQUEST("blablaaaaaaaa");
		erro.setSTATUS(1);
		
		
		sec_errosRepository.save(erro);

		}catch(Exception e) {
			System.out.println("==================SALVAR ERROS==================================");
			System.out.println("Erro : " + e.getMessage());
			System.out.println("Causa : " + e.getCause());
			System.out.println("=================================================================");
			
		}
		
		
		
		
	}
	
}
