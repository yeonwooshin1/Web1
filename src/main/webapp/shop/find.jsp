<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="/shop/assets/style.css">
</head>
<body>
    <jsp:include page="/shop/header.jsp"></jsp:include>

    <div>
        <h3> 홈쇼핑 회원 정보 수정 </h3>
        회원번호 : <input type="text" class="customerNo" disabled > <br/>
        회원성명 : <input type="text" class="customerName" /> <br/>
        회원전화 : <input type="text" class="phone" /> <br/>
        회원주소 : <input type="text" class="address" /> <br/>

        가입일자 : <input type="text" placeholder="YYYYMMDD" inputmode="numeric" 
        maxlength="8" class="joinDate" /> <br/>

        고객등급[A:VIP, B:일반, C:직원] : <input type="text" class="grade" /> <br/>
        도시코드 : <input type="text" class="city" /> <br/>

        <button type="button" onclick="memberUpdate()"> 수정 </button>
        <button type="button" onclick="location.href='/shop/memberList.jsp'">조회</button>
    </div>
    <script src="/shop/find.js?time=<%= System.currentTimeMillis() %>"></script>
    
</body>
</html>