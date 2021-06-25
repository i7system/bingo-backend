 

package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_grupos")
public class PortGrupos {
	

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDGRUPO", nullable = false)	
	private int IDGRUPO;
	@Column(name = "SIGLA_GRUPO", length = 20, nullable = false)	
	private String SIGLA_GRUPO;
	@Column(name = "NOME_GRUPO", length = 50, nullable = false)	
	private String NOME_GRUPO;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	public int getIDGRUPO() {
		return IDGRUPO;
	}
	public void setIDGRUPO(int iDGRUPO) {
		IDGRUPO = iDGRUPO;
	}
	public String getSIGLA_GRUPO() {
		return SIGLA_GRUPO;
	}
	public void setSIGLA_GRUPO(String sIGLA_GRUPO) {
		SIGLA_GRUPO = sIGLA_GRUPO;
	}
	public String getNOME_GRUPO() {
		return NOME_GRUPO;
	}
	public void setNOME_GRUPO(String nOME_GRUPO) {
		NOME_GRUPO = nOME_GRUPO;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
	

	
	
}
	

