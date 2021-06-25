package br.com.bingo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bingo.models.BingoClientes;
import br.com.bingo.models.SecEmpresas;

public interface bingo_clientesRepository extends JpaRepository<BingoClientes,Integer>{
	
	BingoClientes findByIDCLIENTE(int IDCLIENTE);
	
	@Query(value=" SELECT A.IDCLIENTE,A.NOMECLIENTE,A.DDD,A.TELEFONE,A.CEP,A.IDUF,B.SIGLA,A.IDCIDADE,C.NOME,A.BAIRRO,A.ENDERECO,A.NUMERO,A.COMPLEMENTO,A.IDUSUARIO, D.EMAIL,D.DESCSENHA AS SENHA,D.LOGINUSUARIO " + 
			" FROM  bingo_clientes A, sec_ufs B, sec_cidades C, sec_usuarios D " + 
			" WHERE B.IDUF = A.IDUF AND C.IDCIDADE = A.IDCIDADE AND D.IDUSUARIO = A.IDUSUARIO AND A.IDCLIENTE = ?1 ",nativeQuery=true)
	List BuscarCliente(int IDCLIENTE);
	
	@Query(value = " SELECT u FROM BingoClientes u WHERE u.IDUSUARIO=?1 ")
	BingoClientes BuscarClienteIDUSUARIO(int IDUSUARIO);
	
	@Query(value = " SELECT COUNT(*) FROM bingo_clientes WHERE IDUSUARIO = ?1 ", nativeQuery=true)
	int QtdeCliente(int IDUSUARIO);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bingo_clientes where IDUSUARIO =:IDUSUARIO", nativeQuery = true)
	void DeletarBingoClientePorIDUSUARIO(@Param("IDUSUARIO") int IDUSUARIO);



}

