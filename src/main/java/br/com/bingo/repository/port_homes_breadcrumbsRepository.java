package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bingo.models.PortHomesBreadcrumbs;


public interface port_homes_breadcrumbsRepository extends JpaRepository<PortHomesBreadcrumbs,Long>{
	

	List<PortHomesBreadcrumbs> findByIDBREADCRUMB(int IDBREADCRUMB);
	
	List<PortHomesBreadcrumbs> findByIDHOME(int IDHOME);
}

