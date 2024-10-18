<%@page import="shop.Service.PersistenceLoginsServiceImpl"%>
<%@page import="shop.Service.PersistenceLoginsService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 자동 로그인
	// - 인증 토큰 삭제
	Cookie cookieRememberMe = new Cookie("rememberMe", "");
	Cookie cookieToken = new Cookie("token", "");
	cookieRememberMe.setPath("/");
	cookieToken.setPath("/");
	cookieRememberMe.setMaxAge(0);
	cookieToken.setMaxAge(0);
	response.addCookie(cookieRememberMe);
	response.addCookie(cookieToken);
	
	PersistenceLoginsService persistenceLoginsService = new PersistenceLoginsServiceImpl();
	String loginId = (String) session.getAttribute("loginId");
	if( loginId != null ) {
		boolean deleted = persistenceLoginsService.delete(loginId);
		if( deleted ) out.println("인증 토큰 데이터 삭제 성공!");
		else 		  out.println("인증 토큰 데이터 삭제 실패!");
	}
	
	// 세션 무효화
	session.invalidate();
	
	// 메인 화면
	// 1) jsp 를 지정하여 이동
	// response.sendRedirect("index.jsp");
	// 2) 루트 경로 (/) 지정하여 이동
	response.sendRedirect(request.getContextPath() + "/");

%>





