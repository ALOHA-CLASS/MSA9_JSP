<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	<h1>POST 방식 요청</h1>
	<form action="/Servlet/hello" method="POST">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" >
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" >
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<input type="text" name="content" >
				</td>
			</tr>
		</table>		
		<input type="submit" value="등록하기">
	</form>
</body>
</html>







