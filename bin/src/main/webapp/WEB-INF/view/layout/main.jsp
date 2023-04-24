<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
.carousel-inner img {
	width: 100%;
	height: 300px;
}

.prev {
	justify-content: flex-start;
}

.next {
	justify-content: flex-end;
}

.article {
	display: flex;
	justify-content: center;
	align-items: center;
}

.article-prod {
	font-size: small;
	margin: 10px;
}

.article-img {
	background-color: #eee;
	size: 50px;
	border-radius: 10px;
	margin: 5px;
}

.content-text {
	margin-top: 50px;
	margin-left: 315px;
	width: 1430px;
}

.content-box {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.carousel-control-prev {
	width: 50px;
}

.carousel-inner img {
	height: 450px;
}

.header-menu {
	width: 1200px;
	margin: 0 auto;
}

.header-menu nav ul li {
	margin-right: -40px;
}

.home-menu2 li {
	margin-left: -40px;
}
</style>
<div class="header">
	<div class="header-menu">
		<nav>
			<ul class="home-menu">
				<li><a href="#">추천</a>
					<ul class="home-menu2">
						<li><a href="#">남성추천</a></li>
						<li><a href="#">여성추천</a></li>
						<li><a href="#">인기브랜드</a></li>
					</ul></li>
				<ul class="home-menu">
					<li><a href="#">남성</a>
						<ul class="home-menu2">
							<li><a href="#">상의</a></li>
							<li><a href="#">하의</a></li>
							<li><a href="#">인기브랜드</a></li>
						</ul></li>
					<ul class="home-menu">
						<li><a href="#">여성</a>
							<ul class="home-menu2">
								<li><a href="#">상의</a></li>
								<li><a href="#">하의</a></li>
								<li><a href="#">인기브랜드</a></li>
							</ul></li>
						<ul class="home-menu">
							<li><a href="#">브랜드</a>
								<ul class="home-menu2">
									<li><a href="#">모든브랜드</a></li>
									<li><a href="#">여성추천</a></li>
									<li><a href="#">남성추천</a></li>
								</ul></li>
							<ul class="home-menu">
								<li><a href="#">공지사항</a>
									<ul class="home-menu2">
										<li><a href="#">공지사항</a></li>
										<li><a href="#">자주묻는질문</a></li>
										<li><a href="#">검수기준</a></li>
									</ul></li>
							</ul>
		</nav>
	</div>
</div>
<div>
	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="/images/banner1.jpg" alt="Los Angeles" width="1100" height="500">
			</div>
			<div class="carousel-item">
				<img src="/images/banner2.jpg" alt="Chicago" width="1100" height="500">
			</div>
			<div class="carousel-item">
				<img src="/images/banner3.jpg" alt="New York" width="1100" height="500">
			</div>
			<div class="carousel-item">
				<img src="/images/banner4.jpg" alt="New York" width="1100" height="500">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev prev" href="#demo" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next next" href="#demo" data-slide="next"> <span class="carousel-control-next-icon"></span>
		</a>
	</div>
</div>
<div class="content">
	<div class="content-box">
		<div class="content-text">
			<h5>Just Dropped</h5>
			<p>발매 상품</p>
		</div>
		<div class="article">
			<c:forEach var="list" items="${list}">
				<div class="article-prod">
					<a href="#"><img alt="" class="article-img" src="${list.img}"></a>
					<h5>Asics</h5>
					<p>${list.prodName}</p>
					<p>${list.prodDescription}</p>
					<h5>169,000원</h5>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
