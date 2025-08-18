<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>

    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <!-- KAKAO 지도가 출력되는 DIV -->
        <div id="map" style="width:500px;height:400px;"></div>

    </div>

    <!-- KAKAO 지도 API JS : 개발자정의 JS보다 먼저 호출 권장-->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0b633e5ec63ebf87e71639e3e8d2e0e2"></script>
    <!-- 개발자정의 JS -->
    <script src="/js/kakao/map.js"></script>

</body>
</html>