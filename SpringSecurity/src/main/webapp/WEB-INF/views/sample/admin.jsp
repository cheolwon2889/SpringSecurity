<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> view/admin.jsp</h1>

<sec:authentication property="principal"/>

<!-- 673 isAnonymous()  -->
<sec:authorize access="isAnonymous()">
<!-- 익명의 사용자일때 (로그인 X) -->
<a href="/customLogin">로그인</a>

</sec:authorize>


</body>
</html>