package br.com.bingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortGrupos;


public interface port_gruposRepository extends JpaRepository<PortGrupos,Integer>{
	
	PortGrupos findByIDGRUPO(int IDGRUPO);
 
}
