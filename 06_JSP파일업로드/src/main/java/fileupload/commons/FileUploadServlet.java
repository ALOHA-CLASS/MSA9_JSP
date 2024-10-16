package fileupload.commons;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

@WebServlet(name = "CommonsFileUploadServlet", urlPatterns = "/fileupload/commons")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String fileUploadPath = "C:/UPLOAD";

		// commons-fileupload 에서 파일 업로드 기능을 가진 객체 DiskFileUpload 생성
		DiskFileUpload upload = new DiskFileUpload();
		
		// parseRequest(request) 
		// : request 객체를 분석하여, multipart/form-data 유형의 파라미터만 읽어드려서 List로 반환
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// FileItem 타입의 파라미터 목록
		
		if( items == null ) {
			out.print("<h1>파일 업로드 실패!</h1>");
		}
		
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
				try {
					fileItem.write(file);  			// write() : 파일 저장
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		out.print("<h1>파일 업로드 성공!</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}