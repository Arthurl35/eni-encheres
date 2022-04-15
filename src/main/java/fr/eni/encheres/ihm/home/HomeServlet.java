package fr.eni.encheres.ihm.home;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import fr.eni.encheres.bll.encheres.EncheresException;
import fr.eni.encheres.bll.encheres.EncheresManager;
import fr.eni.encheres.bll.encheres.EncheresManagerSing;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.ihm.categories.CategoriesModel;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CategoriesManager managerCategories = CategoriesManagerSing.getInstance();
	private ArticlesVendusManager managerArticles = ArticlesVendusManagerSing.getInstance();
	private EncheresManager managerEncheres = EncheresManagerSing.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeModel model = new HomeModel();
		CategoriesModel model2 = new CategoriesModel();
		String next = "/WEB-INF/home.jsp";
		
		//récupère la session
		HttpSession session = request.getSession();
		  session.setMaxInactiveInterval(300);    // session timeout dans 5 minutes
		if(session.getAttribute("user") != null) {
			model.setUser((Utilisateurs)session.getAttribute("user"));
			model.setPseudo(model.getUser().getPseudo());
		}
		
		
		//MAJ ETAT ARTICLE
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		try {
			lstArticles = managerArticles.getAllArticles();
		} catch (ArticlesVendusException | UtilisateursException | CategoriesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (ArticleVendu article : lstArticles) {
			//vérifie si etat doit être ouvert
			if(article.getEtatVente().equals(0) && (article.getDateDebutEncheres().isEqual(LocalDate.now()) && article.getDateFinEncheres().isAfter(LocalDate.now()) || article.getDateDebutEncheres().isBefore(LocalDate.now()) && article.getDateFinEncheres().isAfter(LocalDate.now()))){
				//modifier etat a ouvert (1)
				article.setEtatVente(1);
				try {
					managerArticles.updateArticle(article);
				} catch (ArticlesVendusException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//vérifie si etat doit être fermé
			if((article.getEtatVente().equals(1) ||  article.getEtatVente().equals(0)) && (article.getDateFinEncheres().isEqual(LocalDate.now()) || article.getDateFinEncheres().isBefore(LocalDate.now()))){
				//modifier etat a fermer (2)
				article.setEtatVente(2);
				
				//ajout utilisateur gagnant a l'article vendu
				List<Encheres> lstEncheres = new ArrayList<Encheres>();
				try {
					lstEncheres = managerEncheres.getById(article.getNoArticle());
				} catch (EncheresException | ArticlesVendusException | UtilisateursException | CategoriesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//test si encheres existe sinon le gagnant est le propriétaire
				if(lstEncheres.size() > 0) {
					article.setUtilisateurWin(lstEncheres.get(0).getUtilisateur());
					article.setPrixVente(lstEncheres.get(0).getMontant_enchere());
				}
				else {
					article.setUtilisateurWin(model.getUser());
				}
				
				try {
					managerArticles.updateArticleWin(article);
				} catch (ArticlesVendusException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		//Affichage de la liste des catï¿½gories
		try {
			model2.setLstCategories(managerCategories.getAllCategories());
		} catch (CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dï¿½connection
		if(request.getParameter("BT_LOGOUT")!= null && model.getUser() != null) {
			session.invalidate();
			model.setUser(null);
		}
		
		//mon profil
		if(request.getParameter("BT_PROFIL") != null && session.getAttribute("user")!= null) {
			//redirect profil
			next = "/WEB-INF/profil.jsp";
		}
		
		//Les articles 
		try {
			model.setLstArticles(managerArticles.getAllArticles());
		} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//filtres achat et vente
		if(request.getParameter("filtrer") != null) {
			if(request.getParameter("radios").equals("achat")) {
				if(request.getParameter("boxAchatOuvert") == null && request.getParameter("boxAchatEncours") == null && request.getParameter("boxAchatRemporte") == null) {
				//getAllArticles
				}
				else {
					model.setLstArticles(null);
					if(request.getParameter("boxAchatOuvert") != null) {
						//Les articles ouvert
						try {
							model.setLstArticles(managerArticles.getAllArticlesByEtat(1));
						} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(request.getParameter("boxAchatEncours") != null) {
						//Les articles en cours d'enchère
						try {
							model.setLstArticles(managerArticles.getAllArticlesByEnchereUser(model.getUser()));
						} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(request.getParameter("boxAchatRemporte") != null) {
						//Les articles gagné
						try {
							model.setLstArticles(managerArticles.getAllArticlesWinByUser(model.getUser()));
						} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			else if(request.getParameter("radios").equals("vente")) {
				model.setLstArticles(null);
				if(request.getParameter("boxVenteEncours") == null && request.getParameter("boxVenteNondebute") == null && request.getParameter("boxVenteTermine") == null) {
					try {
						model.setLstArticles(managerArticles.getAllArticlesByUser(model.getUser()));
					} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					if(request.getParameter("boxVenteEncours") != null) {
						try {
							model.setLstArticles(managerArticles.getAllArticlesByEtatAndUser(1, model.getUser()));
						} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(request.getParameter("boxVenteNondebute") != null) {
						try {
							model.setLstArticles(managerArticles.getAllArticlesByEtatAndUser(0, model.getUser()));
						} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(request.getParameter("boxVenteTermine") != null) {
						try {
							model.setLstArticles(managerArticles.getAllArticlesByEtatAndUser(2, model.getUser()));
						} catch (ArticlesVendusException | UtilisateursException | CategoriesException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
//TODO filtre categorie and search with filtre of check box
		//filtre categories
		if(request.getParameter("BTN_SEARCH") != null) {
			if(Integer.parseInt(request.getParameter("choixCategorie")) > 0) {
				try {
					//get articles by catégorie
					model.setLstArticles(managerArticles.getAllArticlesByCategorie(managerCategories.getCategoriById(Integer.parseInt(request.getParameter("choixCategorie")))));
				} catch (NumberFormatException | ArticlesVendusException | UtilisateursException | CategoriesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//search (sans bdd)
			if(!request.getParameter("search").equals("")) {
				//get articles by catégorie
				lstArticles = model.getLstArticles();
				
				List<ArticleVendu> lstArticlesSearch = new ArrayList<ArticleVendu>();
				
				for (ArticleVendu article : lstArticles) {
					if(article.getNomArticle().contains(request.getParameter("search"))) {
						lstArticlesSearch.add(article);
					}
				}
				model.setLstArticles(lstArticlesSearch);
			}
			else System.out.println("pas recherche");
		}
		
		
		
		
		request.setAttribute("model", model);
		request.setAttribute("model2", model2);
		request.getRequestDispatcher(next).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
