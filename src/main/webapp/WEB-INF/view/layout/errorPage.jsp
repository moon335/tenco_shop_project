<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
body {
	width: 1183px;
	margin: 0 auto;
}

.wrap_exception {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 100px;
}

.button--home {
	display: inline-flex;
	cursor: pointer;
	align-items: center;
	justify-content: center;
	text-align: center;
	padding: 0 18px;
	height: 42px;
	border-radius: 12px;
	border: 1px solid black;
	font-size: 14px;
	font-weight: 700;
	width: 120px;
	height: 42px;
}

.button--parent {
	display: flex;
	align-items: center;
	justify-content: center;
}

.wrap_content {
	text-align: center;
}

.title {
	font-weight: bold;
	font-size: 18px;
}

.button--home a{
	color: black;
}
.sub-title{
	font-size: 14px;
	color: #B2B2B2;
}
</style>

<div class="wrap_exception">
	<div class="wrap_content">
		<img src="/static/images/errorImage.png" alt="TENCO" class="illust">
		<div class="title">
			<p>찾을 수 없는 페이지입니다.</p>
		</div>
		<div class="sub-title">
			<p>
				주소가 올바르지 않거나 알 수 없는 오류로 인해<br> 페이지를 찾을 수 없습니다.
			</p>
		</div>
		<div class="button--home--parent">
			<div class="button--home">
				<a href="/main">홈으로 가기</a>
			</div>
		</div>
	</div>
</div>

</body>
</html>
