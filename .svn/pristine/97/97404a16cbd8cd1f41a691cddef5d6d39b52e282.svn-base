package br.com.bingo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.PortListasColunas;
import br.com.bingo.models.TabColunas;


public interface tab_colunasRepository extends JpaRepository<TabColunas,Integer>{
	
	TabColunas findByIDCOLUNA(int IDCOLUNA);
	
	@Query(value="SELECT B.* FROM port_listas_colunas A, tab_colunas B " + 
			" WHERE A.IDCOLUNA = B.IDCOLUNA " + 
			" AND A.IDLISTA=?1 " + 
			" ORDER BY A.ORDEM ",nativeQuery=true)
	List<TabColunas> ListaTabColunas(int IDLISTA);

 
}
