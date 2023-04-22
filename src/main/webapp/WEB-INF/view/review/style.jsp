<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet "
	href="https: //fonts.googleapis.com /css2 ?family =Material+Symbols+Outlined:opsz, wght, FILL, GRAD @20 ..48, 100 ..700, 0 ..1, -50 ..200 " />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<style type="text/css">
.review--wrap {
	display: flex;
	flex-direction: column;
	padding: 0 40px;
}

.category--wrap {
	display: flex;
	flex-direction: column;
}

.category--wrap>a {
	text-decoration: none;
	color: black;
	margin: 15px;
	padding: 10px;
}

img {
	border: 1px solid black;
	width: 200px;
	height: 300px;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48
}

h3>a {
	font-size: 28px;
}

.order--wrap{
	display: flex;
}
</style>
<main>
	<div class="review--wrap">
		<div class="category--wrap">
			<!-- 카테고리로 이동 : pathVariable or queryParam -->
			<a href="#">발견</a> 
			<a href="#">스니커즈</a> 
			<a href="#">럭셔리</a> 
			<a href="#">의류</a> 
			<a href="#">가방</a> 
			<a href="#">액세서리</a>
		</div>
		
		<div class="insert--wrap">
			<a href="#">리뷰 등록</a>
		</div>

		<div class="order--wrap">
			<!-- 인기순 : 하트 많은 순 / 최신순 : id order주기 -->
			<a href="#">인기순</a> <a href="#">최신순</a>
		</div>

		<div class="">
			<!-- 상세보기로 이동 -->
			<a href="#"><img src=""></a>
			<!-- 유저의 이미지와 아이디 select -->
			<a href="#">유저 사진, 유저 아이디 갖고오기</a> <span
				class="material-symbols-outlined"> favorite </span>
		</div>

		<div class="">
			<a href="#">여름에 잘 어울리는 트렌디한 Y2K 캐주얼 스트릿 하트하트하트</a>
		</div>

	</div>
</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>