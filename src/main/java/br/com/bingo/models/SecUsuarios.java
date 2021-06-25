package br.com.bingo.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "sec_usuarios")
public class SecUsuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIO", nullable = false)
	private int IDUSUARIO;
	@Column(name = "NOMEUSUARIO", length = 50,nullable = false)	
	private String NOMEUSUARIO; 
	@Column(name = "FOTO", length = 250,nullable = false)	
	private String FOTO; 
	@Column(name = "EMAIL", length = 250,nullable = false)	
	private String EMAIL;
	@Column(name = "LOGINUSUARIO", length = 250,nullable = false)	
	private String LOGINUSUARIO;
	@Column(name = "SENHA", length = 250,nullable = false)	
	private String SENHA;
	@Column(name = "DESCSENHA", length = 250,nullable = false)	
	private String DESCSENHA;
	@Column(name = "DDD", nullable = false)	
	private int DDD;
	@Column(name = "TELEFONE", length = 30,nullable = false)	
	private String TELEFONE;
	@Column(name = "IDIDIOMA", nullable = false)	
	private int IDIDIOMA;
	@Column(name = "STATUS", nullable = false)	
	private int STATUS;
	@Column(name = "APELIDO", length = 50,nullable = false)	
	private String APELIDO; 
	@Column(name = "CARGO", length = 50,nullable = false)	
	private String CARGO; 
	@Column(name = "TOKEN", length = 250,nullable = false)	
	private String TOKEN;
	@Column(name = "IDEMPRESA", nullable = false)	
	private int IDEMPRESA;
	
		
    public String getLOGINUSUARIO() {
		return LOGINUSUARIO;
	}

	public void setLOGINUSUARIO(String lOGINUSUARIO) {
		LOGINUSUARIO = lOGINUSUARIO;
	}

	public String getDESCSENHA() {
		return DESCSENHA;
	}

	public void setDESCSENHA(String dESCSENHA) {
		DESCSENHA = dESCSENHA;
	}

	public int getIDEMPRESA() {
		return IDEMPRESA;
	}

	public void setIDEMPRESA(int iDEMPRESA) {
		IDEMPRESA = iDEMPRESA;
	}

	public String getTOKEN() {
		return TOKEN;
	}

	public void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}

	public int getIDUSUARIO() {
		return IDUSUARIO;
	}

	public void setIDUSUARIO(int iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}

	public String getNOMEUSUARIO() {
		return NOMEUSUARIO;
	}

	public void setNOMEUSUARIO(String nOMEUSUARIO) {
		NOMEUSUARIO = nOMEUSUARIO;
	}

	public String getFOTO() {
		return FOTO;
	}

	public void setFOTO(String fOTO) {
		FOTO = fOTO;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getSENHA() {
		return SENHA;
	}

	public void setSENHA(String sENHA) {
		SENHA = sENHA;
	}

	public int getDDD() {
		return DDD;
	}

	public void setDDD(int dDD) {
		DDD = dDD;
	}

	public String getTELEFONE() {
		return TELEFONE;
	}

	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}


	public int getIDIDIOMA() {
		return IDIDIOMA;
	}

	public void setIDIDIOMA(int iDIDIOMA) {
		IDIDIOMA = iDIDIOMA;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public String getAPELIDO() {
		return APELIDO;
	}

	public void setAPELIDO(String aPELIDO) {
		APELIDO = aPELIDO;
	}

	public String getCARGO() {
		return CARGO;
	}

	public void setCARGO(String cARGO) {
		CARGO = cARGO;
	}

	public List<SecPerfis> getSecPerfis() {
		return secPerfis;
	}

	public void setSecPerfis(List<SecPerfis> secPerfis) {
		this.secPerfis = secPerfis;
	}

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="sec_usuarios_perfis",
            joinColumns=@JoinColumn(name="IDUSUARIO"),
            inverseJoinColumns=@JoinColumn(name="IDPERFIL")
    )
	
    private List<SecPerfis> secPerfis;

	
	
	
    public SecUsuarios() {
    }

    public SecUsuarios(String nOMEUSUARIO, String eMAIL) {
        super();
        this.NOMEUSUARIO = nOMEUSUARIO;
        this.EMAIL = eMAIL;
    }
    
    public SecUsuarios(SecUsuarios usuario) {
        super();
        this.secPerfis = usuario.getSecPerfis();
        this.IDUSUARIO=usuario.getIDUSUARIO();
        this.IDIDIOMA=usuario.getIDIDIOMA();
        this.NOMEUSUARIO=usuario.getNOMEUSUARIO();
        this.FOTO=usuario.getFOTO();
        this.EMAIL=usuario.getEMAIL();
        this.SENHA=usuario.getSENHA();
        this.DDD=usuario.getDDD();
        this.TELEFONE=usuario.getTELEFONE();
        this.STATUS=usuario.getSTATUS();
        this.APELIDO=usuario.getAPELIDO();
        this.CARGO=usuario.getCARGO();
        
    }
    
    public SecUsuarios(int idusuario,int ididioma,String nomeusuario,String foto,String email,String senha,
    		           int ddd, String telefone,int status,int idsexo,String apelido,String cargo, List<SecPerfis> secPerfis) {
        super();
       
        this.secPerfis = secPerfis;       
        this.IDUSUARIO=idusuario;
        this.IDIDIOMA=ididioma;
        this.NOMEUSUARIO=nomeusuario;
        this.FOTO=foto;
        this.EMAIL=email;
        this.SENHA=senha;
        this.DDD=ddd;
        this.TELEFONE=telefone;
        this.STATUS=status;
        this.APELIDO=apelido;
        this.CARGO=cargo;

        
        
        
    }

}
