package devoir.partie2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devoir.partie2.interfaces.Controller;
import devoir.util.DBClient;
import jakarta.persistence.EntityManager;

public class ModifierVehiculeController implements Controller {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBClient.getEntityManager("parcvehicule");
		String id = request.getParameter("modifierVehiculeBtn_goto");
		String forwardDest = "ParcVehiculesServlet?method=post&listeVehicules=1";
		if (id != null)
		{
			Vehicule vehicule = em.find(Vehicule.class, id);
			
			setFormAttributes(request, vehicule);
			
			forwardDest = "Modifier_véhicule.jsp";
		}
		else 
			saveUpdates();
		
		
		request.getRequestDispatcher(forwardDest).forward(request, response);

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
	}
	
	private void saveUpdates()
	{
		
	}

}
