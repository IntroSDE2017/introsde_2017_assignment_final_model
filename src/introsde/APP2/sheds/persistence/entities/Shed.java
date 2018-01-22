package introsde.APP2.sheds.persistence.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Sheds")
@SequenceGenerator(name="seq", initialValue=500, allocationSize=1000)
public class Shed implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Integer id;								// ID is automatically generated
    
    private String nome;
    private String localita; 
	@Column(columnDefinition="text")
    private String comune;
    private String settore_alpino;
	private String web;
	private Float anno;
	private Float quota;
	private Float letti;
	private Float cuccette;
	private Float tavolato;
	private Float invernale;
	private String tipologia;
	private String regione;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getSettore_alpino() {
		return settore_alpino;
	}

	public void setSettore_alpino(String settore_alpino) {
		this.settore_alpino = settore_alpino;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Float getAnno() {
		return anno;
	}

	public void setAnno(Float anno) {
		this.anno = anno;
	}

	public Float getQuota() {
		return quota;
	}

	public void setQuota(Float quota) {
		this.quota = quota;
	}

	public Float getLetti() {
		return letti;
	}

	public void setLetti(Float letti) {
		this.letti = letti;
	}

	public Float getCuccette() {
		return cuccette;
	}

	public void setCuccette(Float cuccette) {
		this.cuccette = cuccette;
	}

	public Float getTavolato() {
		return tavolato;
	}

	public void setTavolato(Float tavolato) {
		this.tavolato = tavolato;
	}

	public Float getInvernale() {
		return invernale;
	}

	public void setInvernale(Float invernale) {
		this.invernale = invernale;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

		
}
