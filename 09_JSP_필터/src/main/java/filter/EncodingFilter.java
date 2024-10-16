package filter;

import java.io.IOException;
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
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(
		urlPatterns = { "/*" },  // 모든 경로 URL 매핑 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8", description = "인코딩 설정 값")
		})
public class EncodingFilter extends HttpFilter implements Filter {
	
	private FilterConfig filterConfig = null;
    private String encoding;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		encoding = filterConfig.getInitParameter("encoding");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("인코딩 필터 : " + encoding);
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}


	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}





