<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link href='https://fonts.googleapis.com/css?family=Noto Sans' rel='stylesheet'>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body {
	width: 1183px;
	margin: 0 auto;
	font-family: 'Noto Sans';
}

.carousel-inner {
	text-align: center;
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

.article {
	width: 1400px;
	flex-wrap: wrap;
}

.article-prod {
	display: flex;
	flex-direction: column;
}

.article-prod p {
	width: 260px;
	height: 20px;
	margin-left: 10px;
}

.article-prod h5 {
	margin-left: 10px;
}

.article-img {
	width: 260px;
}

.list {
	display: flex;
	margin-top: 60px;
	padding: 0 30px;
}

.list div {
	text-align: center;
	flex: 1;
}

.title {
	text-align: center;
}

.word {
	outline: 1px solid black;
	outline-style: none;
	display: block;
	color: black;
	width: 630px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
<div class="title">
	<div id="demo" class="carousel slide" data-ride="carousel">

		<div class="carousel-inner">
			<div class="carousel-item active">
				<h1>${brand.brandName}</h1>
			</div>
		</div>

	</div>
	<div class="header"></div>
</div>
<div class="content">
	<div class="content-box">
		<div class="article">
			<div class="article">
				<c:forEach var="brandProductInfoList" items="${brandProductInfoList}">
					<div class="article-prod">
						<a href="/product/prod-info/${brandProductInfoList.id}"><img alt="" class="article-img" src="/static/images/prodImages/${brandProductInfoList.imgRoute}"></a>
						<h5>${brandProductInfoList.brandName}</h5>
						<p class="word">${brandProductInfoList.engName}</p>
						<h5>${brandProductInfoList.releasePrice}원</h5>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
