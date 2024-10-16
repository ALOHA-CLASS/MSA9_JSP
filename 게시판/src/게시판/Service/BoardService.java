package 게시판.Service;

import java.util.List;

import 게시판.DTO.Board;

/**
 *  게시판 프로그램 - 기능 메소드
 *  - 게시글 목록
 *  - 게시글 조회
 *  - 게시글 등록
 *  - 게시글 수정
 *  - 게시글 삭제
 */
public interface BoardService {
	
	// 게시글 목록
	List<Board> list();
	// 게시글 조회
	Board select(int no);
	// 게시글 등록
	int insert(Board board);
	// 게시글 수정
	int update(Board board);
	// 게시글 삭제
	int delete(int no);
	
}




