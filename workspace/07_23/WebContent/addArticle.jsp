<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "kr.ac.green.Article "%>
<%@ page import = "java.util.Vector "%>
<!-- ���� ������ �ʴ� �������� �ʿ� ���� �ؿ� ������������ addArticle.jsp -->
<%
	request.setCharacterEncoding("euc_kr");
	String title = request.getParameter("title");	//��������� ���� title
	String writer = request.getParameter("writer");	//��������� ���� writer
	String pw = request.getParameter("pw");	//��������� ���� pw
	String contents = request.getParameter("contents");	//��������� ���� contents
	
	Article article = new Article(title, writer, contents, pw);
	
	//list(����, �۾���, ��й�ȣ, �۳���)	
	Vector<Article> list = (Vector<Article>) application.getAttribute("list");
	//list ó������ null�� 
	if(list == null) {
		list = new Vector<Article>(); //list(����, �۾���, ��й�ȣ, �۳���) 
		application.setAttribute("list",list);
		//�̸��� list�� �Ӽ��� ���� list�� �����Ѵ� (������ ���� �� �� ���� ����)
	}
	list.add(article);//�� ���� list�� article ��ü�� ���� 
	response.sendRedirect("list.jsp");
%>
