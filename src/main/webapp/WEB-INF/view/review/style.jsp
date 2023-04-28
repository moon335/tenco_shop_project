<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="/css/reviewCategory.css">
<script>
    function addLike(index) {
        const pushHeartBtn = document.querySelectorAll(".heartBtn");
        pushHeartBtn[index].innerHTML = '<i class="xi-heart xi-2x"></i>';
        pushHeartBtn[index].style.color = 'red';
    }
</script>
<style type="text/css">
.header-inner {
	padding: 20px 20px;
}

.review--all--wrap {
	display: flex;
	flex-direction: column;
	padding: 0 40px;
	align-items: center;
}

h3>a {
	font-size: 28px;
}

.order--wrap {
	display: flex;
	width: 970px;
	justify-content: flex-end;
	margin-top: 30px;
}

.order--wrap>a {
	text-decoration: none;
	color: black;
	margin-left: 10px;
}

.img--wrap {
	display: flex;
	flex-wrap: wrap;
	width: 1200px;
	justify-content: center;
}

#review--id {
	display: flex;
	justify-content: space-between;
}

.review--box {
	display: flex;
	flex-direction: column;
	margin-right: 10px;
}

.review--wrap>a>img {
	border-radius: 15px;
	margin-top: 20px;
}

.heart--wrap {
	display: flex;
	justify-content: flex-end;
}

.heartBtn {
	margin: 0;
	padding: 0;
}

.review--heart {
	display: flex;
}

.review--heart>span {
	font-size: 17px;
	margin-left: 5px;
}

main {
	margin-bottom: 30px;
}

.order--wrap {
	display: flex;
	width: 970px;
	justify-content: flex-end;
	margin-top: 30px;
}

.order--wrap>a {
	text-decoration: none;
	color: black;
	margin-left: 10px;
}

.img--wrap {
	display: flex;
	flex-wrap: wrap;
	width: 1200px;
	justify-content: center;
}

#review--id {
	display: flex;
	justify-content: space-between;
}

.review--box {
	display: flex;
	flex-direction: column;
	margin-right: 10px;
}

.review--wrap>a>img {
	border-radius: 15px;
	margin-top: 20px;
}

.review--contents>a {
	display: flex;
	color: black;
	margin: 10px;
	margin: 10px;
	text-decoration: none;
}

.heart--wrap {
	display: flex;
	justify-content: flex-end;
}

.heartBtn {
	margin: 0;
	padding: 0;
}

.review--heart {
	display: flex;
	margin: 10px;
}

.review--heart>span {
	font-size: 17px;
	margin-left: 5px;
}

main {
	margin-bottom: 30px;
}

.detail--wrap{
	padding-bottom: 60px;
}

.category--wrap>a{
	padding:0;
	margin: 0;
	text-align: center;
	padding-bottom: 10px;
	color:gray;
}
</style>
<main>
	<div class="review--all--wrap">
		<div class="detail--wrap">
			<h1>style</h1>
		</div>
		<div class="category--wrap">
			<a href="/review/style">전체</a>
			<%-- 카테고리로 이동 : pathVariable or queryParam --%>
			<c:forEach var="reviewCategoryList" items="${reviewCategoryList}">
				<a href="/review/prod-category/${reviewCategoryList.id}">${reviewCategoryList.name}</a>
			</c:forEach>
		</div>
		<div class="order--wrap">
			<%-- 인기순 : 하트 많은 순 order by 하트수 / 최신순 : id order주기 --%>
			<a href="/review/style?type=orderByHeart">인기순</a> <a href="/review/style?type=orderByRecent">최신순</a>
		</div>
		<div class="img--wrap">
			<c:forEach var="reviewList" items="${reviewList}">
				<div class="review--box">
					<div class="review--wrap">
						<%-- 상세보기로 이동 --%>
						<%-- list 형식이 아닌데 forEach를 사용해서 발생하는 에러 --%>
						<a href="/review/detail/${reviewList.id}"> <img src="/images/uploads/${reviewList.setUpReviewImage()}" class="img--element" width=250
							height=400></a>
						<%-- 유저의 이미지와 아이디 select --%>
					</div>
					<div class="review--contents" id="review--id">
						<a href="#">${reviewList.userName}</a>
						<div class="review--heart">
							<button class="heartBtn" onclick="addLike(${status.index})">
								<i class=" xi-heart-o xi-2x" style="color: black;"></i>
							</button>
							<span>${reviewList.heart}</span>
						</div>
					</div>
					<div class="review--contents">
						<a href="/review/detail/${reviewList.userId}">${reviewList.title}</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>