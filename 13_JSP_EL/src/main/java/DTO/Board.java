package DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  (DTO)
 *  게시글 정보		
 *  				Java			DB
 *  - 게시글 번호		no				no	
 *  - 제목			title			title
 *  - 작성자			writer			writer
 *  - 내용			content			content
 *  - 등록일자			regDate			red_date
 *  - 수정일자			updDate			upd_date
 */
@Data
@AllArgsConstructor
public class Board {

	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Date updDate;
	
	public Board() {
		this("(제목없음)", "(작성자없음)", "");
	}
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
}




