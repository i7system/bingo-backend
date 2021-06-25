package br.com.bingo.models;

//import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;


@Entity
@Table(name="sec_perfis")
public class SecPerfis  {

    public SecPerfis(String nomeperfil) {
        this.NOMEPERFIL = nomeperfil;
    }
    public SecPerfis() {
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPERFIL", nullable = false)
	private int IDPERFIL;
	@Column(name = "IDEMPRESA", nullable = false)
	private int IDEMPRESA;
	@Column(name = "NOMEPERFIL", length = 50,nullable = false)
	private String NOMEPERFIL;
	@Column(name = "FOTO", length = 250,nullable = false)
	private String FOTO;
	@Column(name = "STATUS", nullable = false)
	private int STATUS;
	public int getIDPERFIL() {
		return IDPERFIL;
	}
	public void setIDPERFIL(int iDPERFIL) {
		IDPERFIL = iDPERFIL;
	}
	public int getIDEMPRESA() {
		return IDEMPRESA;
	}
	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}
	public String getNOMEPERFIL() {
		return NOMEPERFIL;
	}
	public void setNOMEPERFIL(String nOMEPERFIL) {
		NOMEPERFIL = nOMEPERFIL;
	}
	public String getFOTO() {
		return FOTO;
	}
	public void setFOTO(String fOTO) {
		FOTO = fOTO;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
	

}
