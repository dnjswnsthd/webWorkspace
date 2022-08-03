package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		// 로직은 여기서 작성
		/* 
		 * 문제냄
		 * 1. 한글 처리
		 * 2. 폼 값 받아
		 * 3. (VO생성)
		 * 4. DAO 리턴 .. 비지니스로직 호출..
		 * 5. ATTRIBUTE에 바인딩 .. 로그인하는 동안 VO 정보를 저장...HttpSession에 저장
		 * 6. 네비게이션
		 */

		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "index.html";
		try {
			MemberVO rvo = dao.login(id, password);
			// 요청하면 세션은 서버에 자동적으로 만들어지고.. 개발자는 그걸 받아서 사용
			HttpSession session = request.getSession();
			if(rvo != null) { // 로그인 성공시에만 바인딩 진행...
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: " + session.getId());
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
