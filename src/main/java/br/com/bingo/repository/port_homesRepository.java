package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortHomes;


public interface port_homesRepository extends JpaRepository<PortHomes,Long>{
	
	List<PortHomes> findByIDHOME(int IDHOME);

}

