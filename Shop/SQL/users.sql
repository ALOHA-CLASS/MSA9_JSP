
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`no`		INT	NOT NULL	AUTO_INCREMENT PRIMARY KEY				COMMENT '회원번호',
	`id`		VARCHAR(255)	NOT NULL								COMMENT 'ID (UUID)',
	`username`	VARCHAR(100)	NOT NULL	UNIQUE						COMMENT '아이디',
	`password`	VARCHAR(100)	NULL									COMMENT '비밀번호',
	`name`		VARCHAR(20)		NOT NULL								COMMENT '이름',
	`email`		VARCHAR(100)	NULL									COMMENT '이메일',
	`enabled`	BOOLEAN			NULL									COMMENT '휴면여부',
	`created_at`	TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`updated_at`	TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
) COMMENT '회원';



INSERT INTO `users` (`id`, `username`, `password`, `name`, `email`, `enabled`, `created_at`, `updated_at`) VALUES
('1e7d1f2e-3b4a-4d2b-8e2d-1f2e3b4a4d2b', 'user1', 'password1', 'John Doe', 'john.doe@example.com', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('2e7d1f2e-3b4a-4d2b-8e2d-2f2e3b4a4d2b', 'user2', 'password2', 'Jane Smith', 'jane.smith@example.com', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('3e7d1f2e-3b4a-4d2b-8e2d-3f2e3b4a4d2b', 'user3', 'password3', 'Alice Johnson', 'alice.johnson@example.com', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('4e7d1f2e-3b4a-4d2b-8e2d-4f2e3b4a4d2b', 'user4', 'password4', 'Bob Brown', 'bob.brown@example.com', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('5e7d1f2e-3b4a-4d2b-8e2d-5f2e3b4a4d2b', 'user5', 'password5', 'Charlie Davis', 'charlie.davis@example.com', FALSE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);