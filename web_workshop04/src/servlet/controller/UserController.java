package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.User;
import servlet.model.UserDAOImpl;
@WebServlet("/user.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String command = request.getParameter("command");
		Controller controller = UserControllerFactory.getInstance().createController(command);
		ModelAndView mv = controller.handleRequest(request, response);
		if(mv != null) { 
			if(mv.isRedirect()) response.sendRedirect(mv.getPath());
			else  request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
		
	}
}
