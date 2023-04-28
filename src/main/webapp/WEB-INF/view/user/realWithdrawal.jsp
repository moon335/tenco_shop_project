<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	margin: 0 auto;
	height: 100vh;
}

.container {
	display: block;
	top: 50%;
	left: 50%;
	background-color: #fff;
	width: 500px;
	border-radius: 16px;
	border: 1px solid black;
	height: 500px;
	margin-top: 30px;
	justify-content: center;
}

.none--withdrawal {
	box-sizing: border-box;
	display: inline-flex;
	cursor: pointer;
	align-items: center;
	justify-content: center;
	text-align: center;
	padding: 0 18px;
	height: 42px;
	border-radius: 12px;
	font-size: 14px;
	background-color: #222;
	font-weight: 700;
	width: 120px;
}

.none--withdrawal a {
	color: #fff;
}

.btn-layer-close {
	top: 18px;
	right: 20px;
	cursor: pointer;
}

h2 {
	margin-block-start: 0.83em;
	margin-block-end: 0.83em;
	font-weight: bold;
	margin-block-end: 0.83em;
}

.real-withdrawal--header {
	display: flex;
	justify-content: center;
	align-items: center;
}

.content {
	padding-top: 12px;
	line-height: 19px;
	font-size: 14px;
	text-align: center;
	font-size: 14px;
}

.content--footer {
	padding-top: 24px;
	text-align: center;
	font-size: 0;
}

.content-footer-check {
	margin-bottom: 20px;
}

.withdrawal-check {
	color: black;
	accent-color: black;
	zoom: 1.5;
}

.check-label {
	position: relative;
	cursor: pointer;
	display: inline-block;
	justify-content: center;
	align-items: center;
}

.label-txt {
	font-size: 13px;
	color: #B2B2B2;
	margin-left: 3px;
	margin-bottom: 5px;
}

.withdrawal a {
	color: #B2B2B2;
}

.withdrawal--border {
	margin-top: 20px;
	margin-bottom: 20px;
}

#withdrawalUser {
	font-size: 13px;
	text-decoration: underline;
	cursor: pointer;
}

.none--withdrawal-a:hover {
	text-decoration: none;
}

.none--withdrawal:active {
	background-color: #666666;
}
</style>
<div class="container">
	<a href="#" class="btn-layer-close"></a>
	<div class="real-withdrawal--header">
		<h2>정말 탈퇴하시겠습니까?</h2>
	</div>
	<div class="content">
		<p>탈퇴하기 클릭 시 바로 탈퇴 처리됩니다.</p>
		<p>탈퇴 후 14일 이내 재가입할 수 없으며,</p>
		<p>재가입 시 동일 이메일을 사용할 수 없습니다.</p>
		<div class="content--footer">
			<div class="content-footer-check">
				<input type="checkbox" class="withdrawal-check" id="check1" name="open"> <label for="check1" class="check-label"><span class="label-txt">TENCO 회원을 탈퇴하겠습니다.</span></label>
			</div>
			<div class="none--withdrawal">
				<a href="/user/withdraw" class="none--withdrawal-a">탈퇴 안 할래요</a>
			</div>
			<form action="/user/withdraw" method="post" class="withdrawal--border">
				<label for="withdrawalUser" class="withdrawal">
					<button type="submit" id="withdrawalUser"
						onclick="if(document.querySelectorAll('#check1:checked').length === 1) { 
                  alert('탈퇴가 완료되었습니다.');
                  return true;
                } else { 
                  alert('약관에 동의해주세요');
                  return false; 
                }">
						탈퇴하기</button>
				</label>

			</form>
		</div>
	</div>
</div>
</div>


<%@ include file="/WEB-INF/view/layout/footer.jsp"%>