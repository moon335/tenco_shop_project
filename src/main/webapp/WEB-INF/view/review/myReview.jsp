<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<main>
	<h1>여기는 내 후기입니다.</h1>
	<h3>상품 불러와야 함. controller에서 productService 호출하기</h3>
	<div>
		${review.id}
		${review.userId}
		${review.content}
		${review.userName}
	</div>
</main>