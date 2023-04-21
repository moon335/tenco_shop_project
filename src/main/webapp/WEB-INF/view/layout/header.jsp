<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.top-inner {
	display: flex;
	justify-content: flex-end;
	font-size: 13px;
	padding: 0 30px;
	height: 20px;
	margin-right: 40px;
}

.top-inner label {
	padding: 10px;
	color: gray;
}

.main-inner {
	padding: 20px;
	height: 100px;
}

.header-inner {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	padding: 20px;
	padding-left: 58px;
}

.header-inner-menu {
	height: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
	width: 300px;
	padding-right: 150px;
}

.header-inner-menu label {
	margin: 10px;
	padding: 10px;
}

.header-menu {
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	align-items: center;
}

.header {
	flex: 1;
	border-bottom: 1px solid #ccc;
	display: flex;
	padding: 5px 40px;
	background-color: white;
	z-index: 2;
}

.home-menu {
	display: flex;
}

.home-menu>li {
	position: relative;
}

.home-menu>li>a {
	padding: 0 40px;
}

.home-menu:hover .home-menu2 {
	height: 135px;
	position: absolute;
	/*background-color: transparent;*/
	z-index: 1;
	border-left: 1px solid #ccc;
}

.home-menu2 {
	overflow: hidden;
	width: 100%;
	padding: 0;
	background: #fff;
	height: 0px;
}

.home-menu2 a {
	display: block;
	padding: 5px 0;
	text-align: center;
	margin: 10px;
}

li {
	list-style: none;
}

.header-inner-menu > label > a:hover {
	font-weight: bold;
	text-decoration: none;
	color: black;
}

.header-inner-menu > label > a {
	color: black;
	text-decoration: none;
}

.header-inner-menu > span > a {
	color: black;
	text-decoration: none;
}

h3>a {
	color: black;
	text-decoration: none;
	font-weight: bold;
}

h3>a:hover {
	text-decoration: none;
	font-size: 28px;
	color: black;
	font-weight: bold;
}


.home-menu>li>a {
	color: black;
	text-decoration: none;
}

.home-menu2>li>a {
	color: black;
	text-decoration: none;
}

a:hover {
	font-weight: bold;
	color: black;
	text-decoration: none;
}

label:hover {
	color: #ccc;
}

header {
	flex: 1;
	display: flex;
	justify-content: center;
	flex-direction: column;
}

.top-inner button {
	margin: 10px;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 200, 'GRAD' 0, 'opsz' 20
}

button {
	border: none;
	background: #fff;
	color: gray;
	margin: 10px;
}

button:hover {
	color: #ccc;
	border: none;
	background: #fff;
}


</style>
</head>
<body>
	<header>
		<div class="main-inner">
			<div class="top-inner">
				<button type="button" onclick="#">관심상품</button>
				<c:choose>
					<c:when test="${principal != null}">
						<a href="/user/logout"> <label>로그아웃</label></a>
						<label>${principal.name}님</label>
					</c:when>
					<c:otherwise>
						<button type="button" onclick="location.href='/user/sign-in'">로그인</button>
						<button type="button" onclick="location.href='/user/sign-up'">회원가입</button>
					</c:otherwise>
				</c:choose>

			</div>
			<div class="header-inner">
				<h3>
					<a href="/test/main">tencoShop</a>
				</h3>
				<div class="header-inner-menu">
					<label><a href="/test/main">HOME</a></label>  <label><a href="#">STYLE</a></label>  <label><a href="#">SHOP</a></label> <label><a href="#">MY</a></label> 
					<span class="material-symbols-outlined"><a href = "/user/search">search</a></span>
				</div>
			</div>
		</div>
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
	</header>