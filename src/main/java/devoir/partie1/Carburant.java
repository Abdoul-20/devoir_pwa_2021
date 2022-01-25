package devoir.partie1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
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
	private PointDeVente pdv;
	
	public PointDeVente getPdv() {
		return pdv;
	}
	public void setPdv(PointDeVente pdv) {
		this.pdv = pdv;
	}
	public long getIdcarburant() {
		return idcarburant;
	}
	public void setIdcarburant(long idcarburant) {
		this.idcarburant = idcarburant;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDatemsj() {
		return datemsj;
	}
	public void setDatemsj(String datemsj) {
		this.datemsj = datemsj;
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
