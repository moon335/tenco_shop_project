<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>

<style>
body {
	width: 1200px;
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
	flex-direction: column;
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
	flex-direction: column;
}

.buyDate {
	display: flex;
	align-items: center;
}

.side h4 {
	color: black;
}
</style>

		<div class="content">
			<div class="content_1">
				<div>
					<div>
						<img alt="" src="/images/myinfo.png">
					</div>
					<div id="profileediter">
						<div>
							<h3>jdy1787</h3>
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
				<div>
					<img alt="" src="/images/1.png" width="120" height="120">
				</div>
				<div style="width: 400px;">
					<p>Dior Saddle Flap Card Holder Blue Dior Oblique Jacquard</p>
					<pre>ONE SIZE</pre>
				</div>
				<div class="buyDate">
					<pre>2023/01/23</pre>
				</div>
				<div style="align-items: center;">
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
</body>
</html>