<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
body {
	margin: 0 auto;
	width: 1200px;
}

main {
	width: 950px;
}

.reviewInsert--all--wrap {
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.reviewInsert--wrap>h4 {
	font-weight: bolder;
}

.wish--list {
	width: 950px;
	padding: 20px;
}

.wish--item {
	width: 950px;
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

.reviewInsert--detail {
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

.wish--buy>button {
	width: 164px;
	height: 60px;
	background-color: #ef6253;
	border-radius: 10px;
	color: #fff;
	display: flex;
	justify-content: space-around;
	align-items: center;
}

.wish--buy>button:hover {
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
	border-right: 1px solid rgba(34, 34, 34, .1);
	background-color: rgba(34, 34, 34, .1);
}

.wish--price {
	flex: 3;
}

body > div > main > form > div.container.mt-3{
	padding: 0;
}

</style>
<main>

	<form action="/review/reviewInsert-proc" method="post" enctype="multipart/form-data" class="reviewInsert--all--wrap">
		<div class="container mt-3">
			<div class="reviewInsert--wrap--title">
				<h4>상품 정보</h4>
				<br>
			</div>
			<div class="reviewInsert--detail">
				<div class="wish--item">
					<div class="wish--product">
						<div class="wish--box">
							<img alt="상품" src="/images/${list.imgRoute}" width="80" height="80">
						</div>
						<div class="reviewInsert--detail">
							<span class="brand--name">${product.brandName}</span> <span class="brand--name">${product.modelNumber}</span> <span class="brand--name">${product.color}</span> <span class="name">${product.engName}</span>
							<span class="name">${product.korName}</span> <span class="size">${product.sizename}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="reviewInsert--categoryList">
			<select name="cars" class="custom-select mb-3">
				<c:forEach var="reviewCategoryList" items="${reviewCategoryList}">
					<option value="${reviewCategoryList.id}">${reviewCategoryList.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="custom-file mb-3">
			<input multiple="multiple" type="file" class="custom-file-input" id="customFile" name="fileList" accept=".jpg, .jpeg, .png"> <label class="custom-file-label" for="customFile">Choose
				file</label>
		</div>

		<div class="reviewInsert--textArea">
			<textarea rows="10" cols="100" style="resize: none; padding: 10px;"></textarea>
		</div>
		<div class="mt-3">
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="button" class="btn btn-primary" onclick="location.href='#/delete'">삭제</button>
		</div>
	</form>
</main>
</div>
<script>
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>