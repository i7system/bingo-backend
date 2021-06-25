package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "port_templates_paginas")
public class PortTemplatesPaginas {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPAGINA", nullable = false)
	private int IDPAGINA;	
    @Column(name = "IDTEMPLATE",nullable = false)
    private int IDTEMPLATE;
	@Column(name = "NOME", length = 50,nullable = false)
	private String NOME;
	@Column(name = "IMAGEM", length = 250,nullable = false)
	private String IMAGEM; 
	@Column(name = "URL", length = 250,nullable = false)
	private String URL;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	public int getIDPAGINA() {
		return IDPAGINA;
	}
	public void setIDPAGINA(int iDPAGINA) {
		IDPAGINA = iDPAGINA;
	}
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
	public String getIMAGEM() {
		return IMAGEM;
	}
	public void setIMAGEM(String iMAGEM) {
		IMAGEM = iMAGEM;
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
