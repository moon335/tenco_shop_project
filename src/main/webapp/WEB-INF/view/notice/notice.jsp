<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style type="text/css">

.container {
	display: flex; 
	padding-top: 30px;
	
}

.side-menu {
	display: flex;
	flex-direction: column;
}
.side-menu h2 {
	margin-left: 40px;
}

.side-menu-list li {
	padding: 5px;
}

li {
	list-style: none;
	border-bottom: 1px solid #ccc;
}

.side-menu a {
	color: black;
	text-decoration: none;
}

.content-area {
	width: 600px;
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
			<div>
				<h2>고객센터</h2>
			</div>

			<div>
				<ul class="side-menu-list">
					<li><a href="notice">공지사항</a></li>
					<li><a href="#">자주 묻는 질문</a></li>
				</ul>
			</div>
		</div>
		<div class="content-area">
			<div class="content-title-border">
				<h3>공지사항</h3>
			</div>
			<div class="customer-notice">
				<c:forEach var="list" items="${list}">
				<li><a href="#${list.id}">${list.title}</a></li>
				</c:forEach>
			</div>
		<button>글쓰기</button>
		</div>
	</div>
</body>
</html>