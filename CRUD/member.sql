DROP TABLE member;

CREATE TABLE member(
	mem_id VARCHAR(20) PRIMARY KEY,
	mem_name VARCHAR(15) NOT NULL,
	mem_pw VARCHAR(20) NOT NULL,
	mem_email VARCHAR(20) NOT NULL,
	mem_reg CHAR(17) NOT NULL
)

SELECT * FROM member;

SELECT count(*) AS cnt FROM member WHERE mem_id = 2;