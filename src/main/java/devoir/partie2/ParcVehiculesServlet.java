package devoir.partie2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BadRequestException;

import devoir.partie2.interfaces.Controller;
import devoir.util.DBClient;

/**
 * Servlet implementation class ParcVoitureServlet
 */
@WebServlet("/ParcVehiculesServlet")
public class ParcVehiculesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, Controller> controllers;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParcVehiculesServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Servlet launched");
        
        DBClient.addDatabase("parcvehicule", "pwa-mysql2");
        
        controllers = new HashMap<>();
        controllers.put("ajouterVehiculeBtn", new AjouterVehiculeControleur());
        controllers.put("listeVehicules", new ListVehiculesControleur());
        ModifierVehiculeController mvc = new ModifierVehiculeController();
        controllers.put("modifierVehiculeBtn_goto", mvc);
        controllers.put("modifierVehiculeBtn_save", mvc);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean controllerFound = false;
		for (String key : controllers.keySet())
		{
			if (request.getParameter(key) != null)
			{
				controllerFound = true;
				controllers.get(key).run(request, response);
			}
		}
		if (!controllerFound)
			throw new BadRequestException("Servlet requested but no matching with parameter name");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
