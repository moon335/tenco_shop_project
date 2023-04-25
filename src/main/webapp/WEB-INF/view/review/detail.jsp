<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.header-inner {
	padding: 20px 20px;
}

.detail--all-wrap {
	display: flex;
	justify-content: center;
	width: 1200px;
}

.detail--category--wrap {
	display: flex;
	flex-direction: column;
}

.category--wrap {
	border-bottom: 1px solid #eee;
	display: flex;
	justify-content: center;
	margin: 0 auto;
	width: 1200px;
}

.category--wrap>a {
	text-decoration: none;
	color: black;
	margin: 15px;
	padding: 10px 30px;
}

.detail--user--wrap, .detail--picture--wrap, .detail--heart--wrap {
	display: flex;
	justify-content: center;
	margin: 0 auto;
	width: 800px;
}

.detail--user--wrap {
	margin-top: 20px;
	justify-content: space-between;
}

.detail--picture--wrap {
	
}

.detail--heart--wrap {
	
}
</style>

<main>
	<div class="detail--category--wrap">
		<div class="category--wrap">
			<a href="/review/style">전체</a>
			<c:forEach var="reviewCategoryList" items="${reviewCategoryList}">
				<a href="/review/prod-category/${reviewCategoryList.id}">${reviewCategoryList.name}</a>
			</c:forEach>
		</div>

		<div class="detail--user--wrap">
			<h1>${review.userName}</h1>
			<h1>팔로우</h1>
		</div>
		<div class="detail--picture--wrap">
			${review.reviewImg}
		</div>
		<div class="detail--heart--wrap">
			<h1>좋아요, 댓글 머터리얼 아이콘</h1>
		</div>
	</div>
</main>
