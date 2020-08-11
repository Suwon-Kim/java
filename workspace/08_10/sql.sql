
DROP TABLE products;
DROP TABLE order_list;
DROP TABLE customers;
DROP TABLE job_list;

CREATE TABLE products (
	p_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	p_name VARCHAR(20) NOT NULL,
	p_price INT NOT NULL
);

CREATE TABLE customers (
	c_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	c_name VARCHAR(20) NOT NULL,
	c_addr VARCHAR(20) NOT NULL,
	j_id INT NOT NULL
);

CREATE TABLE order_list (
	o_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	p_id INT NOT NULL,
	c_id INT NOT NULL,
	o_date DATE NOT NULL,
	o_count INT NOT NULL
);

CREATE TABLE job_list(
	j_id INT, PRIMARY AUTO_INCREMENT PRIMARY KEY,
	job VARCHAR(10) NOT NULL
);


INSERT INTO job_list (job) VALUES
	('student'),
	('teacher'),
	('programmer'),
	('guard');
	
INSERT INTO products (p_name, p_price) VALUES
	('DVD', 250000),
	('TV', 150000),
	('audio', 900000),
	('computer', 750000);

INSERT INTO customers (c_name, c_addr, j_id) VALUES 
	('doo', 'pusan', 2),
	('hong', 'seoul', 2),
	('kim', 'ursan', 1),
	('jack', 'pusan', 3),
	('smith', 'inchun', 4);

INSERT INTO order_list (p_id, c_id, o_date, o_count) VALUES
	(1, 1, '2014-12-13', 2),
	(4, 3, '2014-12-18', 1),
	(3, 2, '2015-12-24', 2),
	(1, 3, '2016-12-31', 3),
	(2, 4, '2012-12-31', 3),
	(3, 1, '2015-1-1', 1),
	(2, 3, '2016-1-1', 3),
	(4, 4, '2016-1-2', 3),
	(2, 1, '2015-1-3', 4),
	(3, 2, '2013-1-5', 1),
	(1, 2, '2016-1-5', 2);
 
/*1.부산에 사는 고객의 직업을 구하라.*/
SELECT job_list.job
FROM job_list INNER JOIN customers
ON customers.j_id = job_list.j_id
WHERE customers.c_addr = 'pusan';

/*2.이름이 kim인 사람의 직업은*/
SELECT job_list.job
FROM job_list INNER JOIN customers
ON customers.j_id = job_list.j_id
WHERE customers.c_name = 'kim';

/*3.가장 가격이 싼 제품의 제품명은?*/
SELECT p_name, MIN(p_price)
FROM products

/*4.고객별 구매한 제품의 이름,수량, 구매일자를 구하시오. 단, 최신 구매순으로 정렬한다.*/
SELECT order_list.o_count, order_list.o_date, products.p_name
FROM products INNER JOIN order_list
ON products.p_id = order_list.p_id
ORDER BY order_list.o_date DESC
 
 /*5.가장 비싼 제품을 구입한 고객의 이름을 구하시오.*/
SELECT customers.c_name
FROM customers INNER JOIN order_list INNER JOIN products
ON customers.c_id = order_list.c_id
AND order_list.p_id = products.p_id
WHERE products.p_price = (SELECT max(p_price) FROM products);

/*6.DVD나 TV를 구매한 고객의 이름과 주소, 제품명을 구하시오.*/
SELECT customers.c_name, customers.c_addr, products.p_name
FROM customers INNER JOIN order_list INNER JOIN products
ON customers.c_id = order_list.c_id
AND order_list.p_id = products.p_id
WHERE products.p_name = 'DVD' OR products.p_name = 'TV'

/*7.doo가 구매한 가격의 총액을 구하시오.*/
SELECT SUM(products.p_price) AS perchase_sum
FROM customers INNER JOIN order_list INNER JOIN products
ON customers.c_id = order_list.c_id
AND order_list.p_id = products.p_id
WHERE customers.c_name = 'doo'

/*8.직업이 teacher인 사람이 구매한 제품목록을 구하시오.*/
SELECT products.p_name
FROM customers NATURAL JOIN job_list NATURAL JOIN order_list NATURAL JOIN products
WHERE job_list.job = 'teacher'

/*9.직업이 student인 고객의 이름과 구매총액을 구하시오.*/
SELECT customers.c_name, SUM(products.p_price)
FROM customers NATURAL JOIN job_list NATURAL JOIN order_list NATURAL JOIN products
WHERE job_list.job = 'student'

/*한번도 구매하지 않은 사람의 직업을 구하시오.*/
SELECT job_list.job
FROM job_list NATURAL JOIN customers
LEFT JOIN order_list
ON order_list.c_id = customers.c_id
WHERE order_list.c_id IS NULL

CREATE TABLE member(
	m_id		
);