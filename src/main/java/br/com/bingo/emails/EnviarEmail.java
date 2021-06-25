package br.com.bingo.emails;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.config.TratamentoErros;
import br.com.bingo.controllers.sec_empresasController;
import br.com.bingo.controllers.sec_errosController;

@RestController
public class EnviarEmail {

 
	   @Autowired private static JavaMailSender mailSender;
	   
	    @PostMapping(value="/enviaremail")
	    public static  void sendMail(String email, String nomeusuario, String codigovalidacao, @RequestHeader HttpHeaders header) throws MessagingException {
	    /*    SimpleMailMessage message = new SimpleMailMessage();
	        message.setText("Hello from Spring Boot Application");
	        message.setTo("moises24_silva@hotmail.com");
	        message.setFrom("bgbrtest@gmail.com");*/
	        
	    	String style="'color:solid red;'";
	        
	        MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo(email);
            helper.setSubject("Confirmação de conta bingoWeb");
            helper.setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\r\n" + 
            		"        \"http://www.w3.org/TR/html4/strict.dtd\">\r\n" + 
            		"<HTML>\r\n" + 
            		"  <HEAD>\r\n" + 
            		"    <TITLE>The document title</TITLE>\r\n" + 
            		"    <style>\r\n" + 
            		"       h1,h2{\r\n" + 
            		"        font-family: sans-serif;\r\n" + 
            		"        color:  #4F545C;\r\n" + 
            		"        text-align: center;\r\n" + 
            		"      }\r\n" + 
            		"\r\n" + 
            		"      h3{\r\n" + 
            		"        font-family: sans-serif;\r\n" + 
            		"        color: #4F545C;\r\n" + 
            		" \r\n" + 
            		"        margin-top: 0%;\r\n" + 
            		"        }\r\n" + 
            		"\r\n" + 
            		"    td{\r\n" + 
            		"         border:solid red 2px;\r\n" + 
            		"         display: flex;\r\n" + 
            		"         justify-content: center;\r\n" + 
            		"       }\r\n" + 
            		"       p{\r\n" + 
            		"        text-align: center;\r\n" + 
            		"         \r\n" + 
            		"       }\r\n" + 
            		"\r\n" + 
            		"  \r\n" + 
            		"    </style>\r\n" + 
            		"\r\n" + 
            		"  </HEAD>\r\n" + 
            		"  <BODY>\r\n" + 
            		"  \r\n" + 
            		"  <p><img src=\"https://bingo-notas-empresas.s3.amazonaws.com/Empresa00/Imagens/logobingo1.png\"/></p>\r\n" + 
            		"\r\n" + 
            		"     \r\n" + 
            		"\r\n" + 
            		"   <p><h2>Olá "+nomeusuario+", Seu código de ativação é : </h2></p>\r\n" + 
            		"   <p><h2>"+codigovalidacao+"</h2></p>\r\n" + 
            		"  </BODY>\r\n" + 
            		"</HTML>\r\n" + 
            		"", true);
          


	        try {
	        	  mailSender.send(mail);
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	          
	            sec_errosController tratarerro = new sec_errosController();
	            
	            tratarerro.SalvarErro(e, header, "br.com.bingo.emails","EnviarEmail", "enviaremail");
	            
	       
	           
	        }
	    }
	
}
