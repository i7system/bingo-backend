
package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_listas")
public class PortListas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLISTA", nullable = false)
	private int IDLISTA;
	@Column(name = "IDGRUPO", nullable = false)
	private int IDGRUPO;
	@Column(name = "IDTABELA", nullable = false)
	private int IDTABELA;
	@Column(name = "NOME_LISTA", length = 50, nullable = false)
	private String NOME_LISTA;
	@Column(name = "TITULO_LISTA", length = 250, nullable = false)
	private String TITULO_LISTA;
	@Column(name = "ICONE", length = 250, nullable = false)
	private String ICONE;
	@Column(name = "COMANDO_SELECT", length = 2000, nullable = false)
	private String COMANDO_SELECT;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDLISTA() {
		return IDLISTA;
	}

	public void setIDLISTA(int iDLISTA) {
		IDLISTA = iDLISTA;
	}

	public int getIDGRUPO() {
		return IDGRUPO;
	}

	public void setIDGRUPO(int iDGRUPO) {
		IDGRUPO = iDGRUPO;
	}

	public int getIDTABELA() {
		return IDTABELA;
	}

	public void setIDTABELA(int iDTABELA) {
		IDTABELA = iDTABELA;
	}

	public String getNOME_LISTA() {
		return NOME_LISTA;
	}

	public void setNOME_LISTA(String nOME_LISTA) {
		NOME_LISTA = nOME_LISTA;
	}

	public String getTITULO_LISTA() {
		return TITULO_LISTA;
	}

	public void setTITULO_LISTA(String tITULO_LISTA) {
		TITULO_LISTA = tITULO_LISTA;
	}

	public String getICONE() {
		return ICONE;
	}

	public void setICONE(String iCONE) {
		ICONE = iCONE;
	}

	public String getCOMANDO_SELECT() {
		return COMANDO_SELECT;
	}

	public void setCOMANDO_SELECT(String cOMANDO_SELECT) {
		COMANDO_SELECT = cOMANDO_SELECT;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
