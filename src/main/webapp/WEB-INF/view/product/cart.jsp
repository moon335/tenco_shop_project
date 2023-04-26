<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
	body {
		margin: 0 auto;
	}
	.header {
		display: flex;
		margin-bottom: 40px;
		padding: 20px;
		justify-content: space-between;
	}
	main {
		margin: 30px;
		width: 950px;
	}
	
	.cart--title {
		border-bottom: 3px solid #000;
	}
	
	.cart--title > h4 {
		font-weight: bolder;
	}
	
	.wish--list {
		width: 950px;
		padding: 20px;
	}
	
	.wish--item {
		width: 950px;
		border-bottom: 1px solid #ebebeb;
		padding: 20px;
		display: flex;
	}
	
	.wish--product {
		width: 746px;
		display: flex;
	}
	
	.wish--box {
		width: 80px;
		height: 80px;
	}
	
	.wish--detail {
		margin-left: 13px;
		text-align: left;
		display: flex;
		flex-direction: column;
	}
	
	.wish--buy {
		margin-left: auto;
		flex-direction: column;
		flex-shrink: 0;
		text-align: right;
	}
	
	.wish--buy > button {
		width: 164px;
		height: 60px;
		background-color: #ef6253;
		border-radius: 10px;
		color: #fff;
		
		display: flex;
	    justify-content: space-around;
	    align-items: center;
	}
	
	.wish--buy > button:hover {
		width: 164px;
		height: 60px;
		background-color: #ef6253;
		border-radius: 10px;
		color: #fff;
		
		display: flex;
	    justify-content: space-around;
	    align-items: center;
	}
	
	.wish--purchase {
		flex: 1;
		width: 55px;
		text-align: center;
		font-size: 18px;
		margin-right: 5px;
		margin-left: 5px;
	}
	.button--line {
		width: 1px;
		height: 100%;
		border-right: 1px solid rgba(34,34,34,.1);
		background-color: rgba(34,34,34,.1);
	}
	
	.wish--price {
		flex: 3;
	}
	
	.button--wrap {
		display: flex;
		flex-direction: column;
	}
	
	.delete--prod {
		display: flex;
		justify-content: flex-end;
	}
	
	.delete--button {
		margin-top: 6px;
	    padding: 0 3px;
	    display: inline-flex;
	    font-size: 12px;
	    letter-spacing: -.06px;
	    color: rgba(34,34,34,.8);
	    text-decoration: underline;
	}
	
	.delete--button:hover {
		margin-top: 6px;
	    padding: 0 3px;
	    display: inline-flex;
	    font-size: 12px;
	    letter-spacing: -.06px;
	    color: rgba(34,34,34,.8);
	    text-decoration: underline;
	    font-weight: normal;
	}
	
</style>
	<main>
		<div class="cart--title">
			<h4>장바구니</h4>
			<br>
		</div>
		<div class="wish--list">
			<c:forEach var="list" items="${cartList}">
			<div class="wish--item">
				<div class="wish--product">
					<div class="wish--box">
						<img alt="상품" src="/static/images/prodImages/${list.imgRoute}" width="80" height="80">
					</div>
					<div class="wish--detail">
						<span class="brand--name">${list.brandName}</span>
						<p class="name">${list.engName}</p>
						<span class="size">${list.sizeName}</span>
					</div>
				</div>
				<div class="button--wrap">
					<div class="wish--buy">
						<button type="button" onclick="location.href='/order/${list.id}'">
							<span class="wish--purchase">구매</span>
							<div class="button--line"> </div>
							<span class="wish--price">${list.purchase}원</span>
						</button>
					</div>
					<div class="delete--prod">
						<a href="/cart/delete/${list.id}" class="delete--button">삭제</a>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</main>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

	