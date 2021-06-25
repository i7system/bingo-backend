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
import br.com.bingo.models.BingoSorteios;
import br.com.bingo.repository.bingo_sorteiosRepository;

@RestController
@RequestMapping(value="/financeiro")
@Api("bingo_sorteiosController")
@CrossOrigin(origins="*")

public class bingo_sorteiosController {

	@Autowired
	bingo_sorteiosRepository bingo_sorteiosRepository;
	
	@GetMapping("BingoSorteios")
	@ApiOperation(value="lista todos os BingoSorteios em ordem crescente")
	public List<BingoSorteios> listarbingo_sorteios(){
		return bingo_sorteiosRepository.findAll();		
	}
	
	@PostMapping("BingoSorteios")
	@ApiOperation(value="cria um novo BingoSorteios")
	public BingoSorteios salvarbingo_sorteios(@RequestBody BingoSorteios BingoSorteios) {	
		return bingo_sorteiosRepository.save(BingoSorteios);
	}

	@PutMapping("BingoSorteios")
	@ApiOperation(value="atualiza um BingoSorteios")
	public BingoSorteios atualizarbingo_sorteios(@RequestBody BingoSorteios BingoSorteios) {	
		return bingo_sorteiosRepository.save(BingoSorteios);
	}

	
}
