 

package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_homes_itens")
public class PortHomesItens {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDITEM", nullable = false)	
	private int IDITEM;
	@Column(name = "NOMEITEM", length = 250, nullable = false)	
	private String NOMEITEM;
	@Column(name = "LOGO", length = 250, nullable = false)	
	private String LOGO;
	@Column(name = "URL", length = 250, nullable = false)	
	private String URL;
	@Column(name = "IDHOME", nullable = false)	
	private int IDHOME;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	public int getIDITEM() {
		return IDITEM;
	}
	public void setIDITEM(int iDITEM) {
		IDITEM = iDITEM;
	}
	public String getNOMEITEM() {
		return NOMEITEM;
	}
	public void setNOMEITEM(String nOMEITEM) {
		NOMEITEM = nOMEITEM;
	}
	public String getLOGO() {
		return LOGO;
	}
	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
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
	

