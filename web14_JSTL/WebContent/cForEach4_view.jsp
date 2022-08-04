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
	<h2>우리 가게 과일</h2>
	<c:forEach var="item" items="${list}"> <!-- 문제냈어요 item은 변수일 뿐 ${list}는 getAttribute인거고 -->
		<li>${item}</li> <!-- 출력할때는 el로 써야한다. getter로 -->
	</c:forEach>
</body>
</html>