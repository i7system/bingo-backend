package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_tabelas")
public class TabTabelas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTABELA", nullable = false)
	private int IDTABELA;
	@Column(name = "NOME_TABELA", length = 50, nullable = false)
	private String NOME_TABELA;
	@Column(name = "IDGRUPO", nullable = false)
	private int IDGRUPO;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDTABELA() {
		return IDTABELA;
	}

	public void setIDTABELA(int iDTABELA) {
		IDTABELA = iDTABELA;
	}

	public String getNOME_TABELA() {
		return NOME_TABELA;
	}

	public void setNOME_TABELA(String nOME_TABELA) {
		NOME_TABELA = nOME_TABELA;
	}

	public int getIDGRUPO() {
		return IDGRUPO;
	}

	public void setIDGRUPO(int iDGRUPO) {
		IDGRUPO = iDGRUPO;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
