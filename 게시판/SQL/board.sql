-- 게시판 테이블 생성
CREATE TABLE `aloha`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `writer` VARCHAR(100) NOT NULL,
  `content` TEXT NULL,
  `reg_date` TIMESTAMP NOT NULL DEFAULT now(),
  `upd_date` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`no`))
COMMENT = '게시판';

-- 조회
SELECT * FROM board;

-- 추가
INSERT INTO board (title, writer, content)
VALUES ('게시글 제목 01', '유지현', '집에가고싶다');

-- 수정
UPDATE board
   SET title = '게시글 수정 제목 01'
      ,writer = '강민아'
      ,content = '내가먼저감'
      ,upd_date = now()
WHERE no = 1;

-- 삭제
DELETE FROM board
WHERE no = 1;








