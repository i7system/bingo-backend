package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortTemplates;


public interface port_templatesRepository extends JpaRepository<PortTemplates,Long>{
	
	List<PortTemplates> findByIDTEMPLATE(int IDTEMPLATE);

}

