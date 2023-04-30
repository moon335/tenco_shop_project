<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	width: 1183px;
	margin: 0 auto;
}

.content--area {
	color: #222;
	box-sizing: border-box;
	margin: 0;
	padding: 0px;
}

.content--title {
	width: 950px;
	color: #222;
	box-sizing: border-box;
	font-size: 17px;
	margin-left: 50px;
	color: #222;
	padding: 20px;
}

.terms--title {
	font-size: 20px;
}

.withdraw--title {
	margin-bottom: 30px;
	font-weight: bold;
}

.withdrawal-title--h2 {
	margin-bottom: 30px;
	font-weight: bold;
}

.checkbox--item {
	font-size: 18px;
	margin-bottom: 15px;
	margin-top: 15px;
}

.terms--item--first {
	font-size: 16px;
}

.terms--item {
	list-style-type: disc;
	list-style-position: inside;
	font-size: 14px;
}

.terms--subtitle {
	font-size: 16px;
	margin-top: 10px;
	margin-bottom: 10px;
	font-weight: bold;
}

.withdrawal--check {
	margin-bottom: 20px;
	margin-top: 20px;
}

.title--title--h2 {
	border: 1px solid #dcdcdc;
	padding: 20px;
}

.btn--checkbox {
	display: flex;
	text-align: center;
	justify-content: center;
	text-align: center;
}

.terms--box {
	margin-bottom: 30px;
	margin-top: 30px;
}

.btn--outlinegrey {
	box-sizing: border-box;
	text-decoration: none;
	display: inline-flex;
	cursor: pointer;
	align-items: center;
	justify-content: center;
	text-align: center;
	padding: 0 18px;
	height: 42px;
	border-radius: 12px;
	font-size: 14px;
	border: 1px solid #d3d3d3;
	width: 120px;
	background-color: #fff;
	color: black;
}

.btn--outlineblack {
	box-sizing: border-box;
	text-decoration: none;
	display: inline-flex;
	cursor: pointer;
	align-items: center;
	justify-content: center;
	text-align: center;
	padding: 0 18px;
	height: 42px;
	border-radius: 12px;
	font-size: 14px;
	border: 1px solid #d3d3d3;
	background-color: #222;
	font-weight: 700;
	width: 120px;
	color: #fff;
	margin-left: 8px;
}

.btn--border {
	height: 150px;
}

.btn--outlineblack:hover {
	color: #fff;
	font-size: 15px;
	text-decoration: none;
}

.btn--outlinegrey:hover {
	color: black;
	font-size: 15px;
	text-decoration: none;
	font-size: 15px;
}

.check--label:hover {
	color: black;
	cursor: pointer;
}

.blind--check {
	color: black;
	accent-color: black;
	zoom: 1.5;
}

.check--label {
	font-size: 18px;
	font-weight: bold;
}
</style>
<div class="content--area">
	<div class="mywith-drawal">
		<div class="content--title">
			<h2 class="withdraw--title">회원 탈퇴</h2>
			<div class="title--title--h2">
				<h3 class="withdrawal-title--h3">회원탈퇴에 앞서 아래 내용을 반드시 확인해 주세요.</h3>
				<div class="terms-box">
					<h5 class="terms--title">
						<div class="checkbox--item">
							<input id="check1" type="checkbox" name="open" class="blind--check" required> <label for="check1" class="check--label"> TencoShop을 탈퇴하면 회원 정보 및 서비스 이용 기록이 삭제됩니다. </label>
						</div>
					</h5>
					<div class="terms_detail">
						<ul class="terms_list">
							<li class="terms--item--first">내 프로필, 거래내역(구매/판매), 관심상품, 보유상품, STYLE 게시물(게시물/댓글), 미사용 보유 포인트 등 사용자의 모든 정보가 사라지며 재가입 하더라도 복구가 불가능합니다.</li>
							<li class="terms--item--first">탈퇴 14일 이내 재가입할 수 없으며, 탈퇴 후 동일 이메일로 재가입할 수 없습니다</li>
						</ul>
					</div>
				</div>
				<div class="terms--box">
					<h5 class="terms--title">
						<div class="checkbox--item">
							<input id="check2" type="checkbox" name="open" class="blind--check" required> <label for="check2" class="check--label"> <span class="label-txt"> 관련 법령 및 내부 기준에 따라 별도 보관하는
									경우에는 일부 정보가 보관될 수 있습니다. </span>
							</label>
						</div>
					</h5>

					<div class="terms-detail">
						<h6 class="terms--subtitle">1. 전자상거래 등 소비자 보호에 관한 법률</h6>
						<ul class="terms-list">
							<li class="terms--item">계약 또는 청약철회 등에 관한 기록: 5년 보관</li>
							<li class="terms--item">대금결제 및 재화 등의 공급에 관한 기록: 5년 보관</li>
							<li class="terms--item">소비자의 불만 또는 분쟁처리에 관한 기록: 3년 보관</li>
						</ul>
					</div>
					<div class="terms-detail">
						<h6 class="terms--subtitle">2. 통신비밀보호법</h6>
						<ul class="terms-list">
							<li class="terms--item">접속 로그 기록: 3개월 보관</li>
						</ul>
					</div>

					<div class="terms-detail">
						<h6 class="terms--subtitle">3. 내부 기준에 따라 별도 보관</h6>
						<ul class="terms-list">
							<li class="terms--item">부정이용 방지를 위해 이름, 이메일(로그인ID), 휴대전화번호, CI/DI: 3년 보관</li>
						</ul>
					</div>
				</div>

				<div class="terms--box">
					<h5 class="terms--title">
						<div class="checkbox--item">
							<input id="check3" type="checkbox" name="open" class="blind--check" required> <label for="check3" class="check--label"> <span class="label--txt"> TencoShop 탈퇴가 제한된 경우에는
									아래 내용을 참고하시기 바랍니다. </span>
							</label>
						</div>
					</h5>
					<div class="terms-detail">
						<ul class="terms-list">
							<li class="terms--item">진행 중인 거래(판매/구매)가 있을 경우: 해당 거래 종료 후 탈퇴 가능</li>
							<li class="terms--item">진행 중인 입찰(판매/구매)가 있을 경우: 해당 입찰 삭제 후 탈퇴 가능</li>
							<li class="terms--item">미납 수수료(착불 발송비/페널티)가 있을 경우: 해당 결제 완료 후 탈퇴 가능</li>
							<li class="terms--item">이용 정지 상태인 경우: 이용 정지 해제 후 탈퇴 가능</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="withdrawal--check">
				<div class="checkbox_item">
					<input id="check4" type="checkbox" name="open" class="blind--check" required> <label for="check4" class="check--label"><span class="label--txt"> 회원탈퇴 안내를 모두 확인하였으며 탈퇴에
							동의합니다. </span> </label>
				</div>
			</div>
			<div class="btn--border">
				<div class="btn--checkbox">
					<a href="/user/realwithdrawal" class="btn--outlinegrey"
						onclick="if(document.querySelectorAll('#check1:checked,#check2:checked,#check3:checked,#check4:checked').length === 4) { 
                  return true; 
                } else { 
                  alert('약관에 동의해주세요');
                  return false; 
                }">탈퇴하기
					</a> <a href="/user/myinfo" class="btn--outlineblack"> 취소하기 </a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
</div>