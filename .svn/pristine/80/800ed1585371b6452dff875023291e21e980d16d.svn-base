package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "port_portais")
public class PortPortais {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int IDPORTAL;
	@Column(name = "NOME", length = 50, nullable = false)
	private String NOME;
	@Column(name = "REDUZIDO", length = 30, nullable = false)
	private String REDUZIDO;
	@Column(name = "DESCRICAO", length = 2000, nullable = false)
	private String DESCRICAO;
	@Column(name = "IMAGEM", length = 250, nullable = false)
	private String IMAGEM;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	public int getIDPORTAL() {
		return IDPORTAL;
	}
	public void setIDPORTAL(int iDPORTAL) {
		IDPORTAL = iDPORTAL;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public String getREDUZIDO() {
		return REDUZIDO;
	}
	public void setREDUZIDO(String rEDUZIDO) {
		REDUZIDO = rEDUZIDO;
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
