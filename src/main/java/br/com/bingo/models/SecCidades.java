package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_cidades")
public class SecCidades {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int IDCIDADE; 
	@Column(name = "NOME", length = 50, nullable = false)	
	private String NOME; 
	@Column(name = "IDPAIS", length = 50, nullable = false)	
	private int IDPAIS; 
	@Column(name = "IDUF", nullable = false)	
	private int IDUF; 
	@Column(name="LATITUDE", columnDefinition="Decimal(18,6) default '0.00'",precision=18, scale=6)
	private double LATITUDE;
	@Column(name="LONGITUDE", columnDefinition="Decimal(18,6) default '0.00'",precision=18, scale=6)
	private double LONGITUDE; 
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	public int getIDCIDADE() {
		return IDCIDADE;
	}
	public void setIDCIDADE(int iDCIDADE) {
		IDCIDADE = iDCIDADE;
	}
	public String getNOME() {
		return NOME;
	}
	public void setNOME(String nOME) {
		NOME = nOME;
	}
	public int getIDPAIS() {
		return IDPAIS;
	}
	public void setIDPAIS(int iDPAIS) {
		IDPAIS = iDPAIS;
	}
	public int getIDUF() {
		return IDUF;
	}
	public void setIDUF(int iDUF) {
		IDUF = iDUF;
	}
	public double getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(double lATITUDE) {
		LATITUDE = lATITUDE;
	}
	public double getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(double lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
