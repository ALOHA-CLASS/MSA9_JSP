package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/img")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다운로드할 파일명을 준비
		String fileName = request.getParameter("fileName");
		// 파일명 유효성 검사
		if( fileName == null || fileName.isEmpty() ) {
			response.getWriter().println("파일명이 지정되지 않았습니다.");
			return; // 메소드 종료
		}
		
		// 파일 경로 
		String downloadDir = "C:\\fileupload";
		String imgFilePath = downloadDir + File.separator + fileName;
		// imgFilePath 	: C:\fileupload\a.b\A.B.jpg
		// 이미지 확장자 	: jpg, png, gif, webp  
		
		// 파일 경로로 부터 이미지 확장자 추출
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		// 이미지 컨텐츠타입 : image/jpeg, image/png, image/gif, /image/webp
		String contentType;
		switch (ext) {
			case "jpg":
			case "jpeg":
				contentType = "image/jpeg";
				break;
			case "png":
				contentType = "image/png";
				break;
			case "gif":
				contentType = "image/gif";
				break;
			case "webp":
				contentType = "image/webp";
				break;
			default:
				response.getWriter().println("이미지 형식이 아닙니다.");
				return;
		}
		// 응답 헤더 컨텐츠 타입 지정
		response.setContentType(contentType);
		
		File file = new File(imgFilePath);
		// 파일 존재 여부
		if( !file.exists() ) {
			response.getWriter().println("파일이 존재하지 않습니다.");
			return;
		}
		// 이미지 파일을 서버에서 파일 입력 			: FileInputStream
		// 입력받은 이미지 파일을 클라이언트로 출력	: ServletOutputStream
		// try-with-resource (Auto Close)
		try( FileInputStream fis = new FileInputStream(file);
			 ServletOutputStream sos = response.getOutputStream() ) {
			byte[] buffer = new byte[4096];
			int data = -1;
			while( (data = fis.read(buffer)) != -1 ) {
				sos.write(buffer, 0, data);
			}
		} catch(Exception e) {
			System.err.println("이미지 파일 전송 중 에러발생");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}






