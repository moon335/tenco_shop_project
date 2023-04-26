<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
.main--table {
	display: flex;
	flex-direction: column;
	justify-content: center;
	margin-left: 20px;
}

table tr td {
	width: 120px;
	text-align: center;
}

.main--table thead {
	border-bottom: 1px solid #eee;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}

.my--review--title {
	padding-left: 50px;
}

.my--review--title h3 {
	font-size: 1.75rem;
}
</style>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<main>
	<div class="my--review--title">
		<h3>내 후기</h3>
		<!--  <h1>수정 추가하기</h1>-->
		<!-- <h3>작성된 후기가 없습니다. jstl type으로 보내서 c:choose 사용하기</h3> -->
	</div>
	<table class="main--table">
		<thead>
			<tr>
				<td>NO</td>
				<td>내용</td>
				<td>사진</td>
				<td>상품명</td>
				<td>사이즈</td>
				<td>브랜드</td>
				<td>작성 날짜</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="review" items="${reviewList}">
				<tr>
					<td>${review.id}</td>
					<td>${review.content}</td>
					<td><img alt="" src="/images/review/${review.originFileName}" width=100 height=100></td>
					<td>${review.engName} <br> ${review.korName}
					</td>
					<td>${review.sizeName}</td>
					<td>${review.brandName}</td>
					<td>${review.formatCreatedAt()}</td>
					<%--/${review.id} --%>
					<td><a href="/review/reviewUpdate">수정</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</main>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>