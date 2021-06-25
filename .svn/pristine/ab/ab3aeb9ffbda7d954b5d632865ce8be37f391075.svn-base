package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.SecEmpresas;

public interface sec_empresasRepository extends JpaRepository<SecEmpresas,Long>{
	
	SecEmpresas findByIDEMPRESA(int IDEMPRESA);
	
	@Query(value="SELECT IFNULL(MAX(IDEMPRESA),0)+1 AS PROXIMO FROM sec_empresas ",nativeQuery = true)
	int proximo(); 

	@Query(value="SELECT u FROM SecEmpresas u WHERE u.TOKEN=?1 AND u.CODIGOVALIDACAO=?2 ")
	SecEmpresas ValidarCodigo(String TOKEN, String CODIGOVALIDACAO) ;


}

