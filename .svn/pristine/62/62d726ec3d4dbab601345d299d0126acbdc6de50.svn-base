package br.com.bingo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sec_empresas")
public class SecEmpresas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDEMPRESA", nullable = true)
	private int IDEMPRESA;
	@Column(name = "NOMEEMPRESA", length = 50,nullable = true)	
	private String NOMEEMPRESA; 
	@Column(name = "EMAIL", length = 250,nullable = true)	
	private String EMAIL; 
	@Column(name = "APELIDO", length = 50,nullable = true)	
	private String APELIDO; 
	@Column(name = "LOGO", length = 250,nullable = true)	
	private String LOGO; 
	@Column(name = "CODIGOVALIDACAO", length = 6 ,nullable = true)	
	private String CODIGOVALIDACAO; 
	@Column(name = "TOKEN", length = 250,nullable = true)	
	private String TOKEN; 
	@Column(name = "TELEFONE", length = 30,nullable = true)	
	private String TELEFONE; 
	@Column(name = "STATUS", nullable = true)	
	private int STATUS;
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getNOMEEMPRESA() {
		return NOMEEMPRESA;
	}
	public void setNOMEEMPRESA(String nOMEEMPRESA) {
		NOMEEMPRESA = nOMEEMPRESA;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getAPELIDO() {
		return APELIDO;
	}
	public void setAPELIDO(String aPELIDO) {
		APELIDO = aPELIDO;
	}
	public String getLOGO() {
		return LOGO;
	}
	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}
	public String getCODIGOVALIDACAO() {
		return CODIGOVALIDACAO;
	}
	public void setCODIGOVALIDACAO(String cODIGOVALIDACAO) {
		CODIGOVALIDACAO = cODIGOVALIDACAO;
	}
	public String getTOKEN() {
		return TOKEN;
	}
	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}
	public String getTELEFONE() {
		return TELEFONE;
	}
	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}


}

