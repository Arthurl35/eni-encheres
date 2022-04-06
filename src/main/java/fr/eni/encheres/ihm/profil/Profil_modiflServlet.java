package fr.eni.encheres.ihm.profil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bll.utilisateurs.UtilisateursManager;
import fr.eni.encheres.bll.utilisateurs.UtilisateursManagerSing;
import fr.eni.encheres.bo.Utilisateurs;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/Profil_modelServlet")
public class Profil_modiflServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UtilisateursManager manager = UtilisateursManagerSing.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil_modiflServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String next = "/WEB-INF/profil_modif.jsp";
		Utilisateurs u = (Utilisateurs) request.getSession().getAttribute("user");
		
		//vers modifier
		if(request.getSession().getAttribute("user")!= null) {
			next = "/WEB-INF/profil_modif.jsp";
		}
		
		//Form validation modif utilisateur
		if(request.getParameter("BT_ENREGISTRER")!=null) {
			try {
				manager.updateUtilisateur(u);
				
				next = "/WEB-INF/profil.jsp";

			} catch (UtilisateursException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Form supp utilisateur
				if(request.getParameter("BT_SUPP")!=null) {
	
					try {
						manager.delUtilisateur(u);
					
						request.getSession().removeAttribute("user");
					
						if(u == null) {
							next = "/WEB-INF/home.jsp";
						}
				

					} catch (UtilisateursException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
		request.getRequestDispatcher(next).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
