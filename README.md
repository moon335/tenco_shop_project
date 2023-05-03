![index_og_tenco](https://user-images.githubusercontent.com/124985978/235557646-7d522796-0516-4f3b-b931-d435d2c805fa.png)
## [👋 프로젝트 소개 README](https://github.com/moon335/tenco_shop_project/tree/feature/login2/README.md)
<br>

## 1️⃣ 프로젝트 구조

```bash
    src   
    ├───main  
    └───java
         └───com
             └───tenco
                  │   
                  └───tencoshop
                  ├───aop
                  ├───config
                  ├───controller
                  ├───dto
                  ├───handler
                  │   └───exception     
                  │         ├───repository
                  │         │      ├───interfaces
                  │         │      └───model
                  │         ├───service
                  │         └───util 
                  ├───resources
                  │   ├───mapper
                  │   └───static
                  │        ├───css
                  │        └───js
                  └───webapp
                        └───WEB-INF
                             └───view
                                  ├───admin
                                  ├───layout
                                  ├───notice
                                  ├───product
                                  ├───review
                                  └───user  
```

<br>

## 2️⃣ 요구사항

<br>


# 현행 시스템(KREAM)을 참고하여 요구사항 분석
* 메인화면 : 카테고리(배너, 공지사항, FAQ, HOME, STYLE, SHOP, MY), 로그인, 회원가입, 장바구니, 검색창
  * (로그인 시 로그아웃으로 변경)
* MY 카테고리 : 쇼핑정보(구매내역, 장바구니), 내정보(프로필 정보, QnA)
* 로그인 : 아이디, 비밀번호 입력
* 회원가입 : 아이디, 비밀번호, 전화번호, 주소, 이메일주소, 성, 이름, 관리자 코드 입력
* 고객센터 : 작성자, 자주 묻는 질문, 게시일, 관리자 계정일 때 답변가능
* 상품 : 브랜드 및 상품명, 가격
* 상품 상세 : 브랜드 및 품명, 사이즈, 구매, 장바구니 담기, 상품정보(모델번호, 출시일, 컬러, 발매가)
* 장바구니 : 구매내역(전체, 배송중, 배송후) 상품이미지, 상품명, 사이즈, 구매일자, 배송상태, 후기작성
* 마이페이지 : 프로필 수정, 내 스타일, 회원등급(일반회원), 포인트




<br>

## 3️⃣ ERD

![db_erc](https://user-images.githubusercontent.com/124985978/235618173-1603b9b3-33a4-430c-a872-132f665edb0d.png)

<br>
## 4️⃣ FLOWCHART
<table>
<tr>
<td>User<img src="https://user-images.githubusercontent.com/124985978/235823234-d976fc6a-ef5f-4a89-a813-5832198d7d0b.jpg"></td>
<td>Manager<img src="https://user-images.githubusercontent.com/124985978/235823280-f5a47a40-f2d6-4eec-9315-9fcbee4052b3.jpg"></td>
</tr>
</table>
