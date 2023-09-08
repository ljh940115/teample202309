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

<c:if test="${MEMBER  eq null}">  
로그인 안되어있음    <br>
<a href="login">로그인하러가기</a>  <br>
<a href="memberForm">회원가입하러 가기</a>    
</c:if>
 
<c:if test="${MEMBER  ne null}"> 
 로그인 되어 있습니다 <br>
  id : ${MEMBER.userid } <br>
  name : ${MEMBER.username } <br>
  <a href="logout">로그아웃</a>       </c:if>
  
</body>

<!-- 푸터 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/footer.jsp"%>