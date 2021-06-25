package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.SecPerfis;

public interface sec_perfisRepository extends JpaRepository<SecPerfis,Integer>{
	
	SecPerfis findByIDPERFIL(int IDPERFIL);
	
	@Query(value="SELECT IFNULL(MAX(IDPERFIL),0)+1 AS PROXIMO FROM sec_perfis ",nativeQuery = true)
	int proximo(); 
	
	@Query(value="select u FROM SecPerfis u")
	List<SecPerfis> ListarSecPerfisPaginacao(Pageable paginacao);
	

}

