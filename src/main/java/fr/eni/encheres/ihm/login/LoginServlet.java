package fr.eni.encheres.ihm.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.utilisateurs.UtilisateursManager;
import fr.eni.encheres.bll.utilisateurs.UtilisateursManagerSing;
import fr.eni.encheres.bo.Utilisateurs;

/**
 * Servlet implementation class VoteServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UtilisateursManager manager = UtilisateursManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String next = "/WEB-INF/login.jsp";
		LoginModel model = new LoginModel();

		// test si déjà connecté
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			model.setUser((Utilisateurs) session.getAttribute("user"));
			next = "";
		}

		if (request.getParameter("BT_VALID") != null) {
			if (!request.getParameter("pseudo").equals("") && !request.getParameter("pass").equals("")) {
				model.setPseudo(request.getParameter("pseudo"));

				Cookie userName = new Cookie("userName", request.getParameter("pseudo"));
				// Set expiry date after 24 Hrs for both the cookies.
				userName.setMaxAge(60 * 60 * 24);

				// Add both the cookies in the response header.
				response.addCookie(userName);

				try {
					// test login
					Utilisateurs user = manager.connect(model.getPseudo(), request.getParameter("pass"));

						if (user != null) {
							
								// connect user
								request.getSession().setAttribute("user", user);
								// redirect home
								next = "";							
					} else
						model.setMessage("Pseudo et/ou mot de passe incorrect !");
				} catch (Exception e) {
					model.setMessage(e.getMessage());
				}
			} else
				model.setMessage("Veuillez renseigner le pseudo et le mot de passe !");
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
