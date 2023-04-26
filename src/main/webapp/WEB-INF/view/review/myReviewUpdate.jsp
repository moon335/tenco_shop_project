<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	display: flex;
	flex-direction: column;
}

</style>

<main>
	<div class="container my-3">
		<form action="#" method="post" class="mb-1">
			<div class="form-group">
			<div class="category-box">
				<label>
					<select name="boardCategoryId" id="boardCategoryId">
						<option value="1">카테고리</option>
						<option value="2">???</option>
						<option value="3">???</option>
						<option value="4">???</option>
					</select>
				</label>
				</div>
				<input type="text" class="form-control" placeholder="제목을 입력하세요" name="title" id="title">
			</div>
			<div class="form-group bg-white">
				<textarea class="form-control summernote" rows="5" id="content"
					name="content"></textarea>
			</div>
		<button type="submit" class="btn btn-primary" style="background-color: black; border-color: black">작성 완료</button>
		</form>
	</div>
</main>
</div>
<script>
$('.summernote').summernote({
    tabsize: 2,
    height: 500,
    toolbar: [
        ['style', ['style']],
        ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['table', ['table']],
        ['insert', ['picture']],
      ]
});
$(document).ready(function() {
	  $('#summernote').summernote();
	});
</script>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>