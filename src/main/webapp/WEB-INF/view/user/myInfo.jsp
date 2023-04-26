<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
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
						<img class="m--profile" alt="" src=" <c:url value="/images/uploads/${principal.image}"/>" width="150px" height="150" style="border-radius: 150px;">

					</c:when>
					<c:otherwise>
						<input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;">
						<img class="m--profile" alt="" src="/images/myinfo.png" width="150px" height="150" style="margin-top: -20px;">

					</c:otherwise>
				</c:choose>
			</div>
			<div id="profileediter" style="margin-top: 20px;">
				<div>
					<h3 style="margin-left: 10px;">${user.username}</h3>
				</div>
				<div>
					<form action="/user/myinfoEditor" method="get">
						<button type="submit" class="btn btn-outline-dark">프로필 수정</button>
					</form>
					<form action="">
						<button type="submit" class="btn btn-outline-dark">내 후기</button>
					</form>
				</div>
			</div>
		</div>
		<hr>
		<div>
			<div class="userGrade">일반회원</div>
			<div class="userPoint">포인트</div>
		</div>
	</div>
	<div class="buylist">
		<div>구매내역</div>
		<div>
			<a href=""> 더보기 > </a>
		</div>
	</div>
	<div class="buyProgress ">
		<div style="border-right: 1px solid #E0E0E0;">
			<h5>전체</h5>
			0
		</div>
		<div>
			<h5>입찰중</h5>
			0
		</div>
		<div>
			<h5>진행중</h5>
			0
		</div>
		<div>
			<h5>종료</h5>
			0
		</div>
	</div>
	<div class="buyProduct">
		<c:forEach var="orderList" items="${orderList}">
			<div>
				<div class="buyProductImg">
					<img alt="" src="/images/1.png" width="120" height="120">
				</div>
				<div style="width: 400px;">
					<p style="width: 250px;">${orderList.engName}</p>
					<pre style="text-align: center; width: 100px;">${orderList.sizeId}</pre>
				</div>
				<div class="buyDate">
					<pre>${orderList.orderDate}</pre>
				</div>
				<div style="align-items: center; width: 150px;">
					<h6>
						배송완료 <br>
					</h6>
					<form action="">
						<button type="submit" style="border: none; background-color: white; color: #088ff7">
							후기 <br>올리기
						</button>
					</form>
				</div>
			</div>
		</c:forEach>

		<div>
			<div>
				<img alt="" src="/images/1.png" width="120" height="120">
			</div>
			<div style="width: 400px;">
				<p style="width: 250px;">Dior Saddle Flap Card Holder Blue Dior Oblique Jacquard</p>
				<pre style="text-align: center; width: 100px;">ONE SIZE</pre>
			</div>
			<div class="buyDate">
				<pre>2023/01/23</pre>
			</div>
			<div style="width: 150px;">
				<h6>
					배송완료 <br>
				</h6>
				<form action="">
					<button type="submit" style="border: none; background-color: white; color: #088ff7">
						후기 <br>올리기
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>