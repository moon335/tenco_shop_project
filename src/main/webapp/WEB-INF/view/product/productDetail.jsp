<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
	main {
		width: 1160px;
		display: flex;
		justify-content: center;
		margin: 0 auto;
		padding: 20px;
	}
	
	.prod--img {
		width: 600px;
		padding: 10px;
	}
	
	form {
		width: 600px;
		padding: 0 20px 20px 20px;
		border-left: 1px solid #ebebeb;
	}
	
	.prod--info {
		width: 540px;
		padding: 0 10px 10px 10px;
	}
	
	.brand--name {
		width: 490px;
	}
	
	.form-group {
		width: 490px;
	}
	
	.buttons {
		width: 490px;
		display: flex;
		justify-content: space-between;
	}
	
	#buy--button {
		display: flex;
		width: 240px;
		margin: 0;
	    background-color: #ef6253;
	    color: #fff;
	    border-radius: 10px;
	    height: 50px;
	    align-items: center;
	}
	
	.purchase {
		flex: 1;
		text-align: center;
		font-size: 18px;
		margin-right: 5px;
		margin-left: 5px;
		width: 200px;
	    background-color: #ef6253;
	    color: #fff;
	    border-radius: 10px;
	    height: 40px;
	    align-items: center;
	    display: flex;
	}
	
	.button--line {
		width: 1px;
		height: 100%;
		border-right: 1px solid rgba(34,34,34,.1);
		background-color: rgba(34,34,34,.1);
	}
	
	.price {
		flex: 3;
	}
	
	#cart--button {
		width: 240px;
	    background-color: #41b979;
	    color: #fff;
	    border-radius: 10px;
	    height: 50px;
	    font-size: 18px;
	    margin: 0;
	}
	
	.detail--title {
	    font-size: 18px;
	    padding: 40px 0 20px;
	    line-height: 22px;
	    font-weight: bolder;
	    
	}
	
	.detail--product {
		border-top: 1px solid #ebebeb;
		border-bottom: 1px solid #ebebeb;
		width: 490px;
		height: 75px;
		padding: 12px 0;
		display: flex;
		justify-content: space-around;
	}
	
	.detail--box {
		border-left: 1px solid #ebebeb;
		padding-left: 15px;
	}
	
	.product--title {
		line-height: 14px;
    	font-size: 12px;
    	color: rgba(34,34,34,.5);
	}
	
	.product--info {
		line-height: 17px;
    	font-size: 14;
    	margin-top: 4px;
    	word-break: break-word;
	}
	
	.detail--product--dl {
		padding-top: 7px;
	}
	
	.prod--brand--name {
		line-height: 19px;
		font-size: 18px;
		font-weight: 600;
		border-bottom: 2px solid #222;
		color: #222;
	    margin-bottom: 9px;
	    letter-spaning: -.27px;
	}
	
	.prod--brand--name:hover {
		line-height: 19px;
		font-size: 18px;
		font-weight: 600;
	    padding-top:1px;
	    margin-bottom: 9px;
	    letter-spaning: -.27px;
	}
	
	.prod--eng--name {
		margin-bottom: 4px;
	    font-size: 18px;
	    letter-spacing: -.09px;
	    font-weight: 400;
	}
	
	.prod--kor--name {
		line-height: 17px;
	    font-size: 14px;
	    letter-spacing: -.15px;
	    color: rgba(34,34,34,.5);
	}
	
</style>
	<main>
		<div class="prod--img">
			<img alt="상품 이미지" src="/static/images/prodimages/${product.imgRoute}" width="560px" height="560px">
		</div>
		<form id="prodForm" action="#">
			<div class="prod--info">
				<div class="prod--title">
					<div class="brand--name">
						<a href="#" class="prod--brand--name">${product.brandName}</a>
					</div>
					<p class="prod--eng--name">${product.engName}</p>
					<p class="prod--kor--name">${product.korName}</p>
				</div>
				<div class="form-group">
				  <label for="sel1">사이즈:</label>
				  <select class="form-control" id="sel1" name="size">
				  	<c:forEach var="size" items="${sizeList}">
				    	<option>${size.name}</option>
				  	</c:forEach>
				  </select>
				</div>
				<div class="buttons">
					<button onclick="submitBuy()" id="buy--button">
						<span class="purchase">구매</span>
						<div class="button--line"> </div>
						<span class="price">${product.purchase}원</span>
					</button>
					<button onclick="submitCart()" id="cart--button">
						장바구니 담기
					</button>
				</div>
				<div class="info--title">
					<h3 class="detail--title">상품 정보</h3>
				</div>
				<div class="detail--product">
					<dl class="detail--product--dl">
						<div class="detail--box--model">
							<dt class="product--title">모델번호</dt>
							<dd class="product--info" style="font-weight: 600">${product.modelNumber}</dd>
						</div>
					</dl>
					<dl class="detail--product--dl">
						<div class="detail--box">
							<dt class="product--title">출시일</dt>
							<dd class="product--info">${product.releaseDate}</dd>
						</div>
					</dl>
					<dl class="detail--product--dl">
						<div class="detail--box">
							<dt class="product--title">컬러</dt>
							<dd class="product--info">${product.color}</dd>
						</div>
					</dl>
					<dl class="detail--product--dl">
						<div class="detail--box">
							<dt class="product--title">발매가</dt>
							<dd class="product--info">${product.releasePrice}원</dd>
						</div>
					</dl>
				</div>
			</div>
			<input type="hidden" value="${product.id}" name="prodId">
		</form>
	</main>
	<script src="/static/js/productDetail.js"></script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
