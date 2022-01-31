package devoir.partie2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devoir.partie2.interfaces.Controller;
import devoir.util.DBClient;
import jakarta.persistence.EntityManager;

public class AjouterVehiculeControleur implements Controller{
	
	private void addVehicule(HttpServletRequest request)
	{
		try
		{
			Vehicule vehicule = creerVehicule(request);		
			
			EntityManager em = DBClient.getEntityManager("parcvehicule");
			em.getTransaction().begin();
			em.persist(vehicule);
			em.getTransaction().commit();
			
			String statusMsg = getAlert("L'enregistrement du véhicule est terminé avec succès", false);
			
			System.out.println(statusMsg);
			
			request.setAttribute("statusMsg", statusMsg);
		}
		catch (NumberFormatException e)
		{
			String statusMsg = getAlert("Numéro de place doit être un entier", true);
			
			request.setAttribute("statusMsg", statusMsg);
			
			System.out.println(statusMsg);
		}
	}
	
	private String getAlert(String msg, boolean isError)
	{
		String alertType = "success";
		if (isError)
			alertType = "danger";
		
		String result = "<div class=\"alert alert-" + alertType + "\" role=\"alert\">";
		result += msg;
		result += "</div>";
		
		return result;
	}
	
	private Vehicule creerVehicule(HttpServletRequest request)
	{

		String immatriculation = request.getParameter("immatriculation");
		String modele = request.getParameter("modele");
		String kilometrage = request.getParameter("kilometrage");
		String type = request.getParameter("type");
		String numeroPlaces = request.getParameter("numero_places");
		String carburant = request.getParameter("carburant");
		String dateService = request.getParameter("date_service");
		String dateAchat = request.getParameter("date_achat");
		String dateProchainRevision = request.getParameter("date_revision");
		
		request.setAttribute("immatriculation", immatriculation);
		request.setAttribute("modele", modele);
		request.setAttribute("kilometrage", kilometrage);
		request.setAttribute("type", type);
		request.setAttribute("numero_places", numeroPlaces);
		request.setAttribute("carburant", carburant);
		request.setAttribute("date_service", dateService);
		request.setAttribute("date_achat", dateAchat);
		request.setAttribute("date_revision", dateProchainRevision);
	
		
		Vehicule vehicule = new Vehicule();
		
		vehicule.setImmatriculation(immatriculation);
		vehicule.setModele(modele);
		vehicule.setKilometrage(kilometrage);
		vehicule.setType(Integer.parseInt(type));
		vehicule.setNbPlace(Integer.parseInt(numeroPlaces));
		vehicule.setTypeCarburant(carburant);
		vehicule.setDateMiseEnService(dateService);
		vehicule.setDateAchat(dateAchat);
		vehicule.setDateProchaineRevision(dateProchainRevision);
		
		return vehicule;
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().println("Ajouter véhicule cliked");
		addVehicule(request);
		
		request.getRequestDispatcher("Ajouter_véhicule.jsp").forward(request, response);
		
	}
}
