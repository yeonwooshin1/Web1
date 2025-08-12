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
        <h3> 대기 전체 조회 페이지 </h3>
        <table border="1">
            <thead>
                <tr>
                    <th> 번호 </th> <th> 이름 </th>
                    <th> 대기수 </th> <th> 날짜 </th>
                </tr>
            </thead>
            <tbody id="waitingTbody">
            </tbody>
        </table>
    </div>

    <script src="/waiting/list.js"></script>

</body>
</html>