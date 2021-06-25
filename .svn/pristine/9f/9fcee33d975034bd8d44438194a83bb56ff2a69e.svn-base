package br.com.bingo.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bingo_parametros")
public class BingoParametros {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDPARAMETRO", nullable = false)	
	private int IDPARAMETRO;
	@Column(name = "NOMEPARAMETRO", length = 50, nullable = false)	
	private String NOMEPARAMETRO;
	@Column(name = "VALORPADRAO", length = 1000, nullable = false)	
	private String VALORPADRAO;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	public int getIDPARAMETRO() {
		return IDPARAMETRO;
	}
	public void setIDPARAMETRO(int iDPARAMETRO) {
		IDPARAMETRO = iDPARAMETRO;
	}
	public String getNOMEPARAMETRO() {
		return NOMEPARAMETRO;
	}
	public void setNOMEPARAMETRO(String nOMEPARAMETRO) {
		NOMEPARAMETRO = nOMEPARAMETRO;
	}
	public String getVALORPADRAO() {
		return VALORPADRAO;
	}
	public void setVALORPADRAO(String vALORPADRAO) {
		VALORPADRAO = vALORPADRAO;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	

}
	