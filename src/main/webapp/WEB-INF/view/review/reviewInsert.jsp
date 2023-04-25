<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<style>
</style>
<main>
	<h1>여기는 후기 올리기입니다.</h1>
	<h3>product 갖고 오기, 파일 업로드 기능</h3>

	<form action="/reviewInsert-proc" method="post"
		enctype="multipart/form-data">

		<div class="custom-file">
			<input type="file" class="custom-file-input" id="customFile">
			<label class="custom-file-input" for="customFile">Choose file</label>
		</div>
	</form>
</main>
<script>

// Add the following code if you want the name of the file appear on select
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
</script>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>