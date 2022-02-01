package devoir.partie2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devoir.partie2.interfaces.Controller;
import devoir.util.DBClient;
import jakarta.persistence.EntityManager;

public abstract class AbstractVehiculeController implements Controller {
	
	protected int approvisionsSize = -1;
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setParametersAsAttributes(request);
	}
	protected void addVehicule(HttpServletRequest request)
	{
		try
		{
			Vehicule vehicule = creerVehicule(request);		
			
			EntityManager em = DBClient.getEntityManager("parcvehicule");
			em.getTransaction().begin();
			em.persist(vehicule);
			for (Approvision approv : vehicule.getAps())
				em.persist(approv);
			em.getTransaction().commit();
			
			String statusMsg = getAlert("L'enregistrement du véhicule est terminé avec succès", false);
			
			request.setAttribute("statusMsg", statusMsg);
		}
		catch (NumberFormatException e)
		{
			String statusMsg = getAlert("Numéro de place doit être un entier", true);
			
			request.setAttribute("statusMsg", statusMsg);
			
			throw e;
		}
		catch (IllegalStateException e)
		{
			request.setAttribute("statusMsg", e.getMessage());
			
			throw e;
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
	
	private void verfiyField(String fieldValue, String fieldName)
	{
		String msg = "Le champs " +fieldName + " est requis";
		if (fieldValue.isBlank())
			throw new IllegalStateException(getAlert(msg, true));
	}
	
	private Vehicule creerVehicule(HttpServletRequest request)
	{

		String immatriculation = request.getParameter("immatriculation");
		verfiyField(immatriculation, "immatriculation");
		String modele = request.getParameter("modele");
		verfiyField(modele, "Modèle");
		String kilometrage = request.getParameter("kilometrage");
		verfiyField(kilometrage, "kilometrage");
		String type = request.getParameter("type");
		String numeroPlaces = request.getParameter("numero_places");
		verfiyField(numeroPlaces, "Numéro de places");
		String carburant = request.getParameter("carburant");
		
		String dateService = request.getParameter("date_service");
		verfiyField(dateService, "Date de mise en service");
		String dateAchat = request.getParameter("date_achat");
		verfiyField(dateAchat, "Date d'achat");
		String dateProchainRevision = request.getParameter("date_revision");
		verfiyField(dateProchainRevision, "date de prochaine révision");
		
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
		
		List<Approvision> apps = getApprovisions(request);
		for (Approvision approv : apps)
			approv.setV(vehicule);
		vehicule.setAps(apps);
		
		return vehicule;
	}
	
	private List<Approvision> getApprovisions(HttpServletRequest request)
	{
		ArrayList<Approvision> apps = new ArrayList<>();
		for (int i = 0; i <= approvisionsSize; i++)
		{
			Approvision app = new Approvision();
			
			String dateApp = request.getParameter("dateapprov_"+i);
			verfiyField(dateApp, "Date d'approvisionnement");
			String quantite = request.getParameter("quantiteapprov_"+i);
			verfiyField(quantite, "quantite du carburant");
			String prixUnitaire = request.getParameter("prixunitaireapprov_"+i);
			verfiyField(prixUnitaire, "prix unitaire");
			
			app.setDateapprov(dateApp);
			app.setQuantite(Double.parseDouble(quantite));
			app.setPrixUnitaire(Double.parseDouble(prixUnitaire));
			
			apps.add(app);
		}
		System.out.println(apps);
		
		
		return apps;
	}
	
	private void setParametersAsAttributes(HttpServletRequest request)
	{
		String immatriculation="", modele="", kilometrage="",
		type, numeroPlaces, carburant, dateService, dateAchat, dateProchainRevision;
		immatriculation = request.getParameter("immatriculation");
		modele = request.getParameter("modele");
		kilometrage = request.getParameter("kilometrage");
		type = request.getParameter("type");
		numeroPlaces = request.getParameter("numero_places");
		carburant = request.getParameter("carburant");
		
		dateService = request.getParameter("date_service");
		dateAchat = request.getParameter("date_achat");
		dateProchainRevision = request.getParameter("date_revision");
		
		List<Approvision> apps = null;
		try
		{
			apps = getApprovisions(request);			
		}
		catch (Exception e)
		{
			apps = new ArrayList<>();
		}
		finally
		{
			request.setAttribute("immatriculation", immatriculation);
			request.setAttribute("modele", modele);
			request.setAttribute("kilometrage", kilometrage);
			request.setAttribute("type", type);
			request.setAttribute("numero_places", numeroPlaces);
			request.setAttribute("carburant", carburant);
			request.setAttribute("date_service", dateService);
			request.setAttribute("date_achat", dateAchat);
			request.setAttribute("date_revision", dateProchainRevision);
			request.setAttribute("approvisions", apps);
			if (approvisionsSize > 0)
				request.setAttribute("approvisionsSize", approvisionsSize);
		}
	}

}
