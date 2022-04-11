package fr.eni.encheres.ihm.articles;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.articlesvendus.ArticlesVendusManager;
import fr.eni.encheres.bll.articlesvendus.ArticlesVendusManagerSing;
import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bll.categories.CategoriesManagerSing;
import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.ihm.categories.CategoriesModel;
import fr.eni.encheres.ihm.profil.ProfilModel;

/**
 * Servlet implementation class ArticlesServlet
 */
@WebServlet("/ArticlesServlet")
public class ArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticlesVendusManager manager = ArticlesVendusManagerSing.getInstance();
	private CategoriesManager manager2 = CategoriesManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticlesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticlesModel model2 = new ArticlesModel();
		ProfilModel model = new ProfilModel();
		CategoriesModel model3 = new CategoriesModel();
		String next = "/WEB-INF/article.jsp";

		//récupère la session
		HttpSession session = request.getSession();

		// Affichage de la liste des catégories
		try {
			model3.setLstCategories(manager2.getAllCategories());
		} catch (CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(request.getParameter("BT_VALID")!=null) {
			//récuprération des données du formulaire
			model2.setNomArticle(request.getParameter("article"));
			model2.setDescription(request.getParameter("description"));
			model2.setCategorie(((Categories) session.getAttribute("categories")));
			model2.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));
			model2.setDateDebutEncheres(LocalDate.parse(request.getParameter("dateDebutEncheres")));
			model2.setDateFinEncheres(LocalDate.parse(request.getParameter("dateFinEncheres")));
			model2.setNomArticle(request.getParameter("article"));
			
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
