package br.com.bingo;

import java.util.ArrayList;
import java.util.List;
import br.com.bingo.models.SecUsuarios;

public class parametros {
	public static List<SecUsuarios> usuarios_token = new ArrayList<>(); 
	
	public static String FOTOUSUARIO = "https://www.uclg-planning.org/sites/default/files/styles/featured_home_left/public/no-user-image-square.jpg?itok=PANMBJF-;";
		
	public static void adicionar_usuario(SecUsuarios usuario) {	
		int existe=0;				
		for(int i=0; i<usuarios_token.size();i++) {		
			if(usuarios_token.get(i).getIDUSUARIO() == usuario.getIDUSUARIO()) {
				existe=i;
			}
		}	
		if(existe==0) {
		   usuarios_token.add(usuario);
		}
		
		if(existe!=0) {
			usuarios_token.remove(existe);
			usuarios_token.add(usuario);
		}
	}
		
	public static SecUsuarios buscar_usuario(String token) {		
		String existe="N";	
		SecUsuarios usuario = new SecUsuarios();
		for(int i=0; i<usuarios_token.size();i++) {
			if(usuarios_token.get(i).getTOKEN().contains(token.replace("\"", ""))) {
				usuario= usuarios_token.get(i);
			}
		}		
		return usuario;
	}	
	
	
	public static void remove_usuario(int IDUSUARIO) {	
		int existe=0;				
		for(int i=0; i<usuarios_token.size();i++) {		
			if(usuarios_token.get(i).getIDUSUARIO() == IDUSUARIO) {
				existe=i;
			}
		}			
		if(existe!=0) {
			usuarios_token.remove(existe);
		}
	}
	
}


