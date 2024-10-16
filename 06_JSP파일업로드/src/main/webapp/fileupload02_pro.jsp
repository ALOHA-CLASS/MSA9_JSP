<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fileUploadPath = "C:/upload";

	// commons-fileupload 에서 파일 업로드 기능을 가진 객체 DiskFileUpload 생성
	DiskFileUpload upload = new DiskFileUpload();
	
	// parseRequest(request) 
	// : request 객체를 분석하여, multipart/form-data 유형의 파라미터만 읽어드려서 List로 반환
	List<FileItem> items = upload.parseRequest(request);	// FileItem 타입의 파라미터 목록
	
	// for( int i = 0 ; i < items.size() ; i++ ) {
	//	 FileItem item = (FileItem) items.get(i);
	// }
	
	Iterator<FileItem> params = items.iterator();			// 반복 객체
	
	while( params.hasNext() ) {
		FileItem fileItem = params.next();					// 파일 요소
		// isFormField() : 요청 파라미터가 일반 데이터 인지 확인 (일반:true, 파일:false)
		// 파일인지 확인
		if( !fileItem.isFormField() ) {
			// 파일명 중복을 방지하기 위해
			// UID_파일명.확장자 형식으로 파일명 지정하기 : UID_강아지.jpg
			String fileName = UUID.randomUUID() + "_" + fileItem.getName();
			File file = new File(fileUploadPath + "/" + fileName); // ~/UPLOAD/강아지.jpg 경로로 파일 객체 생성
			fileItem.write(file);				// write() : 파일 저장
		}
	}
	out.print("<h1>파일 업로드 성공!</h1>");
%>