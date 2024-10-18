package shop.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import shop.DTO.PersistenceLogins;
import shop.DTO.Users;
import shop.Service.PersistenceLoginsService;
import shop.Service.PersistenceLoginsServiceImpl;
import shop.Service.UserService;
import shop.Service.UserServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(description = "자동 로그인 등, 인증 처리 필터", urlPatterns = { "/*" })
public class LoginFilter extends HttpFilter implements Filter {
	
	PersistenceLoginsService persistenceLoginsService;
	UserService userService;
       
    public LoginFilter() {
        super();
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	persistenceLoginsService = new PersistenceLoginsServiceImpl();
    	userService = new UserServiceImpl();
    }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 쿠키 확인
		// 1. 자동 로그인 여부
		// 2. 인증 토큰
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Cookie[] cookies = httpRequest.getCookies();
		
		String rememberMe = null;		// 자동 로그이 여부
		String token = null;			// 인증 토큰
		
		if( cookies != null ) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				String cookieValue = URLDecoder.decode( cookie.getValue(), "UTF-8") ;
				switch (cookieName) {
					case "rememberMe"	: rememberMe = cookieValue; break;
					case "token"		: token = cookieValue; break;
				}
			}
		}
		System.out.println("LoginFilter...");
		System.out.println("rememberMe : " + rememberMe);
		System.out.println("token : " + token);
		
		// 로그인 여부 확인
		HttpSession session = httpRequest.getSession();
		String loginId = (String) session.getAttribute("loginId");
		Users loginUser = (Users) session.getAttribute("loginUser");
		
		// 이미 로그인 됨
		if( loginId != null && loginUser != null ) {
			chain.doFilter(request, response);
			System.out.println("로그인된 사용자 : " + loginId);
			return;
		}	
		
		
		// 자동 로그인 & 토큰 ok
		if( rememberMe != null && token != null ) {
			PersistenceLogins persistenceLogins = persistenceLoginsService.selectByToken(token);
			boolean isValid = persistenceLoginsService.isValid(token);
			// 토큰이 존재, 유효
			if( persistenceLogins != null && isValid ) {
				loginId = persistenceLogins.getUsername();
				loginUser = userService.select(loginId);
				// 로그인 처리
				session.setAttribute("loginId", loginId);
				session.setAttribute("loginUser", loginUser);
				System.out.println("자동 로그인 성공 : " + loginUser);
			}
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}
}











