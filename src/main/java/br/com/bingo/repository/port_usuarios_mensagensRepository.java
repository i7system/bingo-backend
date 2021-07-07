package br.com.bingo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bingo.models.PortUsuariosMensagens;

public interface port_usuarios_mensagensRepository extends JpaRepository<PortUsuariosMensagens,Long>{
	
	List<PortUsuariosMensagens> findByIDMENSAGEM(int IDMENSAGEM);	
	List<PortUsuariosMensagens> findByIDUSUARIO(int IDUSUARIO);

	  @Query("select u FROM PortUsuariosMensagens u WHERE u.IDUSUARIO=?1 ")
	  List<PortUsuariosMensagens> listar_mensagem_usuario( Pageable paginacao,int IDUSUARIO);    

		@Modifying
		@Transactional
		@Query(value = "DELETE FROM port_usuarios_mensagens where IDUSUARIO =:IDUSUARIO", nativeQuery = true)
		void DeletarPortUsuariosMensagens(@Param("IDUSUARIO") int IDUSUARIO);

}

