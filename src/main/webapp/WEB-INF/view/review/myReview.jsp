<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	margin: 0 auto;
	width: 1200px;
}

.side>div:nth-child(2)>h5 {
	font-size: 1.25rem;
	margin-bottom: 0.5rem;
	font-weight: 500;
	line-height: 1.2;
}

.side>div:nth-child(5)>h5 {
	font-size: 1.25rem;
	margin-bottom: 0.5rem;
	font-weight: 500;
	line-height: 1.2;
}

.side>div:nth-child(1)>h4>a {
	font-size: 1.5rem;
	font-weight: 500;
	line-height: 1.2;
}

.side>div:nth-child(1)>h4>a:hover {
	font-weight: bolder;
}

#main--table {
	display: flex;
	flex-direction: column;
	justify-content: center;
	margin-left: 20px;
}

main>table tr td {
	width: 120px;
	text-align: center;
}

main thead {
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

tbody tr td a {
	text-decoration: none;
	color: black;
}

tbody tr td a:hover {
	color: black;
	text-decoration: underline;
}
</style>
<main>
	<div class="my--review--title">
		<h3>내 후기</h3>
		<!--  <h1>수정 추가하기</h1>-->
		<!-- <h3>작성된 후기가 없습니다. jstl type으로 보내서 c:choose 사용하기</h3> -->
	</div>
	<table id="main--table">
		<thead>
			<tr>
				<td>NO</td>
				<td>제목</td>
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
					<td><a href="#">${review.id}</a></td>
					<td><a href="#">${review.title}</a></td>
					<td><a href="#"><img alt="" src="/images/uploads/${review.uploadFileName}" width=100 height=100></a></td>
					<td><a href="#">${review.engName}<br> ${review.korName}
					</a></td>
					<td><a href="#">${review.sizeName}</a></td>
					<td><a href="#">${review.brandName}</a></td>
					<td><a href="#">${review.formatCreatedAt()}</a></td>
					<%--/${review.id} --%>
					<td><a href="/review/reviewUpdate">수정</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</main>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
