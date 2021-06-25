package br.com.bingo.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bingo_sorteios")
public class BingoSorteios {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "IDSORTEIO", nullable = false)	
	private int IDSORTEIO;
	@Column(name = "IDCLIENTE", nullable = false)	
	private int IDCLIENTE;
	@Column(name = "DATA_HORA", nullable = false)	
	private Timestamp DATA_HORA; 
	@Column(name = "PREMIO1", columnDefinition = "DECIMAL(18,5) DEFAULT 0.0", nullable = false)	
	private double PREMIO1;  
	@Column(name = "PREMIO2", columnDefinition = "DECIMAL(18,5) DEFAULT 0.0", nullable = false)	
	private double PREMIO2;  
	@Column(name = "PREMIO3", columnDefinition = "DECIMAL(18,5) DEFAULT 0.0", nullable = false)	
	private double PREMIO3;  
	@Column(name = "PREMIO4", columnDefinition = "DECIMAL(18,5) DEFAULT 0.0", nullable = false)	
	private double PREMIO4;  
	@Column(name = "PREMIO5", columnDefinition = "DECIMAL(18,5) DEFAULT 0.0", nullable = false)	
	private double PREMIO5; 
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	
	public int getIDSORTEIO() {
		return IDSORTEIO;
	}
	public void setIDSORTEIO(int iDSORTEIO) {
		IDSORTEIO = iDSORTEIO;
	}
	public int getIDCLIENTE() {
		return IDCLIENTE;
	}
	public void setIDCLIENTE(int iDCLIENTE) {
		IDCLIENTE = iDCLIENTE;
	}
	public Timestamp getDATA_HORA() {
		return DATA_HORA;
	}
	public void setDATA_HORA(Timestamp dATA_HORA) {
		DATA_HORA = dATA_HORA;
	}
	public double getPREMIO1() {
		return PREMIO1;
	}
	public void setPREMIO1(double pREMIO1) {
		PREMIO1 = pREMIO1;
	}
	public double getPREMIO2() {
		return PREMIO2;
	}
	public void setPREMIO2(double pREMIO2) {
		PREMIO2 = pREMIO2;
	}
	public double getPREMIO3() {
		return PREMIO3;
	}
	public void setPREMIO3(double pREMIO3) {
		PREMIO3 = pREMIO3;
	}
	public double getPREMIO4() {
		return PREMIO4;
	}
	public void setPREMIO4(double pREMIO4) {
		PREMIO4 = pREMIO4;
	}
	public double getPREMIO5() {
		return PREMIO5;
	}
	public void setPREMIO5(double pREMIO5) {
		PREMIO5 = pREMIO5;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
	