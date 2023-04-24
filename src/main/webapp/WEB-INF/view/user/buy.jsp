<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<style>
body {
   width: 1200px;
   margin: 0 auto;
}

.header {
   display: flex;
   margin-bottom: 40px;
   padding: 20px;
   justify-content: space-between;
}

.body {
   display: flex;
}

.side {
   margin: 30px;
}

.side a {
   color: gray;
   text-decoration-line: none;
}

.side a:hover {
   color: black;
}

.side div {
   margin-bottom: 25px;
}

.content_1 {
   border: 1px solid #ccc;
   border-radius: 10px;
   margin: 20px;
   padding: 20px;
}

.content_1 div {
   display: flex;
}

.content_1 button {
   border-color: #ccc;
   border-radius: 10px;
   margin: 15px 2px 10px 4px;
   border-radius: 10px;
}

.content {
   display: flex;
   flex-direction: column;
   width: 950px;
}

.userGrade {
   border-right: 1px solid #ccc;
   justify-content: center;
   flex: 1;
}

.userPoint {
   flex: 1;
   justify-content: center;
}

.buylist {
   display: flex;
   justify-content: space-between;
}

.buylist a {
   color: #6A6A6A;
   font-size: 13px;
}

.buylist a:hover {
   text-decoration: none;
}

#profileediter {
   display: flex;
   flex-direction: column;
}

#profileediter button:hover {
   background-color: white;
   color: black;
}

#profileediter div button:focus {
   background-color: #EBEBEB;
}

.buyProduct {
   margin: 0 auto;
   width: 1000px;
   display: flex;
   flex-direction: column;
   flex: 1;
   padding: 10px;
   border: 1px solid #D2D2D2;
   flex: 1;
}

.buyProduct div {
   display: flex;
   margin: 0 20px;
   flex: auto;
   flex-direction: column;
   align-items: center;
   justify-content: center;
}

.buyProductInfo {
   display: flex;
   border-bottom: 1px solid #D2D2D2;
   width: 900px;
}

.buyProductInfo div {
   display: flex;
   align-items: flex-start;
   justify-content: flex-start;
}

.buyProduct div {
   display: flex;
   align-items: flex-start;
   justify-content: flex-start;
}

.buyProduct div div {
   display: flex;
   flex-direction: row;
}

.buyProduct div div div {
   display: flex;
   align-items: flex-start;
   justify-content: flex-end;
   flex-direction: column;
   margin-top: 10px;
}

.buyDate {
   display: flex;
   align-items: center;
}

.size {
   display: flex;
   justify-content: center;
   align-items: center;
}

.size div {
   display: flex;
   justify-content: center;
   align-items: center;
}
</style>

<body>
   <div class="header">
      <h1>TencoShop</h1>
      <a href=""><img alt="" src="/images/search.png"></a>
   </div>
   <div class="content">
      <hr>
   </div>
   <div class="buyProduct">
      <div>
         <div class="buyProductInfo">
            <img alt="" src="/images/1.png" width="120" height="120">
            <div style="width: 400px;">
               <pre>모델 번호</pre>
               <pre>Dior Saddle Flap Card Holder Blue Dior Oblique Jacquard</pre>
               <pre>ONE SIZE</pre>
            </div>
         </div>
      </div>
      <div class="size">
         <div>
            <p>260</p>
         </div>
      </div>
   </div>
   </div>
</body>
</html>