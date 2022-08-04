<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">회원 전체 명단 보기</h2>
	<table align="center" border="2" width="350" bgcolor="green">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.address}</td>
			</tr>
		</c:forEach>
	</table>
	<h3 align="center">
		<a href="index.jsp">HOME...</a>
	</h3>
</body>
</html>