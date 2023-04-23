<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.detail--all--wrap {
	border-top: 1px solid #eee;
}
</style>

<main>
	<div class="detail--all--wrap">
		<c:forEach var="reviewDto" items="${reviewDto}">
			<div class="">
				<p>${reviewDto.userName}</p>
			</div>
		</c:forEach>
	</div>
</main>
