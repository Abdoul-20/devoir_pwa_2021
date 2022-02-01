package devoir.partie2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devoir.partie2.interfaces.Controller;
import devoir.util.DBClient;
import jakarta.persistence.EntityManager;

public class VehiculeFormulaireController implements Controller {
	
	private EntityManager em;
	private int nbApprovisions;
	
	public VehiculeFormulaireController() {
		// TODO Auto-generated constructor stub
		
		em = DBClient.getEntityManager("parcvehicule");
		nbApprovisions = -1;
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destination = null;
		if (request.getParameter("ajouterVehiculeBtn") != null)
		{
			if (setErrorAlert(request, false))
			{
				destination = "Ajouter_véhicule.jsp";
			}
			else
			{
				ajouterVehicule(request);
				destination = "ParcVehiculesServlet?method=get&listeVehicules=1";
			}
		}
		else if (request.getParameter("ajouterVehicule_ajouterApprovisionBtn") != null)
		{
			validerFormulaire(request, true);
			request.setAttribute("nbApprovisions", ++nbApprovisions);
			destination = "Ajouter_véhicule.jsp";
		}
		else if (request.getParameter("ajouterVehiculeEntry") != null)
		{
			nbApprovisions = -1;
			destination = "Ajouter_véhicule.jsp";
		}
		else if (request.getParameter("modifierVehiculeBtn_goto") != null)
		{
			nbApprovisions = -1;
			setVehiculeAttributes(request);
			destination = "Modifier_véhicule.jsp";
		}
		else if (request.getParameter("modifierVehiculeBtn_save") != null)
		{
			if (setErrorAlert(request, true))
			{
				destination = "Modifier_véhicule.jsp";
			}
			else
			{
				supprimerVehicule(request.getParameter("hiddenImmatriculation"));
				ajouterVehicule(request);
				destination = "ParcVehiculesServlet?method=get&listeVehicules=1";
			}
		}
		else if (request.getParameter("modifierVehicule_ajouterApprovisionBtn") != null)
		{
			validerFormulaire(request, true);
			request.setAttribute("nbApprovisions", ++nbApprovisions);
			destination = "Modifier_véhicule.jsp";
		}
		else if (request.getParameter("supprimerVehiculeBtn") != null)
		{
			supprimerVehicule(request.getParameter("supprimerVehiculeBtn"));
			
			destination = "ParcVehiculesServlet?method=get&listeVehicules=1";
		}
		
		request.getRequestDispatcher(destination).forward(request, response);

	}
	
	private void ajouterVehicule(HttpServletRequest request)
	{

		Vehicule vehicule = new Vehicule();
		
		vehicule.setImmatriculation((String)request.getAttribute("immatriculation"));
		vehicule.setModele((String)request.getAttribute("modele"));
		vehicule.setKilometrage((String)request.getAttribute("kilometrage"));
		vehicule.setType((int)request.getAttribute("type"));
		vehicule.setNbPlace((int)request.getAttribute("nbPlaces"));
		vehicule.setTypeCarburant((String)request.getAttribute("carburant"));
		vehicule.setDateMiseEnService((String)request.getAttribute("dateService"));
		vehicule.setDateAchat((String)request.getAttribute("dateAchat"));
		vehicule.setDateProchaineRevision((String)request.getAttribute("dateProchainRevision"));
		
		@SuppressWarnings("unchecked")
		ArrayList<Approvision> apps = (ArrayList<Approvision>)request.getAttribute("approvisions");
		em.getTransaction().begin();
		for (Approvision approv : apps)
		{
			approv.setV(vehicule);
			em.persist(approv);
		}
		vehicule.setAps(apps);
		em.persist(vehicule);
		
		em.getTransaction().commit();
		
	}
	
	private void setVehiculeAttributes(HttpServletRequest request)
	{
		Vehicule vehicule = em.find(Vehicule.class, request.getParameter("modifierVehiculeBtn_goto"));
		
		request.setAttribute("immatriculation", vehicule.getImmatriculation());
		request.setAttribute("modele", vehicule.getModele());
		request.setAttribute("kilometrage", vehicule.getKilometrage());
		request.setAttribute("type", vehicule.getType());
		request.setAttribute("nbPlaces", vehicule.getNbPlace());
		request.setAttribute("carburant", vehicule.getTypeCarburant());
		request.setAttribute("dateService", vehicule.getDateMiseEnService());
		request.setAttribute("dateAchat", vehicule.getDateAchat());
		request.setAttribute("dateProchainRevision",vehicule.getDateProchaineRevision());
		
		
		List<Approvision> apps = new ArrayList<>();
		for (Approvision app : vehicule.getAps())
		{
			app.calulerMontant();
			apps.add(app);
		}
		request.setAttribute("approvisions", apps);
		nbApprovisions = apps.size() - 1;
		if (nbApprovisions >= 0)
			request.setAttribute("nbApprovisions", nbApprovisions);
	}
	
	private void supprimerVehicule(String immatriculation)
	{
		System.out.println("immatriculatio" + immatriculation);
		
		em.getTransaction().begin();
		em.createQuery("delete Approvision app where app.v.immatriculation = :imm").
		setParameter("imm", immatriculation).executeUpdate();
		em.createQuery("delete Vehicule v where v.immatriculation = :imm").
		setParameter("imm", immatriculation).executeUpdate();
		em.getTransaction().commit();
		em.clear();
	}
	
	private String validerFormulaire(HttpServletRequest request, boolean update)
	{
		String errorMsg = "";
		String immatriculation = request.getParameter("immatriculation");
		request.setAttribute("immatriculation", immatriculation);
		if (immatriculation.isBlank())
			errorMsg = "Le champs immatriculation est vide <br/>";
		else if (!update && em.find(Vehicule.class, immatriculation) != null)
			errorMsg = "Il y a déjà un vehicule avec l'immatriculation " + immatriculation + "<br/>";
		
		
		String modele = request.getParameter("modele");
		request.setAttribute("modele", modele);
		
		if (modele.isBlank())
			errorMsg += "Le champs modele est vide <br/>";
		
		String kilometrage = request.getParameter("kilometrage");
		request.setAttribute("kilometrage", kilometrage);
		try
		{
			Integer.parseInt(kilometrage);
		}
		catch(NumberFormatException e)
		{
			if (kilometrage.isBlank())
				errorMsg += "Le champs kilometrage est vide <br/>";
			else
				errorMsg += "Le kilometrage doit être un entier <br/>";
		}
		
		String type = request.getParameter("type");
		request.setAttribute("type", type);
		
		try
		{
			int typeV = Integer.parseInt(type);
			request.setAttribute("type", typeV);
		}
		catch(NumberFormatException e)
		{
			if (type.isBlank())
				errorMsg += "Le champs type est vide <br/>";
			else
				errorMsg += "Le type doit être un entier <br/>";
		}
		
		String numeroPlaces = request.getParameter("numero_places");
		request.setAttribute("nbPlaces", numeroPlaces);
		try
		{
			int nbPlaces = Integer.parseInt(numeroPlaces);
			request.setAttribute("nbPlaces", nbPlaces);
		}
		catch(NumberFormatException e)
		{
			if (numeroPlaces.isBlank())
				errorMsg += "Le champs numéro de places est vide <br/>";
			else
				errorMsg += "Le numéro de places est invalide <br/>";
		}
		
		String carburant = request.getParameter("carburant");
		request.setAttribute("carburant", carburant);
		
		if (carburant.isBlank())
			errorMsg += "Le champs carburant est vide <br/>";
		
		LocalDate now = LocalDate.now();
		
		String dateService = request.getParameter("date_service");
		request.setAttribute("dateService", dateService);
		LocalDate dateServiceDT = null;
		try
		{
			dateServiceDT = LocalDate.parse(dateService);
			if (dateServiceDT.compareTo(now) > 0)
				errorMsg += "La date de mise en service doit être antérieure à la date d'aujourd'hui <br/>";
		}
		catch (Exception e)
		{
			errorMsg += "Le champs date de mise en service est invalide <br/>";
		}
		
		String dateAchat = request.getParameter("date_achat");
		request.setAttribute("dateAchat", dateAchat);
		LocalDate dateAchatDT = null;
		try
		{
			dateAchatDT = LocalDate.parse(dateAchat);
			String[] errorCmp = {"", ""};
			if (dateAchatDT.compareTo(now) > 0)
				errorCmp[0] = "La date d'achat doit être antérieure à la date d'aujourd'hui";
			if (dateServiceDT != null && dateAchatDT.compareTo(dateServiceDT) < 0)
				errorCmp[1] = "La d'achat doit être postérieure à la date de mise en service <br/>";
			
			errorMsg += (errorCmp[0].isEmpty() ? "" : (errorCmp[0] + " et ")) + errorCmp[1];
		}
		catch (Exception e)
		{
			errorMsg += "Le champs date d'achat est invalide <br/>";
		}
		
		String dateProchainRevision = request.getParameter("date_revision");
		request.setAttribute("dateProchainRevision", dateProchainRevision);
		
		LocalDate datePR = null;
		try
		{
			datePR = LocalDate.parse(dateProchainRevision);
			if (datePR.compareTo(now) < 0)
				errorMsg += "La date de la prochaine révision doit être postérieure à la date d'aujourd'hui <br/>";
		}
		catch (Exception e)
		{
			errorMsg += "Le champs date de la prochaine révision est invalide <br/>";
		}
		
		errorMsg += validerApprovisionsFormulaire(request);
		
		return errorMsg;
	}
	
	private String validerApprovisionsFormulaire(HttpServletRequest request)
	{
		ArrayList<Approvision> approvisions = new ArrayList<>();
		String errorMsg = "";
		for (int i = 0; i <= nbApprovisions; i++)
		{
			Approvision app = new Approvision();
			
			
			String dateApp = request.getParameter("dateapprov_"+i);
			if (dateApp.isBlank())
				errorMsg += "Le champs date approvision est vide <br/>";
			app.setDateapprov(dateApp);
			
			
			String quantite = request.getParameter("quantiteapprov_"+i);
			if (quantite.isBlank())
				errorMsg += "Le champs quantite est vide <br/>";
			try
			{
				double quantiteI = Double.parseDouble(quantite);
				app.setQuantite(quantiteI);
				
			}
			catch(Exception e)
			{
				if (quantite.isBlank())
					errorMsg += "Le champs quantite est vide <br/>";
				else
					errorMsg += "La quantite doit être un nombre <br/>";
			}
			
			String prixUnitaire = request.getParameter("prixunitaireapprov_"+i);
			try
			{
				double prixUnitaireI = Double.parseDouble(prixUnitaire);
				app.setPrixUnitaire(prixUnitaireI);
				
			}
			catch(Exception e)
			{
				if (prixUnitaire.isBlank())
					errorMsg += "Le champs prix unitaire est vide <br/>";
				else
					errorMsg += "Le prix unitaire doit être un nombre <br/>";
			}
			app.calulerMontant();
			approvisions.add(app);
			
			
		}
		
		request.setAttribute("approvisions", approvisions);
		
		return errorMsg;
	}
	
	private boolean setErrorAlert(HttpServletRequest request, boolean update)
	{
		String errorMsg = validerFormulaire(request, update);
		
		
		if (errorMsg.isEmpty())
			return false;
		
		
		String alertMsg = "<div class=\"alert alert-danger\" role=\"alert\">";
		alertMsg += errorMsg;
		alertMsg += "</div>";
		request.setAttribute("errorMsg", alertMsg);
		
		if (nbApprovisions >= 0)
			request.setAttribute("nbApprovisions", nbApprovisions);
		
		return true;
	}

}
