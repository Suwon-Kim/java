DELETE FROM car;

CREATE TABLE car(
	car_id		INT		PRIMARY KEY		AUTO_INCREMENT,
	car_model	CHAR(4)	NOT NULL,
	car_price	INT		NOT NULL,
	car_desc	VARCHAR(20)
);

DESC car;

SELECT count(*) FROM car;