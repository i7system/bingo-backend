package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bingo_unidades")
public class BingoUnidades {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUNIDADE", nullable = true)
	private int IDUNIDADE;
	@Column(name = "IDUSUARIO",nullable = true)	
	private int IDUSUARIO; 
	@Column(name = "IDCLIENTE",nullable = true)	
	private int IDCLIENTE; 
	@Column(name = "DDD",nullable = true)	
	private int DDD; 
	@Column(name = "TELEFONE", nullable = true)	
	private String TELEFONE; 
	@Column(name = "NOMEESTABELECIMENTO", nullable = true)	
	private String NOMEESTABELECIMENTO; 
	@Column(name = "CEP", nullable = true)	
	private String CEP;
	@Column(name = "IDUF", nullable = true)	
	private int IDUF; 
	@Column(name = "IDCIDADE", nullable = true)	
	private int IDCIDADE; 
	@Column(name = "BAIRRO", nullable = true)	
	private String BAIRRO;
	@Column(name = "RUA", nullable = true)	
	private String RUA;
	@Column(name = "NUMERO", nullable = true)	
	private String NUMERO;
	@Column(name = "COMPLEMENTO", nullable = true)	
	private String COMPLEMENTO;
	@Column(name = "STATUS", nullable = true)	
	private int STATUS;
	
	
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
	public int getIDUNIDADE() {
		return IDUNIDADE;
	}
	public void setIDUNIDADE(int iDUNIDADE) {
		IDUNIDADE = iDUNIDADE;
	}
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public int getIDCLIENTE() {
		return IDCLIENTE;
	}
	public void setIDCLIENTE(int iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}
	public String getNOMEESTABELECIMENTO() {
		return NOMEESTABELECIMENTO;
	}
	public void setNOMEESTABELECIMENTO(String nOMEESTABELECIMENTO) {
		NOMEESTABELECIMENTO = nOMEESTABELECIMENTO;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
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
	public String getBAIRRO() {
		return BAIRRO;
	}
	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}
	public String getRUA() {
		return RUA;
	}
	public void setRUA(String rUA) {
		RUA = rUA;
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
