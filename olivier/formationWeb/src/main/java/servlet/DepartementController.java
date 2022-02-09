package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationJpa.services.DepartementService;

/**
 * Servlet implementation class DepartementController
 */
@WebServlet("/departement")
public class DepartementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DepartementService departementService;

	@Override
	public void init() throws ServletException {
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) getServletContext()
				.getAttribute("ctxSpring");
		departementService = ctx.getBean(DepartementService.class);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartementController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String q = request.getParameter("q");
		if (q == null || q.isEmpty()) {
			rd = goList(request, response);
		} else if (q.equals("delete")) {
			rd = delete(request, response);
		}
		rd.forward(request, response);
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

	private RequestDispatcher goList(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("departements", departementService.getAll());
		return request.getRequestDispatcher("/WEB-INF/departement/list.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		departementService.deleteById(id);
		return goList(request, response);
	}

}
