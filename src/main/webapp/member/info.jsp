<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/info.css'>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    
    <h3>내정보조회</h3>
    
    <table border = "2">
        <thead>
            <tr>
                <th> 회원 번호 </th> <th> 회원 아이디</th> <th>회원 이름</th>
                <th> 유저 전화번호 </th> <th> 회원가입 날짜/시간 </th>
            </tr>
        </thead>
        <tbody id="memberTbody">
        </tbody>
    <table>

    <a href="/member/update.jsp"> 회원정보 수정</a> <br>
    <a href="/member/pwdupdate.jsp"> 비밀번호 수정</a> <br>
    <a href="#" onclick="onDelete()"> 회원 탈퇴 </a>

    <h3>내 포인트 지급 내역 </h3>
    <table border = "2">
        <thead>
            <tr>
                <th> 번호 </th> <th> 포인트량 </th> <th> 지급사유 </th> <th> 날짜 </th>
            </tr>
        </thead>
        <tbody>
            <tbody id="pointTbody">
            </tbody>
        </tbody>
    </table>

    <script src="/js/member/info.js"></script>
</body>
</html>