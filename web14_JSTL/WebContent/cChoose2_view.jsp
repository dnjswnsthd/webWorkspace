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
	<h2>c:choose문법 사용하기</h2>
	<c:choose>
		<c:when test="${param.NUM=='1'}">
			<b>ㅎㅇ ㅂㅇ</b>
		</c:when>
		<c:when test="${param.NUM=='2'}">
			<b>그럭저럭 잘 지내고 있어요.</b>
		</c:when>
		<c:otherwise>
			<b>부재중</b>
		</c:otherwise>
	</c:choose>
</body>
</html>