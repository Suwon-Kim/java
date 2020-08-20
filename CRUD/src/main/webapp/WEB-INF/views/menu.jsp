<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<nav class="navbar navbar-default">
	<div class="container">
		<ul class="nav navbar-nav">
			<li style="margin-left:50px;"><a href="home">메인</a></li> 
			<li><a href="main?pageNum=1">자유게시판</a></li>
<!-- 			<li><a href="chart">통계</a></li>  -->
			
                  <!-- 로그인세션 -->  
				 <c:if test="${sessionScope.am_id eq null}">
				    <li style="margin-left:700px;"> 
                		<a href="joinForm">회원가입</a>
              	 	 </li> 
					<li>	
                	<a href="loginForm">로그인</a>
               		</li>
				 </c:if>	 
	 			 <c:if test="${sessionScope.am_id ne null}">	
            	 	 <li style="margin-left:600px;">
                	  	<a href="#">${sessionScope.am_name}(${sessionScope.am_id})님 반갑습니다.</a> 
               		 </li>
               	<li>   
                	<a href="logout">로그아웃</a>
                </li>
                </c:if>  
                <!-- 로그인세션 -->
			
			
<!-- 			<li><a href="loginForm">로그인</a></li>  -->
<!-- 			<li><a href="joinForm">회원가입</a></li>	 -->
<%-- 			<li><a href="#">${sessionScope.am_name }님 환영합니다!</a></li>	 --%>
<!-- 			<li><a href="logout">로그아웃</a></li>  -->
		</ul>
	</div>
</nav>  