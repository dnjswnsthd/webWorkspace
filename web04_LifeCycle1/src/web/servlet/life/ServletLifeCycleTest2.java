package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation ---> XML
public class ServletLifeCycleTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;

	public ServletLifeCycleTest2() { // Servlet 생성할때... Container가 DD일 읽은 후
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
		// 클라이언트의 서비스를 수행... 수행결과 데이터를 jsp페이저로 연결...
		count = 1004;
		out.println("<a href=life2.jsp?cnt=" + count + ">life2.jsp</a>");
		// 브라우저로 일단 응답을 하지않고 ...서버안에서 바로 jsp로 연결....응답을 jsp가 한다.
//		request.getRequestDispatcher("life2.jsp?cnt=" + count).forward(request, response);;
		out.close();
	}
}
