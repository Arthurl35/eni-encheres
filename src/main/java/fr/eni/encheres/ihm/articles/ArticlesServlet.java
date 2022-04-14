package fr.eni.encheres.ihm.articles;

import java.io.IOException;
import java.time.LocalDate;

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

import fr.eni.encheres.bll.retraits.RetraitsException;
import fr.eni.encheres.bll.retraits.RetraitsManager;
import fr.eni.encheres.bll.retraits.RetraitsManagerSing;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.ihm.categories.CategoriesModel;
import fr.eni.encheres.ihm.profil.ProfilModel;



/**
 * Servlet implementation class ArticlesServlet
 */
@WebServlet("/ArticlesServlet")
public class ArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticlesVendusManager manager = ArticlesVendusManagerSing.getInstance();
	private CategoriesManager managerCategorie = CategoriesManagerSing.getInstance();
	private RetraitsManager managerRetrait = RetraitsManagerSing.getInstance();

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
		ProfilModel modelProfil = new ProfilModel();
		ArticlesModel modelArticles = new ArticlesModel();
		CategoriesModel modelCategories = new CategoriesModel();
		
		String next = "/WEB-INF/article.jsp";

		
		//test si bien connect�
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			next = "";
		}
		else{modelArticles.setUtilisateur((Utilisateurs)session.getAttribute("user"));}

		// Affichage de la liste des cat�gories
		try {
			modelCategories.setLstCategories(managerCategorie.getAllCategories());
		} catch (CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(request.getParameter("BT_VALID")!=null) {
			//r�cupr�ration des donn�es du formulaire
			modelArticles.setNomArticle(request.getParameter("article"));
			modelArticles.setDescription(request.getParameter("description"));
			try {
				modelArticles.setCategorie(managerCategorie.getCategoriById(Integer.parseInt(request.getParameter("categories"))));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CategoriesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if(!modelArticles.getNomArticle().equals("")
					&& !modelArticles.getDescription().equals("")
					&& !modelArticles.getCategorie().equals(null)
					&& !(modelArticles.getMiseAPrix() != null)
					&& !(modelArticles.getDateDebutEncheres() != null)
					&& !(modelArticles.getDateFinEncheres() != null)) {
				
				modelArticles.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));
				modelArticles.setDateDebutEncheres(LocalDate.parse(request.getParameter("dateDebutEncheres")));
				modelArticles.setDateFinEncheres(LocalDate.parse(request.getParameter("dateFinEncheres")));
				
				//cr�ation articles
				ArticleVendu article = new ArticleVendu(modelArticles.getNomArticle(), modelArticles.getDescription(), modelArticles.getCategorie(), modelArticles.getMiseAPrix(), 
										modelArticles.getDateDebutEncheres(), modelArticles.getDateFinEncheres());
				article.setUtilisateur(modelArticles.getUtilisateur());
				article.setPrixVente(0);
				article.setEtatVente(0);
				try {
					manager.addArticle(article);
					next = "";
				} catch (ArticlesVendusException e) {
					modelArticles.setMessage(e.getMessage());
				}
				
				Retraits retrait = new Retraits(article, request.getParameter("street"), request.getParameter("cp"), request.getParameter("city"));
				
				try {
					managerRetrait.addRetrait(retrait);
					next = "";
				}
				catch (RetraitsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			else {
				modelArticles.setMessage("Champs manquant !");
			}
		
		}
		

		request.setAttribute("modelProfil", modelProfil);
		request.setAttribute("modelArticles", modelArticles);
		request.setAttribute("modelCategories", modelCategories);
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
