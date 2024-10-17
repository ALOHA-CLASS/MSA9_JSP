<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - fuctions</title>
</head>
<body>
	<h1>문자열 검색</h1>
	<h3>Hello JSTL~!</h3>
	<h5>${fn:contains("Hello JSTL~!","Hello")}</h5>
	
	<c:set var="check" value=""></c:set>
	
	<c:if test="${fn:contains('Hello JSTL~!','Hello')}">
		<h5>Hello 가 포함된 문자열입니다.</h5>
	</c:if>	
	
	<hr>
	
	<h1>contains() 함수</h1>
	
	<p>
		문자열 포함 여부 
		: ${fn:contains("Hello JSTL~!", "JSTL")}
	</p>
	<p>
		문자열 포함 여부(대소문자 구분X) 
		: ${fn:containsIgnoreCase("Hello JSTL~!", "jstl")}
	</p>
	<p>
		문자열 포함 여부 
		: ${fn:contains("Hello JSTL~!", "JSP")}
	</p>
	
	<hr>
	
	<h1>toUpperCase(), toLowerCase() 함수</h1>
	<p>
		hello jstl~!
		: ${fn:toUpperCase("hello jstl~!")}
	</p>
	<p>
		Hello JSTL~!
		: ${fn:toLowerCase("Hello JSTL~!")}
	</p>
	
	<hr>
	
	<h1>length() 함수</h1>
	<p>
		글자수 : Hello JSTL~! ( ${fn:length("Hello JSTL~!")} )
	</p>
	
	
	<h1>split() 함수</h1>
	<c:set var="texts" value="${fn:split('Hello JSTL~!', ' ')}" />
	<c:forEach var="i" begin="0" end="${fn:length(texts)-1}">
		<p>texts[${i}] : ${texts[i]}</p>
	</c:forEach>
	
	<p><c:out value="${fn:join(texts, ',')}"/> </p>
</body>
</html>














