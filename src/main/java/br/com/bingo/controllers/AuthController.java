package br.com.bingo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.models.ERole;
import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.models.SecUsuariosPerfis;
import br.com.bingo.payload.request.LoginRequest;
import br.com.bingo.payload.request.SignupRequest;
import br.com.bingo.payload.response.JwtResponse;
import br.com.bingo.payload.response.MessageResponse;
import br.com.bingo.repository.sec_perfisRepository;
import br.com.bingo.repository.sec_usuariosRepository;
import br.com.bingo.repository.sec_usuarios_perfisRepository;
import br.com.bingo.security.jwt.JwtUtils;
import br.com.bingo.security.services.UserDetailsImpl;
import br.com.bingo.UsuariosLogados;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bingo/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	sec_usuariosRepository sec_usuariosRepository;

	@Autowired
	sec_perfisRepository sec_perfisRepository;
	
	@Autowired
	sec_usuarios_perfisRepository sec_usuarios_perfisRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	@RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = {
	        MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, @RequestHeader HttpHeaders header) {
			
		
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		



		
		try {
		

			
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());		
			String STRINGLOGIN = loginRequest.getUsername();
			
			SecUsuarios usuario =UsuariosLogados.UsuarioLogado;
			
			usuario.setTOKEN("Bearer " +  jwt );
			sec_usuariosRepository.save(usuario);
				
			
			UsuariosLogados.RemoverUsuario(usuario);
			
			UsuariosLogados.AdicionarUsuario(usuario);
			

		}catch(Exception e) {
			
			sec_errosController tratarerro = new sec_errosController();
			
			tratarerro.SalvarErro(e, header, "br.com.bingo.controllers", "AuthController", "authenticateUser");
		}
		
		
		return ResponseEntity.ok(new JwtResponse(jwt,				
				 userDetails.getLoginusuario(),
				 userDetails.getUsername()
				));
	}
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, @RequestHeader HttpHeaders header) {
	/*	if (sec_usuariosRepository.existsByEmail(signUpRequest.getEMAIL())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
*/
	/*	if (sec_usuariosRepository.existsByEmail(signUpRequest.getEMAIL())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Erro : Email já está sendo usado !"));
		}
*/
		// Create new user's account
	//	SecUsuarios usuario = new SecUsuarios(signUpRequest.getNOMEUSUARIO(),signUpRequest.getEMAIL(),
		//					 encoder.encode(signUpRequest.getPassword()));
		//Criando nova conta
		SecUsuarios usuario = new SecUsuarios();
		

	/*	if (strRoles == null) {
			SecPerfis userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}*/
		
		//user.setRoles(roles);
		
		try {
			usuario.setAPELIDO(signUpRequest.getUsername());
			usuario.setCARGO("");
			usuario.setDDD(13);
			usuario.setEMAIL(signUpRequest.getEmail());
			usuario.setFOTO("");
			usuario.setIDEMPRESA(1);
			usuario.setIDIDIOMA(1);
			usuario.setNOMEUSUARIO(signUpRequest.getUsername());
			usuario.setSENHA(encoder.encode(signUpRequest.getPassword()));
			usuario.setSTATUS(1);
			usuario.setTELEFONE("");
			usuario.setTOKEN("");
			
			Set<String> strRoles = signUpRequest.getRole();
			Set<SecPerfis> perfis = new HashSet<>();
			
			sec_usuariosRepository.save(usuario);
			
			SecUsuariosPerfis usuarioperfil = new SecUsuariosPerfis();
			
			
			usuarioperfil.setIDPERFIL(2);
			usuarioperfil.setIDUSUARIO(usuario.getIDUSUARIO());
			usuarioperfil.setSTATUS(1);
			sec_usuarios_perfisRepository.save(usuarioperfil);


		}catch(Exception e) {
			 sec_errosController erro = new sec_errosController();
			 
			 erro.SalvarErro(e, header, "br.com.bingo.controllers", "AuthController", "registerUser");
		}
		

		return ResponseEntity.ok(new MessageResponse("Usuário registrado com sucesso "));
	}
}
