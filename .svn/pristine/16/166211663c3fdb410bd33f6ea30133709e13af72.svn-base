package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortListas;


public interface port_listasRepository extends JpaRepository<PortListas,Integer>{
	
	List<PortListas> findByIDLISTA(int IDLISTA, Pageable paginacao);
 
}
