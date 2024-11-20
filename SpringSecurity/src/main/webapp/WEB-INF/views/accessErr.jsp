<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 접근 권한 없는 페이지에 접근함! </h2>

<h2><a href="/sample/all">메인페이지 이동</a></h2>

<% 	
/* response.addHeader("refresh", "5; url='/sample/all'"); */ 
/* response.sendRedirect("/sample/all"); */

%>

</body>
</html>