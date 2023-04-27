<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	height: 100vh;
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

.buyProduct {
	display: flex;
	flex: 1;
	align-items: center;
	border-bottom: 1px solid #D2D2D2;
}

.buyProduct div {
	display: flex;
	flex-direction: column;
}

.buyProduct div a {
	font-size: 15px;
	color: black;
}

.content>div:nth-child(3) {
	border-top: 1px solid #ccc;
}

.box {
	border: 1px solid #F9F9F9;
	height: 400px;
	background-color: #F9F9F9;
	padding: 40px;
}

.goList {
	display: flex;
	justify-content: center;
	margin-top: 10px;
}
</style>
<div class="content">
	<div class="contentTitle">
		<div style="border-bottom: 2px solid black">
			<h3 style="margin-left: 20px;">Title : ${quest.title}</h3>
			<c:choose>
				<c:when test="${user.getRole().equals('admin')}">
					<c:choose>
						<c:when test="${quest.reqStatus==1}">
						</c:when>
						<c:otherwise>
							<button type="button">
								<a style="color: white;"
									href="/answer/answerWriting?id=${quest.id}">답변달기</a>
							</button>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<form action="/question/findProc" method="post">
						<input type="text" name="findWord">
						<button type="submit"
							style="background-color: white; color: black;">검색</button>
					</form>
					<button type="button">
						<a style="color: white;" href="/user/questWriting">글쓰기</a>
					</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div class="requestStatus">
		<div style="flex: 5;"></div>
	</div>
	<div class="box">
		<div>${quest.content}</div>
	</div>
	<hr>
	<div class="box">
		<c:choose>
			<c:when test="${answer!=null}">
				<div>${answer.content}</div>
			</c:when>
			<c:otherwise>
				<div>아직 답글이 없습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="goList">
		<button
			style="border: 1px solid #ccc; border-radius: 15px; padding: 10px;">
			<a href="/question/find">목록보기</a>
		</button>
	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>