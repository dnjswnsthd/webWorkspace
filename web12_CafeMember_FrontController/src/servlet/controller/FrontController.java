package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
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
		// command로 넘어온 값에 따라서 요청을 알수 있고 요청에 해당하는 메소드를 하나씩 이곳에서 연결시킨다.
		String command = request.getParameter("command");
		String path = "index.html";

		if (command.equals("register")) {
			path = register(request, response);
		} else if (command.equals("find")) {
			path = find(request, response);
		} else if (command.equals("login")) {
			path = login(request, response);
		} else if(command.equals("showAll")) {
			path = showAll(request, response);
		}
		
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);

	}


	// doProcess
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원 가입 요청을 서비스 하는 로직을 작성...
		// 이전의 RegisterServlet 서비스 안의 내용이 여기에...
		MemberVO pvo = new MemberVO(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("address"));
		String path = "index.html";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";

		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			if (vo != null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {

		}
		return path;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "index.html";
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			// 요청하면 세션은 서버에 자동적으로 만들어지고.. 개발자는 그걸 받아서 사용
			HttpSession session = request.getSession();
			if (rvo != null) { // 로그인 성공시에만 바인딩 진행...
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: " + session.getId());
				path = "login_result.jsp";
			}
		} catch (SQLException e) {
			
		}
		return path;
	}
	private String showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.html"; 
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();
			path = "AllView.jsp";
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		return path;
	}
}
