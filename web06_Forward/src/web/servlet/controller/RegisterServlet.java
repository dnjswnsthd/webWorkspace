package web.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
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
		/*
		 * 1. 양방향 한글처리
		 * 2. 폼값 받는다.
		 * 3. (받은 값을 바탕으로 vo생성)
		 * 4. DAO 리턴받는다.
		 * 5. 비지니스 호출... (반환값 나온다)
		 * 6. 페이지 이동(네비게이션)
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset-utf-8");
		Member member = new Member(request.getParameter("name"), Integer.parseInt(request.getParameter("age")), request.getParameter("address"));
		RequestDispatcher rdp = request.getRequestDispatcher("result.jsp");
		rdp.forward(request, response);
	}
}
