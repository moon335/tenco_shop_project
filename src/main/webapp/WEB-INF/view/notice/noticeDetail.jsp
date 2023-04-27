<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.container {
	display: flex;
	padding-top: 30px;
	height: 800px;
}

.side-menu {
	display: flex;
	flex-direction: column;
}

.content-title-border {
	border-bottom: 3px solid black;
}

h3 {
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

.title {
	margin-top: 10px;
}

.button {
	display: flex;
	justify-content: center;
}

.button a {
	color: black;
	border: 1px solid #ccc;
	border-radius: 7px;
	padding: 5px;
	margin: 5px;
}

.content {
	border-top: 1px solid #ccc;
	height: 600px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="side-menu">
			<h2 class="side-menu-title">고객센터</h2>
			<div class="side-menu-list">
				<a href="list">공지사항</a> <a href="#">자주 묻는 질문</a>
			</div>
		</div>
		<div class="content-area">

			<div class="content-title-border">
				<h3>공지사항</h3>
			</div>
			<div class="notice-content">
				<p class="title">제목 : ${noticeList.title}</p>
				<div class="content">
					<p>${noticeList.content}</p>
				</div>
			</div>
			<div class="button">
				<a href="list">목록보기</a> <a href="/notice/update/${id}">수정하기</a>
			</div>
		</div>
	</div>
</body>
</html>