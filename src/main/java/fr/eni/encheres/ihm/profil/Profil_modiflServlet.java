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
import fr.eni.encheres.ihm.login.LoginModel;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String next = "/WEB-INF/profil_modif.jsp";
		Utilisateurs u = new Utilisateurs();
		ProfilModel model = new ProfilModel();

		// r�cup�re la session
		HttpSession session = request.getSession();

		// vers modifier
		if (request.getSession().getAttribute("user") != null) {
			next = "/WEB-INF/profil_modif.jsp";
		}

		// Form validation modif utilisateur
		if (request.getParameter("BT_ENREGISTRER") != null) {
			try {
				// r�cupr�ration des donn�es du formulaire
				u.setId(((Utilisateurs) session.getAttribute("user")).getId());
				u.setPseudo(request.getParameter("pseudo"));
				u.setNom(request.getParameter("name"));
				u.setPrenom(request.getParameter("surname"));
				u.setEmail(request.getParameter("mail"));
				u.setTelephone(request.getParameter("tel"));
				u.setRue(request.getParameter("street"));
				u.setCode_postal(request.getParameter("cp"));
				u.setVille(request.getParameter("city"));

				String mot_de_passe_actuel = request.getParameter("pass_actuel");
				String mot_de_passe_confirme1 = request.getParameter("pass_new");
				String mot_de_passe_confirme2 = request.getParameter("pass-confirm");

				if (mot_de_passe_confirme1.equals(mot_de_passe_confirme2) && !mot_de_passe_confirme1.isEmpty()
						&& !mot_de_passe_confirme2.isEmpty()) {
					u.setMot_de_passe(request.getParameter("pass_new"));

					System.out.println("passe");
					System.out.println("toto " + u);
					manager.updateUtilisateur(u);

					// modification de la session
					request.getSession().setAttribute("user", u);

					next = "/WEB-INF/profil.jsp";

				} else {
					 model.setMessage("Les mots de passes entrées sont nuls ou ne sont pas identiques");
				}
			} catch (UtilisateursException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Form supp utilisateur
		if (request.getParameter("BT_SUPP") != null) {

			try {
				u.setId(((Utilisateurs) session.getAttribute("user")).getId());
				manager.delUtilisateur(u);

				request.getSession().removeAttribute("user");

				if (u == null) {
					next = "/WEB-INF/home.jsp";
				}

			} catch (UtilisateursException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
