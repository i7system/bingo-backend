package br.com.bingo.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bingo.UsuariosLogados;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.sec_usuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	sec_usuariosRepository sec_usuariosRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String STRINGLOGIN) throws UsernameNotFoundException {

		// SecUsuarios usuario = sec_usuariosRepository.findByEMAIL(EMAIL);

		SecUsuarios usuario = null;
		char validacao = 'N';

		List<SecUsuarios> usuarios = sec_usuariosRepository.findAll();
		// TENTANDO POR LOGINUSUARIO
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLOGINUSUARIO().equals(STRINGLOGIN)) {
				usuario = usuarios.get(i);
				validacao = 'S';
				break;
			}
		}

		if (validacao == 'N') {
			//TENTANDO POR EMAIL
			for (int i = 0; i < usuarios.size(); i++) {
				if (usuarios.get(i).getEMAIL().equals(STRINGLOGIN)) {
					usuario = usuarios.get(i);
					validacao = 'S';
					break;
				}
			}

		}
		
		if (validacao == 'N') {
			//TENTANDO POR TELEFONE
			for (int i = 0; i < usuarios.size(); i++) {
				
				String ddd = Integer.toString(usuarios.get(i).getDDD());
				String telefonecompleto = ddd+usuarios.get(i).getTELEFONE();
				
				if (telefonecompleto.equals(STRINGLOGIN)) {
					usuario = usuarios.get(i);
					validacao = 'S';
					break;
				}
			}

		}
		
		UsuariosLogados.UsuarioLogado = usuario;

		// .orElseThrow(() -> new UsernameNotFoundException("Usuario não foi encontrado
		// com o EMAIL: " + EMAIL));
		return UserDetailsImpl.build(usuario);
	}

}
