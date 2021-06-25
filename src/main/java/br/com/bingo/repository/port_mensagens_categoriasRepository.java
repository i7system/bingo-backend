package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.PortMensagensCategorias;



public interface port_mensagens_categoriasRepository extends JpaRepository<PortMensagensCategorias,Long>{
	
	List<PortMensagensCategorias> findByIDCATEGORIA(int IDCATEGORIA);
	
	  @Query("select u FROM PortMensagensCategorias u WHERE u.STATUS=1")
	  List<PortMensagensCategorias> lista_ativos( Pageable paginacao);    

}

