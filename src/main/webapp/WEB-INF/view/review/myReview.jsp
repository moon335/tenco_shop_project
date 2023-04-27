<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	margin: 0 auto;
	width: 1200px;
}

#main--table {
	display: flex;
	flex-direction: column;
	justify-content: center;
	margin-top: 20px;
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
	width: 950px;
	display: flex;
	flex-direction:column;
	align-items:center;
	justify-content: center;
}

.myReview--img--wrap img {
	width: 150px;
	height: 150px;
	border-radius: 100px;
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

.no--review--wrap {
	width: 950px;
	text-align: center;
}

.myReview--username--wrap{
	
}
</style>
<main>
	<div class="my--review--title">
		<span class="myReview--img--wrap"><img src=" <c:url value="/images/uploads/${principal.image}"/>"></span>
		<span class="myReview--username--wrap">${principal.username}</span>
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
			<c:choose>
				<c:when test="${reviewList.isEmpty() == false}">
					<c:forEach var="review" items="${reviewList}">
						<tr>
							<td><a href="/review/detail/${review.id}">${review.id}</a></td>
							<td><a href="/review/detail/${review.id}">${review.title}</a></td>
							<td><a href="/review/detail/${review.id}"><img alt="" src="/images/uploads/${review.setUpReviewImage()}" width=100 height=100></a></td>
							<td><a href="/review/detail/${review.id}">${review.engName}<br> ${review.korName}
							</a></td>
							<td><a href="/review/detail/${review.id}">${review.sizeName}</a></td>
							<td><a href="/review/detail/${review.id}">${review.brandName}</a></td>
							<td><a href="/review/detail/${review.id}">${review.formatCreatedAt()}</a></td>
							<%--/${review.id} --%>
							<td><a href="/review/reviewUpdate/${review.id}">수정</a> | <a href="/review/delete/${review.id}">삭제</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<td class="no--review--wrap"><h5>작성된 후기가 없습니다.</h5></td>
				</c:otherwise>
			</c:choose>
		</tbody>

	</table>
</main>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
