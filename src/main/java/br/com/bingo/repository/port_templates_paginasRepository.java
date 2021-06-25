package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortTemplatesPaginas;


public interface port_templates_paginasRepository extends JpaRepository<PortTemplatesPaginas,Long>{
	
	List<PortTemplatesPaginas> findByIDPAGINA(int IDPAGINA);

}

