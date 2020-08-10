
DROP TABLE customers;
DROP TABLE orderItems;
DROP TABLE orders;
DROP TABLE products;
DROP TABLE vendors;

CREATE TABLE customers
(
  cust_id      CHAR(10)  NOT NULL ,
  cust_name    CHAR(50)  NOT NULL ,
  cust_address CHAR(50)  NULL ,
  cust_city    CHAR(50)  NULL ,
  cust_state   CHAR(5)   NULL ,
  cust_zip     CHAR(10)  NULL ,
  cust_country CHAR(50)  NULL ,
  cust_contact CHAR(50)  NULL ,
  cust_email   CHAR(255) NULL ,
  PRIMARY KEY(cust_id)
);

CREATE TABLE orderItems
(
  order_num  INT          NOT NULL ,
  order_item INT          NOT NULL ,
  prod_id    CHAR(10)     NOT NULL ,
  quantity   INT          NOT NULL ,
  item_price DECIMAL(8,2) NOT NULL ,
  PRIMARY KEY (order_num, order_item)
);



CREATE TABLE orders
(
  order_num  INT      NOT NULL ,
  order_date DATETIME NOT NULL ,
  cust_id    CHAR(10) NOT NULL ,
  PRIMARY KEY (order_num)
);

CREATE TABLE products
(
  prod_id    CHAR(10)      NOT NULL ,
  vend_id    CHAR(10)      NOT NULL ,
  prod_name  CHAR(255)     NOT NULL ,
  prod_price DECIMAL(8,2)  NOT NULL ,
  prod_desc  TEXT          NULL ,
  PRIMARY KEY (prod_id)
);

CREATE TABLE vendors
(
  vend_id      CHAR(10) NOT NULL ,
  vend_name    CHAR(50) NOT NULL ,
  vend_address CHAR(50) NULL ,
  vend_city    CHAR(50) NULL ,
  vend_state   CHAR(5)  NULL ,
  vend_zip     CHAR(10) NULL ,
  vend_country CHAR(50) NULL ,
  PRIMARY KEY (vend_id)
);


INSERT INTO customers(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email)
VALUES('1000000001', 'Village Toys', '200 Maple Lane', 'Detroit', 'MI', '44444', 'USA', 'John Smith', 'sales@villagetoys.com');
INSERT INTO customers(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact)
VALUES('1000000002', 'Kids Place', '333 South Lake Drive', 'Columbus', 'OH', '43333', 'USA', 'Michelle Green');
INSERT INTO customers(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email)
VALUES('1000000003', 'Fun4All', '1 Sunny Place', 'Muncie', 'IN', '42222', 'USA', 'Jim Jones', 'jjones@fun4all.com');
INSERT INTO customers(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact, cust_email)
VALUES('1000000004', 'Fun4All', '829 Riverside Drive', 'Phoenix', 'AZ', '88888', 'USA', 'Denise L. Stephens', 'dstephens@fun4all.com');
INSERT INTO customers(cust_id, cust_name, cust_address, cust_city, cust_state, cust_zip, cust_country, cust_contact)
VALUES('1000000005', 'The Toy Store', '4545 53rd Street', 'Chicago', 'IL', '54545', 'USA', 'Kim Howard');

INSERT INTO vendors(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country)
VALUES('BRS01','Bears R Us','123 Main Street','Bear Town','MI','44444', 'USA');
INSERT INTO vendors(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country)
VALUES('BRE02','Bear Emporium','500 Park Street','Anytown','OH','44333', 'USA');
INSERT INTO vendors(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country)
VALUES('DLL01','Doll House Inc.','555 High Street','Dollsville','CA','99999', 'USA');
INSERT INTO vendors(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country)
VALUES('FRB01','Furball Inc.','1000 5th Avenue','New York','NY','11111', 'USA');
INSERT INTO vendors(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country)
VALUES('FNG01','Fun and Games','42 Galaxy Road','London', NULL,'N16 6PS', 'England');
INSERT INTO vendors(vend_id, vend_name, vend_address, vend_city, vend_state, vend_zip, vend_country)
VALUES('JTS01','Jouets et ours','1 Rue Amusement','Paris', NULL,'45678', 'France');

INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BR01', 'BRS01', '8 inch teddy bear', 5.99, '8 inch teddy bear, comes with cap and jacket');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BR02', 'BRS01', '12 inch teddy bear', 8.99, '12 inch teddy bear, comes with cap and jacket');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BR03', 'BRS01', '18 inch teddy bear', 11.99, '18 inch teddy bear, comes with cap and jacket');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BNBG01', 'DLL01', 'Fish bean bag toy', 3.49, 'Fish bean bag toy, complete with bean bag worms with which to feed it');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BNBG02', 'DLL01', 'Bird bean bag toy', 3.49, 'Bird bean bag toy, eggs are not included');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BNBG03', 'DLL01', 'Rabbit bean bag toy', 3.49, 'Rabbit bean bag toy, comes with bean bag carrots');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('RGAN01', 'DLL01', 'Raggedy Ann', 4.99, '18 inch Raggedy Ann doll');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('RYL01', 'FNG01', 'King doll', 9.49, '12 inch king doll with royal garments and crown');
INSERT INTO products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('RYL02', 'FNG01', 'Queen doll', 9.49, '12 inch queen doll with royal garments and crown');

INSERT INTO orders(order_num, order_date, cust_id)
VALUES(20005, '2004-05-01', '1000000001');
INSERT INTO orders(order_num, order_date, cust_id)
VALUES(20006, '2004-01-12', '1000000003');
INSERT INTO orders(order_num, order_date, cust_id)
VALUES(20007, '2004-01-30', '1000000004');
INSERT INTO orders(order_num, order_date, cust_id)
VALUES(20008, '2004-02-03', '1000000005');
INSERT INTO orders(order_num, order_date, cust_id)
VALUES(20009, '2004-02-08', '1000000001');

INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20005, 1, 'BR01', 100, 5.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20005, 2, 'BR03', 100, 10.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 1, 'BR01', 20, 5.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 2, 'BR02', 10, 8.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 3, 'BR03', 10, 11.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 1, 'BR03', 50, 11.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 2, 'BNBG01', 100, 2.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 3, 'BNBG02', 100, 2.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 4, 'BNBG03', 100, 2.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 5, 'RGAN01', 50, 4.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 1, 'RGAN01', 5, 4.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 2, 'BR03', 5, 11.99);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 3, 'BNBG01', 10, 3.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 4, 'BNBG02', 10, 3.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 5, 'BNBG03', 10, 3.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 1, 'BNBG01', 250, 2.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 2, 'BNBG02', 250, 2.49);
INSERT INTO orderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 3, 'BNBG03', 250, 2.49);


SELECT * FROM products 
	WHERE vend_id = 'DLL01' OR vend_id = 'BRS01' 
	ORDER BY prod_name ASC;
	
SELECT prod_price, prod_name FROM products 
	WHERE prod_price >= 5 AND prod_price <= 10;
	
SELECT prod_name FROM products 
	WHERE prod_price IS NULL;

SELECT prod_name FROM products
	WHERE vend_id <> 'DDL01'
	ORDER BY prod_name ASC;

SELECT prod_id, prod_name FROM products
	WHERE prod_name LIKE 'Fish%';


SELECT prod_name FROM products
	WHERE prod_name LIKE 'F%y';
	
SELECT prod_id, quantity, quantity * item_price AS expanded_price
	FROM order_item
	WHERE order_name = 20008;
	
/*
 * GROUP BY -- > 묶는다.(vend_id로 그룹을 만든다)
 * COUNT(*) -- > 레코드 개수를 가져옴  
 * HAVING -- > 나눠진 그룹들 사이에서 레코드수가 2개 이상인것 
 */

SELECT vend_id, COUNT(*) AS num_prods
	FROM products
	WHERE prod_price >= 4
	GROUP BY vend_id
	HAVING COUNT(*) >= 2	
/*
 *	WHERE과 HAVING은 조건인데 사용해서 걸러낼려고 ㅆ느느거지  
 */
SELECT vend_id, SUM(prod_price) AS total_price
	FROM products
	GROUP BY vend_id;

/*
	테이블 안에서 테이블로 찾아가는 것을  서브 쿼리라고  
*/	
-- FNG01
SELECT vend_id
	FROM products
	WHERE prod_name = 'King doll';
-- = << 얘는 값을 1:1로 비교함 그래서 IN을 써야함 1대 다 비교 할 때 
SELECT vend_name, vend_address
	FROM vendors
	WHERE vend_id IN (SELECT vend_id
							FROM products
								WHERE prod_name = 'King doll');

--조인1 (								
SELECT vend_name, vend_address  
FROM 
	vendors , products  
WHERE 
	vendors.vend_id = products.vend_id;
	AND
	prod_name = 'King doll';
	
--옛날 버전
SELECT vend_name, vend_address  
FROM 
	vendors v, products p  
WHERE 
	v.vend_id = p.vend_id;
	AND
	prod_name = 'King doll';	
	
--요즘 버전
SELECT vend_name, vend_address	--SELECT는 맨 마지막에 
FROM
	vendors INNER JOIN products
ON
	vendors.vend_id = products.vend_id	--조인의 조건
WHERE
	prod_name = 'King doll'

	
SELECT vend_name, vend_address	--SELECT는 맨 마지막에 
FROM
	-- PRIMARY KEY와 FOREIGN KEY
	vendors NATURAL JOIN products	-- 열 이름이 같으면 vendors에 vend_id랑 products의 vend_id가 같으면
	-- 테이블 3개 이상 조인 하면 복잡함 그래서 씀 알아서 JOIN시켜준다 NATURAL JOIN  
WHERE
	prod_name = 'King doll'
/*
	(SELECT vend_id
	FROM products
	WHERE prod_name = 'King doll'); -- > FNG01							
*/
--(inner 조인 , 크로스 조인 outer 조인 어떻게 합치냐에 따라서 조인이 달라진다)
--테이블 여러 개를 합쳐서 논리적으로 가상의 테이블 하나로 만든것을 조인(크로스)이라고 한다 	
--크로스 조인 : 그냥 테이블을 합쳐놓은거 (실제로 쓸 일은 없다) 
--inner조인 : 양쪽에서 공통으로 가진 값을 가지고 연결하는 조인을 inner조인이라고 함 
	-- inner 조인 안에는 Natural Join, Self Join, 
--outer 조인 : 공통되지 않은 값을 가지고 연결하는 조인을 outter조인이라고 함
	-- leftJoin, rightJoin, fullJoin
--inner 조인을 가장 많이 쓴다. (조인 하면 대부분 inner 조인임) 

--조인 방식
SELECT cust_name, cust_contact
FROM 
	customers INNER JOIN orderItems INNER JOIN orders
ON
	customers.cust_id = orders.cust_id AND orders.order_num = orderItems.order_num
WHERE 
	prod_id = 'RGAN01';

	
	
--주키랑 외래키가 같을 때 사용
SELECT cust_name, cust_contact
FROM 
	customers NATURAL JOIN orders
	NATURAL JOIN orderItems
WHERE
	orderItem.prod_id = 'RGAN01'

	
--쿼리 방식
SELECT cust_name, cust_contact FROM customers WHERE cust_id IN 
	(
		SELECT cust_id FROM orders WHERE order_num IN
		(
			SELECT order_num FROM orderItems
			WHERE prop_id = 'RGAN01'
		)
	);
	
--한번도 주문하지 않은 고객의 이름을 구하라 (customers, orders)


SELECT * 
	FROM customers LEFT OUTER JOIN orders
	ON customers.cust_id = orders.cust_id

SELECT *
	FROM customers INNER JOIN orders
	ON customers.cust_id = orders.cust_id

SELECT MAX(item_price) cust_name, item_price, quantity
FROM customers INNER JOIN orders INNER JOIN orderItems
ON customers.cust_id = orders.cust_id AND
     orders.order_num = orderItems.order_num



SELECT vend_name 
FROM vendors LEFT OUTER JOIN products
ON vendors.vend_id = products.vend_id
WHERE prod_id IS NULL;
