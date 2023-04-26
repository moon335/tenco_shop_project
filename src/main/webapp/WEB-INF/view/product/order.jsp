<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
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
	
</style>
	<main>
		<div class="main--contents">
			<div class="prod--info--area">
				<div class="prod--info">
					<div class="product">
						<img alt="" src="/static/images/prodImages/img1.png" width="80" height="80">
					</div>
					<div class="prod--detail">
						<span class="model--number">ABC-123y72313</span>
						<p class="eng--name">aaaaaaaaaaa</p>
						<p class="kor--name">bbbbbbbbbb</p>
						<span class="size">L</span>
					</div>
				</div>
			</div>
			<div class="info--box">
				
			</div>
		</div>
	</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
