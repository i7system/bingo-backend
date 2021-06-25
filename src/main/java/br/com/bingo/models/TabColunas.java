package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_colunas")
public class TabColunas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOLUNA", nullable = false)
	private int IDCOLUNA;
	@Column(name = "IDTABELA", nullable = false)
	private int IDTABELA;
	@Column(name = "IDTIPOCOLUNA", nullable = false)
	private int IDTIPOCOLUNA;
	@Column(name = "NOME_COLUNA", length = 50, nullable = false)
	private String NOME_COLUNA;
	@Column(name = "PRIMARY_KEY", length = 1, nullable = false)
	private String PRIMARY_KEY;
	@Column(name = "NOT_NULL", length = 1, nullable = false)
	private String NOT_NULL;
	@Column(name = "UNIQUE", length = 1, nullable = false)
	private String UNIQUE;
	@Column(name = "BINARY", length = 1, nullable = false)
	private String BINARY;
	@Column(name = "UNSIGNED", length = 1, nullable = false)
	private String UNSIGNED;
	@Column(name = "ZERO_FILL", length = 1, nullable = false)
	private String ZERO_FILL;
	@Column(name = "AUTO_INCREMENT", length = 1, nullable = false)
	private String AUTO_INCREMENT;
	@Column(name = "GENERATED", length = 1, nullable = false)
	private String GENERATED;
	@Column(name = "MASCARA", length = 50, nullable = false)
	private String MASCARA;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;

	public int getIDCOLUNA() {
		return IDCOLUNA;
	}

	public void setIDCOLUNA(int iDCOLUNA) {
		IDCOLUNA = iDCOLUNA;
	}

	public String getNOME_COLUNA() {
		return NOME_COLUNA;
	}

	public void setNOME_COLUNA(String nOME_COLUNA) {
		NOME_COLUNA = nOME_COLUNA;
	}

	public int getIDTIPOCOLUNA() {
		return IDTIPOCOLUNA;
	}

	public void setIDTIPOCOLUNA(int iDTIPOCOLUNA) {
		IDTIPOCOLUNA = iDTIPOCOLUNA;
	}

	public String getPRIMARY_KEY() {
		return PRIMARY_KEY;
	}

	public void setPRIMARY_KEY(String pRIMARY_KEY) {
		PRIMARY_KEY = pRIMARY_KEY;
	}

	public String getNOT_NULL() {
		return NOT_NULL;
	}

	public void setNOT_NULL(String nOT_NULL) {
		NOT_NULL = nOT_NULL;
	}

	public String getUNIQUE() {
		return UNIQUE;
	}

	public void setUNIQUE(String uNIQUE) {
		UNIQUE = uNIQUE;
	}

	public String getBINARY() {
		return BINARY;
	}

	public void setBINARY(String bINARY) {
		BINARY = bINARY;
	}

	public String getUNSIGNED() {
		return UNSIGNED;
	}

	public void setUNSIGNED(String uNSIGNED) {
		UNSIGNED = uNSIGNED;
	}

	public String getZERO_FILL() {
		return ZERO_FILL;
	}

	public void setZERO_FILL(String zERO_FILL) {
		ZERO_FILL = zERO_FILL;
	}

	public String getAUTO_INCREMENT() {
		return AUTO_INCREMENT;
	}

	public void setAUTO_INCREMENT(String aUTO_INCREMENT) {
		AUTO_INCREMENT = aUTO_INCREMENT;
	}

	public String getGENERATED() {
		return GENERATED;
	}

	public void setGENERATED(String gENERATED) {
		GENERATED = gENERATED;
	}

	public int getIDTABELA() {
		return IDTABELA;
	}

	public void setIDTABELA(int iDTABELA) {
		IDTABELA = iDTABELA;
	}

	public String getMASCARA() {
		return MASCARA;
	}

	public void setMASCARA(String mASCARA) {
		MASCARA = mASCARA;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

}
