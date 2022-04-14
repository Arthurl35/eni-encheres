package fr.eni.encheres.ihm.admin;

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
import fr.eni.encheres.ihm.profil.ProfilModel;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UtilisateursManager manager = UtilisateursManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String next = "/WEB-INF/admin.jsp";
		ProfilModel model = new ProfilModel();
		Utilisateurs u = new Utilisateurs();
		
		// retour au home
		if (request.getParameter("BT_LOGOUT") != null) {
			next = "";
		}
				

		// test si d�j� connect�
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			model.setUser((Utilisateurs) session.getAttribute("user"));

			// Récupération de boolean de l'utilisateur
			Boolean admin = ((Utilisateurs) session.getAttribute("user")).isAdministrateur();
			Integer adminId = ((Utilisateurs) session.getAttribute("user")).getId();

			// Redirection vers home si utilisateur n'est pas admin ou connecté
			if (request.getSession().getAttribute("user") == null || admin == false) {
				next = "";
			} else {
				// Liste des utilisateurs
				try {
					model.setLstUtilisateurs(manager.getAllUtilisateurs_sansAdmin());
					// Form supp utilisateur
					if (request.getParameter("BT_SUPP_admin") != null) {

						Integer idSelected = Integer.parseInt(request.getParameter("id_utilisateur"));
						
						//pour éviter de supprimer un admin
						if (adminId.equals(idSelected)) {
							model.setMessage("Vous êtes administrateur !!!");
							
						}else {
							
							u.setId(idSelected);

							manager.delUtilisateur(u);

							model.setLstUtilisateurs(manager.getAllUtilisateurs_sansAdmin());

						}

					}
					if (request.getParameter("BT_STATUS_valid") != null) {

						System.out.println("je passe ici");
						System.out.println(request.getParameter("pricing"));
						

					}
					

			
					
					
				
						
						
				
					
				} catch (UtilisateursException e) {
					// TODO Auto-generated catch block
					model.setMessage(e.getMessage());
				}

			}

		} else {
			next = "";
		}

		request.setAttribute("model", model);
		request.getRequestDispatcher(next).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
