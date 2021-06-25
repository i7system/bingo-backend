package br.com.bingo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bingo.models.SecMenusPerfis;


public interface sec_menus_perfisRepository extends JpaRepository<SecMenusPerfis,Long>{
	
	List<SecMenusPerfis> findByIDMENUPERFIL(int IDMENUPERFIL);
	
	@Modifying
    @Transactional
	@Query(value=" INSERT INTO sec_menus_perfis(IDEMPRESA, IDPERFIL, IDMENU) " + 
			" SELECT :IDEMPRESA, :IDPERFIL, IDMENU FROM port_menus",nativeQuery = true
			)
	public void  salvar_sec_menus_perfis(@Param("IDEMPRESA") int IDEMPRESA, @Param("IDPERFIL") int IDPERFIL); 
	
	


}

