package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/TestFilter") // 필터 패턴 경로
public class TestFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public TestFilter() {
        super();
    }
    
    /**
	 * 필터를 초기화하는 메소드
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("TestFilter 초기화...");
	}

	/**
	 * 필터에서 처리할 작업을 작성하는 메소드
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터 통과 시, 처리할 작업
		// TODO: ...
		System.out.println("TestFilter 필터 처리 작업...");

		// 필터 체인의 다음 필터로 요청과 응답을 넘겨주는 메소드
		chain.doFilter(request, response);
	}

	/**
	 * 필터가 제거될 때 호출되는 메소드 
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
