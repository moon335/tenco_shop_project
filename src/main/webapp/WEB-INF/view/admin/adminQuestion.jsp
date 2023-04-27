<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
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
</style>
<div class="content">
	<div class="contentTitle">
		<div style="border-bottom: 2px solid black">
			<h3 style="margin-left: 80px;">QnA</h3>
			<form action="/question/findProc" method="post">
				<input type="text" name="findWord">
				<button type="submit" style="background-color: white; color: black;">검색</button>
			</form>
			<button type="button">
				<a style="color: white;" href="/user/questWriting">글쓰기</a>
			</button>
		</div>
	</div>

	<div class="requestStatus">
		<div style="flex: 2;">답변상태</div>
		<div style="flex: 6;">제목</div>
	</div>
	<c:forEach var="questList" items="${questList}">
		<div style="height: 80px;">
			<div class="buyProduct" style="height: 80px;">
				<c:choose>
					<c:when test="${questList.reqStatus == 0}">
						<div style="flex: 2;">
							<a href="/admin/detail?id=${questList.id}" value="답변미완료">
								답변미완료</a>
						</div>
					</c:when>
					<c:otherwise>
						<div style="flex: 2;">
							<a href="/admin/detail?id=${questList.id}" value="답변완료">
								답변완료</a>
						</div>
					</c:otherwise>
				</c:choose>
				<div style="flex: 6;">
					<a href="/admin/detail?id=${questList.id}"
						value="${questList.id}">${questList.title}</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>