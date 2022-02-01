package devoir.partie2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devoir.util.DBClient;
import jakarta.persistence.EntityManager;

public class ModifierVehiculeController extends AbstractVehiculeController {
	
	private int approvisionsSize = -1;

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.run(request, response);
		
		EntityManager em = DBClient.getEntityManager("parcvehicule");
		String id = request.getParameter("modifierVehiculeBtn_goto");
		String forwardDest = "ParcVehiculesServlet?method=post&listeVehicules=1";
		if (id != null)
		{
			Vehicule vehicule = em.find(Vehicule.class, id);
			
			setFormAttributes(request, vehicule);
			
			forwardDest = "Modifier_véhicule.jsp";
		}
		else if (request.getParameter("modifierVehiculeBtn_save") != null)
			saveUpdates(request);
		else if (request.getParameter("modifierVehicule_ajouterApprovisionBtn") != null)
		{
			request.setAttribute("approvisionsSize", ++approvisionsSize);
		}
		
		request.getRequestDispatcher("Modifier_véhicule.jsp").forward(request, response);

	}
	
	private void setFormAttributes(HttpServletRequest request, Vehicule vehicule)
	{
		request.setAttribute("immatriculation", vehicule.getImmatriculation());
		request.setAttribute("modele", vehicule.getModele());
		request.setAttribute("kilometrage", vehicule.getKilometrage());
		request.setAttribute("type", vehicule.getType());
		request.setAttribute("numero_places", vehicule.getNbPlace());
		request.setAttribute("carburant", vehicule.getTypeCarburant());
		request.setAttribute("date_service", vehicule.getDateMiseEnService());
		request.setAttribute("date_achat", vehicule.getDateAchat());
		request.setAttribute("date_revision",vehicule.getDateProchaineRevision());
		List<Approvision> apps = vehicule.getAps();
		request.setAttribute("approvisions", apps);
		approvisionsSize = apps.size();
		
		request.setAttribute("approvisionsSize", approvisionsSize-1);
	}
	
	private void saveUpdates(HttpServletRequest request)
	{
		String immatriculation = request.getParameter("immatriculation");
		EntityManager em = DBClient.getEntityManager("parcvehicule");
		Vehicule vehicule = em.find(Vehicule.class, immatriculation);
		List<Approvision> approvs = vehicule.getAps();
		em.getTransaction().begin();
		em.remove(vehicule);
		for (Approvision approv : approvs)
			em.remove(approv);
		em.getTransaction().commit();
		
		try
		{
			addVehicule(request);
		}
		catch (Exception e)
		{
			em.getTransaction().begin();
			em.persist(vehicule);
			for (Approvision approv : approvs)
				em.persist(approv);
			em.getTransaction().commit();
		}
	}

}
