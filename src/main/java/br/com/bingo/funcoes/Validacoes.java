package br.com.bingo.funcoes;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.sec_usuariosRepository;

@RestController
@RequestMapping(value = "/bingo/validacoes")
public class Validacoes {

	@Autowired
	private sec_usuariosRepository repositorio01;

	@PostMapping(path = "/ValidarLoginUsuario")
	public HashMap<String, Object> ValidarLoginUsuario(@RequestBody HashMap<String, Object> RequisicaoLoginUsuario) {
		
		HashMap<String, Object> retorno = new HashMap<>();
		//CRIANDO OBJETO DE RETORNO

		String LOGINUSUARIO = (String) RequisicaoLoginUsuario.get("campo");
		//CAPTURANDO O EMAIL VINDO DO CLIENT
		int TIPO = (int) RequisicaoLoginUsuario.get("tipo");
		//CAPTURANDO O TIPO DA AÇÃO
		//OBS: SE O TIPO FOR 1 O CLIENTE ESTÁ CRIANDO O USUÁRIO
		//SE FOR 2 O CLIENTE ESTÁ ALTERANDO O USUÁRIO
				
		List<SecUsuarios> usuarios = repositorio01.findAll();
		//LISTANDO OS USUARIOS
		if (TIPO == 1) {
			//SE O USUÁRIO FOR CRIAR
			for (int i = 0; i < usuarios.size(); i++) {
				//ME LISTE TODOS OS USUÁRIOS CONTIDOS NO BANCO DE DADOS
				if(usuarios.get(i).getLOGINUSUARIO().equals(LOGINUSUARIO)){
					//SE ALGUM DESSES USUÁRIOS TIVER O MESMO EMAIL QUE VEIO DA REQUISIÇÃO
					retorno.put("existe", "S");
					//ENTÃO RETORNAREI AO USUÁRIO UMA MENSAGEM INFORMANDO QUE O LOGINUSUARIO QUE FOI PASSADO JÁ EXISTE !
					break;
					//LOGO APÓS TER ENCONTRADO O LOGINUSUARIO EXISTENTE, PARO O LOOPING
				}else{
					//CASO AO CONTRÁRIO SE O EMAIL INFORMADO NÃO EXISTIR
					retorno.put("existe", "N");
					//INFORMO AO USUÁRIO QUE O EMAIL NÃO EXISTE !
				}
			}

		}else if(TIPO == 2) {
			//SE O USUÁRIO FOR ALTERAR
			int IDUSUARIO = (int)RequisicaoLoginUsuario.get("idusuario");
			//PEGO O IDUSUARIO PASSADO NA REQUISIÇÃO
			String LOGINUSUARIOATUAL = repositorio01.findByIDUSUARIO(IDUSUARIO).getLOGINUSUARIO();
			//PEGO O LOGINUSUARIO DESTE USUÁRIO
			for(int i = 0;i<usuarios.size();i++) {
				//LISTO TODOS OS USUÁRIOS
				if(usuarios.get(i).getLOGINUSUARIO() != LOGINUSUARIOATUAL){
					//LISTO TODOS OS USUÁRIOS QUE SÃO DIFERENTES DO EMAILATUAL
					if(usuarios.get(i).getLOGINUSUARIO().equals(LOGINUSUARIO)){
						//SE ALGUM DESSES USUÁRIOS FOR IGUAL AO EMAIL PASSADO NA REQUISIÇÃO
						retorno.put("existe", 'S');
						//ENTÃO INFORMO AO USUÁRIO QUE O LOGINUSUARIO JÁ EXISTE
						break;
						//PARO O LOOPING
					}else {
						//CASO NÃO EXISTIR
						retorno.put("existe", 'N');
						//INFORMO AO USUÁRIO QUE O LOGINUSUARIO NÃO EXISTE
					}
				}
			}
		}

	

		return retorno;

	}
	
	@PostMapping(path = "/ValidarEmail")
	public HashMap<String, Object> ValidarEmail(@RequestBody HashMap<String, Object> RequisicaoEmail) {
		
		HashMap<String, Object> retorno = new HashMap<>();
		//CRIANDO OBJETO DE RETORNO

		String EMAIL = (String) RequisicaoEmail.get("campo");
		//CAPTURANDO O EMAIL VINDO DO CLIENT
		int TIPO = (int) RequisicaoEmail.get("tipo");
		//CAPTURANDO O TIPO DA AÇÃO
		//OBS: SE O TIPO FOR 1 O CLIENTE ESTÁ CRIANDO O USUÁRIO
		//SE FOR 2 O CLIENTE ESTÁ ALTERANDO O USUÁRIO
				
		List<SecUsuarios> usuarios = repositorio01.findAll();
		//LISTANDO OS USUARIOS
		if (TIPO == 1) {
			//SE O USUÁRIO FOR CRIAR
			for (int i = 0; i < usuarios.size(); i++) {
				//ME LISTE TODOS OS USUÁRIOS CONTIDOS NO BANCO DE DADOS
				if(usuarios.get(i).getEMAIL().equals(EMAIL)){
					//SE ALGUM DESSES USUÁRIOS TIVER O MESMO EMAIL QUE VEIO DA REQUISIÇÃO
					retorno.put("existe", "S");
					//ENTÃO RETORNAREI AO USUÁRIO UMA MENSAGEM INFORMANDO QUE O LOGINUSUARIO QUE FOI PASSADO JÁ EXISTE !
					break;
					//LOGO APÓS TER ENCONTRADO O LOGINUSUARIO EXISTENTE, PARO O LOOPING
				}else{
					//CASO AO CONTRÁRIO SE O EMAIL INFORMADO NÃO EXISTIR
					retorno.put("existe", "N");
					//INFORMO AO USUÁRIO QUE O EMAIL NÃO EXISTE !
				}
			}

		}else if(TIPO == 2) {
			//SE O USUÁRIO FOR ALTERAR
			int IDUSUARIO = (int)RequisicaoEmail.get("idusuario");
			//PEGO O IDUSUARIO PASSADO NA REQUISIÇÃO
			String EMAILATUAL = repositorio01.findByIDUSUARIO(IDUSUARIO).getEMAIL();
			//PEGO O LOGINUSUARIO DESTE USUÁRIO
			for(int i = 0;i<usuarios.size();i++) {
				//LISTO TODOS OS USUÁRIOS
				if(usuarios.get(i).getEMAIL() != EMAILATUAL){
					//LISTO TODOS OS USUÁRIOS QUE SÃO DIFERENTES DO EMAILATUAL
					if(usuarios.get(i).getEMAIL().equals(EMAIL)){
						//SE ALGUM DESSES USUÁRIOS FOR IGUAL AO EMAIL PASSADO NA REQUISIÇÃO
						retorno.put("existe", 'S');
						//ENTÃO INFORMO AO USUÁRIO QUE O LOGINUSUARIO JÁ EXISTE
						break;
						//PARO O LOOPING
					}else {
						//CASO NÃO EXISTIR
						retorno.put("existe", 'N');
						//INFORMO AO USUÁRIO QUE O LOGINUSUARIO NÃO EXISTE
					}
				}
			}
		}

	

		return retorno;

	}
	
	@PostMapping(path = "/ValidarTelefone")
	public HashMap<String, Object> ValidarTelefone(@RequestBody HashMap<String, Object> RequisicaoTelefone) {
		
		HashMap<String, Object> retorno = new HashMap<>();
		//CRIANDO OBJETO DE RETORNO

		String TELEFONE = (String) RequisicaoTelefone.get("campo");
		//CAPTURANDO O EMAIL VINDO DO CLIENT
		int TIPO = (int) RequisicaoTelefone.get("tipo");
		//CAPTURANDO O TIPO DA AÇÃO
		//OBS: SE O TIPO FOR 1 O CLIENTE ESTÁ CRIANDO O USUÁRIO
		//SE FOR 2 O CLIENTE ESTÁ ALTERANDO O USUÁRIO
				
		List<SecUsuarios> usuarios = repositorio01.findAll();
		//LISTANDO OS USUARIOS
		if (TIPO == 1) {
			//SE O USUÁRIO FOR CRIAR
			for (int i = 0; i < usuarios.size(); i++) {
				//ME LISTE TODOS OS USUÁRIOS CONTIDOS NO BANCO DE DADOS
				
				String ddd = Integer.toString(usuarios.get(i).getDDD());
				String telefonecompleto = ddd+usuarios.get(i).getTELEFONE();
				
				if (telefonecompleto.equals(TELEFONE)) {				
					retorno.put("existe", "S");
					//ENTÃO RETORNAREI AO USUÁRIO UMA MENSAGEM INFORMANDO QUE O LOGINUSUARIO QUE FOI PASSADO JÁ EXISTE !
					break;
				}else{
					//CASO AO CONTRÁRIO SE O EMAIL INFORMADO NÃO EXISTIR
					retorno.put("existe", "N");
					//INFORMO AO USUÁRIO QUE O EMAIL NÃO EXISTE !
				}
				
			}

		}else if(TIPO == 2) {
			//SE O USUÁRIO FOR ALTERAR
			int IDUSUARIO = (int)RequisicaoTelefone.get("idusuario");
			//PEGO O IDUSUARIO PASSADO NA REQUISIÇÃO
			
			String TELEFONEATUAL = Integer.toString(repositorio01.findByIDUSUARIO(IDUSUARIO).getDDD())+repositorio01.findByIDUSUARIO(IDUSUARIO).getTELEFONE();
			
			
			//PEGO O LOGINUSUARIO DESTE USUÁRIO
			for(int i = 0;i<usuarios.size();i++) {
				String TELEFONEBANCO_DADOS = Integer.toString(usuarios.get(i).getDDD())+usuarios.get(i).getTELEFONE();
				//LISTO TODOS OS USUÁRIOS
				if(TELEFONEBANCO_DADOS != TELEFONEATUAL){
					//LISTO TODOS OS USUÁRIOS QUE SÃO DIFERENTES DO EMAILATUAL
					if(TELEFONEBANCO_DADOS.equals(TELEFONE)){
						//SE ALGUM DESSES USUÁRIOS FOR IGUAL AO EMAIL PASSADO NA REQUISIÇÃO
						retorno.put("existe", 'S');
						//ENTÃO INFORMO AO USUÁRIO QUE O LOGINUSUARIO JÁ EXISTE
						break;
						//PARO O LOOPING
					}else {
						//CASO NÃO EXISTIR
						retorno.put("existe", 'N');
						//INFORMO AO USUÁRIO QUE O LOGINUSUARIO NÃO EXISTE
					}
				}
			}
		}

	

		return retorno;

	}
}
