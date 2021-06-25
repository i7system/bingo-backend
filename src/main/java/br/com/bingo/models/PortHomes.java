 

package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_homes")
public class PortHomes {
	

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDHOME", nullable = false)	
	private int IDHOME;
	@Column(name = "IDGRUPO", nullable = false)
	private int IDGRUPO;
	@Column(name = "LOGO", length = 250, nullable = false)	
	private String LOGO;
	@Column(name = "NOMEHOME", length = 50, nullable = false)	
	private String NOMEHOME;
	@Column(name = "TITULOHOME", length = 250, nullable = false)	
	private String TITULOHOME;
	@Column(name = "ICONE", length = 250, nullable = false)	
	private String ICONE;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	public int getIDHOME() {
		return IDHOME;
	}
	public void setIDHOME(int iDHOME) {
		IDHOME = iDHOME;
	}
	public int getIDGRUPO() {
		return IDGRUPO;
	}
	public void setIDGRUPO(int iDGRUPO) {
		IDGRUPO = iDGRUPO;
	}
	public String getLOGO() {
		return LOGO;
	}
	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}
	public String getNOMEHOME() {
		return NOMEHOME;
	}
	public void setNOMEHOME(String nOMEHOME) {
		NOMEHOME = nOMEHOME;
	}
	public String getTITULOHOME() {
		return TITULOHOME;
	}
	public void setTITULOHOME(String tITULOHOME) {
		TITULOHOME = tITULOHOME;
	}
	public String getICONE() {
		return ICONE;
	}
	public void setICONE(String iCONE) {
		ICONE = iCONE;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
	

	
	
}
	

