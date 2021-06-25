

package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_homes_breadcrumbs")
public class PortHomesBreadcrumbs {
	


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDBREADCRUMB", nullable = false)	
	private int IDBREADCRUMB;
	@Column(name = "IDACAO", nullable = false)	
	private int IDACAO;
	@Column(name = "NOMEBREADCUMB", length = 250, nullable = false)	
	private String NOMEBREADCUMB;
	@Column(name = "URL", length = 250, nullable = false)	
	private String URL;
	@Column(name = "IDHOME", nullable = false)	
	private int IDHOME;	
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	public int getIDBREADCRUMB() {
		return IDBREADCRUMB;
	}
	public void setIDBREADCRUMB(int iDBREADCRUMB) {
		IDBREADCRUMB = iDBREADCRUMB;
	}
	public String getNOMEBREADCUMB() {
		return NOMEBREADCUMB;
	}
	public void setNOMEBREADCUMB(String nOMEBREADCUMB) {
		NOMEBREADCUMB = nOMEBREADCUMB;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
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
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	
}