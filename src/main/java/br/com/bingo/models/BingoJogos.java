package br.com.bingo.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bingo_jogos")
public class BingoJogos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDJOGO", nullable = false)	
	private int IDJOGO;
	@Column(name = "IDSORTEIO", nullable = false)	
	private int IDSORTEIO; 
	@Column(name = "DOACAO", columnDefinition = "DECIMAL(18,5) DEFAULT 0.0", nullable = false)	
	private double DOACAO; 
	@Column(name = "CODIGO", length = 50, nullable = false)	
	private String CODIGO;
	@Column(name = "DATA_HORA", nullable = false)	
	private Timestamp DATA_HORA;
	@Column(name = "VALIDACAO", nullable = false)	
	private int VALIDACAO;
	@Column(name = "TOKEN", length = 50, nullable = false)	
	private String TOKEN;
	@Column(name = "NUMEROS", length = 50, nullable = false)	
	private String NUMEROS;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	public int getIDJOGO() {
		return IDJOGO;
	}
	public void setIDJOGO(int iDJOGO) {
		IDJOGO = iDJOGO;
	}
	public int getIDSORTEIO() {
		return IDSORTEIO;
	}
	public void setIDSORTEIO(int iDSORTEIO) {
		IDSORTEIO = iDSORTEIO;
	}
	public double getDOACAO() {
		return DOACAO;
	}
	public void setDOACAO(double dOACAO) {
		DOACAO = dOACAO;
	}
	public String getCODIGO() {
		return CODIGO;
	}
	public void setCODIGO(String cODIGO) {
		CODIGO = cODIGO;
	}
	public Timestamp getDATA_HORA() {
		return DATA_HORA;
	}
	public void setDATA_HORA(Timestamp dATA_HORA) {
		DATA_HORA = dATA_HORA;
	}
	public int getVALIDACAO() {
		return VALIDACAO;
	}
	public void setVALIDACAO(int vALIDACAO) {
		VALIDACAO = vALIDACAO;
	}
	public String getTOKEN() {
		return TOKEN;
	}
	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}
	public String getNUMEROS() {
		return NUMEROS;
	}
	public void setNUMEROS(String nUMEROS) {
		NUMEROS = nUMEROS;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
	