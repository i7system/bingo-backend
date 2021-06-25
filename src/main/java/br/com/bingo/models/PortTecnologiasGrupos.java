
package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_tecnologias_grupos")
public class PortTecnologiasGrupos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDGRUPO", nullable = false)
	private int IDGRUPO;
	@Column(name = "NOME_GRUPO", length = 50, nullable = false)
	private String NOME_GRUPO;;
	@Column(name = "ICONE", length = 50, nullable = false)
	private String ICONE;
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String DESCRICAO;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	public int getIDGRUPO() {
		return IDGRUPO;
	}
	public void setIDGRUPO(int iDGRUPO) {
		IDGRUPO = iDGRUPO;
	}
	public String getNOME_GRUPO() {
		return NOME_GRUPO;
	}
	public void setNOME_GRUPO(String nOME_GRUPO) {
		NOME_GRUPO = nOME_GRUPO;
	}
	public String getICONE() {
		return ICONE;
	}
	public void setICONE(String iCONE) {
		ICONE = iCONE;
	}
	public String getDESCRICAO() {
		return DESCRICAO;
	}
	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	
}
