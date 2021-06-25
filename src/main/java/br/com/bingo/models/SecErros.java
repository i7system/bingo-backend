package br.com.bingo.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_erros")
public class SecErros {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDERRO", nullable = false)
	private int IDERRO;	
	@Column(name = "ERRO", nullable = false)
	private String ERRO;
	@Column(name = "REQUEST", nullable = false)
	private String REQUEST;
	@Column(name = "IDUSUARIO", nullable = false)
	private int IDUSUARIO;
	@Column(name = "IDEMPRESA", nullable = false)
	private int IDEMPRESA;
	@Column(name = "PACOTE", nullable = false)
	private String PACOTE;
	@Column(name = "CLASSE", nullable = false)
	private String CLASSE;
	@Column(name = "METODO", nullable = false)
	private String METODO;
	@Column(name = "DATAHORA", nullable = false)
	private Timestamp DATAHORA;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	public int getIDERRO() {
		return IDERRO;
	}
	public void setIDERRO(int iDERRO) {
		IDERRO = iDERRO;
	}
	public String getERRO() {
		return ERRO;
	}
	public void setERRO(String eRRO) {
		ERRO = eRRO;
	}
	public String getREQUEST() {
		return REQUEST;
	}
	public void setREQUEST(String rEQUEST) {
		REQUEST = rEQUEST;
	}
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getPACOTE() {
		return PACOTE;
	}
	public void setPACOTE(String pACOTE) {
		PACOTE = pACOTE;
	}
	public String getCLASSE() {
		return CLASSE;
	}
	public void setCLASSE(String cLASSE) {
		CLASSE = cLASSE;
	}
	public String getMETODO() {
		return METODO;
	}
	public void setMETODO(String mETODO) {
		METODO = mETODO;
	}
	public Timestamp getDATAHORA() {
		return DATAHORA;
	}
	public void setDATAHORA(Timestamp dATAHORA) {
		DATAHORA = dATAHORA;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	

}
