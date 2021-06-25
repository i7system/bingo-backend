package br.com.bingo.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "port_usuarios_mensagens")
public class PortUsuariosMensagens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMENSAGEM", nullable = false)	
	private int IDMENSAGEM;
	@Column(name = "IDUSUARIO", nullable = false)	
	private int IDUSUARIO;
	@Column(name = "IDEMPRESA", nullable = false)
	private int IDEMPRESA;
	@Column(name = "IMAGEM", length = 250, nullable = false)
	private String IMAGEM;
	@Column(name = "TITULO", length = 250, nullable = false)
	private String TITULO;
	@Column(name = "MENSAGEM", length = 2000, nullable = false)
	private String MENSAGEM;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	@Column(name = "DATA", nullable = false)
	private Instant DATA;
	@Column(name = "IDCATEGORIA", nullable = false)	
	private int IDCATEGORIA;
	
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public int getIDCATEGORIA() {
		return IDCATEGORIA;
	}
	public void setIDCATEGORIA(int iDCATEGORIA) {
		IDCATEGORIA = iDCATEGORIA;
	}
	public int getIDMENSAGEM() {
		return IDMENSAGEM;
	}
	public void setIDMENSAGEM(int iDMENSAGEM) {
		IDMENSAGEM = iDMENSAGEM;
	}
	public int getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public String getIMAGEM() {
		return IMAGEM;
	}
	public void setIMAGEM(String iMAGEM) {
		IMAGEM = iMAGEM;
	}
	public String getTITULO() {
		return TITULO;
	}
	public void setTITULO(String tITULO) {
		TITULO = tITULO;
	}
	public String getMENSAGEM() {
		return MENSAGEM;
	}
	public void setMENSAGEM(String mENSAGEM) {
		MENSAGEM = mENSAGEM;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public Instant getDATA() {
		return DATA;
	}
	public void setDATA(Instant dATA) {
		DATA = dATA;
	}

	
}
