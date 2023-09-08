<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 헤더 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/header.jsp"%>
    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h1>Custom Login Page</h1>
  
  <!-- submit버튼 누르면 post 방식으로 /login 요청 보냄 -->
  <form method='post' action="/login/memberRegist">
  
  <div>
    <input type='text' name='userid'>
  </div>
  <div>
    <input type='password' name='userpw'>
  </div>
  <div>
    <input type='text' name='username'>
  </div>
  <div>
    <input type='text' name='userphone'>
  </div>
  <div>
    <input type='submit'>
  </div>
 
  </form>
  
</body>

<!-- 푸터 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/footer.jsp"%>