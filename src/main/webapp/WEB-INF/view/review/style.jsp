<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet "
	href="https: //fonts.googleapis.com /css2 ?family =Material+Symbols+Outlined:opsz, wght, FILL, GRAD @20 ..48, 100 ..700, 0 ..1, -50 ..200 " />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<style type="text/css">
.review--all--wrap {
	display: flex;
	flex-direction: column;
	padding: 0 40px;
	align-items: center;
}

.category--wrap {
	display: flex;
	width: 1200px;
}

.category--wrap>a {
	text-decoration: none;
	color: black;
	margin: 15px;
	padding: 10px 30px;
	flex:1 1 auto;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48
}

h3>a {
	font-size: 28px;
}

.order--wrap {
	display: flex;
	width: 800px;
    justify-content: flex-end;
}

.order--wrap>a {
	text-decoration: none;
	color: black;
}

.img--wrap {
	display: flex;
	flex-wrap: wrap;
    width: 850px;
}

#review--id{
	display: flex;
	justify-content: space-between;
}

.review--box {
	display: flex;
	flex-direction: column;
	margin-right: 10px;	
}

.review--contents>a{
	text-decoration: none;
	color:black;
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
			<a href="#">인기순</a>&nbsp;<a href="#">최신순</a>
		</div>
		<div class="img--wrap">
			<c:forEach var="reviewList" items="${reviewList}">
			<div class="review--box">
				<div class="review--wrap">
					<%-- 상세보기로 이동 --%>
					<a href="#"><img src="/images/review/${reviewList.reviewImg}" width=200
						height=300></a>
					<%-- 유저의 이미지와 아이디 select --%>
				</div>
				<div class="review--contents" id="review--id">
					<a href="#">${reviewList.id}</a> 
					<span class="material-symbols-outlined"> favorite </span>
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