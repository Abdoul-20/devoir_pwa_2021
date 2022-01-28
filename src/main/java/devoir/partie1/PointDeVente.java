package devoir.partie1;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity 
@XmlRootElement
public class PointDeVente {
	
	@Id
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
	
	@XmlAttribute
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@XmlAttribute
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	@XmlAttribute
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	@XmlAttribute
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@XmlElement
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
