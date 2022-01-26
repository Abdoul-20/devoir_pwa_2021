package devoir.partie1;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity 
public class PointDeVente {
	
@Id 
@GeneratedValue
@Column(name="ID")
private long id; 

@Column(name="CodePostal")
private String cp; 

@Column(name="Ville")
private String ville; 

@Column(name="Adresse")
private String adresse;

@OneToMany(mappedBy="pdv")
private List<Carburant> carburants;
	
	public PointDeVente()
	{
		carburants = new ArrayList<>();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Carburant> getCarburants() {
		return carburants;
	}
	public void setCarburants(List<Carburant> carburant) {
		this.carburants = carburant;
	}
	
	@Override
	public String toString()
	{
		String res = "Point de vente : " + id;
		res += "\n\tcp : " + cp;
		res += "\n\tville : " + ville;
		res += "\n\tadresse : " + adresse;
		
		for (Carburant carburant : carburants)
			res += "\n\t" + carburant;
		
		return res;
	}

}
