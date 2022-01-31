package devoir.partie2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devoir.partie2.interfaces.Controller;
import devoir.util.DBClient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ListVehiculesControleur implements Controller {
	
	private List<Vehicule> getVehicules()
	{
		EntityManager em = DBClient.getEntityManager("parcvehicule");
		
		CriteriaBuilder cBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Vehicule> query = cBuilder.createQuery(Vehicule.class);
		
		Root<Vehicule> vehicules = query.from(Vehicule.class);
		query.select(vehicules);
		
		return em.createQuery(query).getResultList();
	}

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().println("Yay!!!!");
		
		request.setAttribute("listeVehicules", getVehicules());
		
		request.getRequestDispatcher("listeVehicules.jsp").forward(request, response);
		
	}
}
