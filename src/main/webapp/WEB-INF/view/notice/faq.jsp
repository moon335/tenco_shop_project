<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style type="text/css">
.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48
}

.container {
	display: flex;
	padding-top: 30px;
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
				<h3>자주 묻는 질문(FAQ)</h3>
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
						<p id="hide-${faqList.id}">[${faqList.content}</p>
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
</body>
</html>