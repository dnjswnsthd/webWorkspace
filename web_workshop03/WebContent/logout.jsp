<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	User vo = (User) session.getAttribute("vo");
	if (vo == null) {
%>
<h2>
	<a href="login.html">로그인 하기</a>
</h2>
<%
	} else { // 로그인 된 상태...
		session.invalidate(); // 세션을 unbind시킴
	}
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.logout{
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("LOG OUT~~!!");
	}
</script>
</head>
<body onload="return logout()">
	<div class="logout">
		<h2>로그아웃 되셨습니다...</h2>
		<hr>
		<a href="login.html">LoginPage로 돌아가기</a>
	</div>
</body>
</html>