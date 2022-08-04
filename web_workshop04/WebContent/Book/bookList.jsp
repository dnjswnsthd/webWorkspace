<%@page import="servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2{
	margin-left: 350px;
	margin-right: 350px;
	border: 1px solid rgb(2, 21, 63);
}
body {
	text-align: center;
}


.styled-table {
    border-collapse: collapse;
    margin-left: 100px;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}
.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h2>도서 리스트</h2>
	<a href="Book/Book.html">도서 등록</a>
	<hr>
	<table class="styled-table">
		<thead>
			<tr>
				<td>도서 번호</td>
				<td>도서 제목</td>
				<td>도서 종류</td>
				<td>출판국가</td>
				<td>출 판 일</td>
				<td>출 판 사</td>
				<td>저  자</td>
				<td>도서 가격</td>
				<td>요약 내용</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
				<td>${list.isbn}</td>
				<td>${list.title}</td>
				<td>${list.catalogue}</td>
				<td>${list.nation}</td>
				<td>${list.publishDate}</td>
				<td>${list.publisher}</td>
				<td>${list.author}</td>
				<td>${list.price} ${list.currency}</td>
				<td>${list.description}</td>
			</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>