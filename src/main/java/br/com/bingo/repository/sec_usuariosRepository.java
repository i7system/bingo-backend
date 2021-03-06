package br.com.bingo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bingo.models.SecPerfis;
import br.com.bingo.models.SecUsuarios;
import br.com.bingo.views.UsuariosDestePerfil;

public interface sec_usuariosRepository extends JpaRepository<SecUsuarios,Integer>{
	
	SecUsuarios findByIDUSUARIO(int IDUSUARIO);
		
	Optional<SecUsuarios> findByNOMEUSUARIO(String NOMEUSUARIO);
	
	SecUsuarios  findByEMAIL(String EMAIL);
	
	SecUsuarios  findByLOGINUSUARIO(String LOGINUSUARIO);
	
	List<SecUsuarios>  findByTOKEN(String TOKEN);
	
	
	@Query(value="select u FROM SecUsuarios u")
	List<SecUsuarios> ListarSecUsuariosPaginacao(Pageable paginacao);

	
	@Query("SELECT COUNT(u.IDUSUARIO) FROM SecUsuarios u WHERE u.EMAIL= ?1 AND u.SENHA = ?2 ")
	int ValidarLogin(String EMAIL, String SENHA); 
	
	@Query("SELECT COUNT(u.IDUSUARIO) FROM SecUsuarios u WHERE u.EMAIL=?1 ")
	int ValidarEmail(String EMAIL);
	
	@Query("SELECT u FROM SecUsuarios u WHERE u.IDEMPRESA=?1 AND u.EMAIL=?2")
	SecUsuarios BuscarUsuarioPorIdempresa(int IDEMPRESA, String EMAIL);
	
	@Query(value=" SELECT EMAIL AS username, SENHA AS password FROM sec_usuarios WHERE EMAIL=?1 ", nativeQuery=true)
	Optional<SecUsuarios> AcharPeloEmail(String username);
	
	@Query(value = "SELECT B.IDUSUARIOPERFIL,A.IDUSUARIO,A.NOMEUSUARIO,A.EMAIL FROM sec_usuarios A, sec_usuarios_perfis B WHERE B.IDUSUARIO = A.IDUSUARIO AND B.IDPERFIL = ?1",nativeQuery=true)
	List VisualizarUsuariosPerfisPaginacao(int IDPERFIL,Pageable paginacao);
	
	@Query(value = "SELECT B.IDUSUARIOPERFIL,A.IDUSUARIO,A.NOMEUSUARIO,A.EMAIL FROM sec_usuarios A, sec_usuarios_perfis B WHERE B.IDUSUARIO = A.IDUSUARIO AND B.IDPERFIL = ?1",nativeQuery=true)
	List VisualizarUsuariosPerfis(int IDPERFIL);

	
	@Query(value = "SELECT A.* FROM sec_usuarios A WHERE A.IDUSUARIO NOT IN (SELECT IDUSUARIO FROM sec_usuarios_perfis)",nativeQuery=true)
	List<SecUsuarios> ListarUsuariosSemPerfil();
	
	@Query(value = " SELECT A.* FROM sec_usuarios A, sec_usuarios_perfis B WHERE B.IDUSUARIO = A.IDUSUARIO AND B.IDPERFIL = ?1",nativeQuery=true)
	List<SecUsuarios> ListarUsuariosDestePerfilPaginacao(int IDPERFIL,Pageable paginacao);
	
	@Query(value = " SELECT A.* FROM sec_usuarios A, sec_usuarios_perfis B WHERE B.IDUSUARIO = A.IDUSUARIO AND B.IDPERFIL = ?1",nativeQuery=true)
	List<SecUsuarios> ListarUsuariosDestePerfilTudo(int IDPERFIL);

	
	@Query(value = " SELECT A.* FROM sec_usuarios A, sec_usuarios_perfis B WHERE B.IDUSUARIO = A.IDUSUARIO AND B.IDPERFIL = 2 AND A.IDUSUARIO NOT IN (SELECT IDUSUARIO FROM bingo_clientes) ",nativeQuery=true)
	List<SecUsuarios> ListarUsuariosPerfilCliente();

	@Query(value = " SELECT A.* FROM sec_usuarios A, sec_usuarios_perfis B WHERE B.IDUSUARIO = A.IDUSUARIO AND B.IDPERFIL = 3 AND A.IDUSUARIO NOT IN (SELECT IDUSUARIO FROM bingo_unidades) ",nativeQuery=true)
	List<SecUsuarios> ListarUsuariosPerfilUnidade();
	

}

