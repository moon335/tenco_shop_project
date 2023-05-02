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

h2,h3 {
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

.customer-notice-delete {
	display: flex;
	border-bottom: 1px solid #ccc;
}
.customer-notice-delete a {
	padding: 10px;
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

.customer-notice-delete a {
	text-decoration: none;
	color: black;
}

.list {
	color: gray;
}

.list:hover {
	color: #ccc;
}
</style>
	<div class="container">
		<div class="side-menu">
			<h2 class="side-menu-title">고객센터</h2>
			<div class="side-menu-list">
				<a href="notice/delete">공지사항</a>
				<a href="#">자주 묻는 질문</a>
			</div>
		</div>
		<div class="content-area">
			<form action="/notice/delete/${id}" method="get">
				<div class="content-title-border">
					<h3>공지사항</h3>
				</div>
					<c:forEach var="list" items="${list}">
				<div class="customer-notice-delete">
						<input type="checkbox" name ="id" value="${list.id}" onclick="OneCheck(this)">
						<a>[${list.categoryName}] ${list.title}</a>
				</div>
					</c:forEach>
				<button type="submit">삭제</button>
				<a href="/notice/list" class="list">목록</a>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	function OneCheck(chk){
		  var obj = document.getElementsByName("id");
		   for(var i=0; i<obj.length; i++){
		     if(obj[i] != chk){
		       obj[i].checked = false;
		     }
		   }
		}
	</script>
</body>
</html>
