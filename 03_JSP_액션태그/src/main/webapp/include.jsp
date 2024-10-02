<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 - include</title>
</head>
<body>
	<%
// 		String menu1 = "Home";
// 		String menu2 = "Board";
// 		String menu3 = "Gallery";
	%>
	<%-- 액션태그 include --%>
	<jsp:include page="header.jsp">
		<jsp:param value="home" name="menu1"/>
		<jsp:param value="board" name="menu2"/>
		<jsp:param value="gallery" name="menu3"/>
	</jsp:include>
	<main>
		<div class="container">
			<h1>메인 영역</h1>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>




