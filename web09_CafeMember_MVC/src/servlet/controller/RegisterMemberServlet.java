package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Register")
public class RegisterMemberServlet extends HttpServlet {
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
		//로직은 여기서 작성
		/*
		 * 1. 한글처리
		 * 2. 폼값 받는다.
		 * 3. vo
		 * 4. dao
		 * 5. 비지니스 로직 호출
		 * 6. nevigation....register.jsp 
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		MemberVO member = new MemberVO(request.getParameter("id"), request.getParameter("password"), request.getParameter("name"), request.getParameter("address"));
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			dao.registerMember(member);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect("AllMember");
	}
}
