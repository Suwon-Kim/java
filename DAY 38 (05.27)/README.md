

fie -> fis (필수 ) -> isr(필터--> 파라미터로 다른 스트림을 받게 되어 있다.) -> br(필터) (파일을 줄단위로 읽어오는 스트림 ) -> (String) -> pw(println) -> fw (write)

OutputStreamWriter -->  (writer는 char를 쓰는놈) (outputStream byte를 쓰는놈)

--> char에서 byte로 변환하는 스트림

file -> fis -> isr -> br -> String <- pw <- fw

pw (PrintWriter) -> fw (FileWriter)

읽으면 닫아줘야하고 쓰면 닫아줘야한다 ( 스트림을 들고 있으면 안된다.)



파일이 있다. 파일을 읽을 수 있는 스트림을 선택 해야한다. 

내가 읽고자 하는 파일이 byte로 구성되어 있다면 FileInputStream을 사용 할 수 있다.

파일에 한글이 있는걸 알게 되었다면 byte 값을 char형으로 변환 시켜주는 놈이 필요하다

그래서 InputStreamReader를 사용해서 FileInputStream의 값을 읽는다.

근데 한글자 한글자 읽어오는게 너무 느리다 그래서 한줄씩 읽어오고 싶다는 생각을 하였다. BufferedReader를 사용한다. 

이제 내가 읽어온 파일들을 다른 파일에 쓰고 싶다는 생각을 하였다. 그래서 

printWriter를 사용해서 



