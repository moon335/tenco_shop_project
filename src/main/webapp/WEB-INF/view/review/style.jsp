<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script>
	function addLike() {
		const pushHeartBtn = document.querySelector(".heartBtn");
		pushHeartBtn.innerHTML = '<i class="xi-heart xi-2x"></i>';
		pushHeartBtn.style.color = 'red';
	}
</script>
<style type="text/css">

body {
	margin: 0;
}

.header-inner {
	padding: 0 20px;
}

.review--all--wrap {
	display: flex;
	flex-direction: column;
	padding: 0 40px;
	align-items: center;
}

.category--wrap {
	display: flex;
	width: 1200px;
	border-bottom: 1px solid #eee;
	margin: 0 auto;
}

.category--wrap>a {
	text-decoration: none;
	color: black;
	margin: 15px;
	padding: 10px 30px;
	flex: 1 1 auto;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48
}

.material-symbols-outlined:hover {
	color: red;
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

.review--contents>a {
	display: flex;
	color: black;
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

.review--like{
	display: flex;
}

.review--like > span {
	font-size: 17px;
	margin-left: 5px;
}

main{
	margin-bottom: 30px;
}
</style>
<main>
	<div class="review--all--wrap">
		<div class="category--wrap">
			<!-- 카테고리로 이동 : pathVariable or queryParam -->
			<a href="#">발견</a> <a href="#">스니커즈</a> <a href="#">럭셔리</a> <a
				href="#">의류</a> <a href="#">가방</a> <a href="#">액세서리</a>
		</div>
		<div class="order--wrap">
			<!-- 인기순 : 하트 많은 순 order by 하트수 / 최신순 : id order주기 -->
			<a href="#">인기순</a> <a href="#">최신순</a>
		</div>
		<div class="img--wrap">
			<c:forEach var="reviewList" items="${reviewList}">
				<div class="review--box">
					<div class="review--wrap">
						<%-- 상세보기로 이동 --%>
						<a href="#"><img src="/images/review/${reviewList.reviewImg}"
							width=240 height=400></a>
						<%-- 유저의 이미지와 아이디 select --%>
					</div>
					<div class="review--contents" id="review--id">
						<a href="#">${reviewList.userName}</a>
						<div class="review--like">
						<button class="heartBtn" onclick="addLike()">
							<i class=" xi-heart-o xi-2x" style="color:red;"></i>
						</button>
						<span>${reviewList.heart}</span> 
						</div>
					</div>
					<div class="review--contents">
						<a href="#">${reviewList.content}</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>