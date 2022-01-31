package devoir.tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class STest
 */
@WebServlet("/STest")
public class STest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public STest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		String prenom = request.getParameter("firstname");
		String nom = request.getParameter("familyname");
		
		String errorMsg = "";
		if (prenom.isBlank())
			errorMsg += "first name is not given\n";
		if (nom.isBlank())
			errorMsg += "family name is not given";
		
		if (!errorMsg.isBlank())
		{
			request.setAttribute("firstname", prenom);
			request.setAttribute("familyname", nom);
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
		
		writer.println("Hello " + prenom + " " + nom);
		
	}

}
