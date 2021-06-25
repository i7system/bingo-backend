package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_tipos_colunas")
public class TabTiposColunas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTIPOCOLUNA", nullable = false)
	private int IDTIPOCOLUNA;
	@Column(name = "NOME_TIPO_COLUNA", length = 50, nullable = false)
	private String NOME_TIPO_COLUNA;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDTIPOCOLUNA() {
		return IDTIPOCOLUNA;
	}

	public void setIDTIPOCOLUNA(int iDTIPOCOLUNA) {
		IDTIPOCOLUNA = iDTIPOCOLUNA;
	}

	public String getNOME_TIPO_COLUNA() {
		return NOME_TIPO_COLUNA;
	}

	public void setNOME_TIPO_COLUNA(String nOME_TIPO_COLUNA) {
		NOME_TIPO_COLUNA = nOME_TIPO_COLUNA;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
