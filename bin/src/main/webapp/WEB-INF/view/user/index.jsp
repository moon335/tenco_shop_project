<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 메인 페이지(지울 예정)</h1>
	<c:forEach var="list" items="${list}">
		<p>username : ${list.username}</p>
		<p>password : ${list.password}</p>
	</c:forEach>
</body>
</html>