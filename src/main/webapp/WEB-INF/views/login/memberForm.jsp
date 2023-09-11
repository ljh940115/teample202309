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
  <label>아이디</label>
    <input type='text' name='userid' placeholder="아이디를 입력하세요.">
  </div>
  <div>
  <label>비밀번호</label>
    <input type='password' name='userpw' placeholder="비밀번호를 입력하세요.">
  </div>
  <div>
  <label>이름</label>
    <input type='text' name='username' placeholder="이름을 입력하세요.">
  </div>
  <div>
  <label>핸드폰 번호</label>
    <input type='text' name='userphone' placeholder="ex) 010-0000-0000">
  </div>
  <div>
    <input type='submit'>
  </div>
 
  </form>
  
</body>

<!-- 푸터 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/footer.jsp"%>