CREATE TABLE member(
	mem_id VARCHAR(20) PRIMARY KEY,
	mem_name VARCHAR(15) NOT NULL,
	mem_pw VARCHAR(20) NOT NULL,
	mem_email VARCHAR(20) NOT NULL,
	mem_reg CHAR(17) NOT NULL
)

CREATE TABLE board (
	b_num INT PRIMARY KEY AUTO_INCREMENT,
	b_title VARCHAR(20) NOT NULL,
	b_writer VARCHAR(20) NOT NULL, 
	b_contents TEXT NOT NULL,
	b_reg CHAR(17) NOT NULL,
	filename1 LONGBLOB,
	b_hit INT,
	b_id VARCHAR(20),
 	FOREIGN KEY (b_id)
    REFERENCES member(mem_id) ON UPDATE CASCADE
);  

DROP TABLE board; 

DROP TABLE member;

desc board;

SELECT * FROM  board;

SELECT * FROM  member;

SELECT CAST(md5('filename1') AS CHAR (10000) CHARACTER SET EUCKR) AS STR FROM board WHERE b_id = 1;

DELETE FROM board;

DELETE FROM member;

DROP TABLE member;

SELECT * FROM board WHERE b_num LIKE ? OR b_title LIKE ? OR b_writer LIKE ? ORDER BY b_num DESC;


INSERT INTO board (b_title, b_writer, b_contents, b_reg, b_id) VALUES ("d","a","b","q","7");

SELECT CONVERT(filename1 USING EUCKR) FROM board;
