package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_ufs")
public class SecUfs {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
		private int IDUF;
		@Column(name = "IDPAIS", nullable = false)
		private int IDPAIS;
		@Column(name = "NOME", length = 50, nullable = false)	
		private String NOME;
		@Column(name = "SIGLA", length = 50, nullable = false)
		private String SIGLA;
		@Column(name = "IMAGEM", length = 250, nullable = false)
		private String IMAGEM;
		@Column(name="LATITUDE", columnDefinition="Decimal(18,6) default '0.00'",precision=18, scale=6, nullable = false)
		private double LATITUDE;
		@Column(name="LONGITUDE", columnDefinition="Decimal(18,6) default '0.00'",precision=18, scale=6, nullable = false)
		private double LONGITUDE;
		@Column(name = "STATUS", nullable = false)	
		private int STATUS;
		public int getIDUF() {
			return IDUF;
		}
		public void setIDUF(int iDUF) {
			IDUF = iDUF;
		}
		public int getIDPAIS() {
			return IDPAIS;
		}
		public void setIDPAIS(int iDPAIS) {
			IDPAIS = iDPAIS;
		}
		public String getNOME() {
			return NOME;
		}
		public void setNOME(String nOME) {
			NOME = nOME;
		}
		public String getSIGLA() {
			return SIGLA;
		}
		public void setSIGLA(String sIGLA) {
			SIGLA = sIGLA;
		}
		public String getIMAGEM() {
			return IMAGEM;
		}
		public void setIMAGEM(String iMAGEM) {
			IMAGEM = iMAGEM;
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


