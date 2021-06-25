package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_listas_botoes")
public class PortListasBotoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDBOTAO", nullable = false)
	private int IDBOTAO;
	@Column(name = "IDLISTA", nullable = false)
	private int IDLISTA;
	@Column(name = "TEXTO_BOTAO", nullable = false)
	private String TEXTO_BOTAO;
	@Column(name = "ORDEM_BOTAO", nullable = false)
	private int ORDEM_BOTAO;
	@Column(name = "LINK_BOTAO", nullable = false)
	private String LINK_BOTAO;
	@Column(name = "COR_BOTAO", nullable = false)
	private String COR_BOTAO;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDBOTAO() {
		return IDBOTAO;
	}

	public void setIDBOTAO(int iDBOTAO) {
		IDBOTAO = iDBOTAO;
	}

	public int getIDLISTA() {
		return IDLISTA;
	}

	public void setIDLISTA(int iDLISTA) {
		IDLISTA = iDLISTA;
	}

	public String getTEXTO_BOTAO() {
		return TEXTO_BOTAO;
	}

	public void setTEXTO_BOTAO(String tEXTO_BOTAO) {
		TEXTO_BOTAO = tEXTO_BOTAO;
	}

	public int getORDEM_BOTAO() {
		return ORDEM_BOTAO;
	}

	public void setORDEM_BOTAO(int oRDEM_BOTAO) {
		ORDEM_BOTAO = oRDEM_BOTAO;
	}

	public String getLINK_BOTAO() {
		return LINK_BOTAO;
	}

	public void setLINK_BOTAO(String lINK_BOTAO) {
		LINK_BOTAO = lINK_BOTAO;
	}

	public String getCOR_BOTAO() {
		return COR_BOTAO;
	}

	public void setCOR_BOTAO(String cOR_BOTAO) {
		COR_BOTAO = cOR_BOTAO;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
