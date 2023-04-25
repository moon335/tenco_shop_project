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
		<form action="/notice/noticeForm" method="get" class="mb-1">
			<div class="form-group">
			<div class="category-box">
				<label>
					<select>
						<option value="1">공지</option>
						<option value="2">이벤트 발표</option>
						<option value="3">쇼룸</option>
						<option value="4">전시 안내</option>
					</select>
				</label>
				</div>
				<input type="text" class="form-control" placeholder="제목을 입력하세요" name="title" id="title">
			</div>
			<div class="form-group bg-white">
				<textarea class="form-control summernote" rows="5" id="content"
					name="content"></textarea>
			</div>
		</form>
		<button onClick="save()" type="button" class="btn btn-primary" style="background-color: black">작성 완료</button>
	</div>
	<script>
        $('.summernote').summernote({
            tabsize: 2,
            height: 400
        });
    </script>
</body>
</html>