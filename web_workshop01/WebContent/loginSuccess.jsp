<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/loginSuccess.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 id="successLogin"><%=request.getParameter("id")%>
		님이 로그인 하셨습니다.
	</h3>
	<hr>
	<div id="link">
		<a href="#" style="text-align:center;">도서 등록</a><br><br>
		<a href="login.html">로그아웃</a>
	</div>
</body>
</html>