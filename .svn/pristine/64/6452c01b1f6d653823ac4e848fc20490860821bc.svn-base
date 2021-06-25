package br.com.bingo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.config.TextMessageDTO;
import io.swagger.annotations.Api;

@RestController
//@RequestMapping(value = "/bingo")
//@Api("sec_usuariosController")
@CrossOrigin(origins = "*", maxAge = 3600)
public class WebSocketTextController {
	
	@Autowired
    	SimpMessagingTemplate template;
	
	@PostMapping("/send")
	public ResponseEntity<Void> sendMessage(@RequestBody TextMessageDTO textMessageDTO) {
		template.convertAndSend("/topic/message", textMessageDTO);
		System.out.println("Mensagem recebida: " +  textMessageDTO.getMessage());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@MessageMapping("/sendMessage")
	public void receiveMessage(@Payload TextMessageDTO textMessageDTO) {
		// receive message from client
		
	}
	
	
	@SendTo("/topic/message")
	public TextMessageDTO broadcastMessage(@Payload TextMessageDTO textMessageDTO) {
		
		return textMessageDTO;
	}
}