<%@page import="org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<%
	String sizeId = "";
	String prodId = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie c : cookies) {
			if(c.getName().equals("size")) {
				sizeId = c.getValue();
			} else if (c.getName().equals("product")) {
				prodId = c.getValue();
			}
		}
	}
%>
<style>
	
	main {
		margin: 0 auto;
	}
	
	.main--contents {
		margin: 0 auto;
	    padding: 20px 40px 160px;
	    max-width: 780px;
	}
	
	.prod--info--area {
		width: 700px;
	}
	
	.prod--info {
		width: 700px;
		display: flex;
		padding: 32px;
	}
	
	.prod--detail {
		padding-left: 16px;
	}
	
	.model--number {
		line-height: 17px;
    	font-size: 14px;
    	font-weight: bolder;
	}
	
	.eng--name {
		line-height: 17px;
    	margin-top: 1px;
    	font-size: 14px;
    	margin-bottom: 0;
	}
	
	.kor--name {
		line-height: 16px;
	    margin-top: 2px;
	    font-size: 13px;
	    letter-spacing: -.05px;
	    color: rgba(34,34,34,.5);
	}
	
	.info--box {
		border-top: 1px solid #ebebeb;
		border-bottom: 1px solid #ebebeb;
	}
	
	.deliver--option--wrap {
		display: flex;
		margin-bottom: 10px;
	}
	
	.deliver--option--title {
		width: 100px;
		margin-right: 30px;
		
	}
	
	.deliver--option--contents {
		width: 200px;
	}
	
	.address--box--title {
		margin-top: 10px;
	}
	
	.address--box--title > h3 {
	    line-height: 22px;
	    font-size: 18px;
    	font-weight: 700;
    	letter-spacing: -.15px;
	}
	
	.address--box {
		padding: 32px;
	}
	
	.price--box {
		display: flex;
		flex-direction: column;
		padding: 32px;
		border-bottom: 1px solid #ebebeb;
	}
	
	.price--title > h3 {
		line-height: 22px;
	    font-size: 18px;
    	font-weight: 700;
    	letter-spacing: -.15px;
	}
	
	.price--total--order--info {
	    padding-top: 0;
	    border-top: 0;
	    padding-bottom: 19px;
	    width: 100%;
    	text-align: right;
	}
	
	.amount {
		line-height: 26px;
	    font-size: 20px;
	    letter-spacing: -.1px;
	    font-weight: 600;
	    letter-spacing: normal;
	}
	
	.price--second--title > span {
		width: 100%;
    	font-size: 14px;
    	font-weight: 700;
    	letter-spacing: -.01px;
	}
	
	.button--box {
		padding: 32px;
		border-bottom: 1px solid #ebebeb;
	}
	
	.buy--button {
		width: 100%;
		background-color: #000;
	    color: #fff;
	    cursor: pointer;
	    font-weight: 700;
	    height: 52px;
	    border-radius: 12px;
	}
	
	.buy--button:hover {
		width: 100%;
		background-color: #000;
	    color: #fff;
	    cursor: pointer;
	    font-weight: 700;
	    height: 52px;
	    border-radius: 12px;
	}
	
</style>
	<main>
		<form action="/order/input-order" method="post">
			<div class="main--contents">
			 	<c:if test="${cart.id} != null">
					<input type="hidden" name="cartId" value="${cart.id}">
				</c:if>
				<div class="prod--info--area">
					<div class="prod--info">
						<div class="product">
							<img alt="" src="/static/images/prodImages/img1.png" width="80" height="80">
						</div>
						<div class="prod--detail">
							<input type="hidden" value="<%=prodId %>" name="prodId">
							<input type="hidden" value="<%=sizeId %>" name="sizeId">
							<span class="model--number">${product.modelNumber}</span>
							<p class="eng--name">${product.engName}</p>
							<p class="kor--name">${product.korName}</p>
							<span class="size">${product.sizeName}</span>
						</div>
					</div>
				</div>
				<div class="info--box">
					<div class="address--box">
						<div class="address--box--title">
							<h3>배송지 정보</h3>
						</div>
						<div class="deliver--option--wrap">
							<span class="deliver--option--title">수령인</span>
							<input type="text" class="form-control form-control-sm deliver--option--contents" name="receiver" value="${loginUser.firstName}${loginUser.lastName}">
						</div>
						<div class="deliver--option--wrap">
							<span class="deliver--option--title">연락처</span>
							<input type="text" class="form-control form-control-sm deliver--option--contents" name="receiverPhoneNumber" value="${loginUser.tel}">
						</div>
						<div class="deliver--option--wrap">
							<span class="deliver--option--title">배송지 주소</span>
							<input type="text" class="form-control form-control-sm deliver--option--contents" name="address" value="${loginUser.address}">
						</div>
					</div>
				</div>
				<div class="price--box">
					<div class="price--title">
						<h3>최종 주문 정보</h3>
					</div>
					<div class="price--second--title">
						<span>총 결제금액</span>
					</div>
					<div class="price--total--order--info">
						<span class="amount">333333원</span>
					</div>
				</div>
				<div class="button--box">
					<button type="submit" class="buy--button">구매하기</button>
				</div>
			</div>
		</form>
	</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
