package fileupload.cos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileupload/cos")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 프로젝트 경로(root) 가져오기
		String className = getClass().getName().substring( getClass().getName().lastIndexOf(".") + 1 );
		URL resourceUrl = getClass().getResource(className+".class");
		System.out.println("class : " + className);
		
		String root = "";
		if (resourceUrl != null) {
			String path = resourceUrl.getFile();
			int lastIndex = path.lastIndexOf("WEB-INF");
			root = path.substring(0, lastIndex);
	        System.out.println("파일 위치: " + resourceUrl.getFile());
	        System.out.println("프로젝트 위치: " + root);
	     } else {
	         System.err.println("리소스를 찾을 수 없습니다.");
	     }

		// 클라이언트에서 서버로 요청한 파일을 다루는 클래스
		// MultipartRequest(request, 저장경로, 파일 최대크기, 인코딩타입, 파일명 정책 객체)
		root = "C:/";		// 고정된 경로로 하는 경우
		String filePath = root + "upload/";
		System.out.println("upload 경로 : " + filePath);
		
		int maxSize = 10 * 1024 * 1024;			// 10MB
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		MultipartRequest multi = new MultipartRequest(request, filePath, maxSize, "UTF-8", policy);
		
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}