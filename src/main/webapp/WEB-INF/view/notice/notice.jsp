<%@page import="com.tenco.tencoshop.dto.LoginResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
LoginResponseDto user = (LoginResponseDto) session.getAttribute("principal");
if (user != null) {
	String role = user.getRole();
	if (role.equals("admin")) {
%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<%
} else {
%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%
}
} else {
%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%
}
%>
<style type="text/css">
.container {
	display: flex;
	padding-top: 30px;
	height: 100vh;
}

.side-menu {
	display: flex;
	flex-direction: column;
}

h2, h3 {
	font-weight: bold;
}

.side-menu-list {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.side-menu-list a {
	margin-top: 10px;
}

.customer-notice li {
	list-style: none;
	border-bottom: 1px solid #ccc;
}

.side-menu a {
	color: black;
	text-decoration: none;
}

.content-area {
	width: 880px;
	margin-left: 50px;
}

.content-title-border {
	border-bottom: 3px solid black;
}

.content-title-border h2 {
	margin-top: 25px;
	height: 25px;
}

.customer-notice a {
	text-decoration: none;
	color: black;
}

.customer-notice li {
	padding: 10px;
}

body {
	width: 1183px;
	margin: 0 auto;
}

.header {
	display: flex;
	margin-bottom: 40px;
	padding: 20px;
	width: 100%;
	justify-content: space-between;
}

.body {
	display: flex;
}

.side {
	margin: 30px;
}

.side a {
	color: gray;
	text-decoration-line: none;
}

.side a:hover {
	color: black;
}

.side div {
	width: 180px;
	margin-bottom: 25px;
}

.content {
	margin: 20px;
	width: 1000px;
}

.content {
	display: flex;
	flex-direction: column;
}

.contentTitle div {
	display: flex;
	justify-content: space-between;
}

.contentTitle div form input {
	border-radius: 10px;
	width: 400px;
}

.contentTitle div button {
	border-radius: 10px;
	color: white;
	background-color: #8C9EFF;
	border-style: none;
	padding: 6px 10px;
}

.contentTitle div button:hover {
	background-color: #4A5DDB;
}

.requestStatus {
	margin: 20px 0;
	display: flex;
}

.requestStatus a {
	color: #6A6A6A;
	font-size: 13px;
}

.requestStatus div {
	display: flex;
	justify-content: center;
}

.buyProduct {
	display: flex;
	flex: 1;
	align-items: center;
	border-bottom: 1px solid #D2D2D2;
}

.buyProduct div {
	display: flex;
	justify-content: center;
	flex-direction: column;
	text-align: center;
}

.buyProduct div a {
	font-size: 15px;
	color: black;
}

.content>div:nth-child(3) {
	border-top: 1px solid black;
}

.class =deleteA {
	display: flex;
	justify-content: center;
	align-items: center;
}

.deleteButton {
	margin-left: -10px;
	border: 1px solid #ccc;
	border-radius: 9px;
	padding: 0 1px;
	background-color: white;
	color: black;
	text-align: center;
}

.top-inner>label {
	padding: 0 10px;
}

.top-inner a {
	text-decoration: none;
}

.side div h4 a {
	font-size: 1.5rem;
	font-weight: 500;
	line-height: 1.2;
}

.content-title-border h3 {
	font-size: 1.75rem;
	line-height: 1.2;
	margin-bottom: 0.5rem;
}
</style>
<%
if (user.getRole().equals("user")) {
%>
<style>
.top-inner>label {
	padding: 10px 10px;
}
</style>
<%
}
%>
<div class="container">
	<%
	if (user == null || user.getRole().equals("user")) {
	%>
	<div class="side-menu">
		<h2 class="side-menu-title">고객센터</h2>
		<div class="side-menu-list">
			<a href="list">공지사항</a> <a href="faq">자주 묻는 질문</a>
		</div>
	</div>
	<%
	}
	%>
	<div class="content-area">
		<div class="content-title-border">
			<h3>공지사항</h3>
		</div>
		<div class="customer-notice">
			<c:forEach var="list" items="${list}">
				<li><a href="/notice/${list.id}">[${list.categoryName}] ${list.title}</a></li>
			</c:forEach>
		</div>
		<c:if test="${principal.role eq 'admin'}">
			<button onclick="location.href='/notice/noticeForm'">글쓰기</button>
			<button onclick="location.href='/notice/deleteForm'">삭제하기</button>
		</c:if>
	</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
