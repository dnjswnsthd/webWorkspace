<%@page import="web.product.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
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
    margin-left: 340px;
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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 리스트</h2>
	<a href="register.html">상품 등록</a>
	<hr>
	<table class="styled-table">
		<thead>
			<tr>
				<td>상품 번호</td>
				<td>상품 이름</td>
				<td>상품 가격</td>
				<td>상품 상품 설명</td>
			</tr>
		</thead>
		<tbody>
			<%
				for (Product vo : list) {
			%>
			<tr>
				<td><%=vo.getId()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getPrice()%></td>
				<td><%=vo.getDescription()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>