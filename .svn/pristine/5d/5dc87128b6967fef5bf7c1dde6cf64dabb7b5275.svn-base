package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortHomesItens;


public interface port_homes_itensRepository extends JpaRepository<PortHomesItens,Long>{
	
	List<PortHomesItens> findByIDITEM(int IDITEM);
	List<PortHomesItens> findByIDHOME(int IDHOME);

}

