
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
 
/*1.�λ꿡 ��� ���� ������ ���϶�.*/
SELECT job_list.job
FROM job_list INNER JOIN customers
ON customers.j_id = job_list.j_id
WHERE customers.c_addr = 'pusan';

/*2.�̸��� kim�� ����� ������*/
SELECT job_list.job
FROM job_list INNER JOIN customers
ON customers.j_id = job_list.j_id
WHERE customers.c_name = 'kim';

/*3.���� ������ �� ��ǰ�� ��ǰ����?*/
SELECT p_name, MIN(p_price)
FROM products

/*4.���� ������ ��ǰ�� �̸�,����, �������ڸ� ���Ͻÿ�. ��, �ֽ� ���ż����� �����Ѵ�.*/
SELECT order_list.o_count, order_list.o_date, products.p_name
FROM products INNER JOIN order_list
ON products.p_id = order_list.p_id
ORDER BY order_list.o_date DESC
 
 /*5.���� ��� ��ǰ�� ������ ���� �̸��� ���Ͻÿ�.*/
SELECT customers.c_name
FROM customers INNER JOIN order_list INNER JOIN products
ON customers.c_id = order_list.c_id
AND order_list.p_id = products.p_id
WHERE products.p_price = (SELECT max(p_price) FROM products);

/*6.DVD�� TV�� ������ ���� �̸��� �ּ�, ��ǰ���� ���Ͻÿ�.*/
SELECT customers.c_name, customers.c_addr, products.p_name
FROM customers INNER JOIN order_list INNER JOIN products
ON customers.c_id = order_list.c_id
AND order_list.p_id = products.p_id
WHERE products.p_name = 'DVD' OR products.p_name = 'TV'

/*7.doo�� ������ ������ �Ѿ��� ���Ͻÿ�.*/
SELECT SUM(products.p_price) AS perchase_sum
FROM customers INNER JOIN order_list INNER JOIN products
ON customers.c_id = order_list.c_id
AND order_list.p_id = products.p_id
WHERE customers.c_name = 'doo'

/*8.������ teacher�� ����� ������ ��ǰ����� ���Ͻÿ�.*/
SELECT products.p_name
FROM customers NATURAL JOIN job_list NATURAL JOIN order_list NATURAL JOIN products
WHERE job_list.job = 'teacher'

/*9.������ student�� ���� �̸��� �����Ѿ��� ���Ͻÿ�.*/
SELECT customers.c_name, SUM(products.p_price)
FROM customers NATURAL JOIN job_list NATURAL JOIN order_list NATURAL JOIN products
WHERE job_list.job = 'student'

/*�ѹ��� �������� ���� ����� ������ ���Ͻÿ�.*/
SELECT job_list.job
FROM job_list NATURAL JOIN customers
LEFT JOIN order_list
ON order_list.c_id = customers.c_id
WHERE order_list.c_id IS NULL

CREATE TABLE member(
	m_id		
);