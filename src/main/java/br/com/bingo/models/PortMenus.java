package br.com.bingo.models;

import javax.persistence.*;

@Entity
@Table(name = "port_menus")
public class PortMenus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMENU", nullable = false)
	private int IDMENU;	
	@Column(name = "NOME", length = 50,nullable = false)	
	private String NOME; 
	@Column(name = "ORDEM", length = 30,nullable = false)	
	private String ORDEM;
	@Column(name = "URL", length = 250,nullable = false)	
	private String URL; 
	@Column(name = "PARAMETROS", length = 250,nullable = false)	
	private String PARAMETROS; 
	@Column(name = "IMAGEM", length = 250,nullable = false)	
	private String IMAGEM; 
	@Column(name = "NIVEL", nullable = false)	
	private int NIVEL;
	@Column(name = "PAI",nullable = false)	
	private int PAI;
	@Column(name = "IDACAO", nullable = false)	
	private int IDACAO;
	@Column(name = "IDPORTAL", nullable = false)	
	private int IDPORTAL;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	public int getIDMENU() {
		return IDMENU;
	}
	public void setIDMENU(int iDMENU) {
		IDMENU = iDMENU;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public String getORDEM() {
		return ORDEM;
	}
	public void setORDEM(String oRDEM) {
		ORDEM = oRDEM;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getPARAMETROS() {
		return PARAMETROS;
	}
	public void setPARAMETROS(String pARAMETROS) {
		PARAMETROS = pARAMETROS;
	}
	public String getIMAGEM() {
		return IMAGEM;
	}
	public void setIMAGEM(String iMAGEM) {
		IMAGEM = iMAGEM;
	}
	public int getNIVEL() {
		return NIVEL;
	}
	public void setNIVEL(int nIVEL) {
		NIVEL = nIVEL;
	}
	public int getPAI() {
		return PAI;
	}
	public void setPAI(int pAI) {
		PAI = pAI;
	}
	public int getIDACAO() {
		return IDACAO;
	}
	public void setIDACAO(int iDACAO) {
		IDACAO = iDACAO;
	}
	public int getIDPORTAL() {
		return IDPORTAL;
	}
	public void setIDPORTAL(int iDPORTAL) {
		IDPORTAL = iDPORTAL;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	

	

	
	
}