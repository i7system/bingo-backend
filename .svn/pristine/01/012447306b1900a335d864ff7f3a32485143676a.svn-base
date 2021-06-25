
package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_tecnologias")
public class PortTecnologias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTECNOLOGIA", nullable = false)
	private int IDTECNOLOGIA;
	@Column(name = "IDGRUPO", nullable = false)
	private int IDGRUPO;
	@Column(name = "NOME_TECNOLOGIA", length = 50, nullable = false)
	private String NOME_TECNOLOGIA;;
	@Column(name = "ICONE", length = 50, nullable = false)
	private String ICONE;
	@Column(name = "DESCRICAO_CURTA", length = 1000, nullable = false)
	private String DESCRICAO_CURTA;
	@Column(name = "DESCRICAO_LONGA", length = 5000, nullable = false)
	private String DESCRICAO_LONGA;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	
	public int getIDTECNOLOGIA() {
		return IDTECNOLOGIA;
	}
	public void setIDTECNOLOGIA(int iDTECNOLOGIA) {
		IDTECNOLOGIA = iDTECNOLOGIA;
	}
	public int getIDGRUPO() {
		return IDGRUPO;
	}
	public void setIDGRUPO(int iDGRUPO) {
		IDGRUPO = iDGRUPO;
	}
	public String getNOME_TECNOLOGIA() {
		return NOME_TECNOLOGIA;
	}
	public void setNOME_TECNOLOGIA(String nOME_TECNOLOGIA) {
		NOME_TECNOLOGIA = nOME_TECNOLOGIA;
	}
	public String getICONE() {
		return ICONE;
	}
	public void setICONE(String iCONE) {
		ICONE = iCONE;
	}
	public String getDESCRICAO_CURTA() {
		return DESCRICAO_CURTA;
	}
	public void setDESCRICAO_CURTA(String dESCRICAO_CURTA) {
		DESCRICAO_CURTA = dESCRICAO_CURTA;
	}
	public String getDESCRICAO_LONGA() {
		return DESCRICAO_LONGA;
	}
	public void setDESCRICAO_LONGA(String dESCRICAO_LONGA) {
		DESCRICAO_LONGA = dESCRICAO_LONGA;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
}
