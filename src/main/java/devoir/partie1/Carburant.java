package devoir.partie1;

public class Carburant {
	
	private String nom;  //Nom du carburant
	private double prix; //Prix du carburant
	private String datemsj; //Date de la mise à jour 
	
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
