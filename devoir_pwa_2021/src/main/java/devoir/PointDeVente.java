package devoir;
import java.util.*;
public class PointDeVente {
private long id; //Identifiant du point de vente
private String cp; //Code postal du point de vente
private String ville; //Ville dans lequel se trouve le point de vente
private String adresse;
private ArrayList<Carburant> carburant;
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
public ArrayList<Carburant> getCarburant() {
	return carburant;
}
public void setCarburant(ArrayList<Carburant> carburant) {
	this.carburant = carburant;
}

}
