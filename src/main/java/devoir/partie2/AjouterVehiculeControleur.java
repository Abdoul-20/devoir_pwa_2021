package devoir.partie2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjouterVehiculeControleur extends AbstractVehiculeController{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.run(request, response);
		if (request.getParameter("ajouterVehiculeBtn") != null)
		{
			try {
			addVehicule(request);
			}
			catch (Exception e)
			{
				
			}
			
		}
		else if (request.getParameter("ajouterVehicule_ajouterApprovisionBtn") != null)
		{
			request.setAttribute("approvisionsSize", ++approvisionsSize);
		}
		else if (request.getParameter("ajouterVehiculEntry") != null)
		{
			approvisionsSize = -1;
		}
		
		request.getRequestDispatcher("Ajouter_véhicule.jsp").forward(request, response);
		
	}
}
