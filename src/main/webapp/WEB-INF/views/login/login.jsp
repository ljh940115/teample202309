<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 헤더 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/header.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%request.setCharacterEncoding("utf-8"); %>
</head>
<body>

	<form action="login" method="post">
		id : <input type="text" name="userid"> <br> 
		pw : <input type="password" name="userpw"> <br>
		<button type="submit">로그인</button> 
	</form>

</body>

<!-- 푸터 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/footer.jsp"%>