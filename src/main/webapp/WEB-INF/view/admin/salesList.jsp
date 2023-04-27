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

.salesProductList {
	display: flex;
	flex: 1;
	align-items: center;
	padding: 10px;
	display: flex;
	flex-direction: column;
}

.salesProductList div {
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

.salesListLine {
	border-bottom: 1px solid #ccc;
}

.salesProductList div div p {
	margin-bottom: -12px;
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
</style>

<div class="content">
	<div class="content_1">
		<h3>구매내역</h3>
	</div>
	<div class="buyProgress ">
		<div>
			<form action="/user/buylistProc" method="get">
				<table class="order_date">
					<tr>
						<td><input class="search__input" type="date"
							name="orderStartDate" /></td>
						<td>~</td>
						<td><input class="search__input" type="date"
							name="orderEndDate" /></td>
						<td>
							<button type="submit" style="width: 70px">조회</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<hr>
	<div class="salesProductList">

		<c:choose>
			<c:when test="">
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>

		<c:forEach var="salesList" items="${salesList}">
			<div class="salesListLine" style="">
				<div style="width: 10px;">
					<img alt="" src="/images/prodImages/${salesList.imgRoute}"
						width="100px" height="100px">
				</div>
				<div style="width: 10px;">
					<p>${salesList.id}</p>
				</div>
				<div style="width: 100px;">
					<p>${salesList.korName}</p>
				</div>
				<div style="width: 70px;">
					<p>${salesList.color}</p>
				</div>
				<div style="width: 50px;">
					<p>${salesList.releasePrice}</p>
				</div>
				<div style="width: 10px;">
					<p>${salesList.sizeId}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>