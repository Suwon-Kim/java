/*
 	���� : ���� (�巹��) �� alt + x
	���̺� ����
	VARCHAR(5(����Ʈ)) -- > ���� ���ϰų� ������ �� �ð��� ����� �� ������ �ȵǰų� ������ ���� ���ϴ� ������ VARCHAR
	CHAR() -- > ���� ���ϴ°͵��� CHAR 
	INT(8(Zerofill�ϸ� 8�ڸ��� �����ڸ� 0 ���� ä��ڴ�) -- >  
*/
DROP TABLE car;

CREATE TABLE car (
	car_id		INT 			PRIMARY KEY				 	AUTO_INCREMENT,
	car_model	CHAR(20)		NOT NULL,
	car_price	INT				NOT NULL,
	car_desc	VARCHAR(200)
);
/*
 * 1 row affected (�ϳ��� �� row�� �����ٴ� ����)
 * primaryKey�� not null�� ������ �ȵ�
 */
DESC car;
/*
 * ������ �Է� (Create) -- > (INSERT INTO)
 */
INSERT INTO car (car_model, car_price, car_desc)
	VALUES ('Sonata',3000,'not bad');
INSERT INTO car (car_desc, car_model, car_price) -- ���� ���ϴ´�� ���� �� �� �ִ� 
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
 * ������ �б� (Read) -- > SELECT 
 */
SELECT * FROM car;
/*
 * ��Ī�ޱ�
 */
SELECT car_model model,  car_price price
	FROM car;
SELECT car_model AS model,  car_price AS price 
	FROM car; 
	--AS ��Ī 
/*
 * ����
 */
SELECT *
	FROM car WHERE car_price = 3000;
	
SELECT *
	FROM car WHERE car_price <> 3000;	
	--<> �ٸ��ٴ� ��

SELECT * 
	FROM car WHERE NOT car_price = 3000;	
	--�ٸ��� 

-- ������ 2500���� �̻� 5000���� �̸� �� ���ϱ� 
SELECT *
	FROM car 
	WHERE car_price >= 2500 AND car_price < 5000;

SELECT * 
	FROM car 
	WHERE car_price BETWEEN 3000 AND 3700; 
	--3000�̻� 3700����

-- 3000�̰ų� 3700�� �ڵ���
SELECT * 
	FROM car 
	WHERE car_price = 3000 OR car_price = 3700;

-- 3000�̰ų� 3700�� �ڵ���
SELECT * 
	FROM car 
	WHERE car_price IN (3000, 3700);

--������ NULL�� �ڵ��� 
SELECT *
	FROM car 
	WHERE car_desc IS NULL;
--������ NOTNULL�� �ڵ���
SELECT * FROM car WHERE car_desc IS NOT NULL;

--���� (���� �����ʹ� ������ �߿�)
SELECT * 
	FROM car 
	ORDER BY car_price ASC;	
	--�������� ����

SELECT * 
	FROM car 
	ORDER BY car_price;	
	--DEFALUE ���� ��������

SELECT * 
	FROM car 
	ORDER BY car_price DESC;	
	--��������

-- �������� �������� ����, ������ ������ �ڵ����� ���� ID�� �������� ���� 
SELECT * 
	FROM car 
	ORDER BY car_price DESC,car_id DESC;

-- �д� ���� FROM -> WHERE -> ORDERBY -> *
SELECT * 
	FROM car 
	WHERE car_price >= 2500 
	ORDER BY car_price DESC,car_id DESC;	

-- ���� ����� 3�� 
SELECT *
	FROM car 
	WHERE car_price >= 2500 
	ORDER BY car_price DESC, car_id DESC
	LIMIT 3, 2;	-- �ε��� 3���� 2�� ���Ͷ� 
	
/*
 *  - : ���ϵ� ī�� 
 * 	% : 0 ~ ���Ѵ� 
 * 	_ : 1���� 
 */

SELECT car_model 
	FROM car
	WHERE car_model LIKE 'm%'; --m���� �����ϴ� ��� ���ڿ�

SELECT car_model 
	FROM car
	WHERE car_model LIKE '%m%'; --m�� ��  ��� ���ڿ�

SELECT car_model 
	FROM car
	WHERE car_model LIKE '_m_'; --3�����ε� �߰��� m�� ��
	

-- primaryŰ�� ã�°� ���� ������. ���̺��� �ε����� ������ 
-- ������ ���̺��� ������ ���� 
-- �ε����� �츮�� ���Ƿ� ���� �� �� �ִµ� ������ ����� �ȵȴ� �ε����� �����ϴ� ���� �߿� �ϳ� (�ʹ� ���� �ε����� ��ȿ�� �����̳� ������ �Ͼ�� )  
-- binarySearch�� ���� ���� ��� (��Ī�߿�)


/*
 * ���� (Delete) - > DELETE FROM 
 */
SELECT * FROM car WHERE car_model = 'K5';
DELETE FROM car WHERE car_model = 'k5';
/*
 * ���� (Update) -> UPDATE 
 */

/*
 * �ּ� ���� ������ ���� �� �� �� �ֱ� ������ �ּ��� �ǵ����̸� �ȵ����� 
 */
SELECT * FROM car WHERE car_id = 2; --Ȯ���ϴ� ������ ������ ������Ʈ�� ����Ʈ �� ��
--primaryKey�� ������ �Ұ����ϴ�..
--���� ���̺��ε� ����ȭ�� �ȵǴ� ��쿡�� cmd���� ��¥ ���̺��� �����غ��� 
UPDATE car SET car_desc = 'very good', car_price = 3800 WHERE car_id = 2;
