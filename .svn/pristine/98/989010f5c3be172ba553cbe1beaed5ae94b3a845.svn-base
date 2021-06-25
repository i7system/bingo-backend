package br.com.bingo.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.emails.EnviarEmail;
import br.com.bingo.funcoes.*;
import br.com.bingo.models.SecEmpresas;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.models.SecUsuariosEmpresas;
import br.com.bingo.models.SecUsuariosPerfis;
import br.com.bingo.repository.sec_empresasRepository;
import br.com.bingo.repository.sec_menus_perfisRepository;
import br.com.bingo.repository.sec_perfisRepository;
import br.com.bingo.repository.sec_usuariosRepository;
import br.com.bingo.repository.sec_usuarios_empresasRepository;
import br.com.bingo.repository.sec_usuarios_perfisRepository;
import br.com.bingo.views.ConfirmarConta;
import br.com.bingo.views.CriarConta;
import br.com.bingo.views.MensagemJson;
import br.com.bingo.views.Retorno;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.parametros;


@RestController
@RequestMapping(value = "/bingo")
@Api("sec_empresasController")

public class sec_empresasController {

	@Autowired
	sec_empresasRepository sec_empresasRepository;
	
	@Autowired
	sec_usuariosRepository sec_usuariosRepository;
	
	@Autowired
	sec_perfisRepository sec_perfisRepository;

	@Autowired
	sec_usuarios_perfisRepository sec_usuarios_perfisRepository;

	@Autowired
	sec_usuarios_empresasRepository sec_usuarios_empresasRepository;
	
	@Autowired
	sec_menus_perfisRepository sec_menus_perfisRepository;
	
	@Autowired
	PasswordEncoder encoder;


	@GetMapping("SecEmpresas")
	@ApiOperation(value = "lista todos as SecEmpresas em ordem crescente")
	public List<SecEmpresas> listarsec_empresas() {
		return sec_empresasRepository.findAll();
	}

	@PostMapping("SecEmpresas/Usuario")
	@ApiOperation(value = "lista todos as SecEmpresasUsuario em ordem crescente")
	public SecEmpresas SecEmpresasUsuario(@RequestHeader HttpHeaders headers) {
		String token = headers.get("authorization").get(0);
		
		
		SecUsuarios usuario = UsuariosLogados.BuscarUsuario(headers);
		
		
		int idempresa = usuario.getIDEMPRESA();
		
		
		return sec_empresasRepository.findByIDEMPRESA(idempresa);
	}

	@GetMapping("SecEmpresas/{IDEMPRESA}")
	@ApiOperation(value = "retorna 1 SecEmpresas por IDEMPRESA")
	public SecEmpresas listarsec_empresasId(@RequestHeader HttpHeaders headers,
			@PathVariable(value = "IDEMPRESA") int IDEMPRESA) {
		return sec_empresasRepository.findByIDEMPRESA(IDEMPRESA);
	}

	@PostMapping("SalvarSecEmpresas")
	@ApiOperation(value = "cria um novo SecEmpresas")
	public String salvarsec_empresas(@RequestBody CriarConta CriarConta,@RequestHeader HttpHeaders header) throws JsonProcessingException {

		String validacao = "S";
		String mensagem = "";
		String token = "";
		System.out.println(CriarConta.getEMAIL());
		
		String senha = encoder.encode(CriarConta.getSENHA());
		
		

		//Instanciando estrutura json
		MensagemJson json = new MensagemJson();
		
		try {
			int qtde = sec_usuariosRepository.ValidarEmail(CriarConta.getEMAIL());

			//validando campos do formulario
			if (CriarConta.getNOMEEMPRESA() == "") {
				validacao = "N";
				mensagem = "Nome da empresa é obrigatório";
			}

			if (CriarConta.getEMAIL() == "") {
				validacao = "N";
				mensagem = "Email é obrigatório";
			}if(qtde == 1) {
				mensagem = "Email já existe";
				validacao = "N";
			}

			if (CriarConta.getNOMEUSUARIO() == "") {
				validacao = "N";
				mensagem = "Nome do usuário é brigatório";
			}
			if (CriarConta.getSENHA() == "") {
				validacao = "N";
				mensagem = "Senha é obrigatório";
			}
			if (CriarConta.getTELEFONE() == "") {
				validacao = "N";
				mensagem = "Telefone é obrigatório";
			}
			
			System.out.println(mensagem);
			
			json.setMensagem(mensagem);
			json.setValidacao(validacao);

			if (validacao == "N") {
				//retornando json com mensagem de validação
				return GeradorDeJson.ConverterJSON(json);
				
			} else {

				String codigovalidacao = CodigoVerificacao.GerarCodigo();
				String logo = "https://bingo-notas-empresas.s3.amazonaws.com/Empresa00/Imagens/logobingo1.png";
				
				//Instanciando SecEmpresas
				SecEmpresas empresa = new SecEmpresas();

				empresa.setAPELIDO(CriarConta.getNOMEEMPRESA());
				empresa.setCODIGOVALIDACAO(codigovalidacao);
				empresa.setIDEMPRESA(0);
				empresa.setLOGO(logo);
				empresa.setNOMEEMPRESA(CriarConta.getNOMEEMPRESA());
				empresa.setSTATUS(100);
				empresa.setTOKEN(token);
				empresa.setEMAIL(CriarConta.getEMAIL());
				empresa.setTELEFONE(CriarConta.getTELEFONE());
				
				//sec_empresasRepository.save(empresa);
				//gerando token criptografado da empresa	
				 token = HashCode.GerarHash(empresa.getIDEMPRESA());

				empresa.setTOKEN(token);
			//	sec_empresasRepository.save(empresa);
				//Salvando empresa na tabela sec_empresas
				
				SecUsuarios usuario = new SecUsuarios();
				
				usuario.setAPELIDO(CriarConta.getNOMEUSUARIO());
				usuario.setCARGO("Empresário");
				usuario.setDDD(13);
				usuario.setEMAIL(CriarConta.getEMAIL());
				usuario.setFOTO("https://cdn.pixabay.com/photo/2015/03/04/22/35/head-659652_960_720.png");
				usuario.setIDEMPRESA(empresa.getIDEMPRESA());
				usuario.setIDIDIOMA(1);
				usuario.setNOMEUSUARIO(CriarConta.getNOMEUSUARIO());
				usuario.setSENHA(senha);
				usuario.setSTATUS(1);
				usuario.setTELEFONE(CriarConta.getTELEFONE());
				usuario.setTOKEN("");
				
			//	sec_usuariosRepository.save(usuario);
				//Salvando o usuario na tabela sec_usuarios	
				
				SecPerfis perfil = new SecPerfis();
				
				perfil.setFOTO("img/usuarios/perfis3.png");
				perfil.setIDEMPRESA(empresa.getIDEMPRESA());
				perfil.setNOMEPERFIL("Administrador");
				perfil.setSTATUS(1);
			
		//		sec_perfisRepository.save(perfil);
				//Salvando o perfil na tabela sec_perfis
				
				SecUsuariosPerfis usuarioperfil = new SecUsuariosPerfis();
			
				usuarioperfil.setIDUSUARIO(usuario.getIDUSUARIO());
				usuarioperfil.setIDPERFIL(perfil.getIDPERFIL());
				usuarioperfil.setSTATUS(1);
				
			//	sec_usuarios_perfisRepository.save(usuarioperfil);
				//Salvando o usuarioperfil na tabela sec_usuarios_perfis
				
				SecUsuariosEmpresas usuarioempresa = new SecUsuariosEmpresas();
				
				usuarioempresa.setIDEMPRESA(empresa.getIDEMPRESA());
				usuarioempresa.setIDUSUARIO(usuario.getIDUSUARIO());
				usuarioempresa.setSTATUS(1);
				
			//	sec_usuarios_empresasRepository.save(usuarioempresa);
				
				
			//	sec_menus_perfisRepository.salvar_sec_menus_perfis(empresa.getIDEMPRESA(), perfil.getIDPERFIL());
				
			//	EnviarEmail.sendMail(empresa.getEMAIL(), usuario.getNOMEUSUARIO(), empresa.getCODIGOVALIDACAO(), header);
				mensagem = "deu certo !";
				
			}
							
		
			
			
			
		}catch (Exception ex) {
			
			sec_errosController tratarerro = new sec_errosController();
			
			tratarerro.SalvarErro(ex, header,"br.com.bingo.controllers", "sec_empresasController", "SalvarSecEmpresas");
			
			return ex.getMessage();
			
			
		}
		
		
		json.setToken(token);
		json.setEmail(CriarConta.getEMAIL());

		return GeradorDeJson.ConverterJSON(json);

	}
	
	@PostMapping("ConfirmarConta")
	@ApiOperation(value = "ConfirmarConta")
	public String ConfirmarConta (@RequestBody ConfirmarConta ConfirmarConta) throws JsonProcessingException {
		
		
		
		System.out.println("valor chegado : " + ConfirmarConta.getCODIGOVERIFICACAO() + " " + ConfirmarConta.getTOKEN());
		
		SecEmpresas empresa = sec_empresasRepository.ValidarCodigo(ConfirmarConta.getTOKEN(), ConfirmarConta.getCODIGOVERIFICACAO());
		
		

		Retorno mensagem = new Retorno();
		
		if(empresa == null) {
			mensagem.setMensagem("Empresa não encontrada");
			mensagem.setStatus(0);
			System.out.println("Empresa não encontrada");
			
		} else {
			mensagem.setMensagem("Empresa encontrada");
			mensagem.setStatus(1);
			System.out.println("Empresa encontrada");
			
			empresa.setSTATUS(101);
			
			sec_empresasRepository.save(empresa);
		}
		
		

			
		return GeradorDeJson.ConverterJSON(mensagem);

		
	}

	@DeleteMapping("SecEmpresas")
	@ApiOperation(value = "Exclui um SecEmpresas")
	public void excluirsec_empresas(@RequestBody SecEmpresas SecEmpresas) {
		sec_empresasRepository.delete(SecEmpresas);
	}

	@PutMapping("SecEmpresas")
	@ApiOperation(value = "atualiza um SecEmpresas")
	public SecEmpresas atualizarsec_empresas(@RequestBody SecEmpresas SecEmpresas) {
		return sec_empresasRepository.save(SecEmpresas);
	}

}
