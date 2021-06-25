package br.com.bingo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;

import br.com.bingo.models.SecUsuarios;

public class UsuariosLogados {

	public static List<SecUsuarios> ListaUsuarios = new ArrayList<SecUsuarios>();

	public static String BuscarToken(HttpHeaders headers) {

		String token = headers.get("authorization").get(0);
		return token;
	}

	public static void AdicionarUsuario(SecUsuarios usuario) {

			ListaUsuarios.add(usuario);
	}

	public static SecUsuarios BuscarUsuario(HttpHeaders headers) {
		String token = headers.get("authorization").get(0);
		SecUsuarios usuario = new SecUsuarios();
		
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			if (ListaUsuarios.get(i).getTOKEN().contentEquals(token)) {
				usuario = ListaUsuarios.get(i);
			}
		}
		return usuario;
	}
	
	
	public static void RemoverUsuario(String loginusuario) {
		
		
		for (int a = 0; a < 10; a++) {
			
		for (int i = 0; i < ListaUsuarios.size(); i++) {
			if (ListaUsuarios.get(i).getLOGINUSUARIO().contentEquals(loginusuario)) {
				System.out.println("passei");
				ListaUsuarios.remove(i);
				break;
			}
		}
		
		}
	}
	
	
	
	
	
}
