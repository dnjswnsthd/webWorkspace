<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User vo = (User) session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.main{
	text-align: center;
}
.title{
	margin-left: 400px;
	margin-right: 400px;
	border: 1px solid purple;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main">
		<h2 class="title"><%=vo.getName()%> 님이  로그인 되었습니다.!!!</h2>
		<hr color="purple">
		<br>
		<a href="Book/Book.html">도서 등록</a><br><br>
		<a href="logout.jsp">로그아웃</a>
	</div>
</body>
</html>