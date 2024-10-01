package move;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A
 */
@WebServlet("/A")
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public A() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 포워드 방식으로 페이지 이동
		String targetURL = "/B";
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		RequestDispatcher dispatcher = request.getRequestDispatcher(targetURL);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








