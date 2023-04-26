<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/noticeHeader.jsp"%>
</head>
<style>
.category-box select {
	width: 150px;
	border: 1px solid #ccc;
	border-radius: 3px;
	padding: 3px;
	color: gray;
}

.category-box option {
	color: gray;
}


</style>
<body>
	<div class="container my-3">
		<form action="/notice/update/${id}" method="post" class="mb-1">
			<div class="form-group">
			<div class="category-box">
				<label>
					<select name="boardCategoryId" id="boardCategoryId">
						<option value="1">공지</option>
						<option value="2">이벤트 발표</option>
						<option value="3">쇼룸</option>
						<option value="4">전시 안내</option>
					</select>
				</label>
				</div>
				<input type="text" class="form-control" name="title" id="title" value="${update.title}">
			</div>
			<div class="form-group bg-white">
				<textarea class="form-control summernote" rows="5" id="content"
					name="content">${update.content}</textarea>
			</div>
		<button type="submit" class="btn btn-primary" style="background-color: black; border-color: black">작성 완료</button>
		</form>
	</div>
	<script>
        $('.summernote').summernote({
            tabsize: 2,
            height: 400
        });
    </script>
</body>
</html>