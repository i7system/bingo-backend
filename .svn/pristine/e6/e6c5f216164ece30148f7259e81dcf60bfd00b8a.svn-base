package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.PortListasColunas;


public interface port_listas_colunasRepository extends JpaRepository<PortListasColunas,Integer>{
	
	PortListasColunas findByIDLISTACOLUNA(int IDLISTACOLUNA);
	
	List<PortListasColunas> findByIDLISTA(int IDLISTA, Pageable paginacao);
	
 
}
