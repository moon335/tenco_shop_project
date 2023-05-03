![logo](https://user-images.githubusercontent.com/124985978/235605573-8e9883a8-5f1b-4e1f-b517-cb1a87a283bc.png)

<details>
<summary> 👉🏻 Contents  </summary>
  
- [🚀 프로젝트 개요]
- [🎮 기술 스택]
  - [✨ Front-End]
  - [💻 Back-End]
  - [🫡 협업툴]
- [🚀 서비스 소개]
- [🚀 주요기능]
  - [회원 정보와 관련된 전반적인 CRUD]
  - [관리자 전용 페이지와 공지사항 및 FAQ]
  - [상품 구매 및 장바구니]
  - [Paging 처리]
  - [검색 기능]
- [🚀 프로젝트 합성 이미지]

</details>

## 



## 🚀 프로젝트 개요
- *모든 팀원이 풀스택으로 개발에 참여했으며, 주 포지션은 아래와 같습니다.*
<br>

|   Name   | 김현우 | 전대영 | 이치승 | 김미정 | 강민정 |
| :------: | --- | --- | --- | --- | --- |
| Profile  | ![김현우](https://user-images.githubusercontent.com/124985978/235606009-bea5abaf-c900-4092-9687-03930e111394.jpg) |![전대영](https://user-images.githubusercontent.com/124985978/235606071-17540786-c7f3-4646-954e-b747edf0f8a9.png) |![이치승](https://user-images.githubusercontent.com/124985978/235606141-63d3c857-b6b1-4156-9c1c-b61774f25d3f.png) |![김미정](https://user-images.githubusercontent.com/124985978/235606169-c42c8b1a-2eb0-46ae-a886-8a4248d4ae52.jpg) |![강민정](https://user-images.githubusercontent.com/124985978/235606203-c0c77adb-8df0-4faa-bb87-29e5b9bfd1a8.jpg) |
| Position | 팀장 & Backend & UI | Backend & UI | Backend & UI | Backend & UI | Backend & UI |

- 프로젝트 기간: 2023년 4월 21일 ~ 2023년 5월 3일
- 소개 및 시연 영상: 

<br> 

## 🎮 기술 스택

### ✨ Front-End

<details>
    <summary>⚡️ FE 자세히 살펴보기</summary>
    <ul>
        <li>springboot(javascript) : 4.18.0 </li>
        <li>bootstrap : 5.1.3 </li>
        <li>bootstrap : 4.6.2 </li>
    </ul>
</details>

### 💻 Back-End

<details>
      <summary>⚡️ BE 자세히 살펴보기</summary>
      <ul>
          <li>springboot : 4.18.0 </li>
          <li>MySQL : 8.0.32 </li>
          <li>jdk : 11.0.17 </li>
          <li>lombok </li>
      </ul>
  </details>
  

### 🙌🏻 Collaboration
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=Jira&logoColor=white"/> <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=Slack&logoColor=white"/> <img src="https://img.shields.io/badge/Github-181717?style=flat&logo=Github&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=Notion&logoColor=white"/>

<br>


## 🚀 서비스 소개

> 누구나 쉽게 거래하고 함께 즐길 수 있도록 치열하게 고민하고 빠르게 실행합니다.
> <br> *_KREAM SERVICE*

<br>

## 🚀 주요기능

### 1️⃣ 회원 정보와 관련된 전반적인 CRUD

💬 *회원가입을 통해 SQL로 올라간 값을 비교해 각종 예외처리를 구현하였습니다.*

<table border="0" >
    <tr>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235808655-d5813d65-7ea0-4274-add8-37c02b49db30.png"> </img></td>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235808666-c693b8f0-5b68-4585-bc25-8d3b819a9b18.png"> </img></td>
   </tr>
</table>


<br>

### 3️⃣ 상품 구매 및 장바구니
💬 *내가 구매한 상품 리뷰 작성 및 삭제, 장바구니 담기가 가능합니다.*

<table border="0" >
    <tr>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235610186-c4ea3638-cf1f-467f-9942-7f5f21afa990.png"> </img></td>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235612046-c17ae348-2619-4962-94eb-8557278f568d.png"> </img></td>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235612756-972a43bb-2b9b-48b6-9a20-2b86cfb682cb.png"> </img></td>
   </tr>
</table>

- 일반 계정 로그인 시 후기 작성 가능
  - 구매확정을 누르면 배송 상태가 배송 완료로 변경됩니다.
  - 장바구니에 담은 상품은 바로 구매가 가능합니다.
- 관리자는 작성된 후기에 답글을 남길 수 있습니다.

<details>
<summary> 👉🏻 Source  </summary>
  
<pre>
<code>

</code>
</pre>
  
</details>

<br>

### 4️⃣ Paging 처리
💬 *상품이 너무 많을 때는 페이지를 이용하여 깔끔하게 정리할 수 있습니다.*

![paging](https://user-images.githubusercontent.com/124985978/235613141-0452b3fb-684a-44ea-8f4e-4ecf013c6361.png)

- 페이지를 숫자를 눌러 편하게 이동할 수 있습니다.

<details>
<summary> 👉🏻 Source  </summary>
  
<pre>
<code>

</code>
</pre>
  
</details>

<br>

### 5️⃣ 검색 기능
💬 *찾고싶은 상품이 있을 때 검색기능을 이용하여 쉽게 찾을 수 있습니다.*

![search](https://user-images.githubusercontent.com/124985978/235613369-db8671dd-b0c0-4770-8dcc-51f240d8c319.png)


- 페이지가 너무 많아서 상품을 찾기 힘들 때 검색 기능을 이용할 수 있습니다.

<details>
<summary> 👉🏻 Source  </summary>
  
<pre>
<code>

</code>
</pre>
  
</details>

## 🚀 합성 이미지

  <table border="0" >
    <tr>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235613820-53b248e0-83eb-4f2a-b3d0-454fba08d840.png"> </img></td>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235613835-3bca9143-9780-4c82-aa5b-5869d337c9ff.png"> </img></td>
        <td>    <img width="400" src="https://user-images.githubusercontent.com/124985978/235613840-0970c268-ed0c-4920-9b2f-91bed44f6fc9.png"> </img></td>
   </tr>
</table>
