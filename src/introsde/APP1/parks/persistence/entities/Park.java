package introsde.APP1.parks.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Parks")
@SequenceGenerator(name="seq", initialValue=500, allocationSize=1000)
public class Park implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Integer id;								// ID is automatically generated
    
    private String parco;
    private String nome;
    private Float superficie; 
    
	@Column(columnDefinition="text")
    private String comuni;
	@Column(columnDefinition="text")
    private String provincie;
	@Column(columnDefinition="text")
    private String provvedimento;
	@Column(columnDefinition="text")
    private String elencoUfficiale;
	@Column(columnDefinition="text")
    private String altreInformazioni;
    private String indirizzo;
    private String gestore;
    private String email;
    
	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getParco() {
		return parco;
	}

	public void setParco(String parco) {
		this.parco = parco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSuperficie() {
		return nome;
	}

	public void setSuperficie(Float superficie) {
		this.superficie = superficie;
	}

	public String getComuni() {
		return comuni;
	}

	public void setComuni(String comuni) {
		this.comuni = comuni;
	}

	public String getProvincie() {
		return provincie;
	}

	public void setProvincie(String provincie) {
		this.provincie = provincie;
	}

	public String getProvvedimento() {
		return provvedimento;
	}

	public void setProvvedimento(String provvedimento) {
		this.provvedimento = provvedimento;
	}

	public String getElencoUfficiale() {
		return elencoUfficiale;
	}

	public void setElencoUfficiale(String elencoUfficiale) {
		this.elencoUfficiale = elencoUfficiale;
	}

	public String getAltreInformazioni() {
		return altreInformazioni;
	}

	public void setAltreInformazioni(String altreInformazioni) {
		this.altreInformazioni = altreInformazioni;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getGestore() {
		return gestore;
	}

	public void setGestore(String gestore) {
		this.gestore = gestore;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
