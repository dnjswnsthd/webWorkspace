package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
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
		 * 한글처리..양방향
		 * Form 값 받는다. 
		 * request 받은 값을 브라우저로 출력 .. 응답 response
		 */
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] tech = request.getParameterValues("tech");
		
		// 응답시 한글 처리
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<html><body><h2> 폼 값에 입력된 정보를 출력합니다. ");
		out.println("<li>당신의 아이디 : " + id + "</li>");
		out.println("<li>당신의 패스워드: " + password + "</li>");
		out.println("<li>당신의 성별 : " + gender + "</li>");
		out.println("<b>당신의 기술 : </b><br>");
		String techs = "";
		for (String t : tech)
			techs += t + " ";
		out.println(techs);
		out.println("</body></html");
	}
}
