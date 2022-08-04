<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>LOGIN INFORMATION...</h2>
	ID ${vo.id} <br>
	NAME ${vo.name} <br>
	ADDRESS ${vo.address} <br>
	<hr>
	<a href="logout.jsp">LOGOUT</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="index.jsp">HOME</a>
</body>
</html>