package br.com.bingo.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.SecUsuarios;
import br.com.bingo.repository.sec_usuariosRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_usuariosController")
@CrossOrigin(origins = "*", maxAge = 3600)
public class Logout {
	
	private sec_usuariosRepository sec_usuariosRepository;
	
	@PostMapping(value="/Logout")
	public void Logout(@RequestHeader HttpHeaders headers) {
		
		String token = headers.get("authorization").get(0);
		
	//	SecUsuarios usuario = sec_usuariosRepository.findByTOKEN(token);
		
//usuario.setTOKEN("");
		
	//	sec_usuariosRepository.save(usuario);
	
		
		
		
	}

}
