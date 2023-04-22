<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
	<main>
		<c:forEach var="list" items="${cartList}">
			<p>영어 이름 : ${list.engName}</p>
			<p>한글 이름 : ${list.korName}</p>
			<p>가격 : ${list.purchase}</p>
			<p>가격 : ${list.purchase}</p>
			<p>가격 : ${list.purchase}</p>
		</c:forEach>
	</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
