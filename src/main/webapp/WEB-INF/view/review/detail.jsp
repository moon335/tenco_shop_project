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
	width: 100%;
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
	width: 100%;
	height: 100%;
	object-fit: cover;
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

/* .category--wrap {
	border-bottom: 1px solid #eee;
	display: flex;
	justify-content: center;
	margin: 0 auto;
	width: 1200px;
}

.category--wrap>a {
	text-decoration: none;
	color: black;
	margin: 22px;
	padding: 10px 45px;
} */
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
}

.detail--content--wrap {
	justify-content: flex-start;
	margin-top: 15px;
	font-size: 20px;
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
	font-size: 15px;
}

.heartBtn {
	margin: 0;
	padding: 0;
}

main {
	margin-bottom: 50px;
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

			<div class="detail--user--wrap">
				<span>유저프사 ${review.userName}</span> <span>${review.formatCreatedAt()}</span> <img src="/images/review/${review.reviewImg}" width=550 height=auto>
			</div>
			<c:choose>
				<c:when test="${review.reviewImg != null}">
					<div class="detail--picture--wrap">
						<div class="swiper mySwiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<img src="/images/review/${review.reviewImg}" width=550 height=auto>
								</div>
								<div class="swiper-slide">Slide 2</div>
								<div class="swiper-slide">Slide 3</div>
								<div class="swiper-slide">Slide 4</div>
								<div class="swiper-slide">Slide 5</div>
							</div>
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</c:when>
			</c:choose>
			<div class="detail--product--wrap">
				<h2>여기는 상품 태그</h2>
			</div>
			<div class="detail--heart--wrap">
				<button class="heartBtn" onclick="addLike(${status.index})">
					<i class=" xi-heart-o xi-2x" style="color: black;"></i>
				</button>
			</div>
			<div class="detail--heart">좋아요 ${review.heart}개</div>
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