<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

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

.reviewInsert--wrap--title>h4 {
	border-bottom: 1px solid #ebebeb;
	padding-bottom: 20px;
}

.reviewInsert--header {
	display: flex;
	justify-content: space-between;
}

.wish--list {
	width: 700px;
	padding: 20px;
}

.wish--item {
	width: 1000px;
	display: flex;
	justify-content: space-between;
}

.wish--product {
	width: 900px;
	display: flex;
	margin-bottom: 20px;
	justify-content: center;
}

.wish--box {
	display: flex;
	justify-content: center;
	margin-right: 40px;
	width: 80px;
	align-items: center;
    height: 100%;
}

.review--product--wrap {
	display: flex;
	flex-direction: column;
}

.reviewInsert--detail {
	text-align: left;
	display: flex;
	padding-top:30px;
	justify-content: space-between;
	width: 700px;
	align-items: center;
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

body>div>main>form>div.container.mt-3 {
	padding: 0;
}

.title--category--wrap {
	display: flex;
	flex-direction: row;
	width: 950px;
	justify-content: space-between;
	margin-top: 20px;
}

.custom-file {
	width: 200px;
	margin-left: 20px;
}

#boardCategoryId {
	height: 38px;
	margin-left: 20px;
	width: 120px;
	border: 1px solid #ced4da;
	border-radius: 0.25rem;
}

.form-control {
	width: 650px;
}

.btn-primary {
	width: 94px;
	height: 38px;
}

.reviewInsert--detail span {
    padding-left: 30px;
}
</style>
<main>
	<form action="/review/reviewInsert-proc" method="post" class="mb-1" enctype="Multipart/form-data">
		<div class="reviewInsert--wrap--title">
			<h4>상품 정보</h4>
		</div>
		<div class="wish--item">
			<div class="wish--product">
				<div class="wish--box">
					<img alt="상품" src="/static/images/prodImages/${product.imgRoute}" width="110" height="110">
				</div>
				<div class="reviewInsert--detail">
					<span class="brand--name">${product.brandName}</span> <span class="brand--name">${product.modelNumber}</span> <span class="brand--name">${product.color}</span> <span class="name">${product.engName}</span>
					<span class="name">${product.korName}</span> <span class="size">${product.sizename}</span>
				</div>
			</div>
		</div>
		<input type="hidden" value="${product.id}" name="prodId"> <input type="hidden" value="${orderId}" name="orderId">
		<div class="form-group">
			<div class="title--category--wrap">
				<input type="text" class="form-control" placeholder="제목을 입력하세요" name="title" id="title"> <select name="reviewCategoryId" id="boardCategoryId">
					<optgroup label="카테고리">
						<c:forEach var="reviewCategoryList" items="${reviewCategoryList}">
							<option value="${reviewCategoryList.id}">${reviewCategoryList.name}</option>
						</c:forEach>
					</optgroup>
				</select>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="customFile" name="file" accept=".jpg, .jpeg, .png"> <label class="custom-file-label" for="customFile">Choose file</label>
				</div>
			</div>
		</div>
		<div class="form-group bg-white">
			<textarea class="form-control summernote" rows="5" id="content" name="content"></textarea>
		</div>
		<button type="submit" class="btn btn-primary" style="background-color: black; border-color: black">작성 완료</button>
	</form>
</main>
</div>
<script>
	$('.summernote').summernote(
			{
				tabsize : 2,
				height : 500,
				toolbar : [ [ 'style', [ 'style' ] ], [ 'color', [ 'color' ] ],
						[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
						[ 'table', [ 'table' ] ], [ 'insert', [] ], ]
			});
	$(document).ready(function() {
		$('#summernote').summernote();
	});
</script>
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
