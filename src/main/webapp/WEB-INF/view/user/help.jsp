<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<style>
body {
	width: 1200px;
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

.content>div:nth-child(3) {
	border-top: 1px solid black;
}
</style>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<div class="content">
	<div class="contentTitle">
		<div style="border-bottom: 2px solid black">
			<h3 style="margin-left: 80px;">QnA</h3>
			<form action="/user/helpWriting">
				<button type="submit">글쓰기</button>
			</form>
		</div>
	</div>

	<div class="requestStatus">
		<div style="flex: 1;"></div>
		<div style="flex: 5;">답변상태</div>
		<div style="flex: 5;">제목/상품</div>
	</div>

	<div class="buyProduct">
		<div style="flex: 1;"></div>
		<div style="flex: 5;">답변상태</div>
		<div style="flex: 5;">제목/상품</div>
	</div>
	<div class="buyProduct">
		<div style="flex: 1;"></div>
		<div style="flex: 5;">답변상태</div>
		<div style="flex: 5;">제목/상품</div>
	</div>
	<div class="buyProduct">
		<div style="flex: 1;"></div>
		<div style="flex: 5;">답변상태</div>
		<div style="flex: 5;">제목/상품</div>
	</div>
	<c:forEach var="questList" items="${questList}">
		<div class="buyProduct">
			<div style="flex: 1;"></div>
			<div style="flex: 5;">${questList.reqStatus}</div>
			<div style="flex: 5;">${questList.title}</div>
		</div>
	</c:forEach>
</div>
</div>
</body>
</html>