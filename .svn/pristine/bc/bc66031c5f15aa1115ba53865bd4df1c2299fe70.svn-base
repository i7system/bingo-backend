package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortListasBreadcrumbs;


public interface port_listas_breadcrumbsRepository extends JpaRepository<PortListasBreadcrumbs,Integer>{
	
	PortListasBreadcrumbs findByIDLISTABREADCRUMB(int IDLISTABREADCRUMB);
	
	List<PortListasBreadcrumbs> findByIDLISTA(int IDLISTA, Pageable paginacao);

 
}
