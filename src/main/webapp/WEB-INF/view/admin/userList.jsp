<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
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
	justify-content: space-between;
}

.content_1 {
	margin: 20px;
	padding: 20px;
}

.content_1 div {
	display: flex;
}

.content_1 button {
	border-color: #ccc;
	border-radius: 10px;
	margin: 15px 2px 10px 4px;
	border-radius: 10px;
}

.content {
	display: flex;
	flex-direction: column;
	width: 950px;
}

.userGrade {
	border-right: 1px solid #ccc;
	justify-content: center;
	flex: 1;
}

.userPoint {
	flex: 1;
	justify-content: center;
}

.buylist {
	display: flex;
	justify-content: space-between;
}

.buylist a {
	color: #6A6A6A;
	font-size: 13px;
}

.buylist a:hover {
	text-decoration: none;
}

#profileediter {
	display: flex;
	flex-direction: column;
}

#profileediter button:hover {
	background-color: white;
	color: black;
}

#profileediter div button:focus {
	background-color: #EBEBEB;
}

.buyProgress {
	display: flex;
	border: 1px solid #ccc;
	background-color: #F9F7F7;
	border-style: none;
	justify-content: space-between;
	padding: 20px;
}

.buyProgress div {
	display: flex;
	flex: 1;
	flex-direction: column;
	align-items: center;
}

.userList {
	display: flex;
	flex: 1;
	align-items: center;
	padding: 10px;
	display: flex;
	flex-direction: column;
	border-bottom: 1px solid #D2D2D2;
}

.userList div {
	display: flex;
	flex: auto;
	flex-direction: row;
	margin: 0 20px;
	align-items: center;
	justify-content: space-between;
	width: 950px;
	justify-content: center;
	align-items: center;
	text-align: center;
	align-items: center;
}

.userList div p {
	
}

.buyDate {
	display: flex;
	align-items: center;
}

.search__input {
	height: 45px;
	width: 100%;
	color: rgb(100, 98, 98);
	font-size: 15px;
	border: 1px solid rgb(230, 227, 227);
}

.order_date td {
	width: 50px;
	text-align: center;
}

.order_date td button {
	background-color: black;
	color: white;
	height: 43px;
}
.userList a {
	text-decoration: underline;
	color: black;
}
</style>

<div class="content">
	<div class="content_1">
		<h3>회원정보</h3>
	</div>
	<hr>
	<div class="userList">

		<c:forEach var="userList" items="${userList}">
			<div>
				<img alt="" src="/static/images/myinfo.png" width="40px" height="40px" style="margin-top: -20px;">
				<div style="width: 10px;">
					<p>${userList.id}</p>
				</div>
				<div style="width: 30px;">
				<a href="/admin/userSelect?userId=${userList.id}">
						<p>${userList.username}</p>
					</a>
				</div>
				<div style="width: 70px;">
					<p>${userList.tel}</p>
				</div>
				<div style="width: 100px;">
					<p>${userList.address}</p>
				</div>
				<div style="width: 80px;">
					<p>${userList.email}</p>
				</div>
				<div style="width: 30px;">
					<p>${userList.role}</p>
				</div>
				<div style="width: 30px; margin-top: -12px;">
					<a href=""><button>X</button></a>
				</div>
			</div>
			<hr>
		</c:forEach>

	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
