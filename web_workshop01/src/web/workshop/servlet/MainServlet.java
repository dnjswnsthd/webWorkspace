package web.workshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String bnkId = "";
	private String bnkPw = "";

	public MainServlet() {
	}

	public void init() throws ServletException {
		bnkId = getInitParameter("ID");
		bnkPw = getInitParameter("PW");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id").equals(bnkId) && request.getParameter("pw").equals(bnkPw)) {
			RequestDispatcher rdp = request.getRequestDispatcher("loginSuccess.jsp?id=" + bnkId);			
			rdp.forward(request, response);
		}else {
			RequestDispatcher rdp = request.getRequestDispatcher("loginError.jsp");			
			rdp.forward(request, response);
		}
	}
}
