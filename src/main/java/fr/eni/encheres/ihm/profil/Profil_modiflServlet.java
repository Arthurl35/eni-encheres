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
		Utilisateurs u = new Utilisateurs();
		
		
		
		//vers modifier
		if(request.getSession().getAttribute("user")!= null) {
			next = "/WEB-INF/profil_modif.jsp";
		}
		
		//Form validation modif utilisateur
		if(request.getParameter("BT_ENREGISTRER")!=null) {
			try {
				//récuprération des données du formulaire
				u.setId((Integer) request.getSession().getAttribute("id"));
				u.setPseudo(request.getParameter("pseudo"));
				u.setNom(request.getParameter("name"));
				u.setPrenom(request.getParameter("surname"));
				u.setEmail(request.getParameter("mail"));
				u.setTelephone(request.getParameter("tel"));
				u.setRue(request.getParameter("street"));
				u.setCode_postal(request.getParameter("cp"));
				u.setVille(request.getParameter("city"));
				
				
				String mot_de_passe_confirme1 = request.getParameter("pass_new");
				String mot_de_passe_confirme2 = request.getParameter("pass-confirm");
				
				if(mot_de_passe_confirme1 == mot_de_passe_confirme2) {
					u.setMot_de_passe(request.getParameter("pass_actuel"));
				}else {
					throw new Exception("Mot de passe non identique");
				}

				System.out.println("toto " + u);
				manager.updateUtilisateur(u);
				
				next = "/WEB-INF/profil.jsp";

			} catch (UtilisateursException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
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
