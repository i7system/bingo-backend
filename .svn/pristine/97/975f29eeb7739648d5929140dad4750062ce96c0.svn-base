
package br.com.bingo.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.PortMenus;
import br.com.bingo.views.MetisMenus;

public interface port_menusRepository extends JpaRepository<PortMenus,Long>{
	
	  List<PortMenus> findByIDMENU(int IDMENU);
		
	  @Query(value = " SELECT C.* FROM port_menus C WHERE C.IDMENU IN ( " + 
		  		" SELECT B.IDMENU FROM sec_menus_perfis B WHERE B.IDPERFIL IN ( " + 
		  		" SELECT A.IDPERFIL FROM sec_usuarios_perfis A WHERE A.IDUSUARIO=?1 )) ORDER BY IDMENU ", nativeQuery = true)
	  List<PortMenus> lista_port_menus(int IDUSUARIO);	 
	  	
	
}
