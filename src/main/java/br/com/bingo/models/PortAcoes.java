package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_acoes")
public class PortAcoes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int IDACAO;
	@Column(name = "NOME", length = 50, nullable = false)	
	private String NOME;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;

	public int getIDACAO() {
		return IDACAO;
	}

	public void setIDACAO(int iDACAO) {
		IDACAO = iDACAO;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
	