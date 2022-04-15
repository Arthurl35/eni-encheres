package fr.eni.encheres.ihm.profil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfilModel model = new ProfilModel();
		
		String next = "/WEB-INF/profil.jsp";
		
		//test bien connecté
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null)model.setPseudo(session.getAttribute("user").toString());
		else next = request.getContextPath();
		
		//vers modifier
		if(request.getParameter("BT_MODIFIER")!= null && session.getAttribute("user")!= null) {
			next = "/WEB-INF/infoProfil.jsp";
		}
		
		//retour au home
		if(request.getParameter("BT_ANNULER") != null) {
		next = request.getContextPath();
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher(next).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
