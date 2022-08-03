<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Attribute에 바인딩된 값을 jsp 결과페이지에서 받아와서 출력합니다.</h2>
	<b>1~50까지의 총합 결과 값 1) :: </b>
	<br>
	<%=request.getAttribute("RESULT")%><br>
	<%=session.getAttribute("RESULT")%><br>
	<%=application.getAttribute("NAME")%><br>
	
	<hr>
	
	<b>1~50까지의 총합 결과 값 1) :: </b><br>
	${RESULT} <br>
	${requestScope.RESULT} <br>
	${sessionScope.RESULT} <br>
	${applicationScope.NAME} <br>
	${RESULT + 100}
</body>
</html>