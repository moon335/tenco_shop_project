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

.salesListLine a {
	text-decoration: underline;
	color: black;
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
	<div class="content_1">
		<h3>판매내역</h3>
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
					<img alt="" src="/static/images/prodImages/${salesList.imgRoute}" width="100px" height="100px">
				</div>
				<div style="width: 10px;">
					<a href="/admin/userSelect?userId=${salesList.userId}">
						<p>${salesList.username}</p>
					</a>
				</div>
				<div style="width: 100px;">
					<p>${salesList.engName}</p>
				</div>
				<div style="width: 50px;">
					<p>${salesList.sizeName}</p>
				</div>
				<div style="width: 10px;">
					<p>${salesList.orderDate}</p>
				</div>
				<div style="width: 70px;">
					<c:choose>
						<c:when test="${salesList.deliveryStatus==1}">
							<p>배송완료</p>
						</c:when>
						<c:otherwise>
							<p>배송중</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
		<div class="page">
			<c:choose>
				<c:when test="${currentPage==1}">
				</c:when>
				<c:otherwise>
					<a href="/admin/salesList?currentPage=1&begin=${5*(1-1)}&range=5"><p><</p></a>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/admin/salesList?currentPage=${i}&begin=${5*(i-1)}&range=5"><p>${i}</p></a>
			</c:forEach>
			<c:choose>
				<c:when test="${currentPage==page}">
				</c:when>
				<c:otherwise>
					<a href="/admin/salesList?currentPage=${page}&type=${type}&begin=${5*(page-1)}&range=5"><p>></p></a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
