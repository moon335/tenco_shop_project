<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
.orderComplete--all--wrap {
	width: 850px;
	display: flex;
	justify-content: center;
	flex-direction: column;
	margin: 0 auto;
	margin-top: 70px;
	border: 1px solid #ccc;
	border-radius: 20px;
	padding: 20px;
}

.orderComplete--content--wrap {
	border-bottom: 1px solid #ccc;
	padding-bottom: 10px;
	display: flex;
	justify-content: center;
	margin-top: 10px;
}

.purchase--product--wrap {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.orderComplete--info--wrap {
	margin: 20px;
}

.product--purchase--wrap {
	display:flex;
	margin-top: 20px;
}

.product--purchase--wrap div {
	padding-left: 20px;
}

.product--orderDate--wrap {
	display:flex;
	margin-top: 20px;
}

.product--orderDate--wrap div {
	padding-left: 20px;
}

.orderComplete--button-wrap {
	display: flex;
	justify-content: center;
}

.orderComplete--button-wrap button {
	color: white;
	background-color: #ddd;
	border: 1px solid #ddd;
	height: 50px;
	border-radius: 15px;
	width: 400px;
	margin-top: 30px;
}

button:hover {
	background-color: black;
	border: 1px solid #ddd;
}
.purchase--title{
	flex: 0.57;
}

.purchase--value{
	flex: 3;
}
</style>

<main>
	<div class="orderComplete--all--wrap">
		<div class="orderComplete--content--wrap">
			<h3 style="font-weight: 900">구매가 정상적으로 완료되었습니다!</h3>
		</div>

		<div class="orderComplete--info--wrap">
			<div class="product--info--wrap">
				<div class="purchase--product--wrap">
					<div>구매 상품</div>
					<img alt="" src="/static/images/prodImages/${order.imgRoute}" width="100" height="100">
					<div>
						${order.engName} <br> ${order.korName}
					</div>
					<div>${order.modelNumber}</div>
					<div>${order.color}</div>
					<div>${order.brandName}</div>
					<div>${order.sizeName}</div>
				</div>
				<div class="product--purchase--wrap">
					<span class="purchase--title">결제 금액</span><span class="purchase--value">${order.purchase} 원</span>
				</div>
				<div class="product--orderDate--wrap">
					<span class="purchase--title">주문 날짜</span><span class="purchase--value">${order.orderDate}</span>
				</div>
			</div>

			<div class="orderComplete--button-wrap">
				<button type="submit" onclick="location.href='/main?begin=0&range=8'">메인 홈으로</button>
				<button type="submit" onclick="location.href='/user/myinfoProc'">확인</button>
			</div>
		</div>
	</div>
</main>