<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="stylesheet" href="/css/reviewCategory.css">
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<style>
body {
   width: 1183px;
   margin: 0 auto;
}

.header-inner {
   padding: 20px 20px;
}

html, body {
   position: relative;
   height: 100%;
}

.detail--all--wrap {
   padding: 0 40px;
}

.swiper {
   height: 100%;
}

.swiper-slide {
   text-align: center;
   font-size: 18px;
   display: flex;
   justify-content: center;
   align-items: center;
}

.swiper-slide img {
   display: block;
   width: 600px;
   height: 100%;
   object-fit: cover;
   border-radius: 20px;
}

.swiper {
   margin-left: auto;
   margin-right: auto;
}

.detail--all-wrap {
   display: flex;
   justify-content: center;
   width: 1200px;
}

.detail--category--wrap {
   display: flex;
   flex-direction: column;
   margin-top: 20px;
}

.detail--user--wrap, .detail--picture--wrap, .detail--product--wrap,
   .detail--content--wrap, .detail--heart--wrap, .detail--heart {
   display: flex;
   justify-content: center;
   margin: 0 auto;
   width: 600px;
}

.detail--user--wrap {
   font-size: 20px;
   margin-top: 20px;
   margin-bottom: 20px;
   justify-content: space-between;
   margin-top: 20px;
   border-bottom: 1px solid #ccc;
   padding-bottom: 10px;
}

.detail--picture--wrap>img {
   border-radius: 20px;
}

.detail--product--wrap {
   justify-content: flex-start;
   margin-top: 10px;
   padding-bottom: 20px;
   border-bottom: 1px solid #ccc;
}

.detail--content--wrap {
   justify-content: flex-start;
   margin-top: 15px;
   font-size: 20px;
}

.detail--content--wrap:hover a{
   text-decoration: underline;
}

.detail--content--wrap a{
   color:black;
   margin-right: 10px;
}

.detail--heart--wrap {
   display: flex;
   justify-content: flex-start;
   margin-top: 18px;
}

.detail--heart {
   display: flex;
   justify-content: flex-start;
   align-items: center;
   font-size: 14px;
   padding-top: 8px;
}

main {
   margin-bottom: 50px;
}

.productInfo--content--wrap {
   display: flex;
   font-size: 20px;
   width: 600px;
   margin: 0 auto;
   margin-top: 20px;
   border-top: 1px solid #ccc;
   padding-top: 20px;
}

.engName--korName--wrap {
   display: flex;
   flex-direction: column;
   text-align: center;
   justify-content: center;
}

.user--userName--wrap {
   display: flex;
}

.user--userImg--wrap>a>img {
   width: 70px;
   height: 70px;
   border-radius: 50px;
}

.user--userImg--wrap {
   margin-right: 20px;
}

.detail--createdAt--wrap {
   display: flex;
   justify-content: center;
   align-items: center;
   font-size: 18px;
}

.detail--userName--wrap {
   display: flex;
}

.detail--userName--wrap a{
   color: black;
}

.detail--userName--wrap a:hover{
   text-decoration: underline;
}

.detail--title--wrap {
   display: flex;
   justify-content: flex-start;
   width: 600px;
   margin: 0 auto;
   font-size: 20px;
   border-bottom: 1px solid #ccc;
   padding-bottom: 20px;
   margin-bottom: 20px;
}

.user--info {
   padding-top: 5px;
}

.detail--wrap {
   font-size: 2.5rem;
}

.heartBtn{
   display: flex;
}

.detail--heart{
   margin-top: 13px;
}
</style>
<main>
   <div class="detail--all--wrap">
      <div class="detail--category--wrap">

         <c:choose>
            <c:when test="${review.image!=null}">
               <div class="detail--user--wrap">
                  <div class="user--userName--wrap">
                     <div class="user--userImg--wrap">
                        <a href="/review/author-style/${review.userName}"><img src="/images/uploads/${review.image}"></a>
                     </div>
                     <div class="user--info">
                        <span class="detail--userName--wrap"><a href="/review/author-style/${review.userName}">${review.userName}</a></span> <span
                           class="detail--createdAt--wrap">${review.formatCreatedAt()}</span>
                     </div>
                  </div>
               </div>
            </c:when>
            <c:otherwise>
               <div class="detail--user--wrap">
                  <div class="user--userName--wrap">
                     <div class="user--userImg--wrap">
                        <a href="/review/author-style/${review.userName}"><img src="/static/images/myinfo.png"></a>
                     </div>
                     <div class="user--info">
                        <span class="detail--userName--wrap"><a href="/review/author-style/${review.userName}"> ${review.userName} </a></span> <span
                           class="detail--createdAt--wrap">${review.formatCreatedAt()}</span>
                     </div>
                  </div>
               </div>
            </c:otherwise>
         </c:choose>
         <div class="detail--title--wrap">${review.title}</div>
         <div class="swiper-slide">
            <img src="/images/uploads/${review.setUpReviewImage()}" width=550 height=auto>
         </div>
         <div class="productInfo--content--wrap">상품 정보</div>
         <div class="detail--product--wrap">
            <img src="/static/images/prodImages/${review.imgRoute}" width="110" height="110">
            <div class="engName--korName--wrap">
               <div class="">${review.engName}</div>
               <div class="">${review.korName}</div>
            </div>
         </div>
         <div class="detail--heart--wrap">
            <c:choose>
               <c:when test="${heart != null}">
                  <form action="/review/delete-heart/${heart.id}/${heart.reviewId}/minus" method="get">
                     <div class="heartBtn">
                        <button type="submit">
                           <img alt="" src="/static/images/review/red_heart2.png" width="45" height="50">
                        </button>
                        <div class="detail--heart">좋아요 ${review.heart}개</div>
                     </div>
                  </form>
               </c:when>
               <c:otherwise>
                  <form action="/review/insert-heart" method="post">
                     <div class="heartBtn">
                        <input type="hidden" name="reviewId" value="${review.id}">
                        <button type="submit">
                           <img alt="" src="/static/images/review/white_heart2.png" width="45" height="50">
                        </button>
                        <div class="detail--heart">좋아요 ${review.heart}개</div>
                     </div>
                  </form>
               </c:otherwise>
            </c:choose>
         </div>
         <div class="detail--content--wrap"><a href="/review/author-style/${review.userName}" style="font-weight: 900"> ${review.userName} </a>${review.content}</div>
      </div>
   </div>

</main>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
