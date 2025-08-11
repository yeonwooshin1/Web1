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
    <jsp:include page="/board/header.jsp"></jsp:include>

    <h3>모든 게시물 조회 페이지</h3>
    
    <table border="1">
        <thead>
            <tr>
                <th> 번호 </th> <th> 작성자 </th>
                <th> 내용 </th>
            </tr>
        </thead>
        <tbody id="listTbody">

        </tbody>
    </table>

    <script src="/board/list.js"></script>
</body>
</html>