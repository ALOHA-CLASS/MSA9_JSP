package request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
// @WebServlet : 요청 경로 매핑 어노테이션
// @WebServlet("/HelloServlet")	
@WebServlet(name = "HelloServlet", urlPatterns = {"/main", "/hello"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성자
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // GET 요청 시, 처리하는 메소드
	protected void doGet(HttpServletRequest request
					   , HttpServletResponse response) throws ServletException, IOException {
		// 요청 정보 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		// 요청 파라미터 확인
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		System.out.println("title 	  : " + title);
		System.out.println("writer    : " + writer);
		System.out.println("content   : " + content);
		
		// 요청 URI, URL 확인
		String requestURI = request.getRequestURI();
		System.out.println("URI : " + requestURI);
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("URL : " + requestURL.toString());
		
		// 요청 헤더 정보를 확인
		String userAgent = request.getHeader("User-Agent");
		System.out.println("User-Agent 헤더 : " + userAgent);
		
		// 클라이언트 IP 주소 확인
		String remoteAddr = request.getRemoteAddr();
		System.out.println("클라이언트 IP 주소 : " + remoteAddr);
		
		// request.getContextPath() : 톰캣 서버 내에서 해당 프로젝트가 배포되는 최상위 경로
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset:UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("GET 방식 요청");
	}

	// POST 요청 시, 처리하는 메소드
	protected void doPost(HttpServletRequest request
						, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		// 요청 정보 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		// 요청 파라미터 확인
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		System.out.println("title 	  : " + title);
		System.out.println("writer    : " + writer);
		System.out.println("content   : " + content);
		System.out.println("게시글 등록 요청 처리...");
		
		response.setContentType("text/html; charset:UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("POST 방식 요청");
	}

}












