package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "sec_idiomas")
public class SecIdiomas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDIDIOMA", nullable = false)
	private int IDIDIOMA;
	@Column(name = "NOMEIDIOMA", length = 50,nullable = false)	
	private String NOMEIDIOMA; 
	@Column(name = "FOTO", nullable = false)	
	private String FOTO; 
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	public String getFOTO() {
		return FOTO;
	}
	public void setFOTO(String fOTO) {
		FOTO = fOTO;
	}
	public int getIDIDIOMA() {
		return IDIDIOMA;
	}
	public void setIDIDIOMA(int iDIDIOMA) {
		IDIDIOMA = iDIDIOMA;
	}
	public String getNOMEIDIOMA() {
		return NOMEIDIOMA;
	}
	public void setNOMEIDIOMA(String nOMEIDIOMA) {
		NOMEIDIOMA = nOMEIDIOMA;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
}
