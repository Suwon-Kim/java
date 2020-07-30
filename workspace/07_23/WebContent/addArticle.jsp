<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "kr.ac.green.Article "%>
<%@ page import = "java.util.Vector "%>
<!-- 눈에 보이지 않는 페이지라서 필요 없음 밑에 설정같은것이 addArticle.jsp -->
<%
	request.setCharacterEncoding("euc_kr");
	String title = request.getParameter("title");	//사용자한테 받은 title
	String writer = request.getParameter("writer");	//사용자한테 받은 writer
	String pw = request.getParameter("pw");	//사용자한테 받은 pw
	String contents = request.getParameter("contents");	//사용자한테 받은 contents
	
	Article article = new Article(title, writer, contents, pw);
	
	//list(제목, 글쓴이, 비밀번호, 글내용)	
	Vector<Article> list = (Vector<Article>) application.getAttribute("list");
	//list 처음에는 null값 
	if(list == null) {
		list = new Vector<Article>(); //list(제목, 글쓴이, 비밀번호, 글내용) 
		application.setAttribute("list",list);
		//이름이 list인 속성의 값을 list로 지정한다 (서버가 종료 될 때 까지 유지)
	}
	list.add(article);//빈 벡터 list에 article 객체를 대입 
	response.sendRedirect("list.jsp");
%>
