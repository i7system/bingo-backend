package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import br.com.bingo.models.SecCidades;

@Repository
public interface sec_cidadesRepository extends JpaRepository<SecCidades, Integer> {	
	
	SecCidades findByIDCIDADE(int IDCIDADE); 
	
	@Query("select u FROM SecCidades u ORDER BY u.IDCIDADE")
	List<SecCidades> listarSecCidades();
	
	@Query("SELECT u FROM SecCidades u WHERE u.IDUF = ?1")
	List<SecCidades> listarCidadesByIDUF(int IDUF);


}