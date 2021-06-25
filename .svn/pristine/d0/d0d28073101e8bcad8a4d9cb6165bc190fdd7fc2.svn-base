package br.com.bingo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.bingo.models.BingoJogos;
import br.com.bingo.repository.bingo_jogosRepository;

@RestController
@RequestMapping(value="/financeiro")
@Api("bingo_jogosController")
@CrossOrigin(origins="*")

public class bingo_jogosController {

	@Autowired
	bingo_jogosRepository bingo_jogosRepository;
	
	@GetMapping("BingoJogos")
	@ApiOperation(value="lista todos os BingoJogos em ordem crescente")
	public List<BingoJogos> listarbingo_jogos(){
		return bingo_jogosRepository.findAll();		
	}
	
	@PostMapping("BingoJogos")
	@ApiOperation(value="cria um novo BingoJogos")
	public BingoJogos salvarbingo_jogos(@RequestBody BingoJogos BingoJogos) {	
		return bingo_jogosRepository.save(BingoJogos);
	}

	@PutMapping("BingoJogos")
	@ApiOperation(value="atualiza um BingoJogos")
	public BingoJogos atualizarbingo_jogos(@RequestBody BingoJogos BingoJogos) {	
		return bingo_jogosRepository.save(BingoJogos);
	}

	
}
