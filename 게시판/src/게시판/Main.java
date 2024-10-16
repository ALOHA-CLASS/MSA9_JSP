package 게시판;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import 게시판.DTO.Board;
import 게시판.Service.BoardService;
import 게시판.Service.BoardServiceImpl;

public class Main {
	
	static Scanner sc = new Scanner(System.in);					// 입력 객체
	static List<Board> boardList = null;						// 게시글 목록
	static BoardService boardService = new BoardServiceImpl();	// 비즈니스 로직 객체
	
	/**
	 *  메뉴판
	 */
	public static void menu() {
		System.out.println(":::::::::: 게시판 ::::::::::");
		System.out.println("1. 게시글 목록");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 등록");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print(":::::::::: 번호 입력 : ");
	}
	
	/**
	 *  게시글 목록
	 */
	public static void list() {
		System.out.println(":::::::::: 게시글 목록 ::::::::::");
		// 게시글 목록 데이터 요청
		boardList = boardService.list();
		printAll(boardList);
	}

	/**
	 * 글 목록 전체 출력
	 * @param list
	 */
	private static void printAll(List<Board> list) {
		// 글 목록이 존재하는지 확인
		if( list == null || list.isEmpty() ) {
			System.err.println("조회된 글이 없습니다.");
			return;
		}
		// 글 목록 출력
		for (Board board : list) {
			print(board);
		}
	}

	/**
	 * 게시글 출력
	 * @param board
	 */
	private static void print(Board board) {
		if( board == null ) {
			System.err.println("조회할 수 없는 게시글입니다.");
			return;
		}
		
		int no = board.getNo();
		String title = board.getTitle();
		String writer = board.getWriter();
		String content = board.getContent();
		Date regDate = board.getRegDate();
		Date updDate = board.getUpdDate();
		// 날짜 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String reg = sdf.format(regDate);
		String upd = sdf.format(updDate);
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		System.out.println("★ 글번호 : " + no);
		System.out.println("★ 제목 : " + title);
		System.out.println("★ 작성자 : " + writer);
		System.out.println("----------------------------------------");
		System.out.println(" " + content);
		System.out.println("★ 등록일자 : " + reg);
		System.out.println("★ 수정일자 : " + upd);
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		System.out.println();
	}
	
	/**
	 * 게시글 조회
	 */
	public static void select() {
		System.out.println(":::::::::: 게시글 조회 :::::::::::");
		System.out.print("글 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		// 글번호(no)를 전달하여 게시글 정보 데이터 요청
		Board board = boardService.select(no);
		// 게시글 정보 출력
		print(board);
	}

	/**
	 * 게시글 등록
	 */
	public static void insert() {
		System.out.println(":::::::::: 게시글 등록 ::::::::::");
		
		Board board = input();
		// 게시글 등록 요청
		int result = boardService.insert(board);
		if( result > 0 ) {
			System.out.println("★ 게시글이 등록되었습니다.");
		} else {
			System.err.println("★ 게시글 등록에 실패하였습니다.");
		}
	}
	
	/**
	 * 게시글 정보 입력
	 * @return
	 */
	private static Board input() {
		System.out.print("★ 제목 : ");
		String title = sc.nextLine();
		System.out.print("★ 작성자 : ");
		String writer = sc.nextLine();
		System.out.print("★ 내용 : ");
		String content = sc.nextLine();
		
		Board board = new Board(title, writer, content);
		return board;
	}
	
	/**
	 * 게시글 수정
	 */
	public static void update() {
		System.out.println(":::::::::: 게시글 수정 ::::::::::");
		
		System.out.print("게시글 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();

		Board board = input();
		board.setNo(no);
		
		// 게시글 수정 요청
		int result = boardService.update(board);
		if( result > 0 ) {
			System.out.println("★ 게시글이 수정되었습니다.");
		} else {
			System.err.println("★ 게시글 수정에 실패하였습니다.");
		}
	}

	/**
	 * 게시글 삭제
	 */
	public static void delete() {
		System.out.println(":::::::::: 게시글 삭제 :::::::::::");
		
		System.out.print("게시글 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		// 게시글 삭제 요청
		int result = boardService.delete(no);
		if( result > 0 ) {
			System.out.println("★ 게시글을 삭제하였습니다.");
		} else {
			System.err.println("★ 게시글 삭제에 실패하였습니다.");
		}
	}
	
	public static void main(String[] args) {
		int menuNo = 0;
		
		do {
			// 메뉴판 출력
			menu();
			// 메뉴 번호 입력
			menuNo = sc.nextInt();
			sc.nextLine();
			// 0 -> 프로그램 종료
			if( menuNo == 0 ) break;
			// 메뉴 선택
			switch (menuNo) {
				case 1:	list();			// 게시글 목록
						break;
				case 2:	select();		// 게시글 조회
						break;
				case 3:	insert();		// 게시글 등록
						break;
				case 4:	update();		// 게시글 수정
						break;
				case 5:	delete();		// 게시글 삭제
						break;
			}
		} while (menuNo != 0);
		
		System.out.println("프로그램을 종료합니다...");
	}

}
