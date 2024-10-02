<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean 액션태그</title>
</head>
<body>
	<%-- person 이라는 이름으로 Person 객체 생성 --%>
	<%-- Person person = new Person(); --%>
	<jsp:useBean id="person" class="beans.Person"></jsp:useBean>
	
	<h3>이름 : <%= person.getName() %></h3>
	<h3>나이 : <%= person.getAge() %></h3>	
	<hr>
	
	<h3>이름 : <jsp:getProperty name="person" property="name" /></h3>
	<h3>나이 : <jsp:getProperty name="person" property="age" /></h3>
	<hr>
		
	<jsp:setProperty name="person" property="name" value="홍길동" />
	<jsp:setProperty name="person" property="age" value="30" />
		
	<h3>이름 : <jsp:getProperty name="person" property="name" /></h3>
	<h3>나이 : <jsp:getProperty name="person" property="age" /></h3>
	<hr>
	
</body>
</html>




