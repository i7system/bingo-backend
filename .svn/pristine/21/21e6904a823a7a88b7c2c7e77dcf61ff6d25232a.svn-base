package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sec_imagens")
public class SecImagens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDIMAGEM", nullable = false)
	private int IDIMAGEM;
	@Column(name = "NOME", length = 250,nullable = false)	
	private String NOME; 
	@Column(name = "IMAGEM", length = 250,nullable = false)	
	private String IMAGEM; 
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	public int getIDIMAGEM() {
		return IDIMAGEM;
	}
	public void setIDIMAGEM(int iDIMAGEM) {
		IDIMAGEM = iDIMAGEM;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
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
