<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!-- 헤더 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/header.jsp"%>

<body>

	 <form action="/login/userDeleteDone" method="post" >
	 <label>계정 삭제</label>
	 <input type="hidden" name="userid" value="${MEMBER.userid }">
	 <button type="submit">삭제</button>
	  </form>

</body>

<!-- 푸터 삽입 : 타일즈 교체 예정 -->
<%@ include file="../commons/footer.jsp"%>
