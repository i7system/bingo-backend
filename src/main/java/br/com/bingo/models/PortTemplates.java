package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_templates")
public class PortTemplates {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTEMPLATE", nullable = false)
	private int IDTEMPLATE; 
	@Column(name = "NOME", length = 50,nullable = false)
	private String NOME;
	@Column(name = "DESCRICAO", length = 2000,nullable = false)
	private String DESCRICAO;
	@Column(name = "IMAGEM", length = 250,nullable = false)
	private String IMAGEM; 
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	
	
	public int getIDTEMPLATE() {
		return IDTEMPLATE;
	}
	public void setIDTEMPLATE(int iDTEMPLATE) {
		IDTEMPLATE = iDTEMPLATE;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public String getDESCRICAO() {
		return DESCRICAO;
	}
	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}
	public String getIMAGEM() {
		return IMAGEM;
	}
	public void setIMAGEM(String iMAGEM) {
		IMAGEM = iMAGEM;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
		
}
