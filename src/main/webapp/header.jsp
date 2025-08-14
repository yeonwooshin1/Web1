 
 	
<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <!-- css 가져오기 -->
    <link href="/css/header.css" rel="stylesheet">
</head>
<body>

    <div id="header">
        <ul id="sub-menu">
            <li> <a href="/index.jsp"> <img src="/img/logo.jpg"/> </a> </li>
            <li> <a href="#"> 메뉴1 </a> </li>
            <li> <a href="#"> 메뉴2 </a> </li>
            <li> <a href="#"> 메뉴3 </a> </li>
        </ul>
        <ul id="log-menu">
            <!-- 로그인 안했을때 구역 -->
            <li> <a href="/member/login.jsp"> 로그인 </a></li>
            <li> <a href="/member/signup.jsp"> 회원가입 </a></li>
            <!-- 로그인 했을때 구역 -->
            <li> <span> OOO님 </span> </li>
            <li> <a href="/member/info.jsp"> 내정보 </a> </li>
            <li> <a href="#" onclick="logout()"> 로그아웃 </a> </li>
        </ul>
    </div>
    <!-- JS 가져오기 -->
    <script src="/js/header.js"> </script>

</body>