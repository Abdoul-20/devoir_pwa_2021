package devoir.partie1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@XmlRootElement
public class Carburant {
	
	@Id
	@GeneratedValue
	@Column(name="IDcarburant")
	private long idcarburant;
	

	@Column(name="Nom")
	private String nom;  
	
	@Column(name="Prix")
	private double prix; 
	
	@Column(name="Datemsj")
	private String datemsj; 
	
	@ManyToOne
	@JsonIgnore
	private PointDeVente pdv;
	
	@XmlAttribute
	public long getIdcarburant() {
		return idcarburant;
	}
	public void setIdcarburant(long idcarburant) {
		this.idcarburant = idcarburant;
	}
	@XmlAttribute
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlAttribute
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@XmlAttribute
	public String getDatemsj() {
		return datemsj;
	}
	public void setDatemsj(String datemsj) {
		this.datemsj = datemsj;
	}
	@XmlTransient
	public PointDeVente getPdv() {
		return pdv;
	}
	public void setPdv(PointDeVente pdv) {
		this.pdv = pdv;
	}
	
	@Override
	public String toString()
	{
		String res = "Carburant : " + nom;
		res += ", prix : " + prix;
		res += ", date de mise à jour : " + datemsj;
		
		return res;
		
	}

}
