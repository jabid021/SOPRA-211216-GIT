package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import formationJpa.model.Adresse;
import formationJpa.model.Civilite;
import formationJpa.model.Employe;
import formationJpa.services.EmployeService;

/**
 * Servlet implementation class EmployeController
 */
@WebServlet("/employe")
public class EmployeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeService employeService;

	@Override
	public void init() throws ServletException {
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) getServletContext()
				.getAttribute("ctxSpring");
		employeService = ctx.getBean(EmployeService.class);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeController() {
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
		} else if (q.equals("add")) {
			rd = add(request, response);
		} else if (q.equals("edit")) {
			rd = edit(request, response);
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
		save(request, response).forward(request, response);
	}

	public RequestDispatcher goList(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("employes", employeService.getAll());
		return request.getRequestDispatcher("/WEB-INF/employe/list.jsp");
	}

	public RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("employe", employeService.getById(id));
		return goFormEdit(request, response);
	}

	public RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("employe", new Employe());
		return goFormEdit(request, response);
	}

	private RequestDispatcher goFormEdit(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("civilites", Civilite.values());
		return request.getRequestDispatcher("/WEB-INF/employe/edit.jsp");
	}

	public RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("id"));
		employeService.delete(id);
		return goList(request, response);
	}

	public RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		String idEnString = request.getParameter("id");
		Long id = null;
		if (idEnString != null && !idEnString.isEmpty()) {
			id = Long.parseLong(idEnString);
		}
		Employe e = new Employe();
		e.setId(id);
		e.setNom(request.getParameter("nom"));
		e.setPoste(request.getParameter("poste"));
		e.setSalaire(Double.parseDouble(request.getParameter("salaire")));
		e.setCommission(Double.parseDouble(request.getParameter("commission")));
		e.setAdresse(new Adresse(request.getParameter("numero"), request.getParameter("rue"),
				request.getParameter("codePostal"), request.getParameter("ville")));
		e.setCivilite(Civilite.valueOf(request.getParameter("civilite")));
		e.setDateEmbauche(LocalDate.parse(request.getParameter("dateEmbauche")));
		employeService.save(e);
		return goList(request, response);
	}
}
