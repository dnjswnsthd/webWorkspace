package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		// session 죽이는 로직
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("vo") != null) { // session 로그인, 회원정보수정
				session.invalidate();
				path = "logout.jsp";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path, true);
	}

}
