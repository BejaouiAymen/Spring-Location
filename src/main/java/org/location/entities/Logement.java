package org.location.entities;

import java.io.Serializable;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;





@Entity
public class Logement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLog;
	private String nomLog;

	private String adresseLog;
	private String descriptionLog;
	@DecimalMin("1")
	private double prix;
	@NotNull
	private double superficie;
	
	private TypeLog typelog;
	
	@OneToMany(mappedBy="logement")
	private Collection<Contrat> contrat;
	
	
	public Long getIdLog() {
		return idLog;
	}
	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}
	public String getNomLog() {
		return nomLog;
	}
	public void setNomLog(String nomLog) {
		this.nomLog = nomLog;
	}
	public String getAdresseLog() {
		return adresseLog;
	}
	public void setAdresseLog(String adresseLog) {
		this.adresseLog = adresseLog;
	}
	public String getDescriptionLog() {
		return descriptionLog;
	}
	public void setDescriptionLog(String descriptionLog) {
		this.descriptionLog = descriptionLog;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public TypeLog getTypelog() {
		return typelog;
	}
	public void setTypelog(TypeLog typelog) {
		this.typelog = typelog;
	}
	public Logement(String nomLog, String adresseLog, String descriptionLog, double prix, double superficie,
			TypeLog typelog) {
		super();
		this.nomLog = nomLog;
		this.adresseLog = adresseLog;
		this.descriptionLog = descriptionLog;
		this.prix = prix;
		this.superficie = superficie;
		this.typelog = typelog;
	}
	public Logement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
