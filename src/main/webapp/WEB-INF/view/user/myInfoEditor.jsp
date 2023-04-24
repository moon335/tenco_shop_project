<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

</head>
<style>
body {
   width: 1183px;
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
   border-radius: 10px;
   margin: 20px;
   padding: 20px;
   display: flex;
   flex-direction: column;
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

.title {
   border-bottom: 3px solid black;
   margin-bottom: 50px;
}

.content {
   display: flex;
   flex-direction: column;
   width: 950px;
}

.myinfo {
   border-bottom: 1px solid #ccc;
   margin-bottom: 50px;
}

.myimage {
   margin-right: 20px;
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

.buyProgress {
   display: flex;
   border: 1px solid #ccc;
   border-radius: 20px;
   background-color: #f8f6f6;
   border-style: none;
   justify-content: space-between;
   padding: 20px;
}

.buyProgress div {
   display: flex;
   flex: 1;
   flex-direction: column;
   align-items: center;
   flex-direction: column;
}

.buyProduct {
   display: flex;
   flex: 1;
   align-items: center;
   padding: 10px;
   border-bottom: 1px solid #D2D2D2;
   display: flex;
}

.buyProduct div {
   display: flex;
   flex: auto;
   flex-direction: column;
   margin: 0 20px;
}

.buyDate {
   display: flex;
   align-items: center;
}

.side h4 {
   color: black;
}

.myinfoDetail {
   display: flex;
   flex-direction: column;
}

.myinfoLogin {
   display: flex;
   flex-direction: column;
   margin-bottom: 30px;
}

.myinfoLogin div {
   flex-direction: column;
   margin: 10px;
}

.myinfoLogin input {
   border: none;
   width: 500px;
   border-bottom: 1px solid #ccc;
}

.myinfoLogin input:focus {
   outline: none;
}

.submit {
   display: flex;
   width: 500px;
   justify-content: flex-end;
   align-items: flex-end;
}

.submit input {
   border-radius: 13px;
   color: black;
   background-color: white;
   padding: 6px 10px;
   border: 1px solid #ccc;
   padding: 10px 14px;
}

.myinfoLogin select {
   appearance: none;
   border: none;
   width: 500px;
   height: 50px;
   border-bottom: 1px solid #ccc;
}

.myinfoLogin select:focus {
   outline: none;
}

.submit input:hover {
   color: #909090;
}
</style>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>

<div class="content">
   <div class="content_1">
      <div class="title" style="padding-bottom: 10px;">
         <h2>프로필 정보</h2>
      </div>
      <div class="myinfo">
         <div class="myimage">
            <img alt="" src="/images/myinfo.png" width="150px" height="150">
         </div>
         <div id="profileediter">
            <div>
               <h3>${user.username}</h3>
            </div>
            <div>
               <form action="">
                  <button type="submit" class="btn btn-outline-dark">이미지 변경</button>
               </form>
               <form action="">
                  <button type="submit" class="btn btn-outline-dark">삭제</button>
               </form>
            </div>
         </div>
      </div>
      <form action="#">
         <div class="myinfoDetail">
            <div class="myinfoLogin">
               <h4>
                  <b>로그인 정보</b>
               </h4>
               <div>
                  <p>이메일 주소</p>
                  <input type="text" value="${user.address}" name="address">
               </div>
               <div>
                  <p>비밀번호</p>
                  <input type="password" value="${user.password}" name="password">
               </div>
            </div>
         </div>
         <div class="myinfoDetail">
            <div class="myinfoLogin">
               <h4>
                  <b>개인 정보</b>
               </h4>
               <div>
                  <p>이름</p>
                  <input type="text" value="${user.lastName}" name="lastName">
               </div>
               <div>
                  <p>휴대폰 번호</p>
                  <input type="text" value="${user.tel}" name="tel">
               </div>
            </div>
         </div>
         <div class="submit">
            <input type="submit" value="수정">
         </div>
      </form>
   </div>
<<<<<<< HEAD
=======

>>>>>>> feature/review
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>