<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/login.css">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@400;700&display=swap"
	rel="stylesheet">
<!-- 나의 스타일 추가 -->
<link rel="stylesheet" href="css/login.css">
<style>
.input-form-login-box--id {
	position: relative;
	height: 35px;
	width: 80px;
	left: 380px;
	bottom: 225px;
	border-radius: 4px;
	color: #fff;
	background-color: #0d6efd;
	font-family: 'Nanum Gothic Coding', monospace;
}

.input-form-login-box--id:hover {
	color: #fff;
	background-color: #0b5ed7;
	height: 33px;
}
.text-center{
	margin-right: 150px;
}
</style>
<div class="text-center">
	<!--  html 전체 영역을 지정하는 container -->
	<div id="container">
		<!--  login 폼 영역을 : loginBox -->
		<div id="loginBox">
			<!-- 로그인 페이지 타이틀 -->
			<div id="loginBoxTitle">Tenco Shop</div>
			<!-- 아이디, 비번, 버튼 박스 -->
			<div id="inputBox">
				<form action="/user/sign-up" method="POST">
					<div class="input-form-box">
						<span class="input-form-login-box">아이디* <input type="text"
							class="form-control" id="username" name="username" required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">비밀번호* <input
							type="password" class="form-control" id="password"
							name="password" required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">전화번호* <input type="text"
							class="form-control" id="tel" name="tel" required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">주소* <input type="text"
							class="form-control" id="address" name="address" required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">이메일 주소* <input
							type="email" class="form-control" id="email" name="email"
							required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">성* <input type="text"
							class="form-control" id="firstName" name="firstName" required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">이름* <input type="text"
							class="form-control" id="lastName" name="lastName" required></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">관리자코드 <input type="text"
							class="form-control" id="role" name="role"></span>
					</div>
					<div class="button-login-box">
						<button type="submit" class="btn btn-primary btn-xs"
							style="width: 100%">가입하기</button>
					</div>
				</form>
			</div>

		</div>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
