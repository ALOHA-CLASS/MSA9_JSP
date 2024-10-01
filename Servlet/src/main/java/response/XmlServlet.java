package response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xml")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XmlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/xml; charset:UTF-8");
		String xml = "<Board>"
					   + "<title>제목</title>"
					   + "<writer>작성자</writer>"
					   + "<content>내용</content>"
				   + "</Board>"
				   ;
		PrintWriter writer = response.getWriter();
		writer.print(xml);
		writer.flush();	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






