package br.com.bingo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
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
import br.com.bingo.parametros;
import br.com.bingo.models.BingoClientes;
import br.com.bingo.models.BingoUnidades;
import br.com.bingo.models.PortMenus;
import br.com.bingo.models.SecEmpresas;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.models.SecUsuariosPerfis;
import br.com.bingo.repository.sec_usuariosRepository;
import br.com.bingo.repository.sec_usuarios_perfisRepository;
import br.com.bingo.repository.bingo_clientesRepository;
import br.com.bingo.repository.bingo_unidadesRepository;
import br.com.bingo.views.UsuariosDestePerfil;
import br.com.bingo.UsuariosLogados;
import br.com.bingo.repository.port_usuarios_mensagensRepository;



@RestController
@RequestMapping(value = "/bingo")
@Api("sec_usuariosController")
@CrossOrigin(origins = "*", maxAge = 3600)

public class sec_usuariosController {

	@Autowired
	sec_usuariosRepository sec_usuariosRepository;

	@Autowired
	sec_usuarios_perfisRepository sec_usuarios_perfisRepository;

	@Autowired
	bingo_clientesRepository bingo_clientesRepository;

	@Autowired
	bingo_unidadesRepository bingo_unidadesRepository;
	
	@Autowired
	port_usuarios_mensagensRepository port_usuarios_mensagensRepository;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/ListarUsuariosPerfilUnidade/NAOUNIDADE")
	@ApiOperation(value = "lista todos os usuarios que tem o acesso a unidade mas ainda não são unidades")
	public List<SecUsuarios> ListarUsuariosPerfilUnidadeNAOUNIDADE() {

		List<SecUsuarios> listausuarios = null;
		try {
			listausuarios = sec_usuariosRepository.ListarUsuariosPerfilUnidade();
		} catch (Exception e) {
			System.out.println("Erro : " + e);
		}

		return listausuarios;
	}

	@GetMapping("/ListarUsuariosPerfilCliente/NAOCLIENTE")
	@ApiOperation(value = "lista todos os usuarios com acesso de cliente mas que ainda não são cliente")
	public List<SecUsuarios> ListarUsuariosPerfilClienteNAOCLIENTE() {

		List<SecUsuarios> listausuarios = null;
		try {
			listausuarios = sec_usuariosRepository.ListarUsuariosPerfilCliente();
		} catch (Exception e) {
			System.out.println("Erro : " + e);
		}

		return listausuarios;
	}
	
	@PostMapping("/ListarUsuariosDestePerfil")
	@ApiOperation(value="lista todos os usuarios deste perfil")
	public HashMap<String,Object> ListarUsuariosDestePerfil(@RequestBody HashMap<String,Object> PaginacaoParametros){
		
		HashMap<String,Object> retorno = new HashMap<String,Object>();
		
		int IDPERFIL = (int) PaginacaoParametros.get("idperfil");
		int INICIO = (int)PaginacaoParametros.get("PAGINA");
		int TAMANHO = (int)PaginacaoParametros.get("TAMANHO");

		List lista = null;
		try {
			Pageable pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
			lista = sec_usuariosRepository.ListarUsuariosDestePerfilPaginacao(IDPERFIL,pagina);
			int total = sec_usuariosRepository.ListarUsuariosDestePerfilTudo(IDPERFIL).size();
			int quantidade = lista.size();
			
			if(quantidade == 0 && total != 0) {
				
				INICIO = INICIO-1;
				pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
				lista = sec_usuariosRepository.ListarUsuariosDestePerfilPaginacao(IDPERFIL,pagina);
				total = sec_usuariosRepository.ListarUsuariosDestePerfilTudo(IDPERFIL).size();
				quantidade = lista.size();
				retorno.put("pagina", INICIO);
				
			}
			
			retorno.put("lista", lista);
			retorno.put("quantidade", quantidade);
			retorno.put("total", total);
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return retorno;	
	}


/*	@ResponseBody
	@PostMapping("/ListarUsuariosDestePerfil")
	@ApiOperation(value = "lista todos os usuarios deste perfil")
	public List<SecUsuarios> ListarUsuariosDestePerfil(@RequestBody HashMap<String, Object> JsonIdperfil) {
		int IDPERFIL = (int) JsonIdperfil.get("idperfil");
		List<SecUsuarios> listausuarios = null;
		try {
			listausuarios = sec_usuariosRepository.ListarUsuariosDestePerfil(IDPERFIL);
		} catch (Exception e) {
			System.out.println("Erro : " + e);
		}

		return listausuarios;
	}*/

	@GetMapping("/ListarUsuariosSemPerfil")
	@ApiOperation(value = "lista todos os usuarios sem perfil")
	public List<SecUsuarios> ListarUsuariosSemPerfil() {

		List<SecUsuarios> listausuarios = null;
		try {
			listausuarios = sec_usuariosRepository.ListarUsuariosSemPerfil();
		} catch (Exception e) {
			System.out.println("Erro : " + e);
		}

		return listausuarios;
	}
/*	@PostMapping("/SecUsuarios")
	@ApiOperation(value="lista todos os SecUsuarios em ordem crescente")
	public HashMap<String,Object> listarsec_usuarios(@RequestBody HashMap<String,Object> PaginacaoParametros){
		
		HashMap<String,Object> retorno = new HashMap<String,Object>();
		

		List lista = null;
		try {
			Pageable pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
			lista = sec_usuariosRepository.ListarSecUsuariosPaginacao(pagina);
			int total = sec_usuariosRepository.findAll().size();
			int quantidade = lista.size();
			
			if(quantidade == 0 && total != 0) {
				
				INICIO = INICIO-1;
				pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
				lista = sec_usuariosRepository.ListarSecUsuariosPaginacao(pagina);
				total = sec_usuariosRepository.findAll().size();
				quantidade = lista.size();
				retorno.put("pagina", INICIO);
				
			}
			
			retorno.put("lista", lista);
			retorno.put("quantidade", quantidade);
			retorno.put("total", total);
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return retorno;	
	}*/

	@ResponseBody
	@PostMapping("/VisualizarUsuariosPerfis/IDPERFIL")
	@ApiOperation(value = "lista todos os usuários que contém este perfil")
	public HashMap<String, Object> VisualizarUsuariosPerfis(@RequestBody List<HashMap<String,Object>> PaginacaoParametros) {

		int IDPERFIL = (int) PaginacaoParametros.get(1).get("IDPERFIL");
		int INICIO = (int)PaginacaoParametros.get(0).get("PAGINA");
		int TAMANHO = (int)PaginacaoParametros.get(0).get("TAMANHO");
		List<Object[]> usuario = null;
		List listausuarios = new ArrayList();
		
		HashMap<String,Object>retorno = new HashMap<String,Object>();

		try {
			Pageable pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
			usuario = sec_usuariosRepository.VisualizarUsuariosPerfisPaginacao(IDPERFIL,pagina);
			int total = sec_usuariosRepository.VisualizarUsuariosPerfis(IDPERFIL).size();
			int quantidade = usuario.size();
			
			if(quantidade == 0 && total != 0) {
				
				INICIO = INICIO-1;
				pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
				usuario = sec_usuariosRepository.VisualizarUsuariosPerfisPaginacao(IDPERFIL,pagina);
				total = sec_usuariosRepository.VisualizarUsuariosPerfis(IDPERFIL).size();
				quantidade = usuario.size();
				retorno.put("pagina", INICIO);
				
			}

			

			for (Object[] obj : usuario) {

				HashMap<String, Object> objeto = new HashMap<>();

				int idusuarioperfil = (int) obj[0];
				int idusuario = (int) obj[1];
				String nomeusuario = (String) obj[2];
				String email = (String) obj[3];

				objeto.put("IDUSUARIOPERFIL", idusuarioperfil);
				objeto.put("IDUSUARIO", idusuario);
				objeto.put("NOMEUSUARIO", nomeusuario);
				objeto.put("EMAIL", email);

				listausuarios.add(objeto);
				
				retorno.put("lista", listausuarios);
				retorno.put("quantidade", quantidade);
				retorno.put("total", total);

			}
			
			
			
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());

		}
		return retorno;
	}

	@ResponseBody
	@PostMapping("/BuscarUsuario")
	@ApiOperation(value = "retorna 1 Usuario por IDUSUARIO")
	public SecUsuarios listarsec_usuarioID(@RequestBody HashMap<String, Object> JsonIdusuario) {

		int IDUSUARIO = (int) JsonIdusuario.get("IDUSUARIO");
		
		SecUsuarios usuario = null;

		try {
			usuario = sec_usuariosRepository.findByIDUSUARIO(IDUSUARIO);
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());

		}
		return usuario;
	}

	@PostMapping("/Usuario")
	@ApiOperation(value = "retorna 1 SecUsuarios por IDUSUARIO")
	public SecUsuarios listarSecUsuarios(@RequestHeader HttpHeaders header) {

		SecUsuarios retorno = null;

		try {
			retorno = UsuariosLogados.BuscarUsuario(header);
		} catch (Exception e) {

			System.out.println("Erro : " + e.getMessage());
		}

		return retorno;
	}

	@GetMapping("SecUsuarios/Usuario")
	@ApiOperation(value = "lista SecUsuarios ativo")
	public List<SecUsuarios> SecUsuariosUsuario(@RequestHeader HttpHeaders headers) {

		System.out.println(headers);

		String token = headers.get("authorization").get(0);

		List<SecUsuarios> lista = new ArrayList<>();

		SecUsuarios retorno = UsuariosLogados.BuscarUsuario(headers);

		if (retorno.getNOMEUSUARIO() == null) {

			List<SecUsuarios> sec_usuarios = sec_usuariosRepository.findByTOKEN(token);

			UsuariosLogados.AdicionarUsuario(sec_usuarios.get(0));

		} else {
			lista.add(retorno);
		}

		return lista;
	}

	@PostMapping("/SalvarUsuario")
	@ApiOperation(value = "cria um novo Usuario")
	public HashMap<String, Object> salvarUsuario(@RequestBody SecUsuarios SecUsuarios,
			@RequestHeader HttpHeaders header) {

		SecUsuarios idempresa = UsuariosLogados.BuscarUsuario(header);

		String validacao = "S";

		HashMap<String, Object> retorno = new HashMap<String, Object>();
		
		int IDPERFIL = 0;
		
		if(SecUsuarios.getCARGO().equals("Administrador")) {
			IDPERFIL = 1;
		}else if(SecUsuarios.getCARGO().equals("Cliente")) {
			IDPERFIL = 2;
		}else if(SecUsuarios.getCARGO().equals("Unidade")) {
			IDPERFIL = 3;
		}

		try {
			if (SecUsuarios.getNOMEUSUARIO().length() == 0) {
				validacao = "N";
			}

			if (SecUsuarios.getAPELIDO().length() == 0) {
				validacao = "N";
			}

			if (SecUsuarios.getCARGO().length() == 0) {
				validacao = "N";
			}

			if (SecUsuarios.getEMAIL().length() == 0) {
				validacao = "N";
			}

			if (SecUsuarios.getDDD() == 0) {
				validacao = "N";
			}

			if (SecUsuarios.getTELEFONE().length() == 0) {
				validacao = "N";
			}
			if (SecUsuarios.getLOGINUSUARIO().length() == 0) {
				validacao = "N";
			}

			/*
			 * if(SecUsuarios.getSENHA().length() == 0) { validacao = "N"; }
			 */

			if (SecUsuarios.getSTATUS() == 0) {
				validacao = "N";
			}

			if (SecUsuarios.getIDUSUARIO() == 0) {
				// É PARA CRIAR UM NOVO
				SecUsuarios usuario = new SecUsuarios();

				if (validacao == "S") {

					usuario.setAPELIDO(SecUsuarios.getAPELIDO());
					usuario.setCARGO(SecUsuarios.getCARGO());
					usuario.setDDD(SecUsuarios.getDDD());
					usuario.setEMAIL(SecUsuarios.getEMAIL());
					usuario.setFOTO(
							"https://www.uclg-planning.org/sites/default/files/styles/featured_home_left/public/no-user-image-square.jpg?itok=PANMBJF-");
					usuario.setIDEMPRESA(idempresa.getIDEMPRESA());
					usuario.setIDIDIOMA(1);
					usuario.setTELEFONE(SecUsuarios.getTELEFONE());
					usuario.setNOMEUSUARIO(SecUsuarios.getNOMEUSUARIO());
					usuario.setLOGINUSUARIO(SecUsuarios.getLOGINUSUARIO());
					usuario.setDESCSENHA(SecUsuarios.getSENHA());
					usuario.setSENHA(encoder.encode(SecUsuarios.getSENHA()));
					usuario.setSTATUS(SecUsuarios.getSTATUS());
					usuario.setTOKEN("");
					usuario.setIDEMPRESA(1);

					sec_usuariosRepository.save(usuario);
					
					SecUsuariosPerfis perfil = new SecUsuariosPerfis();
					
					perfil.setIDUSUARIO(usuario.getIDUSUARIO());
					perfil.setIDPERFIL(IDPERFIL);
					sec_usuarios_perfisRepository.save(perfil);
					retorno.put("validacao", validacao);
					retorno.put("mensagem", "novo usuário criado com sucesso !");
					
				}

			} else {
				SecUsuarios usuario = sec_usuariosRepository.findByIDUSUARIO(SecUsuarios.getIDUSUARIO());

				usuario.setAPELIDO(SecUsuarios.getAPELIDO());
				usuario.setCARGO(SecUsuarios.getCARGO());
				usuario.setDDD(SecUsuarios.getDDD());
				usuario.setTELEFONE(SecUsuarios.getTELEFONE());
				usuario.setSENHA(encoder.encode(SecUsuarios.getSENHA()));
				usuario.setSTATUS(1);
				usuario.setEMAIL(SecUsuarios.getEMAIL());
				usuario.setLOGINUSUARIO(SecUsuarios.getLOGINUSUARIO());
				usuario.setDESCSENHA(SecUsuarios.getSENHA());
				usuario.setNOMEUSUARIO(SecUsuarios.getNOMEUSUARIO());
				sec_usuariosRepository.save(usuario);
				
				SecUsuariosPerfis perfil = sec_usuarios_perfisRepository.findByIDUSUARIO(usuario.getIDUSUARIO());
				
				perfil.setIDPERFIL(IDPERFIL);
				sec_usuarios_perfisRepository.save(perfil);
				
				retorno.put("validacao", validacao);
				retorno.put("mensagem", "perfil editado com sucesso !");
				
				

			}

		} catch (Exception erro) {
			System.out.println("Erro : " + erro.getMessage());
		}

		return retorno;
	}

	@PostMapping("/SecUsuarios")
	@ApiOperation(value="lista todos os SecUsuarios em ordem crescente")
	public HashMap<String,Object> listarsec_usuarios(@RequestBody HashMap<String,Object> PaginacaoParametros){
		
		HashMap<String,Object> retorno = new HashMap<String,Object>();
		
		
		int INICIO = (int)PaginacaoParametros.get("PAGINA");
		int TAMANHO = (int)PaginacaoParametros.get("TAMANHO");

		List lista = null;
		try {
			Pageable pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
			lista = sec_usuariosRepository.ListarSecUsuariosPaginacao(pagina);
			int total = sec_usuariosRepository.findAll().size();
			int quantidade = lista.size();
			
			if(quantidade == 0 && total != 0) {
				
				INICIO = INICIO-1;
				pagina = PageRequest.of(INICIO, TAMANHO, Sort.by("NOMEUSUARIO").ascending());		
				lista = sec_usuariosRepository.ListarSecUsuariosPaginacao(pagina);
				total = sec_usuariosRepository.findAll().size();
				quantidade = lista.size();
				retorno.put("pagina", INICIO);
				
			}
			
			retorno.put("lista", lista);
			retorno.put("quantidade", quantidade);
			retorno.put("total", total);
			
		}catch(Exception e) {
			System.out.println("Erro : " + e);
		}
		
		return retorno;	
	}


	


	@GetMapping("/SecUsuarios")
	@ApiOperation(value = "lista todos os SecUsuarios em ordem crescente")
	public List<SecUsuarios> listarsec_usuarios() {
		List retorno = null;
		try {
			retorno = sec_usuariosRepository.findAll();
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
		return retorno;
	}

	@DeleteMapping("/DeletarUsuario")
	@ApiOperation(value = "Exclui um Usuario")
	public HashMap<String, Object> excluiruUuario(@RequestBody HashMap<String, Object> JsonIdusuario) {
		HashMap<String, Object> retorno = new HashMap<String, Object>();

		char validacao = 'A';
		String mensagem = "";

		try {

			int IDUSUARIO = (int) JsonIdusuario.get("idusuario");
			int IDPERFIL = 0;

			List<SecUsuariosPerfis> listausuariosperfis = sec_usuarios_perfisRepository.findAll();
			for (int i = 0; i < listausuariosperfis.size(); i++) {
				if (listausuariosperfis.get(i).getIDUSUARIO() == IDUSUARIO) {
					IDPERFIL = listausuariosperfis.get(i).getIDPERFIL();
					break;
				} else {
					IDPERFIL = 0;
				}
			}

			if (IDPERFIL == 2) {
				// SE O IDPERFIL FOR 2 E FOR UM CLIENTE
				BingoClientes Cliente = bingo_clientesRepository.BuscarClienteIDUSUARIO(IDUSUARIO);
				if (Cliente == null) {
					sec_usuarios_perfisRepository.DeletarSecUsuarioPerfilPorIDUSUARIO(IDUSUARIO);
					// ENFIM DELETE O USUÁRIO PELO SEU ID
					sec_usuariosRepository.deleteById(IDUSUARIO);
					validacao = 'S';
					mensagem = "Usuário deletado com sucesso";
				} else {
					int IDCLIENTE = Cliente.getIDCLIENTE();
					// DELETE O CLIENTE PELO O ID DO USUARIO
					List<BingoUnidades> unidades = bingo_unidadesRepository.BingoUnidadesIDCLIENTE(IDCLIENTE);
					// VERIFICANDO SE TEM UNIDADES
					if (unidades.size() > 0) {
						// SE TIVER
						// Não poderá excluir
						validacao = 'N';
						mensagem = "Não é possível deletar o usuário, pois o mesmo é um cliente e possui algumas unidades";
						// A AÇÃO NÃO SERÁ CONCLUÍDA
					} else {

						validacao = 'S';
					}
					if (validacao == 'S') {
						// DELETO O CLIENTE
						bingo_clientesRepository.DeletarBingoClientePorIDUSUARIO(IDUSUARIO);
						sec_usuarios_perfisRepository.DeletarSecUsuarioPerfilPorIDUSUARIO(IDUSUARIO);
						// ENFIM DELETE O USUÁRIO PELO SEU ID
						sec_usuariosRepository.deleteById(IDUSUARIO);
						mensagem = "Usuário deletado com sucesso";

					}

				}

			} else if (IDPERFIL == 3) {
				// CASO AO CONTRÁRIO SE O PERFIL FOR 3 E FOR UMA UNIDADE
				bingo_unidadesRepository.DeletarBingoUnidadesPorIDUSUARIO(IDUSUARIO);
				// DELETE A UNIDADE PELO O ID DO USUÁRIO
				// FEITO ISSO, AGORA DELLETE O USUARIO PERFIL DO USUARIO
				sec_usuarios_perfisRepository.DeletarSecUsuarioPerfilPorIDUSUARIO(IDUSUARIO);
				// ENFIM DELETE O USUÁRIO PELO SEU ID
				sec_usuariosRepository.deleteById(IDUSUARIO);
				mensagem = "Usuário unidade deletado com sucesso";
				validacao = 'S';

			} else{
				
				port_usuarios_mensagensRepository.DeletarPortUsuariosMensagens(IDUSUARIO);
				sec_usuarios_perfisRepository.DeletarSecUsuarioPerfilPorIDUSUARIO(IDUSUARIO);
				// ENFIM DELETE O USUÁRIO PELO SEU ID
				sec_usuariosRepository.deleteById(IDUSUARIO);
				mensagem = "Usuário  deletado com sucesso";
				validacao = 'S';
			}

			retorno.put("mensagem", mensagem);
			retorno.put("validacao", validacao);

		} catch (Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		return retorno;
	}
	
	
	
	@DeleteMapping("SecUsuarios")
	@ApiOperation(value = "Exclui um SecUsuarios")
	public void excluirsec_usuarios(@RequestBody SecUsuarios SecUsuarios) {
		sec_usuariosRepository.delete(SecUsuarios);
	}

	@PutMapping("SecUsuarios")
	@ApiOperation(value = "atualiza um SecUsuarios")
	public SecUsuarios atualizarsec_usuarios(@RequestBody SecUsuarios SecUsuarios) {
		return sec_usuariosRepository.save(SecUsuarios);
	}

}
