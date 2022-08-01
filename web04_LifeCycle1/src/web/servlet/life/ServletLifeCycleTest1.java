package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Life1")
public class ServletLifeCycleTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;

	public ServletLifeCycleTest1() { // Servlet 생성할때... Container가 DD일 읽은 후
		System.out.println("1. 서블릿 객체가 생성...컨테이너에 의해서...");
	}

	public void init() throws ServletException {
		System.out.println("2. init() 호출...컨테이너에 의해서...");
	}

	public void destroy() {
		System.out.println("4. destroy() 호출...컨테이너에 의해서...");// 서버가 내려갈때
	}

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
		System.out.println("3. servie() 호출 --> doGet()/doPost()재호출...컨테이너에 의해서...");
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method....</h3>");
		out.println("<b>Count :: </b>" + ++count);
		out.println("</body></html>");
		out.close();

	}

}
