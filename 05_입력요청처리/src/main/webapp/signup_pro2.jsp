<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 요청 처리</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");		

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String sex = request.getParameter("sex");
		// request.getParameterValues()  
		// : 2 개이상의 파라미터 값을 배열로 반환하는 메소드
		String[] hobby = request.getParameterValues("hobby");
		String comment = request.getParameter("comment");
		
		// 요청 정보를 객체로 매핑
		User user = new User();
		user.setId(id);
		user.setPasswd(passwd);
		user.setName(name);
		user.setPhone(phone1+phone2+phone3);
		List<String> hobbyList = Arrays.asList(hobby);
		user.setHobby(hobbyList);
		user.setComment(comment);
		
		// 서비스로 데이터 등록 요청 (회원가입 처리)
		// boardService.insert(user);
		Random random = new Random();
		int result = random.nextInt(2);
		
		String root = request.getContextPath();
		// 회원가입 성공
		if( result > 0 ) {
			// 1. 메인 화면으로 이동
			// response.sendRedirect(root + "/");
			// 2. 로그인 화면으로 이동
			response.sendRedirect(root + "/login.jsp");
		}
		// 회원가입 실패
		else {
			// - 회원가입 화면으로 이동
			//   : /signup2?error=invalid
			response.sendRedirect(root + "/signup2.jsp?error=invalid");
		}
	%>
	
</body>
</html>











