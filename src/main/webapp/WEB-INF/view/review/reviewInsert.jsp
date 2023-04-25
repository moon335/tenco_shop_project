<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
</style>
<main>
	<h1>여기는 후기 올리기입니다.</h1>
	<h3>productId 기반 product 컬럼 내용 갖고 오기, 파일 업로드 기능</h3>

	<div class="container mt-3">
		<form action="/review/reviewInsert-proc" method="post" enctype="multipart/form-data">
			<p>파일 올리기 :</p>
			<div class="custom-file mb-3">
				<input multiple="multiple" type="file" class="custom-file-input" id="customFile" name="fileList" accept=".jpg, .jpeg, .png"> 
				<label class="custom-file-label" for="customFile">Choose file</label>
			</div>
			<div class="mt-3">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</main>
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