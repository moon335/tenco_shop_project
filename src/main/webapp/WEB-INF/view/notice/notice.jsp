<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
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
</style>
</head>
<body>
	<div class="container">
		<div class="side-menu">
			<h2 class="side-menu-title">고객센터</h2>
			<div class="side-menu-list">
				<a href="list">공지사항</a> <a href="faq">자주 묻는 질문</a>
			</div>
		</div>
		<div class="content-area">
			<div class="content-title-border">
				<h3>공지사항</h3>
			</div>
			<div class="customer-notice">
				<c:forEach var="list" items="${list}">
					<li><a href="/notice/${list.id}">[${list.categoryName}]
							${list.title}</a></li>
				</c:forEach>
			</div>
			<c:if test="${user.getRole().equals('admin')}">
					<button onclick="location.href='/notice/noticeForm'">글쓰기</button>
					<button onclick="location.href='/notice/deleteForm'">삭제하기</button>
			</c:if>
		</div>
	</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
