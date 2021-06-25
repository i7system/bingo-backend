package br.com.bingo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bingo.models.BingoSorteios;

public interface bingo_sorteiosRepository extends JpaRepository<BingoSorteios,Long>{
	
	List<BingoSorteios> findByIDSORTEIO(int IDSORTEIO);
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bingo_sorteios  where IDCLIENTE =:IDCLIENTE", nativeQuery = true)
	void DeletarSorteiosIDCLIENTE(@Param("IDCLIENTE") int IDCLIENTE);

	


}

