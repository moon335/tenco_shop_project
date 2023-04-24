<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file ="/WEB-INF/view/layout/header.jsp" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
   display: flex;
   align-items: center;
   flex-direction: column;
}

.search-container {
   display: flex;
   justify-content: center;
}
.search {
   width: 770px;
   padding-bottom: 16px;
   border-bottom: 3px solid #000;
   margin: 30px;
   
}
.search input {
   display:flex;
   border: none;
   width: 770px;
   line-height: 29px;
   background-color: #eee;
   font-size : 20px;
   background-color: transparent;
   
}

.producct {
   display: flex;
   justify-content: center;
   align-items: center;
}

.product-search {
   font-size: small;
   margin: 10px;
}

.product-search>img {
   background-color: #eee;
   size: 50px;
   border-radius: 10px;
   margin: 5px;
}
</style>
</head>
<body>
   <body>
   <div class="search-container">
      <form action="/product/search-proc" method = "get">
      <div class="search">
         <input type="text" id ="search"  name ="title" placeholder="브랜드명,모델명 등">
         <input type="submit" value="검색">
      </div>
      <div class="producct">
         </div>
      </form>
   </div>
</body>
</html>
