<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!-- 헤더 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/header.jsp"%>

<body>

	 <form action="/login/userUpdate" method="post" >
	 <label>휴대폰 번호 수정</label>
	 <input type="text" name="userphone" placeholder="변경할 휴대폰 번호를 입력하세요.">
	 <input type="hidden" name="userid" value="${MEMBER.userid }">
	 <button type="submit">수정</button>
	  </form>

</body>

<!-- 푸터 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/footer.jsp"%>
