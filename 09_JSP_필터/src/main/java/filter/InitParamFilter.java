package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class InitParamFilter
 */
// 서블릿 4.0 에서는 web.xml 설정 대신 어노테이션으로 필터 설정 가능
@WebFilter(
		urlPatterns = { "/filter01_pro.jsp" }, 
		initParams = { 
				@WebInitParam(name = "param1", value = "admin", description = "관리자 아이디"), 
				@WebInitParam(name = "param2", value = "1234", description = "관리자 비밀번호")
		})
public class InitParamFilter extends HttpFilter implements Filter {
	
	private FilterConfig filterConfig = null;
       
    /**
     * 초기 파라미터 설정
     */
    public InitParamFilter() {
        super();
    }
    
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	/**
	 *   /filter01_pro.jsp 로 요청 시,
	 *   username, password 아이디 비밀번호가 관리자(admin/1234)와 같은지 확인
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("아이디 : " + username);
		System.out.println("비밀번호 : " + password);
		
		// 초기 파라미터 param1, param2 가져오기
		String param1 = filterConfig.getInitParameter("param1");  // admin
		String param2 = filterConfig.getInitParameter("param2");  // 1234

		String message = "";
		// 아이디 비밀번호 null 체크
		if( (username == null || username.isEmpty()) || (password == null || password.isEmpty()) ) {
			message = "아이디 또는 비밀번호가 누락되었습니다.";
		}
		// 관리자 아이디 비밀번호 같은지 확인
		else if( username.equals(param1) && password.equals(param2) ) {
			message = "로그인 성공했습니다.";
		}
		else {
			message = "로그인 실패했습니다.";
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<h1>" + message + "</h1>");
		writer.println("</body></html>");
		
		
		chain.doFilter(request, response);
	}

	
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
