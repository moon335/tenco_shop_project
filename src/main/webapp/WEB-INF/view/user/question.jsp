<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
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

.deleteButton {
	border: 1px solid #8C9EFF;
	border-radius: 10px;
	padding: 1px 5px;
	background-color: #8C9EFF;
	color: white;
}

.page {
	margin-top: 100px;
	display: flex;
	justify-content: center;
	text-align: center;
	padding-bottom: 200px;
}

.page p {
	font-size: 15px;
	color: black;
	width: 50px;
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
		<div style="flex: 3;">답변상태</div>
		<div style="flex: 8;">제목</div>
		<div style="flex: 1;"></div>
	</div>
	<c:forEach var="questList" items="${questList}">
		<div style="height: 80px;">
			<div class="buyProduct" style="height: 80px;">
				<c:choose>
					<c:when test="${questList.reqStatus == 0}">
						<div style="flex: 3;">
							<a href="/question/detail?id=${questList.id}" value="답변미완료"> 답변미완료</a>
						</div>
					</c:when>
					<c:otherwise>
						<div style="flex: 3;">
							<a href="/question/detail?id=${questList.id}" value="답변완료"> 답변완료</a>
						</div>
					</c:otherwise>
				</c:choose>
				<div style="flex: 8;">
					<a href="/question/detail?id=${questList.id}" value="${questList.id}">${questList.title}</a>
				</div>
				<div style="flex: 1;">
					<c:choose>
						<c:when test="${user.getRole().equals('admin')}">
							<a href="/question/delete?id=${questList.id}" value="${questList.id}"><button type="button" class="deleteButton">delete</button></a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${questList.userId==user.id}">
									<a href="/question/delete?id=${questList.id}" value="${questList.id}"><button type="button" class="deleteButton">delete</button></a>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
	</c:forEach>
</div>
<div class="page">
	<c:choose>
		<c:when test="${currentPage==1}">
		</c:when>
		<c:otherwise>
			<a href="/question/find?currentPage=1&begin=${8*(1-1)}&range=8"><p><</p></a>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/question/find?currentPage=${i}&begin=${8*(i-1)}&range=8"><p>${i}</p></a>
	</c:forEach>
	<c:choose>
		<c:when test="${currentPage==page||page==0}">
		</c:when>
		<c:otherwise>
			<a href="/question/find?currentPage=${page}&begin=${8*(page-1)}&range=8"><p>></p></a>
		</c:otherwise>
	</c:choose>
</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
