<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/adminHeader.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	width: 1183px;
	margin: 0 auto;
}

.header {
	display: flex;
	margin-bottom: 40px;
	padding: 20px;
	width: 100%;
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
	width: 180px;
	margin-bottom: 25px;
}

.content {
	margin: 20px;
	width: 1000px;
}

.content {
	display: flex;
	flex-direction: column;
}

.contentTitle div {
	display: flex;
	justify-content: space-between;
}

.contentTitle h2 {
	margin-bottom: 20px;
	font-size: 30px;
}

.textbox-button {
	display: flex;
	justify-content: flex-end;
	align-items: flex-end;
	margin-right: 60px;
}

.textbox-button button {
	border-radius: 10px;
	color: white;
	background-color: #8C9EFF;
	border-style: none;
	padding: 6px 10px;
}

.textbox-button button:hover {
	background-color: #4A5DDB;
}

.requestStatus {
	margin: 20px 0;
	display: flex;
}

.requestStatus a {
	color: #6A6A6A;
	font-size: 13px;
}

.buyProduct {
	display: flex;
	flex: 1;
	align-items: center;
	border-bottom: 1px solid #D2D2D2;
}

.buyProduct div {
	display: flex;
	flex-direction: column;
}

.content>div:nth-child(3) {
	border-top: 1px solid black;
}

.textbox textarea {
	background-color: #F6F6F6;
	border-radius: 30px;
	width: 850px;
	height: 500px;
	margin: 30px;
	vertical-align: top;
	text-align: top;
	padding: 20px;
	resize: none;
	border: none;
}

.textbox textarea:focus {
	outline: none;
}

.textbox input {
	margin: 20px 0;
	width: 800px;
	height: 30px;
	border-radius: 5px;
}

.textbox input:focus {
	outline: none;
}
</style>
<div class="content">
	<div class="contentTitle">
		<div style="border-bottom: 2px solid black">
			<h2 style="margin-left: 80px;">QnA</h2>
		</div>
	</div>
	<div class="textbox">
		<form action="/answer/writing" method="post">
			<input type="hidden" name="questionId" value="${id}">
			<input type="hidden" name="questionId" value="${quest.id}">
			<input type="hidden" name="questionTitle" value="${quest.title}">
			<input type="hidden" name="questionContent" value="${quest.content}">
			<input type="hidden" name="questionUserId" value="${quest.userId}">
			<input type="hidden" name="questionReqStatus" value="${quest.reqStatus}">
			<textarea id="myTextarea" autofocus="autofocus" name="content">
			</textarea>
			<div class="textbox-button">
				<button type="submit" style="margin: 10px;">작성완료</button>
			</div>
		</form>
	</div>
</div>
</div>
<script type="text/javascript"
	src='https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js'
	referrerpolicy="origin">
	
</script>
<script>
	tinymce.init({
		selector : 'textarea', // change this value according to your HTML
		plugins : 'a_tinymce_plugin',
		a_plugin_option : true,
		a_configuration_option : 400
	});
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>