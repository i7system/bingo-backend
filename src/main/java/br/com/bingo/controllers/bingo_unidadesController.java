
package br.com.bingo.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.models.BingoClientes;
import br.com.bingo.models.BingoUnidades;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.models.SecUsuariosPerfis;
import br.com.bingo.repository.bingo_unidadesRepository;
import br.com.bingo.repository.sec_usuariosRepository;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.parametros;
import br.com.bingo.repository.sec_usuarios_perfisRepository;
import br.com.bingo.views.Unidade;
import ch.qos.logback.core.encoder.Encoder;

@RestController
@RequestMapping(value="/bingo")
@Api("bingo_unidadesController")
@CrossOrigin(origins="*")

public class bingo_unidadesController {

	@Autowired
	bingo_unidadesRepository bingo_unidadesRepository;
	
	@Autowired
	bingo_clientesController bingo_clientesController;
	
	@Autowired
	sec_usuariosRepository sec_usuariosRepository;
	
	@Autowired
	sec_usuarios_perfisRepository sec_usuarios_perfisRepository;
	
	@Autowired
	PasswordEncoder encoder;


	
	@PostMapping("/ListarUnidades/IDCLIENTE")
	@ApiOperation(value="buscar unidades por idcliente")
	public List<HashMap<String, Object>> ListarUnidadesIDCLIENTE(@RequestHeader HttpHeaders header,@RequestBody HashMap<String,Object>JsonIdCliente){
		
		
		
		
		
		int IDUSUARIO = UsuariosLogados.BuscarUsuario(header).getIDUSUARIO();
		
		HashMap<String,Object> JsonIdusuario = new HashMap<>();
		JsonIdusuario.put("idusuario", IDUSUARIO);
		
		int IDCLIENTE = 0;
		
		if((int)JsonIdCliente.get("IDCLIENTE") == 0) {
			
			IDCLIENTE = bingo_clientesController.BuscarClienteIDUSUARIO(header).getIDCLIENTE();
		}else {
			IDCLIENTE =(int) JsonIdCliente.get("IDCLIENTE");
		}
		
		
		System.out.println("Retorno da controladora com o idcliente : "+IDCLIENTE);
		
		List<Object[]> unidade = null;
		List listaunidades = new ArrayList();
		
		
		try {
			unidade = bingo_unidadesRepository.ListarUnidadesIDCLIENTE(IDCLIENTE);
			System.out.println("Tamanho unidades : "+unidade.size());			
	
			for(Object[] obj: unidade ) {
			
					
				HashMap<String,Object> objeto = new HashMap<>();

				int idunidade = (int)obj[0];				
				int idusuario= (int)obj[1];
				String nomeusuario = (String)obj[2];	
				String nomeestabelecimento= (String)obj[3];
				int idcliente= (int)obj[4];
				String nomecliente= (String)obj[5];
				String rua= (String)obj[6];
				String numero= (String)obj[7];
				String complemento= (String)obj[8];
				String bairro= (String)obj[9];
				int iduf= (int)obj[10];
				String sigla= (String)obj[11];
				int idcidade= (int)obj[12];
				String nomecidade= (String)obj[13];
				int ddd= (int)obj[14];
				String telefone= (String)obj[15];
				int status= (int)obj[16];
				
				objeto.put("IDUNIDADE",idunidade);
				objeto.put("IDUSUARIO",idusuario);
				objeto.put("NOMEUSUARIO",nomeusuario);
				objeto.put("NOMEESTABELECIMENTO",nomeestabelecimento);
				objeto.put("IDCLIENTE",idcliente);
				objeto.put("NOMECLIENTE",nomecliente);
				objeto.put("RUA",rua);
				objeto.put("NUMERO",numero);
				objeto.put("COMPLEMENTO",complemento);
				objeto.put("BAIRRO",bairro);
				objeto.put("IDUF",iduf);
				objeto.put("SIGLA",sigla);
				objeto.put("IDCIDADE",idcidade);
				objeto.put("NOMECIDADE",nomecidade);
				objeto.put("DDD",ddd);
				objeto.put("TELEFONE",telefone);
				objeto.put("STATUS",status);
				
				listaunidades.add(objeto);
				
		
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return listaunidades;	
	}
	
	@GetMapping("/ListarUnidades")
	@ApiOperation(value="buscar unidades")
	public List<HashMap<String, Object>> ListarUnidades(){
			
		List<Object[]> unidade = null;
		List listaunidades = new ArrayList();
		
		
		try {
			unidade = bingo_unidadesRepository.ListarTodasUnidades();
			System.out.println("Tamanho unidades : "+unidade.size());
			
	
			for(Object[] obj: unidade ) {
			
				/*SELECT A.IDUNIDADE,A.IDUSUARIO,B.NOMEUSUARIO,A.NOMEESTABELECIMENTO,A.IDCLIENTE, C.NOMECLIENTE, A.RUA,A.NUMERO
				 * ,A.COMPLEMENTO,A.BAIRRO,A.IDUF,D.SIGLA,
				 */
			/*	A.IDCIDADE,E.NOME AS NOMECIDADE,A.STATUS*/
				
				
				HashMap<String,Object> objeto = new HashMap<>();

				int idunidade = (int)obj[0];				
				int idusuario= (int)obj[1];
				String nomeusuario = (String)obj[2];	
				String nomeestabelecimento= (String)obj[3];
				int idcliente= (int)obj[4];
				String nomecliente= (String)obj[5];
				String rua= (String)obj[6];
				String numero= (String)obj[7];
				String complemento= (String)obj[8];
				String bairro= (String)obj[9];
				int iduf= (int)obj[10];
				String sigla= (String)obj[11];
				int idcidade= (int)obj[12];
				String nomecidade= (String)obj[13];
				int ddd= (int)obj[14];
				String telefone= (String)obj[15];
				int status= (int)obj[16];
				
				objeto.put("IDUNIDADE",idunidade);
				objeto.put("IDUSUARIO",idusuario);
				objeto.put("NOMEUSUARIO",nomeusuario);
				objeto.put("NOMEESTABELECIMENTO",nomeestabelecimento);
				objeto.put("IDCLIENTE",idcliente);
				objeto.put("NOMECLIENTE",nomecliente);
				objeto.put("RUA",rua);
				objeto.put("NUMERO",numero);
				objeto.put("COMPLEMENTO",complemento);
				objeto.put("BAIRRO",bairro);
				objeto.put("IDUF",iduf);
				objeto.put("SIGLA",sigla);
				objeto.put("IDCIDADE",idcidade);
				objeto.put("NOMECIDADE",nomecidade);
				objeto.put("DDD",ddd);
				objeto.put("TELEFONE",telefone);
				objeto.put("STATUS",status);
				
				listaunidades.add(objeto);
				
		
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return listaunidades;	
	}
	
	

	@PostMapping("/BuscarUnidade")
	@ApiOperation(value="buscar unidades")
	public HashMap<String, Object> BuscarUnidade(@RequestBody HashMap<String,Object> JsonIdunidade){
			
		List<Object[]> unidade = null;
		HashMap<String,Object> objeto = new HashMap<>();
		int IDUNIDADE = (int)JsonIdunidade.get("IDUNIDADE");
		
		try {
			unidade = bingo_unidadesRepository.BuscarUnidade(IDUNIDADE);
			
			for(Object[] obj: unidade ) {
			
		
				
				
				

				int idunidade = (int)obj[0];				
				int idusuario= (int)obj[1];
				String nomeusuario = (String)obj[2];	
				String nomeestabelecimento= (String)obj[3];
				int idcliente= (int)obj[4];
				String nomecliente= (String)obj[5];
				String rua= (String)obj[6];
				String numero= (String)obj[7];
				String complemento= (String)obj[8];
				String bairro= (String)obj[9];
				int iduf= (int)obj[10];
				String sigla= (String)obj[11];
				int idcidade= (int)obj[12];
				String nomecidade= (String)obj[13];
				int ddd= (int)obj[14];
				String telefone= (String)obj[15];
				int status= (int)obj[16];
				String cep = (String)obj[17];
				String email = (String)obj[18];
				String senha = (String)obj[19];
				String loginusuario = (String)obj[20];
				
				objeto.put("IDUNIDADE",idunidade);
				objeto.put("IDUSUARIO",idusuario);
				objeto.put("NOMEUSUARIO",nomeusuario);
				objeto.put("NOMEESTABELECIMENTO",nomeestabelecimento);
				objeto.put("IDCLIENTE",idcliente);
				objeto.put("NOMECLIENTE",nomecliente);
				objeto.put("RUA",rua);
				objeto.put("NUMERO",numero);
				objeto.put("COMPLEMENTO",complemento);
				objeto.put("BAIRRO",bairro);
				objeto.put("IDUF",iduf);
				objeto.put("SIGLA",sigla);
				objeto.put("IDCIDADE",idcidade);
				objeto.put("NOMECIDADE",nomecidade);
				objeto.put("DDD",ddd);
				objeto.put("TELEFONE",telefone);
				objeto.put("STATUS",status);
				objeto.put("CEP", cep);
				objeto.put("EMAIL", email);
				objeto.put("SENHA", senha);
				objeto.put("LOGINUSUARIO", loginusuario);
		
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return objeto;	
	}
	
	@DeleteMapping("/DeletarUnidade")
	@ApiOperation(value="Exclui uma unidade")
	public HashMap<String,String> DeletarUnidade(@RequestBody HashMap<String,Object>JsonIdunidade) {	
		HashMap<String,String> retorno = new  HashMap<String,String>();
		try {
			
			int IDUNIDADE = (int)JsonIdunidade.get("idunidade");
			int IDUSUARIO = bingo_unidadesRepository.findByIDUNIDADE(IDUNIDADE).getIDUSUARIO();
			bingo_unidadesRepository.deleteById(IDUNIDADE);
			
			sec_usuarios_perfisRepository.DeletarSecUsuarioPerfilPorIDUSUARIO(IDUSUARIO);
			
			sec_usuariosRepository.deleteById(IDUSUARIO);
			
			retorno.put("mensagem", "OK");
			
		}catch(Exception erro){
				System.out.println("Erro: "+erro.getMessage());
		}
		return retorno;
	}

	
	@GetMapping("/BingoUnidades")
	@ApiOperation(value="lista todos os BingoUnidades em ordem crescente")
	public List<BingoUnidades> listarbingo_unidades(){
			
		List listaunidades = null;
		try {
			listaunidades =(List<BingoUnidades>) bingo_unidadesRepository.findAll();		
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return listaunidades;	
	}
	
	@PostMapping("/SalvarUnidade")
	@ApiOperation(value="salvar unidade")
	public HashMap<String, Object> SalvarUnidade(@RequestBody Unidade Unidade, @RequestHeader HttpHeaders header) {	
		
		HashMap<String, Object> retorno = new HashMap<String,Object>();
		//Varivável de retorno 
		
		String validacao = "S";
		//Variável que valida os campos
		
		try {
			
			//A validação de todos os campos será feita nesse bloco...
			
			int IDUSUARIO = UsuariosLogados.BuscarUsuario(header).getIDUSUARIO();
			
		/*	int IDPERFIL = sec_usuarios_perfisRepository.ListarUsuarioPerfilIDUSUARIO(IDUSUARIO).getIDPERFIL();
			
			if(IDPERFIL == 1){
				//Se o usuário que estiver acessando for um administrador..
				if(Unidade.getIDCLIENTE() == 0) {
					//Então passe por este tratamento
					validacao = "N";			
				}				
			}else {
				//Caso ao contrário..
				//Não faça nada
			}*/
			
			
			if(Unidade.getNOMEESTABELECIMENTO().length() == 0) {
				
				validacao = "N";			
			}
			
			
			if(Unidade.getCEP().length() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getIDUF() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getIDCIDADE() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getBAIRRO().length() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getRUA().length() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getNUMERO().length() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getCOMPLEMENTO().length() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getDDD() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getTELEFONE().length() == 0) {
				
				validacao = "N";			
			}
			
			if(Unidade.getNOME().length() == 0) {
				validacao = "N";
			}
			
			if(Unidade.getEMAIL().length() == 0) {
				validacao = "N";
			}
			
			if(Unidade.getLOGINUSUARIO().length() == 0) {
				validacao = "N";
			}


			if(Unidade.getSENHA().length() == 0) {
				validacao = "N";
			}

			
			String APELIDO = Unidade.getNOME().split(" ")[0];
			
			
			
			if(Unidade.getIDUNIDADE() == 0) {
				//Se não houver o id da unidade,
				
				
				//Crie uma nova unidade,
				
				if(validacao == "S") {
					//Se todos os campos estiverem preenchidos,
					//Começe a incluir-los no banco de dados
					
					SecUsuarios usuario = new SecUsuarios();
					
					usuario.setAPELIDO(APELIDO);
					usuario.setCARGO("Unidade");
					usuario.setDDD(Unidade.getDDD());
					usuario.setDESCSENHA(Unidade.getSENHA());
					usuario.setEMAIL(Unidade.getEMAIL());
					usuario.setLOGINUSUARIO(Unidade.getLOGINUSUARIO());
					usuario.setFOTO(parametros.FOTOUSUARIO);
					usuario.setIDEMPRESA(1);
					usuario.setIDIDIOMA(1);
					usuario.setNOMEUSUARIO(Unidade.getNOME());
					usuario.setSENHA(encoder.encode(Unidade.getSENHA()));
					usuario.setSTATUS(1);
					usuario.setTELEFONE(Unidade.getTELEFONE());
					usuario.setTOKEN("");
					
					sec_usuariosRepository.save(usuario);
					
					SecUsuariosPerfis usuarioperfil = new SecUsuariosPerfis();
					
					usuarioperfil.setIDPERFIL(3);
					usuarioperfil.setIDUSUARIO(usuario.getIDUSUARIO());
					usuarioperfil.setSTATUS(1);
					
					sec_usuarios_perfisRepository.save(usuarioperfil);
					
					BingoUnidades unidade = new BingoUnidades();
					
					unidade.setBAIRRO(Unidade.getBAIRRO());
					unidade.setCEP(Unidade.getCEP());
					unidade.setCOMPLEMENTO(Unidade.getCOMPLEMENTO());
					unidade.setDDD(Unidade.getDDD());
					unidade.setIDCIDADE(Unidade.getIDCIDADE());
					unidade.setIDCLIENTE(Unidade.getIDCLIENTE());
					unidade.setIDUF(Unidade.getIDUF());
					unidade.setIDUSUARIO(usuario.getIDUSUARIO());
					unidade.setNOMEESTABELECIMENTO(Unidade.getNOMEESTABELECIMENTO());
					unidade.setNUMERO(Unidade.getNUMERO());
					unidade.setRUA(Unidade.getRUA());
					unidade.setSTATUS(1);
					unidade.setTELEFONE(Unidade.getTELEFONE());
					bingo_unidadesRepository.save(unidade);
					
				//retorno
				retorno.put("validacao", "S");
				retorno.put("mensagem", "nova unidade criada com sucesso !");
				}

				
			}else {
				//Se houver id da unidade...
				BingoUnidades unidade = bingo_unidadesRepository.findByIDUNIDADE(Unidade.getIDUNIDADE());
				
				
				//Pegue uma unidade passando o id da unidade
				
				if(validacao == "S") {
					
					SecUsuarios usuario = sec_usuariosRepository.findByIDUSUARIO(unidade.getIDUSUARIO());
					
					usuario.setAPELIDO(Unidade.getNOME());
	
					usuario.setDDD(Unidade.getDDD());
					usuario.setDESCSENHA(Unidade.getSENHA());
					usuario.setEMAIL(Unidade.getEMAIL());			
					usuario.setLOGINUSUARIO(Unidade.getLOGINUSUARIO());
					usuario.setNOMEUSUARIO(Unidade.getNOME());
					usuario.setSENHA(encoder.encode(Unidade.getSENHA()));
					usuario.setTELEFONE(Unidade.getTELEFONE());
					
					sec_usuariosRepository.save(usuario);
					
					//se validação for igual a verdadeiro,
					//atualize os dados da unidade
					unidade.setBAIRRO(Unidade.getBAIRRO());
					unidade.setCEP(Unidade.getCEP());
					unidade.setCOMPLEMENTO(Unidade.getCOMPLEMENTO());
					unidade.setDDD(Unidade.getDDD());
					unidade.setIDCIDADE(Unidade.getIDCIDADE());
					unidade.setIDCLIENTE(Unidade.getIDCLIENTE());
					unidade.setIDUF(Unidade.getIDUF());
					unidade.setNOMEESTABELECIMENTO(Unidade.getNOMEESTABELECIMENTO());
					unidade.setNUMERO(Unidade.getNUMERO());
					unidade.setRUA(Unidade.getRUA());
					unidade.setSTATUS(1);
					unidade.setTELEFONE(Unidade.getTELEFONE());
					
					bingo_unidadesRepository.save(unidade);
					
					retorno.put("validacao", "S");
					retorno.put("idunidade", unidade.getIDUNIDADE());
					retorno.put("mensagem", "sua unidade foi atualizada com sucesso !");
					}

			}

		}catch(Exception e) {
				System.out.println("Erro : "+e.getMessage());
		}
		
		
			
		
		return retorno;
	}


	

}
