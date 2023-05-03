<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	width: 1183px;
	margin: 0 auto;
}

.header {
	display: flex;
	margin-bottom: 40px;
	padding: 20px;
	justify-content: space-between;
}

.body {
	display: flex;
}

.side {
	margin: 30px;
}

.side a {
	color: gray;
	text-decoration-line: none;
}

.side a:hover {
	color: black;
}

.side div {
	margin-bottom: 25px;
}

.content_1 {
	border-radius: 10px;
	margin: 20px;
	padding: 20px;
	display: flex;
	flex-direction: column;
}

.content_1 div {
	display: flex;
}

.content_1 button {
	border-color: #ccc;
	border-radius: 10px;
	margin: 15px 2px 10px 4px;
	border-radius: 10px;
}

.title {
	border-bottom: 3px solid black;
	margin-bottom: 50px;
}

.content {
	display: flex;
	flex-direction: column;
	width: 950px;
}

.myInfo {
	border-bottom: 1px solid #ccc;
	margin-bottom: 50px;
}

.myImage {
	margin-right: 20px;
}

.userGrade {
	border-right: 1px solid #ccc;
	justify-content: center;
	flex: 1;
}

.userPoint {
	flex: 1;
	justify-content: center;
}

.buyList {
	display: flex;
	justify-content: space-between;
}

.buyList a {
	color: #6A6A6A;
	font-size: 13px;
}

.buyList a:hover {
	text-decoration: none;
}

#profileEditer {
	display: flex;
	flex-direction: column;
}

#profileEditer button:hover {
	background-color: white;
	color: black;
}

#profileEditer div button:focus {
	background-color: #EBEBEB;
}

.buyProgress {
	display: flex;
	border: 1px solid #ccc;
	border-radius: 20px;
	background-color: #f8f6f6;
	border-style: none;
	justify-content: space-between;
	padding: 20px;
}

.buyProgress div {
	display: flex;
	flex: 1;
	flex-direction: column;
	align-items: center;
	flex-direction: column;
}

.buyProduct {
	display: flex;
	flex: 1;
	align-items: center;
	padding: 10px;
	border-bottom: 1px solid #D2D2D2;
	display: flex;
}

.buyProduct div {
	display: flex;
	flex: auto;
	flex-direction: column;
	margin: 0 20px;
}

.buyDate {
	display: flex;
	align-items: center;
}

.side h4 {
	color: black;
}

.myInfoDetail {
	display: flex;
	flex-direction: column;
}

.myInfoLogin {
	display: flex;
	flex-direction: column;
	margin-bottom: 30px;
}

.myInfoLogin div {
	flex-direction: column;
	margin: 10px;
}

.myInfoLogin input {
	border: none;
	width: 500px;
	border-bottom: 1px solid #ccc;
}

.myInfoLogin input:focus {
	outline: none;
}

.submit {
	display: flex;
	width: 500px;
	justify-content: flex-end;
	align-items: flex-end;
}

.submit input {
	border-radius: 13px;
	color: black;
	background-color: white;
	padding: 6px 10px;
	border: 1px solid #ccc;
	padding: 10px 14px;
}

.myInfoLogin select {
	appearance: none;
	border: none;
	width: 500px;
	height: 50px;
	border-bottom: 1px solid #ccc;
}

.myInfoLogin select:focus {
	outline: none;
}

.submit input:hover {
	color: #909090;
}

#result_card img {
	max-width: 100%;
	height: auto;
	display: block;
	padding: 5px;
	margin-top: 10px;
	margin: auto;
}

#result_card {
	position: relative;
}

.imgDeleteBtn {
	position: absolute;
	top: 0;
	right: 5%;
	background-color: #ef7d7d;
	color: wheat;
	font-weight: 900;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	line-height: 26px;
	text-align: center;
	border: none;
	display: block;
	cursor: pointer;
}
</style>

<div class="content">
	<div class="content_1">
		<div class="title" style="padding-bottom: 10px;">
			<h2>프로필 정보</h2>
		</div>
		<div class="myInfo">
			<form action="/admin/adminInfoupdateimage" method="post" enctype="multipart/form-data" style="display: flex;">
				<div class="myimage">
					<c:choose>
						<c:when test="${principal.image!=null}">
							<label for="customFile"> <input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;"> <img class="m--profile" alt=""
								src=" <c:url value="/images/uploads/${principal.image}"/>" width="150px" height="150" style="margin-top: -20px; border-radius: 150px;">
							</label>
						</c:when>
						<c:otherwise>
							<label for="customFile"><input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;"> <img class="m--profile" alt=""
								src="/static/images/myinfo.png" width="150px" height="150" style="margin-top: -20px; border-radius: 150px;"></label>
						</c:otherwise>
					</c:choose>
					<div id="uploadResult"></div>
				</div>
				<div id="profileEditer">
					<div>
						<h3>${user.username}</h3>
					</div>
				<div>
					<button type="submit" class="btn btn-outline-dark">이미지 변경</button>
			</form>
			<form action="/admin/adminInfoDeleteimage" method="post" enctype="multipart/form-data" style="display: flex;">
				<button type="submit" class="btn btn-outline-dark">삭제</button>
			</form>
		</div>
	</div>
</div>
<form action="/admin/myInfoUpdate" method="post">
	<div class="myInfoDetail">
		<div class="myInfoLogin">
			<h4>
				<b>로그인 정보</b>
			</h4>
			<form>
				<div>
					<p>이메일 주소</p>
					<input type="text" value="${user.email}" name="email">
				</div>
				<div>
					<p>비밀번호</p>
					<input type="password" value="${principal.password}" name="password">
				</div>
		</div>
	</div>
	<div class="myInfoDetail">
		<div class="myInfoLogin">
			<h4>
				<b>개인 정보</b>
			</h4>
			<div>
				<p>이름</p>
				<input type="text" value="${user.lastName}" name="lastName">
			</div>
			<div>
				<p>휴대폰 번호</p>
				<input type="text" value="${user.tel}" name="tel">
			</div>
		</div>
	</div>
	<div class="submit">
		<input type="submit" value="수정">
	</div>
</form>
</form>
</div>
</div>
</div>
<script>
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
