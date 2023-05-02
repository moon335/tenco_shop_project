<%@page import="com.tenco.tencoshop.dto.LoginResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
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
.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48
}

.container {
	display: flex;
	padding-top: 30px;
	height: 100vh;
}

.side div {
	width: 180px;
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

.show {
	display: flex;
	flex-direction: row;
}

.faqTitle ul {
	margin: 0;
	padding: 0;
	justify-content: space-between;
	border-bottom: 1px solid #ccc;
	cursor: hand;
}

.faqTitle li {
	display: flex;
}

.faqContent {
	background-color: #eee;
}

.faqContent p {
	display: none;
	padding: 20px;
	height: 100px;
}

.category-list-table {
	margin: 10px 0 10px 0;
	width: 100%;
}

.category-list-table td {
	border: 1px solid #ebebeb;
}

.category-list {
	width: 300px;
	height: 80px;
	text-align: center;
}

button:hover {
	color: black;
	font-weight: bold;
}

.search-faq input {
	margin-top: 10px;
	padding: 10px;
	width: 880px;
	height: 40px;
	background-color: #f4f4f4;
	border: none;
	border-radius: 5px;
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
if(user != null){
if (user.getRole().equals("user")) {
%>
<style>
.top-inner>label {
	padding: 10px 10px;
}
</style>
<%
	}
}
%>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${principal.role eq 'admin'}">
			</c:when>
			<c:otherwise>
				<div class="side-menu">
					<h2 class="side-menu-title">고객센터</h2>
					<div class="side-menu-list">
						<a href="list">공지사항</a> <a href="faq">자주 묻는 질문</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="content-area">
			<div class="content-title-border">
				<h3>자주 묻는 질문(FAQ)</h3>
			</div>
			<div class="search-faq">
				<form action="/notice/findProc" method="get">
					<input type="text" name="find" placeholder="검색">
				</form>
			</div>
			<div class="category-list-table">
				<table>
					<tr>
						<td class="category-list">
							<button type="submit" name="category" value="all" onclick="location.href='/notice/categorySelect'">전체</button>
						</td>
						<td class="category-list">
							<button type="submit" name="category" value="이용정책" onclick="location.href='/notice/categorySelect?type=이용정책'">이용정책</button>
						</td>
						<td class="category-list">
							<button type="submit" name="category" value="공통" onclick="location.href='/notice/categorySelect?type=공통'">공통</button>
						</td>
						<td class="category-list">
							<button type="submit" name="category" value="구매" onclick="location.href='/notice/categorySelect?type=구매'">구매</button>
						</td>

					</tr>
				</table>
			</div>
			<div class="customer-notice">
				<c:forEach var="faqList" items="${faqList}">
					<div class="faqTitle" id="show-${faqList.id}">
						<ul class="show">
							<li>[${faqList.category}] ${faqList.title}</li>
							<li><span class="material-symbols-outlined">expand_more</span></li>
						</ul>
					</div>
					<div class="faqContent">
						<p id="hide-${faqList.id}">${faqList.content}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[id^="show-"]').each(function() {
				let id = $(this).attr("id");
				let num = id.split("-")[1];
				$(this).click(function() {
					$("#hide-" + num).toggle();
				});
			});
		});
	</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
	