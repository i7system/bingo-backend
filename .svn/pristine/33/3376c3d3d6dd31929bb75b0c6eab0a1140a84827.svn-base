package br.com.bingo.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.PortListasBotoes;


public interface port_listas_botoesRepository extends JpaRepository<PortListasBotoes,Integer>{

	PortListasBotoes findByIDBOTAO(int IDBOTAO);
	
	@Query(value="SELECT u FROM PortListasBotoes u WHERE u.IDLISTA=?1 ")
    List<PortListasBotoes> findByIDLISTA(int idlista, Pageable paginacao);
	
}
