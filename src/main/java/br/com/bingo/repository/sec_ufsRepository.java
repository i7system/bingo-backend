package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.bingo.models.SecUfs;

@Repository
public interface sec_ufsRepository extends JpaRepository<SecUfs, Integer> {	
	
	SecUfs findByIDUF(int IDUF); 
	
	@Query("select u FROM SecUfs u ORDER BY u.IDUF")
	List<SecUfs> listarSecUfs();	 
}


