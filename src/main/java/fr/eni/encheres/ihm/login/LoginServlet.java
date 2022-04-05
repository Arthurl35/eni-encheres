package fr.eni.encheres.ihm.login;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "/WEB-INF/login.jsp";
		
		//test si déjà connecté
		HttpSession session = request.getSession();
		if((String)session.getValue("user") != null) next = "HomeServlet";
		
		if(request.getParameter("BT_VALID")!=null) {
			if(!request.getParameter("pseudo").equals("") && !request.getParameter("pass").equals("")) {
				//test login
				if(true) {
					//connect user
					request.getSession().setAttribute("user", request.getParameter("pseudo"));
					//redirect home
					next = "HomeServlet";
				}
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
