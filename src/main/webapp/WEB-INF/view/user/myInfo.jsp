<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/myInfoHeader.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
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
}

.buyProduct {
   display: flex;
   flex: 1;
   align-items: center;
   padding: 10px;
   border-bottom: 1px solid #D2D2D2;
   display: flex;
   flex-direction: column;
}

.buyProduct div {
   display: flex;
   flex: auto;
   flex-direction: row;
   margin: 0 20px;
   align-items: center;
   justify-content: space-between;
}

.buyDate {
   display: flex;
   align-items: center;
}

.page {
   margin-top: 50px;
   display: flex;
   justify-content: center;
   text-align: center;
   padding-bottom: 200px;
}

.page p {
   font-size: 15px;
   color: black;
   width: 50px;
}
</style>
<div class="content">
   <div class="content_1">
      <div>
         <div>
            <c:choose>
               <c:when test="${principal.image!=null}">
                  <input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;">
                  <img class="m--profile" alt="" src=" <c:url value="/images/uploads/${principal.image}"/>" width="150px" height="150" style="border-radius: 150px;">
               </c:when>
               <c:otherwise>
                  <input type="file" class="cutom-file-input" id="customFile" name="file" accept=".jpg,.jpeg,.png" style="display: none;">
                  <img class="m--profile" alt="" src="/static/images/myinfo.png" width="150px" height="150" style="margin-top: -20px;">
               </c:otherwise>
            </c:choose>
         </div>
         <div id="profileediter" style="margin-top: 20px;">
            <div>
               <h3 style="margin-left: 10px;">${user.username}님반갑습니다.</h3>
            </div>
            <div>
               <form action="/user/myinfoEditor" method="get">
                  <button type="submit" class="btn btn-outline-dark">프로필 수정</button>
               </form>
               <a href="/review/myReview">
                  <button type="submit" class="btn btn-outline-dark">내 스타일</button>
               </a>
            </div>
         </div>
      </div>
      <hr>
      <div>
         <div class="userGrade">일반회원</div>
         <div class="userPoint">포인트</div>
      </div>
   </div>
   <div class="buylist">
      <div>구매내역</div>
      <div>
         <a href="/user/buylistProc?orderStartDate=2020-01-01&orderEndDate=2024-01-01&currentPage=1&begin=0&range=8"> 더보기 > </a>
      </div>
   </div>
   <div class="buyProgress ">
      <div style="border-right: 1px solid #E0E0E0;">
         <h5>전체</h5>
         ${orderCount.deliveryCount}
      </div>
      <div>
         <h5>배송중</h5>
         ${orderCount.deliveryNonComplete}
      </div>
      <div>
         <h5>배송완료 </h5>
         ${orderCount.deliveryComplete}
      </div>
   </div>
   <div class="buyProduct">
      <c:forEach var="orderList" items="${orderList}">
         <div>
            <div class="buyProductImg">
               <img alt="" src="/static/images/prodImages/${orderList.imgRoute}" width="120" height="120">
            </div>
            <div style="width: 400px;">
               <p style="width: 250px;">${orderList.engName}</p>
               <pre style="text-align: center; width: 100px;">${orderList.sizeName}</pre>
            </div>
            <div class="buyDate">
               <pre>${orderList.orderDate}</pre>
            </div>
            <div class="status" style="align-items: center; width: 150px; text-align: center">
               <c:choose>
                  <c:when test="${orderList.deliveryStatus==1}">
                     <h6>배송완료</h6>
                  </c:when>
                  <c:otherwise>
                     <h6 style="margin-left: 5px;">배송중</h6>
                  </c:otherwise>
               </c:choose>
               <c:choose>
                  <c:when test="${orderList.deliveryStatus==1}">
                     <button type="submit" onclick="location.href='/review/reviewInsert/${orderList.id}'" style="border: none; background-color: white; color: #088ff7; margin-right: 10px;">
                        후기 <br>올리기
                     </button>
                  </c:when>
                  <c:otherwise>
                     <button type="submit" onclick="location.href='/order/updateDeliveryStatus?id=${orderList.id}'" style="border: none; background-color: white; color: #088ff7; margin-top: -10px;">구매확정</button>
                  </c:otherwise>
               </c:choose>
            </div>
         </div>
      </c:forEach>
   </div>
   <div class="page">
      <c:choose>
         <c:when test="${currentPage==1}">
         </c:when>
         <c:otherwise>
            <a href="/user/myinfoProc?currentPage=1&begin=${8*(1-1)}&range=8"><p><</p></a>
         </c:otherwise>
      </c:choose>
      <c:forEach var="i" begin="${startPage}" end="${endPage}">
         <a href="/user/myinfoProc?currentPage=${i}&begin=${8*(i-1)}&range=8"><p>${i}</p></a>
      </c:forEach>
      <c:choose>
         <c:when test="${currentPage==page}">
         </c:when>
         <c:otherwise>
            <a href="/user/myinfoProc?currentPage=${page}&begin=${8*(page-1)}&range=8"><p>></p></a>
         </c:otherwise>
      </c:choose>
   </div>
</div>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
