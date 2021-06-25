package br.com.bingo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortTecnologiasGrupos;


public interface port_tecnologias_gruposRepository extends JpaRepository<PortTecnologiasGrupos,Integer>{
	
	PortTecnologiasGrupos findByIDGRUPO(int IDGRUPO);
 
}
