<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 클라이언트에서 서버로 요청한 파일을 다루는 클래스
	// MultipartRequest(request, 저장경로, 파일 최대크기, 인코딩타입, 파일명 정책 객체)
	String uploadPath = "C:/upload/";
	out.println("upload 경로 : " + uploadPath);
	int maxSize = 10 * 1024 * 1024;				// 10MB
	DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "UTF-8", policy);
	
	// enctype="multipart/form-data" 으로 요청하는 경우
	// MultipartRequest 로 요청 파라미터 확인
	Enumeration params = multi.getParameterNames();
	
	while( params.hasMoreElements() ) {
		String name = (String) params.nextElement();
		String value = multi.getParameter(name);
		out.println(name + " : " +  value + "<br>");
	}
	out.println("----------------------------------------------<br>");
		
	// 파일
	Enumeration files = multi.getFileNames();
	
	while( files.hasMoreElements() ) {
		String file = (String) files.nextElement();
		
		String fileName = multi.getFilesystemName(file);		// 서버에 업로드된 파일명
		String original = multi.getOriginalFileName(file);		// 클라이언트에서 업로드한 파일명
		String type = multi.getContentType(file);				// 컨텐츠 타입
		File f = multi.getFile(file);
		
		out.println("요청 파라미터 이름 : " + file + "<br>");
		out.println("실제 파일 이름 : " + original + "<br>");
		out.println("저장 파일 이름 : " + fileName + "<br>");
		out.println("파일 콘텐츠 타입 : " + type + "<br>");
		out.println("저장 경로 : " + f.getPath() + "<br>");
		
		if( f != null ) {
			out.println("파일 크기 : " + f.length()	);
			out.println("<br>");
		}
		out.println("----------------------------------------------<br>");
		
	}

%>