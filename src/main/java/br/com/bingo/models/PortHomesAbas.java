
package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_homes_abas")
public class PortHomesAbas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDABA", nullable = false)
	private int IDABA;
	@Column(name = "IDACAO", nullable = false)
	private int IDACAO;
	@Column(name = "IDHOME", nullable = false)
	private int IDHOME;
	@Column(name = "NOME", length = 50, nullable = false)
	private String NOME;
	@Column(name = "ESTILO", length = 250, nullable = false)
	private String ESTILO;
	@Column(name = "URL", length = 250, nullable = false)
	private String URL;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDABA() {
		return IDABA;
	}

	public void setIDABA(int iDABA) {
		IDABA = iDABA;
	}

	public int getIDACAO() {
		return IDACAO;
	}

	public void setIDACAO(int iDACAO) {
		IDACAO = iDACAO;
	}

	public int getIDHOME() {
		return IDHOME;
	}

	public void setIDHOME(int iDHOME) {
		IDHOME = iDHOME;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getESTILO() {
		return ESTILO;
	}

	public void setESTILO(String eSTILO) {
		ESTILO = eSTILO;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
