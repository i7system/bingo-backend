package br.com.bingo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bingo.models.BingoUnidades;


public interface bingo_unidadesRepository extends JpaRepository<BingoUnidades,Integer>{
	
	BingoUnidades findByIDUNIDADE(int IDUNIDADE);
	
	@Query(value=" SELECT A.IDUNIDADE,A.IDUSUARIO,B.NOMEUSUARIO,A.NOMEESTABELECIMENTO,A.IDCLIENTE, C.NOMECLIENTE, A.RUA,A.NUMERO,A.COMPLEMENTO,A.BAIRRO,A.IDUF,D.SIGLA, " + 
			" A.IDCIDADE,E.NOME AS NOMECIDADE,A.DDD,A.TELEFONE,A.STATUS " + 
			" FROM bingo_unidades A, sec_usuarios B, bingo_clientes C, sec_ufs D, sec_cidades E " + 
			" WHERE B.IDUSUARIO = A.IDUSUARIO AND C.IDCLIENTE = A.IDCLIENTE AND D.IDUF = A.IDUF AND E.IDCIDADE = A.IDCIDADE ",nativeQuery=true)
	List ListarTodasUnidades();
	
	@Query(value=" SELECT A.IDUNIDADE,A.IDUSUARIO,B.NOMEUSUARIO,A.NOMEESTABELECIMENTO,A.IDCLIENTE, C.NOMECLIENTE, A.RUA,A.NUMERO,A.COMPLEMENTO,A.BAIRRO,A.IDUF,D.SIGLA, " + 
			" A.IDCIDADE,E.NOME AS NOMECIDADE,A.DDD,A.TELEFONE,A.STATUS " + 
			" FROM bingo_unidades A, sec_usuarios B, bingo_clientes C, sec_ufs D, sec_cidades E " + 
			" WHERE B.IDUSUARIO = A.IDUSUARIO AND C.IDCLIENTE = A.IDCLIENTE AND D.IDUF = A.IDUF AND E.IDCIDADE = A.IDCIDADE AND A.IDCLIENTE=?1 ",nativeQuery=true)
	List ListarUnidadesIDCLIENTE(int IDCLIENTE);
	
	@Query(value = "SELECT u FROM BingoUnidades u WHERE u.IDCLIENTE = ?1")
	List<BingoUnidades> BingoUnidadesIDCLIENTE(int IDCLIENTE);

	
	@Query(value=" SELECT A.IDUNIDADE,A.IDUSUARIO,B.NOMEUSUARIO,A.NOMEESTABELECIMENTO,A.IDCLIENTE, C.NOMECLIENTE, A.RUA,A.NUMERO,A.COMPLEMENTO,A.BAIRRO,A.IDUF,D.SIGLA,  " + 
			" A.IDCIDADE,E.NOME AS NOMECIDADE,A.DDD,A.TELEFONE,A.STATUS,A.CEP, B.EMAIL,B.DESCSENHA,B.LOGINUSUARIO " + 
			" FROM bingo_unidades A, sec_usuarios B, bingo_clientes C, sec_ufs D, sec_cidades E " + 
			" WHERE B.IDUSUARIO = A.IDUSUARIO AND C.IDCLIENTE = A.IDCLIENTE AND D.IDUF = A.IDUF AND E.IDCIDADE = A.IDCIDADE AND A.IDUNIDADE=?1 ",nativeQuery=true)
	List BuscarUnidade(int IDUNIDADE);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bingo_unidades  where IDCLIENTE =:IDCLIENTE", nativeQuery = true)
	void DeletarUnidadesIDCLIENTE(@Param("IDCLIENTE") int IDCLIENTE);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bingo_unidades where IDUSUARIO =:IDUSUARIO", nativeQuery = true)
	void DeletarBingoUnidadesPorIDUSUARIO(@Param("IDUSUARIO") int IDUSUARIO);



}

