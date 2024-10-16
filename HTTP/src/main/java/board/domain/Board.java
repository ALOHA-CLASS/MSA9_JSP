package board.domain;

import java.time.LocalDateTime;

public class Board {
	private int no;						// 글번호
	private String title;				// 제목
	private String writer;				// 작성자
	private String content;				// 내용
	private LocalDateTime regDate;		// 등록일자
	private LocalDateTime updDate;		// 수정일자
	
	// 생성자
	public Board() {
		
	}
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getUpdDate() {
		return updDate;
	}

	public void setUpdDate(LocalDateTime updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", updDate=" + updDate + "]";
	}

	
	
}



