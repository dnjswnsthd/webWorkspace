<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">회원 전체 명단 보기</h2>
	<table border="2" width="350" bgcolor="green">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
			</tr>
		</thead>
		<%
			for (MemberVO vo : list) {
		%>
		<tr>
			<td><%=vo.getId()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getAddress()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<h3 align="center">
		<a href="index.html">HOME...</a>
	</h3>
</body>
</html>