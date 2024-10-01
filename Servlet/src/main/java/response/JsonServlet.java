package response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 컨텐츠 타입 : json 
		// { title : "", writer : "", content : "" }
		Map<String, String> data = new HashMap<String, String>();
		data.put("title", "제목");
		data.put("writer", "작성자");
		data.put("content", "내용");
		
		// Map 컬렉션을 json 문자열로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(data);
		// jsonString : '{ "title" : "", "writer" : "", "content" : "" }'
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset:UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
		writer.flush();				// 버퍼의 내용을 출력 스트림으로 내보냄
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





