<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <!-- 현재 JSP 파일내 다른 JSP 포함하기 -->
    <jsp:include page="/shop/header.jsp"></jsp:include>
    
    <div>
        <h3> 쇼핑몰 회원관리.ver 1.0 </h3>
        <p> localhost:8080/shop/index.jsp </p>
    </div>
    
    <jsp:include page="/shop/footer.jsp"></jsp:include>
</body>
</html>