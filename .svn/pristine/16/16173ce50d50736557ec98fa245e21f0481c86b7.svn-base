package br.com.bingo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "port_mensagens_categorias")
public class PortMensagensCategorias {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int IDCATEGORIA;
	@Column(name = "NOMECATEGORIA", length = 50, nullable = false)
	private String  NOMECATEGORIA;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	
	public int getIDCATEGORIA() {
		return IDCATEGORIA;
	}
	public void setIDCATEGORIA(int iDCATEGORIA) {
		IDCATEGORIA = iDCATEGORIA;
	}
	public String getNOMECATEGORIA() {
		return NOMECATEGORIA;
	}
	public void setNOMECATEGORIA(String nOMECATEGORIA) {
		NOMECATEGORIA = nOMECATEGORIA;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
}
