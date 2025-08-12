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
    <!-- 현재 JSP 파일내 다른 JSP 포함하기 -->
    <jsp:include page="/shop/header.jsp"></jsp:include>
    
    <div class="aa">
        <h3> 쇼핑몰 회원관리 프로그램 </h3>
    </div>
    <div class="bb"> 쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.</div>
    
    <jsp:include page="/shop/footer.jsp"></jsp:include>
</body>
</html>