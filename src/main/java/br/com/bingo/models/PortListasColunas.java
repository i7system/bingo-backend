
package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_listas_colunas")
public class PortListasColunas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDLISTACOLUNA", nullable = false)
	private int IDLISTACOLUNA;
	@Column(name = "IDCOLUNA", nullable = false)
	private int IDCOLUNA;
	@Column(name = "IDLISTA", nullable = false)
	private int IDLISTA;
	@Column(name = "NOME_LISTA_COLUNA", length = 50, nullable = false)
	private String NOME_LISTA_COLUNA;
	@Column(name = "LARGURA", nullable = false)
	private int LARGURA;
	@Column(name = "ORDEM", nullable = false)
	private int ORDEM;
	@Column(name = "ALINHAMENTO", length = 20, nullable = false)
	private String ALINHAMENTO;
	@Column(name = "LISTA", length = 200, nullable = false)
	private String LISTA;
	@Column(name = "CLASSNAME", length = 250, nullable = false)
	private String CLASSNAME;
	@Column(name = "SORTABLE", length = 1, nullable = false)
	private String SORTABLE;
	@Column(name = "ORDENADO", nullable = false)
	private int ORDENADO;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	
	public int getORDENADO() {
		return ORDENADO;
	}
	public void setORDENADO(int oRDENADO) {
		ORDENADO = oRDENADO;
	}
	public int getIDLISTACOLUNA() {
		return IDLISTACOLUNA;
	}
	public void setIDLISTACOLUNA(int iDLISTACOLUNA) {
		IDLISTACOLUNA = iDLISTACOLUNA;
	}
	public int getIDCOLUNA() {
		return IDCOLUNA;
	}
	public void setIDCOLUNA(int iDCOLUNA) {
		IDCOLUNA = iDCOLUNA;
	}
	public int getIDLISTA() {
		return IDLISTA;
	}
	public void setIDLISTA(int iDLISTA) {
		IDLISTA = iDLISTA;
	}
	public String getNOME_LISTA_COLUNA() {
		return NOME_LISTA_COLUNA;
	}
	public void setNOME_LISTA_COLUNA(String nOME_LISTA_COLUNA) {
		NOME_LISTA_COLUNA = nOME_LISTA_COLUNA;
	}
	public int getLARGURA() {
		return LARGURA;
	}
	public void setLARGURA(int lARGURA) {
		LARGURA = lARGURA;
	}
	public int getORDEM() {
		return ORDEM;
	}
	public void setORDEM(int oRDEM) {
		ORDEM = oRDEM;
	}
	public String getALINHAMENTO() {
		return ALINHAMENTO;
	}
	public void setALINHAMENTO(String aLINHAMENTO) {
		ALINHAMENTO = aLINHAMENTO;
	}
	public String getLISTA() {
		return LISTA;
	}
	public void setLISTA(String lISTA) {
		LISTA = lISTA;
	}
	public String getCLASSNAME() {
		return CLASSNAME;
	}
	public void setCLASSNAME(String cLASSNAME) {
		CLASSNAME = cLASSNAME;
	}
	public String getSORTABLE() {
		return SORTABLE;
	}
	public void setSORTABLE(String sORTABLE) {
		SORTABLE = sORTABLE;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	


}
