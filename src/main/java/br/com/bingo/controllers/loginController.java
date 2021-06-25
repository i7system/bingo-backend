package br.com.bingo.controllers;
/*package br.com.bingo.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bingo.repository.sec_usuariosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.views.Login;
import br.com.bingo.parametros;
import br.com.bingo.models.SecUsuarios;
import java.security.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.math.*;
import br.com.bingo.views.EsqueciSenha;
import br.com.bingo.emails.EnviarEmail;

@RestController
@RequestMapping(value="/bingo")
@Api("sec_usuariosController")
public class loginController  {
	@Autowired
	sec_usuariosRepository sec_usuariosRepository;

    @Autowired
    private JavaMailSender mailSender;
	
	@PostMapping("ValidarLogin")
	@ApiOperation(value="retorna 1 SecUsuarios por IDUSUARIO")
	public String ValidarLogin(@RequestBody Login Login) throws NoSuchAlgorithmException{		
		String retorno="";		
		
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("sanches_1971@hotmail.com");
        email.setSubject("Teste envio de e-mail");
        email.setText("Enviei este e-mail usando Spring Boot.");
        mailSender.send(email);
		
		
		
		int qtde_usuario= sec_usuariosRepository.ValidarLogin(Login.getEMAIL(), Login.getSENHA());	
		if(qtde_usuario>0) {
			   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			   Date date = new Date();
			   String token=dateFormat.format(date)+""+Login.getEMAIL()+"i7system";
		       MessageDigest m=MessageDigest.getInstance("MD5");
		       m.update(token.getBytes(),0,token.length());
		       token=new BigInteger(1,m.digest()).toString(16);
			   SecUsuarios novo_usuario = sec_usuariosRepository.findByEMAIL(Login.getEMAIL());	
			   novo_usuario.setTOKEN(token);
			   sec_usuariosRepository.save(novo_usuario);
			   parametros.adicionar_usuario(novo_usuario);
			   retorno=token;			
		}		
		return retorno;		
	}	

	@PostMapping("EsqueciSenha")
	@ApiOperation(value="esqueci a senha do sistema")
	public String esquecisenha(@RequestBody EsqueciSenha email) throws NoSuchAlgorithmException{	
		
		String retorno="";		
		
		
		System.out.println("email:"+email.getEMAIL());


		
		if(email.getEMAIL().length()<=0) {
			retorno="O email não foi informado";
			System.out.println(retorno);
		}
		
		if(retorno=="") {
			
			SecUsuarios usuario = sec_usuariosRepository.findByEMAIL(email.getEMAIL());
			
			
			if(usuario == null ) {
				retorno="O email informado não existe no sistema";
				System.out.println(retorno);

			} else {
			
			//System.out.println(usuario.getIDUSUARIO());
			//System.out.println("continua validando");
			     retorno="Enviamos um código de acesso para o email :"+usuario.getEMAIL();
					System.out.println(retorno);
			     
			} 			
		}
		

		int qtde_usuario= sec_usuariosRepository.ValidarLogin(Login.getEMAIL(), Login.getSENHA());	
		if(qtde_usuario>0) {
			   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			   Date date = new Date();
			   String token=dateFormat.format(date)+""+Login.getEMAIL()+"i7system";
		       MessageDigest m=MessageDigest.getInstance("MD5");
		       m.update(token.getBytes(),0,token.length());
		       token=new BigInteger(1,m.digest()).toString(16);
			   SecUsuarios novo_usuario = sec_usuariosRepository.findByEMAIL(Login.getEMAIL());	
			   novo_usuario.setTOKEN(token);
			   sec_usuariosRepository.save(novo_usuario);
			   parametros.adicionar_usuario(novo_usuario);
			   retorno=token;			
		}	
	
		return retorno;		
	}	

	
	
	@GetMapping("Logout")
	@ApiOperation(value="exclui usuario da memoria do servidor")
	public void Logout(@RequestHeader HttpHeaders headers){	
		List<String> token=headers.get("authorization");
		SecUsuarios usuario = parametros.buscar_usuario(token.get(0));
		parametros.remove_usuario(usuario.getIDUSUARIO());		
	}
	
}*/
