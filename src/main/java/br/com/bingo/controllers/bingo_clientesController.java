
package br.com.bingo.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.models.BingoClientes;
import br.com.bingo.models.BingoUnidades;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.models.SecUsuariosPerfis;
import br.com.bingo.repository.bingo_clientesRepository;
import br.com.bingo.repository.bingo_sorteiosRepository;
import br.com.bingo.repository.bingo_unidadesRepository;
import br.com.bingo.repository.sec_usuariosRepository;
import br.com.bingo.repository.sec_usuarios_perfisRepository;
import br.com.bingo.views.Cliente;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.parametros;

@RestController
@RequestMapping(value="/bingo")
@Api("bingo_clientesController")
@CrossOrigin(origins="*")

public class bingo_clientesController {

	@Autowired
	bingo_clientesRepository bingo_clientesRepository;
	
	
	@Autowired
	bingo_sorteiosRepository bingo_sorteiosRepository;
		
	@Autowired
	bingo_unidadesRepository bingo_unidadesRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	sec_usuariosRepository sec_usuariosRepository;
	
	@Autowired
	sec_usuarios_perfisRepository sec_usuarios_perfisRepository;


	 private EntityManager entityManager;
	 
		@PostMapping("/QtdeCliente")
		@ApiOperation(value="Buscar um cliente por idusuario")
		public HashMap<String,Object> QtdeCliente(@RequestBody HashMap<String,Object>JsonIdUsuario){
				
			int qtde = 0;
			int IDUSUARIO =(int) JsonIdUsuario.get("idusuario");
			HashMap<String, Object> retorno = new HashMap<String,Object>();
			
			try {
				qtde = bingo_clientesRepository.QtdeCliente(IDUSUARIO);
				if(qtde == 1){
					retorno.put("qtde",1);
					retorno.put("existe","S");
				}else {
					retorno.put("qtde", 0);
					retorno.put("existe", "N");
				}
			}catch(Exception e) {
				System.out.println("Erro : " + e);
			}
			
			return retorno;	
		}

	 
		@GetMapping("/BuscarCliente/IDUSUARIO")
		@ApiOperation(value="Buscar um cliente por idusuario")
		public BingoClientes BuscarClienteIDUSUARIO(@RequestHeader HttpHeaders headers){
				
			BingoClientes retorno = null;
			int IDUSUARIO = UsuariosLogados.BuscarUsuario(headers).getIDUSUARIO();
			
			try {
				retorno = bingo_clientesRepository.BuscarClienteIDUSUARIO(IDUSUARIO);
			}catch(Exception e) {
				System.out.println("Erro : " + e);
			}
			
			return retorno;	
		}

	
	@DeleteMapping("/DeletarCliente")
	@ApiOperation(value="Exclui um Cliente")
	public HashMap<String,Object> DeletarCliente(@RequestBody HashMap<String,Object>JsonIdcliente) {	
		HashMap<String,Object> retorno = new  HashMap<String,Object>();
		String mensagem = "";
		char validacao;
		
		try {
			//Ao deletar um cliente não devo matar apenas o cliente e sim suas licenças, sorteios, parâmetros e suas unidades
			
			int IDCLIENTE = (int)JsonIdcliente.get("idcliente");
			//PEGANDO ID DO CLIENTE VINDO DO CLIENT-SIDE
			
			int IDUSUARIO = bingo_clientesRepository.findByIDCLIENTE(IDCLIENTE).getIDUSUARIO();
			//CAPTURANDO ID DO USUARIO DO CLIENTE NA TABELA DE CLIENTE NO CAMPO IDUSUARIO
			
			List<BingoUnidades> unidades = bingo_unidadesRepository.BingoUnidadesIDCLIENTE(IDCLIENTE);
			//VERIFICANDO SE O CLIENTE POSSUÍ UNIDADES
			if(unidades.size() > 0){
				//SE O CLIENTE POSSUIR UNIDADES
				//ENTÃO O SERVIDOR AVISARÁ O USUÁRIO QUE O CLIENTE NÃO PODERÁ SER EXCLUIDO, POIS ELE POSSUÍ ALGUMAS UNIDADES
				//ENTÃO A AÇÃO NÃO SERÁ TOMADA
				validacao = 'N';
				mensagem = "Não é possível deletar o cliente, pois o mesmo possui algumas unidades";

			}else{
				//DELETANDO O CLIENTE
				bingo_clientesRepository.deleteById(IDCLIENTE);
				System.out.println("cliente deletado com sucesso !");
				
				//DELETANDO O USUARIO PERFIL DO CLIENTE
				sec_usuarios_perfisRepository.DeletarSecUsuarioPerfilPorIDUSUARIO(IDUSUARIO);
				System.out.println("Usuário perfil deletado com sucesso !");
				
				//DELETANDO O USUÁRIO DO CLIENTE
				sec_usuariosRepository.deleteById(IDUSUARIO);
				System.out.println("Usuário deletado com sucesso !");
				validacao = 'S';
				mensagem = "Cliente deletado com sucesso";

			}
						

			
			
			//DELETANDO SORTEIOS
		//	bingo_sorteiosRepository.DeletarSorteiosIDCLIENTE(IDCLIENTE);
		//	System.out.println("sorteio deletado com sucesso !");
			retorno.put("mensagem", mensagem);
			retorno.put("validacao", validacao);
			
		}catch(Exception erro){
				System.out.println("Erro: "+erro.getMessage());
		}
		return retorno;
	}

	
	@GetMapping("/BingoClientes")
	@ApiOperation(value="lista todos os BingoCLientes em ordem crescente")
	public List<SecPerfis> listarbingo_clientes(){
			
		List listaclientes = null;
		try {
			listaclientes =(List<BingoClientes>) bingo_clientesRepository.findAll();		
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return listaclientes;	
	}
	
	@PostMapping("/BuscarCliente/IDCLIENTE")
	@ApiOperation(value="buscar um cliente")
	public HashMap<String, Object> BuscarCliente(@RequestBody HashMap<String,Object> JsonIdcliente){
			
		List<Object[]> cliente = null;
		HashMap<String, Object> objeto = new HashMap<String , Object>();
		int IDCLIENTE = (int)JsonIdcliente.get("IDCLIENTE");
		try {
			cliente = bingo_clientesRepository.BuscarCliente(IDCLIENTE);
			
			
			
			for(Object[] obj: cliente ) {

				int idcliente = (int)obj[0];				
				String nomecliente = (String)obj[1];
				int ddd = (int)obj[2];	
				String telefone = (String)obj[3];	
				String cep = (String)obj[4];	
				int iduf = (int)obj[5];
				String sigla = (String)obj[6];
				int idcidade = (int)obj[7];
				String nomecidade= (String)obj[8];	
				String bairro = (String)obj[9];
				String endereco = (String)obj[10];
				String numero = (String)obj[11];
				String complemento = (String)obj[12];
				int idusuario = (int)obj[13];	
				String email = (String)obj[14];	
				String senha = (String)obj[15];	
				String loginusuario = (String)obj[16];	
				
				
				objeto.put("IDCLIENTE",idcliente);
				objeto.put("NOMECLIENTE",nomecliente);
				objeto.put("DDD", ddd);
				objeto.put("TELEFONE",telefone);
				objeto.put("CEP",cep);
				objeto.put("IDUF", iduf);
				objeto.put("SIGLA", sigla);
				objeto.put("IDCIDADE", idcidade);
				objeto.put("NOMECIDADE", nomecidade);
				objeto.put("BAIRRO",bairro);
				objeto.put("ENDERECO", endereco);
				objeto.put("NUMERO",numero);
				objeto.put("COMPLEMENTO",complemento);
				objeto.put("IDUSUARIO", idusuario);
				objeto.put("EMAIL", email);
				objeto.put("SENHA", senha);
				objeto.put("LOGINUSUARIO", loginusuario);
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return objeto;	
	}

	
	@PostMapping("/SalvarCliente")
	@ApiOperation(value="salvar SecPerfis")
	public HashMap<String, Object> EditarSecPerfis(@RequestBody Cliente Cliente, @RequestHeader HttpHeaders header) {	
		
		HashMap<String, Object> retorno = new HashMap<String,Object>();
		
		String validacao = "S";
				
		try {
			
			if(Cliente.getNOME().length() == 0) {
				
				validacao = "N";
			}
			
			if(Cliente.getDDD() == 0) {
				
				validacao = "N";
			}
			
			if(Cliente.getTELEFONE().length() == 0) {
				
				validacao = "N";
			}
			
			if(Cliente.getCEP().length()==0 || Cliente.getCEP() ==null ) {
				
				validacao = "N";
			}
			
			
			if(Cliente.getIDUF() == 0) {
				
				validacao = "N";
			}
			
			if(Cliente.getIDCIDADE() == 0) {
				
				validacao = "N";
			}
			
			if(Cliente.getBAIRRO().length()==0) {
				
				validacao = "N";
			}
			
			
			if(Cliente.getENDERECO().length()== 0) {
				
				validacao = "N";
			}
			
			if(Cliente.getNUMERO().length()==0) {
				
				validacao = "N";
			}
			
			
			if(Cliente.getCOMPLEMENTO().length()==0) {
				
				validacao = "N";
			}
			
			if(Cliente.getEMAIL().length()==0) {
				
				validacao = "N";
			}
			
			if(Cliente.getLOGINUSUARIO().length()==0) {
				validacao = "N";
			}
			
			if(Cliente.getSENHA().length()==0) {
				
				validacao = "N";
			}
		
			//SE NAO TIVER IDCLIENTE, CRIE UM NOVO CLIENTE
			String APELIDO = Cliente.getNOME().split(" ")[0];
			if(Cliente.getIDCLIENTE() == 0) {
				
				
				
				if(validacao == "S") {
					
					
					
					SecUsuarios usuario = new SecUsuarios();
					
					
					
					usuario.setAPELIDO(APELIDO);
					usuario.setCARGO("Cliente");
					usuario.setDDD(Cliente.getDDD());
					usuario.setEMAIL(Cliente.getEMAIL());
					usuario.setLOGINUSUARIO(Cliente.getLOGINUSUARIO());
					usuario.setFOTO(parametros.FOTOUSUARIO);
					usuario.setIDEMPRESA(1);
					usuario.setIDIDIOMA(1);
					usuario.setNOMEUSUARIO(Cliente.getNOME());
					usuario.setSENHA(encoder.encode(Cliente.getSENHA()));
					usuario.setDESCSENHA(Cliente.getSENHA());
					usuario.setSTATUS(1);
					usuario.setTELEFONE(Cliente.getTELEFONE());
					usuario.setTOKEN("");
					
					sec_usuariosRepository.save(usuario);
					
					SecUsuariosPerfis usuarioperfil = new SecUsuariosPerfis();
					usuarioperfil.setIDPERFIL(2);
					usuarioperfil.setIDUSUARIO(usuario.getIDUSUARIO());
					usuarioperfil.setSTATUS(1);
					sec_usuarios_perfisRepository.save(usuarioperfil);
					
					BingoClientes cliente = new BingoClientes();
					cliente.setDDD(Cliente.getDDD());
					cliente.setCEP(Cliente.getCEP());
					cliente.setBAIRRO(Cliente.getBAIRRO());
					cliente.setCOMPLEMENTO(Cliente.getCOMPLEMENTO());
					cliente.setNUMERO(Cliente.getNUMERO());
					cliente.setENDERECO(Cliente.getENDERECO());
					cliente.setIDCIDADE(Cliente.getIDCIDADE());
					cliente.setIDUF(Cliente.getIDUF());
					cliente.setIDUSUARIO(usuario.getIDUSUARIO());
					cliente.setNOMECLIENTE(Cliente.getNOME());
					cliente.setSTATUS(1);
					cliente.setTELEFONE(Cliente.getTELEFONE());
					
					bingo_clientesRepository.save(cliente);

					
				
				retorno.put("validacao", "S");
				retorno.put("mensagem", "novo cliente criado com sucesso !");
				retorno.put("idcliente", cliente.getIDCLIENTE());
				}

				
			}else {
				//SE TIVER 	IDCLIENTE, PEGUE O CLIENTE POR IDCLIENTE E O ATUALIZE
				if(validacao == "S") {
					
					
					
					BingoClientes cliente = bingo_clientesRepository.findByIDCLIENTE(Cliente.getIDCLIENTE());
					
					
					cliente.setBAIRRO(Cliente.getBAIRRO());
					cliente.setCEP(Cliente.getCEP());
					cliente.setCOMPLEMENTO(Cliente.getCOMPLEMENTO());
					cliente.setDDD(Cliente.getDDD());
					cliente.setENDERECO(Cliente.getENDERECO());
					cliente.setIDCIDADE(Cliente.getIDCIDADE());
					cliente.setIDUF(Cliente.getIDUF());
					cliente.setNOMECLIENTE(Cliente.getNOME());
					cliente.setNUMERO(Cliente.getNUMERO());
					
					bingo_clientesRepository.save(cliente);
					
					SecUsuarios usuario = sec_usuariosRepository.findByIDUSUARIO(cliente.getIDUSUARIO());
					
					usuario.setDDD(Cliente.getDDD());
					usuario.setEMAIL(Cliente.getEMAIL());
					usuario.setLOGINUSUARIO(Cliente.getLOGINUSUARIO());
					usuario.setNOMEUSUARIO(Cliente.getNOME());
					usuario.setSENHA(encoder.encode(Cliente.getSENHA()));
					usuario.setDESCSENHA(Cliente.getSENHA());
					usuario.setTELEFONE(Cliente.getTELEFONE());
					sec_usuariosRepository.save(usuario);
					//SALVANDO O USUÁRIO
					
					retorno.put("validacao", "S");
					retorno.put("idcliente", cliente.getIDCLIENTE());
					retorno.put("mensagem", "seu cliente foi atualizado com sucesso !");
					}

			}

		}catch(Exception e) {
				System.out.println("Erro : "+e.getMessage());
		}
		
		
			
		
		return retorno;
	}

	

}
