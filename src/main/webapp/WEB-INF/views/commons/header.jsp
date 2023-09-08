<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Landing Page - Start Bootstrap Theme</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="/resources//resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)	-->
<link href="/resources/css/styles.css" rel="stylesheet" />
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-light bg-light static-top">
		<div class="container">
			<a class="navbar-brand" href="/"><img alt="사이트 로고	"
				src="../resources/assets/siteLogo.png"></a> <a
				class="navbar-brand" href="/board/list">게시판</a>
				<c:if test="${MEMBER  eq null}">
				<a class="btn btn-primary" href="${contextPath}/login/isLogin ">로그인</a>
				<a class="btn btn-primary" href="/login/memberForm">회원가입</a>
				</c:if>			 
				<c:if test="${MEMBER  ne null}">
				<a class="btn btn-primary" href="${contextPath}/login/login ">로그아웃</a>
				<a class="btn btn-primary" href="/login/myPage">마이페이지</a>
				</c:if>
			
		</div>
	</nav>
