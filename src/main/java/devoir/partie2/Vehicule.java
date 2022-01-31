package devoir.partie2;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "parcvehicule")
public class Vehicule {

	@Id 
	@Column(name="Immatriculation")
	private String immatriculation;
	
	@Column(name="Modele")
	private String modele;
	
	@Column(name="Kilometrage")
	private String kilometrage;
	
	@Column(name="Type") 
	private int type;
	
	@Column(name="NbPLace")
	private int nbPlace;
	
	@Column(name="TypeCarburant")
	private String typeCarburant;
	
	@Column(name="DateMiseEnService")
	private String dateMiseEnService;

	@Column(name="DateAchat")
	private String dateAchat;
	
	@Column(name="DateProchaineRevision")
	private String dateProchaineRevision;
	
	@OneToMany(mappedBy = "v")
	private List<Approvision>aps;
	
	public Vehicule() {
		aps = new ArrayList<Approvision>();
	}

	public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getNbPlace() {
		return nbPlace;
	}


	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}


	public String getTypeCarburant() {
		return typeCarburant;
	}


	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}


	public String getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}


	public String getDateProchaineRevision() {
		return dateProchaineRevision;
	}


	public void setDateProchaineRevision(String dateProchaineRevision) {
		this.dateProchaineRevision = dateProchaineRevision;
	}


	public List<Approvision> getAps() {
		return aps;
	}


	public void setAps(List<Approvision> aps) {
		this.aps = aps;
	}
	
	public String getDateMiseEnService() {
		return dateMiseEnService;
	}

	public void setDateMiseEnService(String dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}
	
}
