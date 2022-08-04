package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		MemberVO pvo = new MemberVO(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("address"));
		try {
			MemberDAOImpl.getInstance().update(pvo);
			HttpSession session = request.getSession();
			if (session.getAttribute("vo") != null) {
				session.setAttribute("vo", pvo);
			}
			path = "update_result.jsp";
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}
}
