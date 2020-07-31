/*
 	실행 : 선택 (드레그) 후 alt + x
	테이블 생성
	VARCHAR(5(바이트)) -- > 값이 변하거나 수정될 때 시간과 비용이 들어감 수정이 안되거나 수정을 거의 안하는 값들은 VARCHAR
	CHAR() -- > 값이 변하는것들은 CHAR 
	INT(8(Zerofill하면 8자리를 남는자리 0 으로 채우겠다) -- >  
*/
DROP TABLE car;

CREATE TABLE car (
	car_id		INT 			PRIMARY KEY				 	AUTO_INCREMENT,
	car_model	CHAR(20)		NOT NULL,
	car_price	INT				NOT NULL,
	car_desc	VARCHAR(200)
);
/*
 * 1 row affected (하나의 줄 row가 변경됬다는 뜻임)
 * primaryKey는 not null임 변경이 안됨
 */
DESC car;
/*
 * 데이터 입력 (Create) -- > (INSERT INTO)
 */
INSERT INTO car (car_model, car_price, car_desc)
	VALUES ('Sonata',3000,'not bad');
INSERT INTO car (car_desc, car_model, car_price) -- 내가 원하는대로 지정 할 수 있다 
	VALUES ('good', 'SM7', 3700);
INSERT INTO car (car_model, car_price)
	VALUES ('genesis', 6000);
INSERT INTO car (car_model, car_price, car_desc)
	VALUES 
	('avente', 2500, 'bad'), 
	('morning', 1800, 'great'),
	('k5', 3000, 'trash'),
	('malibu', 3100, 'cool');
/*
 * 데이터 읽기 (Read) -- > SELECT 
 */
SELECT * FROM car;
/*
 * 별칭달기
 */
SELECT car_model model,  car_price price
	FROM car;
SELECT car_model AS model,  car_price AS price 
	FROM car; 
	--AS 별칭 
/*
 * 조건
 */
SELECT *
	FROM car WHERE car_price = 3000;
	
SELECT *
	FROM car WHERE car_price <> 3000;	
	--<> 다르다는 뜻

SELECT * 
	FROM car WHERE NOT car_price = 3000;	
	--다르다 

-- 가격이 2500만원 이상 5000만원 미만 차 구하기 
SELECT *
	FROM car 
	WHERE car_price >= 2500 AND car_price < 5000;

SELECT * 
	FROM car 
	WHERE car_price BETWEEN 3000 AND 3700; 
	--3000이상 3700이하

-- 3000이거나 3700인 자동차
SELECT * 
	FROM car 
	WHERE car_price = 3000 OR car_price = 3700;

-- 3000이거나 3700인 자동차
SELECT * 
	FROM car 
	WHERE car_price IN (3000, 3700);

--설명이 NULL인 자동차 
SELECT *
	FROM car 
	WHERE car_desc IS NULL;
--설명이 NOTNULL인 자동차
SELECT * FROM car WHERE car_desc IS NOT NULL;

--정렬 (복수 데이터는 정렬이 중요)
SELECT * 
	FROM car 
	ORDER BY car_price ASC;	
	--오름차순 정렬

SELECT * 
	FROM car 
	ORDER BY car_price;	
	--DEFALUE 값이 오름차순

SELECT * 
	FROM car 
	ORDER BY car_price DESC;	
	--내림차순

-- 가격으로 내림차순 정렬, 가격이 동일한 자동차에 대해 ID로 내림차순 정렬 
SELECT * 
	FROM car 
	ORDER BY car_price DESC,car_id DESC;

-- 읽는 순서 FROM -> WHERE -> ORDERBY -> *
SELECT * 
	FROM car 
	WHERE car_price >= 2500 
	ORDER BY car_price DESC,car_id DESC;	

-- 제일 비싼차 3개 
SELECT *
	FROM car 
	WHERE car_price >= 2500 
	ORDER BY car_price DESC, car_id DESC
	LIMIT 3, 2;	-- 인덱스 3부터 2개 들고와라 
	
/*
 *  - : 와일드 카드 
 * 	% : 0 ~ 무한대 
 * 	_ : 1글자 
 */

SELECT car_model 
	FROM car
	WHERE car_model LIKE 'm%'; --m으로 시작하는 모든 문자열

SELECT car_model 
	FROM car
	WHERE car_model LIKE '%m%'; --m이 들어간  모든 문자열

SELECT car_model 
	FROM car
	WHERE car_model LIKE '_m_'; --3글자인데 중간에 m이 들어감
	

-- primary키로 찾는게 제일 빠르다. 테이블에는 인덱스가 존재함 
-- 실제로 테이블에는 순서가 없음 
-- 인덱스를 우리가 임의로 만들 수 도 있는데 무조건 만들면 안된다 인덱스는 정렬하는 기준 중에 하나 (너무 많은 인덱스는 역효과 변경이나 수정이 일어나면 )  
-- binarySearch가 가장 빠른 방법 (서칭중에)


/*
 * 삭제 (Delete) - > DELETE FROM 
 */
SELECT * FROM car WHERE car_model = 'K5';
DELETE FROM car WHERE car_model = 'k5';
/*
 * 수정 (Update) -> UPDATE 
 */

/*
 * 주석 들어가면 가끔씩 에러 날 수 도 있기 때문에 주석은 되도록이면 안들어가도록 
 */
SELECT * FROM car WHERE car_id = 2; --확인하는 습관을 들이자 업데이트랑 딜리트 할 때
--primaryKey는 변경이 불가능하다..
--같은 테이블인데 동기화가 안되는 경우에는 cmd들어가서 진짜 테이블을 조사해보자 
UPDATE car SET car_desc = 'very good', car_price = 3800 WHERE car_id = 2;
