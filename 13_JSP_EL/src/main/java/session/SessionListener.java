package session;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener
 * 사용자의 세션에 대한 행위를 인식하는 클래스
 *
 * * 리스너 : 이벤트를 인식하는 클래스
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * 세션이 생성될 때 실행
     * - 접속자 수를 1씩 증가
     */
    public void sessionCreated(HttpSessionEvent event)  {
    	ServletContext application = event.getSession().getServletContext();
    	AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount");
    	if( visitorCount == null ) {
    		visitorCount = new AtomicInteger(0);
    	}
    	// 접속자 수 1 증가
    	int currentCount = visitorCount.incrementAndGet();
    	application.setAttribute("visitorCount", visitorCount);
    	System.out.println("현재 접속자 수 : " + currentCount);
    }

	/**
     * 세션이 종료될 때 실행
     * - 접속자 수를 1씩 감소
     */
    public void sessionDestroyed(HttpSessionEvent event)  {
    	ServletContext application = event.getSession().getServletContext();
    	AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount");
    	int count = 0;
    	if( visitorCount != null ) {
    		count = visitorCount.decrementAndGet();
    		System.out.println("사용자가 나갔습니다.");
    	}
    	application.setAttribute("visitorCount", count);
    	System.out.println("현재 접속자 수 : " + count);
    }
	
}




