package devoir.partie1;


import java.util.ArrayList;


public class PointDeVente {
	
	private long id; //Identifiant du point de vente
	private String cp; //Code postal du point de vente
	private String ville; //Ville dans lequel se trouve le point de vente
	private String adresse;
	private ArrayList<Carburant> carburants;
	
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
	public ArrayList<Carburant> getCarburants() {
		return carburants;
	}
	public void setCarburants(ArrayList<Carburant> carburant) {
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
