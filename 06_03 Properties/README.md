Object InputStream  --> 객체를 읽고 쓸 수 있다.

Object OutputStream --> 객체를 읽고 쓸 수 있다.

객체를 바이트 데이터로 쪼개서 파일(파일이 아니라도 상관 없음) 에 쓴다. (write)  

객체를 바이트 단위로 쪼개서 어디로 write 할 수 있고 (마샬링) 다시 read해서 객체로 만들 수 있다 (언마샬링).

--- > 객체 직렬화 (Serialization) 를 보여주는 애들이 Object inputStram, outputStream

--> 직렬화가 되는놈이 있고 안되는 놈이 있다.  



Serializable -- > 제일 많이 사용 되는 마크 인터페이스 ( 직렬화를 하는냐 안하느냐를 구분하는)

