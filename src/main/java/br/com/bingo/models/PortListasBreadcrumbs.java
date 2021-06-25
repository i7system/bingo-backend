
package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_listas_breadcrumbs")
public class PortListasBreadcrumbs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLISTABREADCRUMB", nullable = false)
	private int IDLISTABREADCRUMB;
	@Column(name = "IDLISTA", nullable = false)
	private int IDLISTA;
	@Column(name = "IDACAO", nullable = false)
	private int IDACAO;
	@Column(name = "URL", length = 250, nullable = false)
	private String URL;
	@Column(name = "NOMEBREADCUMB", length = 50, nullable = false)
	private String NOMEBREADCUMB;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDLISTABREADCRUMB() {
		return IDLISTABREADCRUMB;
	}

	public void setIDLISTABREADCRUMB(int iDLISTABREADCRUMB) {
		IDLISTABREADCRUMB = iDLISTABREADCRUMB;
	}

	public int getIDLISTA() {
		return IDLISTA;
	}

	public void setIDLISTA(int iDLISTA) {
		IDLISTA = iDLISTA;
	}

	public int getIDACAO() {
		return IDACAO;
	}

	public void setIDACAO(int iDACAO) {
		IDACAO = iDACAO;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getNOMEBREADCUMB() {
		return NOMEBREADCUMB;
	}

	public void setNOMEBREADCUMB(String nOMEBREADCUMB) {
		NOMEBREADCUMB = nOMEBREADCUMB;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
