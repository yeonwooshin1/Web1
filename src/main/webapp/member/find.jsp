<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/find.css'>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="idContainer">
        <h3>  아이디 찾기 </h3>
        <div> 회원 이름 : <input type="text" class="mname"> </div>
        <div> 회원 전화번호 : <input type="text" class="mphone1"> </div>
        <button type="button" onclick="idFind()"> 아이디 찾기 </button>
    </div>

    <div id="pwdContainer">
        <h3>  비밀번호 찾기 </h3>
        <div> 회원 아이디 : <input type="text" class="mid"> </div>
        <div> 회원 전화번호 : <input type="text" class="mphone2"> </div>
        <button type="button" onclick="pwdFind()"> 비밀번호 찾기 </button>
    </div>

    <div id="resultFind"> </div>

    <script src="/js/member/find.js"></script>
</body>
</html>
<!--1. 아이디 찾기 기능
    - 입력: 이름, 연락처
    - 처리: 이름+연락처 일치 시 아이디 반환
    - 불일치 시 "회원정보 없음" 메시지

2. 비밀번호 찾기 기능
    - 입력: 아이디, 연락처
    - 처리: 아이디+연락처 일치 시 새로운 난수 비밀번호 생성 후 반환
    - 생성된 비밀번호를 DB에 업데이트(임시 비밀번호로 사용)

