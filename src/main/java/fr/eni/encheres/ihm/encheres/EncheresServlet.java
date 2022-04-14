package fr.eni.encheres.ihm.encheres;

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
import fr.eni.encheres.bll.encheres.EncheresException;
import fr.eni.encheres.bll.encheres.EncheresManager;
import fr.eni.encheres.bll.encheres.EncheresManagerSing;
import fr.eni.encheres.bll.utilisateurs.UtilisateursException;
import fr.eni.encheres.bo.Encheres;
import fr.eni.encheres.bo.Utilisateurs;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/EncheresServlet")
public class EncheresServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EncheresManager managerEncheres = EncheresManagerSing.getInstance();
	private ArticlesVendusManager managerArticles = ArticlesVendusManagerSing.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncheresServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncheresModel model = new EncheresModel();

		String next = "/WEB-INF/enchere.jsp";
		
		//test si bien connecté
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null) {
			model.setUser((Utilisateurs)session.getAttribute("user"));

			//test si idArticle valide
			try {
				model.setArticle(managerArticles.getById(Integer.parseInt(request.getParameter("idArticle"))));
			} catch (NumberFormatException | ArticlesVendusException | UtilisateursException | CategoriesException e) {
				e.printStackTrace();
			}
			
			if(model.getArticle() == null)next = "";
			else {
				//récup les enchères d'un article
				try {
					model.setLstEncheres(managerEncheres.getById(model.getArticle().getNoArticle()));
				} catch (EncheresException | ArticlesVendusException | UtilisateursException | CategoriesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//enchérir
				if(request.getParameter("BT_OFFRE") != null) {
					if(Integer.parseInt(request.getParameter("montant")) > model.getArticle().getMiseAPrix()) {
						if(model.getLstEncheres().size() > 0) {
							if(Integer.parseInt(request.getParameter("montant")) > model.getLstEncheres().get(0).getMontant_enchere()) {
								Encheres enchere = new Encheres(LocalDate.now(), Integer.parseInt(request.getParameter("montant")), model.getUser(), model.getArticle());
								try {
									managerEncheres.addEnchere(enchere);
								} catch (EncheresException e) {
									e.printStackTrace();
								}
							}
							else model.setMessage("Offre insufisante !");
						}
						else {
							Encheres enchere = new Encheres(LocalDate.now(), Integer.parseInt(request.getParameter("montant")), model.getUser(), model.getArticle());
							try {
								managerEncheres.addEnchere(enchere);
							} catch (EncheresException e) {
								e.printStackTrace();
							}
						}
					}
					else model.setMessage("Offre insufisante !");
				}
				
				//récup les enchères d'un article
				try {
					model.setLstEncheres(managerEncheres.getById(model.getArticle().getNoArticle()));
				} catch (EncheresException | ArticlesVendusException | UtilisateursException | CategoriesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else next = "LoginServlet";
		
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
