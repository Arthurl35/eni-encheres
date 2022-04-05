package fr.eni.encheres.ihm.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "/WEB-INF/register.jsp";
		RegisterModel model = new RegisterModel();
		
		//test si déjà connecté
		HttpSession session = request.getSession();
		if((String)session.getValue("user") != null) next = "HomeServlet";
		
		if(request.getParameter("BT_VALID")!= null) {
			
			model.setPseudo(request.getParameter("pseudo"));
			model.setNom(request.getParameter("name"));
			model.setPrenom(request.getParameter("surname"));
			model.setEmail(request.getParameter("mail"));
			model.setTelephone(request.getParameter("tel"));
			model.setRue(request.getParameter("street"));
			model.setCode_postal(request.getParameter("cp"));
			model.setVille(request.getParameter("city"));
			model.setMot_de_passe(request.getParameter("pass"));
			model.setMot_de_passe_confirm(request.getParameter("pass-confirm"));
			
			if(!model.getPseudo().equals("")
					&& !model.getNom().equals("")
					&& !model.getPrenom().equals("")
					&& !model.getEmail().equals("")
					&& !model.getTelephone().equals("")
					&& !model.getRue().equals("")
					&& !model.getCode_postal().equals("")
					&& !model.getVille().equals("")
					&& !model.getMot_de_passe().equals("")
					&& !model.getMot_de_passe_confirm().equals("")) {
				
				//test inscription
				if(true) {
					//connect user
					request.getSession().setAttribute("user", request.getParameter("pseudo"));
					//redirect home
					next = "HomeServlet";
				}
			}
		}
		else if(request.getParameter("BT_ANNUL")!= null) {
			next = "HomeServlet";
		}
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
