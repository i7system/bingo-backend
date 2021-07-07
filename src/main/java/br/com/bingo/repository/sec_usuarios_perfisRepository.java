package br.com.bingo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bingo.models.SecUsuariosPerfis;

public interface sec_usuarios_perfisRepository extends JpaRepository<SecUsuariosPerfis,Integer>{
	
	List<SecUsuariosPerfis> findByIDUSUARIOPERFIL(int IDUSUARIOPERFIL);
	
	SecUsuariosPerfis findByIDUSUARIO(int IDUSUARIO);
	
	@Query(value = " DELETE FROM sec_usuarios_perfis WHERE IDUSUARIO = ?1", nativeQuery = true)
	void DeletarSecUsuarioPerfilByIDUSUARIO(int IDUSUARIO);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM sec_usuarios_perfis  where IDUSUARIO =:IDUSUARIO", nativeQuery = true)
	void DeletarSecUsuarioPerfilPorIDUSUARIO(@Param("IDUSUARIO") int IDUSUARIO);

	
	@Query(value = "SELECT u FROM SecUsuariosPerfis u WHERE u.IDUSUARIO=?1")
	SecUsuariosPerfis ListarUsuarioPerfilIDUSUARIO(int IDUSUARIO);

}

