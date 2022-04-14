package fr.eni.encheres.ihm.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusException;
import fr.eni.encheres.bll.articlesvendus.ArticlesVendusManager;
import fr.eni.encheres.bll.articlesvendus.ArticlesVendusManagerSing;
import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bll.categories.CategoriesManagerSing;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.ihm.categories.CategoriesModel;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CategoriesManager manager = CategoriesManagerSing.getInstance();
	private ArticlesVendusManager managerArticles = ArticlesVendusManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HomeModel model = new HomeModel();
		CategoriesModel model2 = new CategoriesModel();
		String next = "/WEB-INF/home.jsp";

		// r�cup�re la session
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300); // session timeout dans 5 minutes
		if (session.getAttribute("user") != null) {
			model.setUser((Utilisateurs) session.getAttribute("user"));
			model.setPseudo(model.getUser().getPseudo());
		}

		// Affichage de la liste des cat�gories
		try {
			model2.setLstCategories(manager.getAllCategories());
		} catch (CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// d�connection
		if (request.getParameter("BT_LOGOUT") != null && model.getUser() != null) {
			session.invalidate();
			model.setUser(null);
		}

		// mon profil
		if (request.getParameter("BT_PROFIL") != null && session.getAttribute("user") != null) {
			// redirect profil
			next = "/WEB-INF/profil.jsp";
		}

		// Les articles
		try {
			model.setLstArticles(managerArticles.getAllArticles());
		} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//filtres
		if(request.getParameter("filtrer") != null) {
			if(request.getParameter("radiosAchat") != null) {
				if(request.getParameter("boxOuvert") != null)System.out.println("ouvert");
				if(request.getParameter("boxEncours") != null)System.out.println("encours");
				if(request.getParameter("boxRemporte") != null)System.out.println("remporte");
			}
			else if(request.getParameter("radiosVente") != null) {
				if(request.getParameter("boxEncours") != null)System.out.println("ouvert");
				if(request.getParameter("boxNondebute") != null)System.out.println("encours");
				if(request.getParameter("boxTermine") != null)System.out.println("remporte");
			}
		}
		
		
		request.setAttribute("model", model);
		request.setAttribute("model2", model2);
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
