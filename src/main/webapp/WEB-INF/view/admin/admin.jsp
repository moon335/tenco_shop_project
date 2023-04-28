<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	justify-content: space-between;
}

.content_1 {
	border: 1px solid #ccc;
	border-radius: 10px;
	margin: 20px;
	padding: 20px;
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

.content {
	display: flex;
	flex-direction: column;
	width: 950px;
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

.buylist {
	display: flex;
	justify-content: space-between;
}

.buylist a {
	color: #6A6A6A;
	font-size: 13px;
}

.buylist a:hover {
	text-decoration: none;
}

#profileediter {
	display: flex;
	flex-direction: column;
}

#profileediter button:hover {
	background-color: white;
	color: black;
}

#profileediter div button:focus {
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
}

.buyProduct {
	display: flex;
	flex: 1;
	align-items: center;
	padding: 10px;
	border-bottom: 1px solid #D2D2D2;
	display: flex;
	flex-direction: column;
}

.buyProduct div {
	display: flex;
	flex: auto;
	flex-direction: row;
	margin: 0 20px;
	align-items: center;
	justify-content: space-between;
}

.buyDate {
	display: flex;
	align-items: center;
}
</style>

<div class="content">
	<div class="content_1">
		<div>
			<div>
				<c:choose>
					<c:when test="${principal.image!=null}">
						<input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;">
						<img class="m--profile" alt="" src=" <c:url value="/static/images/uploads/${principal.image}"/>" width="150px" height="150" style="border-radius: 150px;">

					</c:when>
					<c:otherwise>
						<input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;">
						<img class="m--profile" alt="" src="/static/images/myinfo.png" width="150px" height="150" style="margin-top: -20px;">

					</c:otherwise>
				</c:choose>
			</div>
			<div id="profileediter" style="margin-top: 20px;">
				<div>
					<h3 style="margin-left: 10px;">${user.username} 님 반갑습니다.</h3>
				</div>
				<div>
					<form action="/admin/adminInfoEditor" method="get">
						<button type="submit" class="btn btn-outline-dark" style="margin-left:20px;">프로필 수정</button>
					</form>
				</div>
			</div>
		</div>
		<hr>
		<div>
			<div class="userGrade">관리자</div>
		</div>
	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
