<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- 나의 스타일 추가 -->
<link rel="stylesheet" href="/static/css/login.css">


<div class="text-center">

	<!--  html 전체 영역을 지정하는 container -->
	<div id="container">
		<!--  login 폼 영역을 : loginBox -->
		<div id="loginBox">

			<!-- 로그인 페이지 타이틀 -->
			<div id="loginBoxTitle" style="margin-top: 100px;">Tenco Shop</div>
			<!-- 아이디, 비번, 버튼 박스 -->
			<div id="inputBox">
				<form action="/user/sign-in" method="POST">
					<div class="input-form-box">
						<span class="input-form-login-box">아이디 <input type="text" class="form-control" id="username" name="username" required="required"></span>
					</div>
					<div class="input-form-box">
						<span class="input-form-login-box">비밀번호 <input type="password" class="form-control" id="password" name="password" required="required"></span>
					</div>
					<div class="button-login-box">
						<button type="submit" class="btn btn-primary btn-xs"
							style="width: 100%">로그인</button>
					</div>
				</form>
				<form action="/user/sign-up">
					<div class="button-login-box">
						<button type="submit" class="btn btn-primary btn-xs"
							style="width: 100%">회원가입 </button>
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
