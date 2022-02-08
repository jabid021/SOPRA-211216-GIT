package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoScopeController
 */
@WebServlet("/demoScope")
public class DemoScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DemoScopeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Request=>Model
		request.setAttribute("requete", "un truc dans le modele");
		// Session
		HttpSession session = request.getSession();
		session.setAttribute("session", "un truc dans la session");
		// Variable d'application
		ServletContext application = request.getServletContext();
		application.setAttribute("application", "un truc en application");
		// Cookie
		Cookie cookie = new Cookie("moncookie", "le_contenu_du_cookie");
		cookie.setMaxAge(3600 * 24);
		response.addCookie(cookie);
		request.getRequestDispatcher("/WEB-INF/demoScope.jsp").forward(request, response);

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
