<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	<h1>
		[ 가계부 ] 
	</h1>
	<c:if test="${empty sessionScope.loginid }">
	<ul>
		<li><a href="/account/join">회원 가입</a></li>
		<li><a href="/account/login">로그인</a></li>
	</ul>
	</c:if>
	<c:if test="${not empty sessionScope.loginid }">
	<ul>
		<li><a href="/moneybook/moneybook">내 가계부</a></li>
		<li><a href="/account/logout">로그아웃</a></li>
	</ul>
	</c:if>
</body>
</html>
