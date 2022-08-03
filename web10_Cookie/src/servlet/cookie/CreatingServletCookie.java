package servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie1")
public class CreatingServletCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 쿠키 생성
		Cookie c1 = new Cookie("id", "bnk");
		Cookie c2 = new Cookie("today", "2022-08-03");

		// 2. 쿠키 유효시간을 지정...setMaxAge()
		c1.setMaxAge(24 * 60 * 60); // 하루동안....브라우저....
		c2.setMaxAge(0); // 쿠키사용안하는 효과

		//
		response.addCookie(c1);
		response.addCookie(c2);
		
		// 페이지 이동방법중 다시 브라우저를 거쳐서 서버로 요청이 들어가기 위해서는 redirect 방법으로 페이지 이동
		response.sendRedirect("getCookies.jsp");
	}

}
