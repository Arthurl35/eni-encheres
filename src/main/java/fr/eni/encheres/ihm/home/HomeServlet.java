package fr.eni.encheres.ihm.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.categories.CategoriesException;
import fr.eni.encheres.bll.categories.CategoriesManager;
import fr.eni.encheres.bll.categories.CategoriesManagerSing;
import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.ihm.categories.CategoriesModel;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CategoriesManager manager = CategoriesManagerSing.getInstance();
    
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
		if(session.getAttribute("user") != null) {
			model.setUser((Utilisateurs)session.getAttribute("user"));
			model.setPseudo(model.getUser().getPseudo());
		}
		
		//Affichage de la liste des catégories
		try {
			model2.setLstCategories(manager.getAllCategories());
		} catch (CategoriesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//déconnection
		if(request.getParameter("BT_LOGOUT")!= null && model.getUser() != null) {
			session.invalidate();
			model.setUser(null);
		}
		
		//mon profil
		if(request.getParameter("BT_PROFIL") != null && session.getAttribute("user")!= null) {
			//redirect profil
			next = "/WEB-INF/profil.jsp";
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
