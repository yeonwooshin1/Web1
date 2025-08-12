<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3> 등록 인원수 수정페이지 </h3>
        폰번호 : <input type="text" class="phone" /> <br/>
        인원수 : <input type="text" class="count" /> <br/>

        <button type="button" onclick="edit1()"> 수정 </button>
    </div>
    <script src="/waiting/update.js"></script>

</body>
</html>