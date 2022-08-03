<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이것은 원래 서블릿입니다.</h2>
	<h2>Attribute에 바인딩된 값 EL로 받아오기</h2>
	<%
		int sum = 0;
		for (int cnt = 0; cnt <= 50; cnt++)
			sum += cnt;

		// 내장 객체 (시험 내장 객체중에 servletContext에 해당하는 것은 ? application)
		request.setAttribute("RESULT", sum); //문제 냈음 RESULT는 변수가 아니다. getter기 떄문에 
		session.setAttribute("RESULT", "session");
		application.setAttribute("NAME", "BNK");

		request.getRequestDispatcher("EL1_View.jsp").forward(request, response);
	%>
</body>
</html>