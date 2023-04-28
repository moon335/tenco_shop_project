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
	border-bottom: 1px solid #ccc;
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

.userSelect {
	display: flex;
	flex: 1;
	align-items: center;
	padding: 10px;
	display: flex;
	flex-direction: column;
}

.userSelect div {
	display: flex;
	flex: auto;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
	width: 950px;
	justify-content: center;
	align-items: center;
	text-align: center;
	align-items: center;
	margin-bottom: 35px;
}

.userInfo {
	border-bottom: 1px solid #ccc;
}

.Info {
	border-bottom: 1px solid #ccc;
}

.Info p {
	font-size:18px;
	margin-bottom: -62px;
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

.userInfo p {
	margin-bottom: 0;
}

</style>

<div class="content">
	<div class="content_1">
		<h3>회원정보</h3>
	</div>
	<div class="userSelect">

		<div class="Info" style="">
			<div style="width: 30px;">
				<p>이름</p>
			</div>
			<div style="width: 100px;">
				<p>이메일</p>
			</div>
			<div style="width: 50px;">
				<p>전화번호</p>
			</div>
			<div style="width: 100px;">
				<p>주소</p>
			</div>
			<div style="width: 30px;">
				<p>관리자</p>
			</div>
		</div>
		<div class="userInfo" style="">
			<div style="width: 30px;">
				<p>${user.username}</p>
			</div>
			<div style="width: 100px;">
				<p>${user.email}</p>
			</div>
			<div style="width: 50px;">
				<p>${user.tel}</p>
			</div>
			<div style="width: 100px;">
				<p>${user.address}</p>
			</div>
			<div style="width: 30px;">
				<p>${user.role}</p>
			</div>
		</div>
	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>