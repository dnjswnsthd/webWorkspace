<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2 {
	text-align: center;
	color: purple
}
.wrap{
	margin-left : 220px;
}
</style>
<script type="text">	
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">REGISTER MEMBER FORM</h2>
	<div class="wrap">
		<form action="front.do" method="post">
			<!-- 값이 노출되지 않으면서 서버로 전달할때 사용하는 태그 -->
			<input type="hidden" name="command" value="register">
			ID <input type="text" name="id" required="required"><br>
			PASS <input type="password" name="password" required="required"><br>
			NAME <input type="text" name="name" required="required"><br>
			ADDR <input type="text" name="address" required="required"><br>
			<input type="submit" value="REGISTER"> 
			<input type="button" value="CLICK" onclick="btnclick()">
		</form>
	</div>
</body>
</html>