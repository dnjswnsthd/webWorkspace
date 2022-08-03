<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- html 주석 -->
<%--jsp 주석
	로그인 되어져 있다면... 세션은 invalidate 시킵니다.
 --%>
<%
	MemberVO vo = (MemberVO) session.getAttribute("vo");
	if (vo == null) { //로그인 안되었다면
%>
<h2>
	<a href="login.jsp">로그인 하기</a>
</h2>
<%
	} else { // 로그인 된 상태...
		session.invalidate(); // 세션을 unbind시킴
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout(){
		alert("LOG OUT~~!!");
	}
</script>
</head>
<body onload="return logout()">
	<b>로그아웃 되셨습니다...</b><br>
	<a href="index.html">HOME</a>
</body>
</html>