package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_paises")
public class SecPaises {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPAIS", nullable = false)	
	private int IDPAIS;
	@Column(name = "NOME_PAIS", length = 50,nullable = false)
	private String NOME_PAIS;
	@Column(name = "IMAGEM", length = 250,nullable = false)
	private String IMAGEM;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	
	public int getIDPAIS() {
		return IDPAIS;
	}
	public void setIDPAIS(int iDPAIS) {
		IDPAIS = iDPAIS;
	}
	public String getNOME_PAIS() {
		return NOME_PAIS;
	}
	public void setNOME_PAIS(String nOME_PAIS) {
		NOME_PAIS = nOME_PAIS;
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
