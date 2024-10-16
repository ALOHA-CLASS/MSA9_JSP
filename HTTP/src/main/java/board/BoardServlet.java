package board;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.domain.Board;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }

    // method 	: GET
    // URL 		: /board
    // 게시글 목록 조회 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 목록 조회 요청");
		// 요청, 응답 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 게시글 목록 샘플 데이터
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board("글1", "이름1", "내용1"));
		boardList.add(new Board("글2", "이름2", "내용2"));
		boardList.add(new Board("글3", "이름3", "내용3"));
		
		// 응답 처리
		// 응답 컨텐츠 타입 : application/json
		/*
			[
				{"title" : "글1", "writer" : "이름1", "content" : "내용1" },
				{"title" : "글2", "writer" : "이름2", "content" : "내용2" },
				{"title" : "글3", "writer" : "이름3", "content" : "내용3" }
			]
		*/
		// List<Board> 를 JSON 문자열 형식으로 변환
		StringBuilder json = new StringBuilder();
		json.append("[");
		for (int i = 0; i < boardList.size(); i++) {
			Board board = boardList.get(i);
			json.append("{");
			json.append("\"title\":\"" + board.getTitle() + "\",");
			json.append("\"writer\":\"" + board.getWriter() + "\",");
			json.append("\"content\":\"" + board.getContent() + "\"");
			json.append("}");
			if( i < boardList.size()-1 ) {
				json.append(",");
			}
		}
		json.append("]");
		// 응답 컨텐츠 타입 지정
		response.setContentType("application/json; charset=UTF-8");
		// 데이터 응답
		response.getWriter().write(json.toString());
	}

	// method 	: POST
    // URL 		: /board
    // 게시글 등록 요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 등록 요청");
		// 요청, 응답 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 요청 바디에서 title, writer, content 값 가져오기
		StringBuilder sb = new StringBuilder();
		List<String> bodyLine = new ArrayList<String>();
		try (BufferedReader reader = request.getReader()) {
			String line;
			while( (line = reader.readLine()) != null) {
				bodyLine.add(line);
				sb.append(line + "\n");
			}
		} catch (Exception e) {
			System.err.println("요청 본문 로딩 시 에러...");
		}
		
		String title = "";
		String writer = "";
		String content = "";
		for (int i = 0 ; i < bodyLine.size() ; i++) {
			String line = bodyLine.get(i);
			if( line.contains("name=\"title\"") ) title = bodyLine.get(i+2);
			if( line.contains("name=\"writer\"") ) writer = bodyLine.get(i+2);
			if( line.contains("name=\"content\"") ) content = bodyLine.get(i+2);
		}
		
		System.out.println(sb.toString());
		
		// 게시글 등록 처리 요청
		Board board = new Board(title, writer, content);
		System.out.println("등록할 게시글 : " + board);
		Random random = new Random();
		int result = random.nextInt(2);	// 0, 1
		
		// 응답 처리
		// FORM 요청
		// request.getContextPath() : 최상위 경로 (루트 컨텍스트)
		/*
		if( result > 0 ) 
			// 게시글 목록으로 이동
			response.sendRedirect(request.getContextPath() + "/board/list.jsp");
		else 
			// 게시글 등록으로 이동(에러메시지 포함)
			response.sendRedirect(request.getContextPath() + "/board/insert.jsp?error=FAIL");
		*/
		
		// 비동기 요청 시
		// - 등록 성공
		if( result > 0 ) 
			response.getWriter().write("SUCCESS");
		// - 등록 실패
		else
			response.getWriter().write("FAIL");
			
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}









