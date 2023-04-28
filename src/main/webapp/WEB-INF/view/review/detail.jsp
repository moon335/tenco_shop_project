<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="stylesheet" href="/css/reviewCategory.css">
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<script>
    function addLike(index) {
        const pushHeartBtn = document.querySelectorAll(".heartBtn");
        pushHeartBtn[index].innerHTML = '<i class="xi-heart xi-2x"></i>';
        pushHeartBtn[index].style.color = 'red';
    }
</script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<style>
.header-inner {
	padding: 20px 20px;
}

html, body {
	position: relative;
	height: 100%;
}

.detail--all--wrap {
	padding: 0 40px;
}

.swiper {
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 550px;
	height: 100%;
	object-fit: cover;
	border-radius: 20px;
}

.swiper {
	margin-left: auto;
	margin-right: auto;
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

.detail--user--wrap, .detail--picture--wrap, .detail--product--wrap,
	.detail--content--wrap, .detail--heart--wrap, .detail--heart {
	display: flex;
	justify-content: center;
	margin: 0 auto;
	width: 550px;
}

.detail--user--wrap {
	font-size: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
	justify-content: space-between;
	margin-top: 20px;
}

.detail--picture--wrap>img {
	border-radius: 20px;
}

.detail--product--wrap {
	justify-content: flex-start;
	margin-top: 10px;
	border-bottom: 1px solid #eee;
}

.detail--content--wrap {
	justify-content: flex-start;
	margin-top: 15px;
	font-size: 20px;
	padding-top: 20px;
}

.detail--heart--wrap {
	display: flex;
	justify-content: flex-start;
	margin-top: 18px;
}

.detail--heart {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	font-size: 14px;
	padding-top: 8px;
}

.heartBtn {
	margin: 0;
	padding: 0;
}

main {
	margin-bottom: 50px;
}

.productInfo--content--wrap {
	display: flex;
	font-size: 20px;
	width: 550px;
	margin: 0 auto;
	margin-top: 20px;
	border-top: 1px solid #eee;
	padding-top: 20px;
}

.engName--korName--wrap {
	display: flex;
	flex-direction: column;
	text-align: center;
	justify-content: center;
}

.user--userName--wrap {
	display: flex;
}

.user--userImg--wrap>a>img{
	width: 70px;
	height: 70px;
	border-radius: 50px;
}

.user--userImg--wrap {
	margin-right: 20px;
}

.detail--createdAt--wrap {
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 18px;
}

.detail--userName--wrap {
	display: flex;
}

.detail--title--wrap{
	display: flex;
	justify-content: flex-start;
	width:550px;
	margin: 0 auto;
	font-size: 20px;
}
</style>
<main>
	<div class="detail--all--wrap">
		<div class="detail--category--wrap">
			<div class="category--wrap">
				<a href="/review/style">전체</a>
				<c:forEach var="reviewCategoryList" items="${reviewCategoryList}">
					<a href="/review/prod-category/${reviewCategoryList.id}">${reviewCategoryList.name}</a>
				</c:forEach>
			</div>

			<c:choose>
				<c:when test="${principal.image!=null}">
					<div class="detail--user--wrap">
						<div class="user--userName--wrap">
							<div class="user--userImg--wrap">
								<a href="/review/author-style/${review.userName}"><img src="/images/uploads/${principal.image}"></a>
							</div>
							<div class="user--info">
								<span class="detail--userName--wrap"><a href="/review/author-style/${review.userName}">${review.userName}</a></span> <span class="detail--createdAt--wrap">${review.formatCreatedAt()}</span>							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="detail--user--wrap">
						<div class="user--userName--wrap">
							<div class="user--userImg--wrap">
								<a href="/review/author-style/${review.userName}"><img src="/images/myinfo.png"></a>
							</div>
							<div class="user--info">
								<span class="detail--userName--wrap"><a href="/review/author-style/${review.userName}"> ${review.userName} </a></span> <span class="detail--createdAt--wrap">${review.formatCreatedAt()}</span>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="detail--title--wrap">${review.title}</div>
			<div class="swiper-slide">
				<img src="/images/uploads/${review.setUpReviewImage()}" width=550 height=auto>
			</div>
			<div class="productInfo--content--wrap">상품 정보</div>
			<div class="detail--product--wrap">
				<img src="/images/prodImages/${review.imgRoute}" width="110" height="110">
				<div class="engName--korName--wrap">
					<div class="">${review.engName}</div>
					<div class="">${review.korName}</div>
				</div>
			</div>
			<div class="detail--heart--wrap">
				<button class="heartBtn" onclick="addLike(${status.index})">
					<i class=" xi-heart-o xi-2x" style="color: black;"></i>
				</button>
				<div class="detail--heart">좋아요 ${review.heart}개</div>
			</div>
			<div class="detail--content--wrap">${review.content}</div>
		</div>
	</div>

	<!-- Swiper JS -->
	<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 1,
      spaceBetween: 30,
      loop: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });
  </script>
</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>