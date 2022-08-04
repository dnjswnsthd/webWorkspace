package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 회원 가입 요청을 서비스 하는 로직을 작성...
		// 이전의 RegisterServlet 서비스 안의 내용이 여기에...
		MemberVO pvo = new MemberVO(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("address"));
		String path = "index.jsp";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path);
	}
}
