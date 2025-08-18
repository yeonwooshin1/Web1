<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="/css/실습7/실습7.css" rel="stylesheet"/>
</head>
<body>

    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div id="map"> </div>
        <div id="sidebar"> </div>
    </div>

    <!-- 카카오지도 API JS 호출 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0b633e5ec63ebf87e71639e3e8d2e0e2&libraries=clusterer"></script>

    <script src="/js/실습7/실습7.js"></script>

</body>