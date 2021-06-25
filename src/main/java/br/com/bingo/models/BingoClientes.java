package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bingo_clientes")
public class BingoClientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCLIENTE", nullable = true)
	private int IDCLIENTE;
	@Column(name = "IDUSUARIO",nullable = true)	
	private int IDUSUARIO; 
	@Column(name = "IDUF", nullable = true)	
	private int IDUF; 
	@Column(name = "IDCIDADE", nullable = true)	
	private int IDCIDADE; 
	@Column(name = "NOMECLIENTE", length = 50,nullable = true)	
	private String NOMECLIENTE; 
	@Column(name = "DDD",nullable = true)	
	private int DDD; 
	@Column(name = "TELEFONE", length = 30 ,nullable = true)	
	private String TELEFONE; 
	@Column(name = "ENDERECO", length = 250 ,nullable = true)	
	private String ENDERECO; 
	@Column(name = "CEP", nullable = true)	
	private String CEP;
	@Column(name = "BAIRRO", nullable = true)	
	private String BAIRRO;
	@Column(name = "NUMERO", nullable = true)	
	private String NUMERO;
	@Column(name = "COMPLEMENTO", nullable = true)	
	private String COMPLEMENTO;
	@Column(name = "STATUS", nullable = true)	
	private int STATUS;
	public int getIDCLIENTE() {
		return IDCLIENTE;
	}
	public void setIDCLIENTE(int iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public int getIDUF() {
		return IDUF;
	}
	public void setIDUF(int iDUF) {
		IDUF = iDUF;
	}
	public int getIDCIDADE() {
		return IDCIDADE;
	}
	public void setIDCIDADE(int iDCIDADE) {
		IDCIDADE = iDCIDADE;
	}
	public String getNOMECLIENTE() {
		return NOMECLIENTE;
	}
	public void setNOMECLIENTE(String nOMECLIENTE) {
		NOMECLIENTE = nOMECLIENTE;
	}
	public int getDDD() {
		return DDD;
	}
	public void setDDD(int dDD) {
		DDD = dDD;
	}
	public String getTELEFONE() {
		return TELEFONE;
	}
	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}
	public String getENDERECO() {
		return ENDERECO;
	}
	public void setENDERECO(String eNDERECO) {
		ENDERECO = eNDERECO;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getBAIRRO() {
		return BAIRRO;
	}
	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}
	public String getNUMERO() {
		return NUMERO;
	}
	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}
	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}
	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}


	

}
