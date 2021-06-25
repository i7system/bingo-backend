package br.com.bingo.models;

import javax.persistence.*;

@Entity
@Table(name = "sec_usuarios_empresas")
public class SecUsuariosEmpresas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIOEMPRESA", nullable = false)	
	private int IDUSUARIOEMPRESA; 
	@Column(name = "IDUSUARIO", nullable = false)
	private int IDUSUARIO;	
	@Column(name = "IDEMPRESA", nullable = false)
	private int IDEMPRESA;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	
	public int getIDUSUARIOEMPRESA() {
		return IDUSUARIOEMPRESA;
	}
	public void setIDUSUARIOEMPRESA(int iDUSUARIOEMPRESA) {
		IDUSUARIOEMPRESA = iDUSUARIOEMPRESA;
	}
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
}
