<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.result{
	text-align: center;
	
}
.title{
	margin-left: 400px;
	margin-right: 400px;
	border: 1px solid purple;
}
.book{
	color: orange;
	font-size: 4em;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="result">
		<h2 class="title">결과 페이지</h2>
		<h3><span class="book">${param.bookTitle}</span> 정상적으로	저장 되었습니다.</h3>
		<br>
		<a href="Book/Book.html">추가등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="book.do?command=allBook">도서목록</a>
	</div>
</body>
</html>