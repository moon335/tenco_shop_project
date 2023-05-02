<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/static/css/join.css">
<link href='https://fonts.googleapis.com/css?family=Noto Sans' rel='stylesheet'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
   integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="text-center">
   <!--  html 전체 영역을 지정하는 container -->
      <div id="container">
         <!--  login 폼 영역을 : loginBox -->
         <div id="loginBox">
            <!-- 로그인 페이지 타이틀 -->
            <div id="loginBoxTitle">
               <h1>회원가입</h1>
            </div>
            <!-- 아이디, 비번, 버튼 박스 -->
            <div id="inputBox">
               <form action="/user/sign-up" method="POST">
               <div class="join--all--wrap">
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">아이디*</span>
                     <input type="text" class="form-control" id="username" name="username" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">비밀번호* </span>
                     <input type="password" class="form-control" id="password" name="password" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">전화번호* </span>
                     <input type="text" class="form-control" id="tel" name="tel" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">주소* </span>
                     <input type="text" class="form-control" id="address" name="address" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">이메일 주소* </span>
                     <input type="email" class="form-control" id="email" name="email" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">성* </span>
                     <input type="text" class="form-control" id="firstName" name="firstName" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">이름* </span>
                     <input type="text" class="form-control" id="lastName" name="lastName" required>
                  </div>
                  <div class="input-form-box">
                     <span class="input-form-login-box" style="font-weight: 900;">관리자코드 </span>
                     <input type="text" class="form-control" id="role" name="role">
                  </div>
               </div>

                  <div class="button-login-box">
                     <button type="submit" class="btn btn-primary btn-xs" style="width: 100%">가입하기</button>
                  </div>
            </form>

            </div>
         </div>
   </div>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
   </script>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
