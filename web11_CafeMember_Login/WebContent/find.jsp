<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.search {
	height: 30px;
	width: 500px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Find" method="post">
		<h3>
			회원 검색 <input class="search" type="text" name="id"
				placeholder="검색어를 입력하세요." required="required"> <input
				type="submit" value="검색">
		</h3>
	</form>
</body>
</html>