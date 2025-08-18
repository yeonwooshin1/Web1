console.log( 'datamap.js');
// [1] 공공데이터 , 인천시 동구 약국 , https://www.data.go.kr/data/15051492/fileData.do#tab-layer-openapi
const dataAPI = async()=>{
    // 1.공공데이터 준비
    const serviceKey = "4n%2BzSPF7At0bR63Tzm0UeoDp3kyhESO5NeMzr4erod46S%2B4MsH%2F19WIniGUGtjCXN%2FP6WW88URdCKazOxcXfkg%3D%3D";
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=72&serviceKey=";
    // 2. fetch 실행
    const response = await fetch( URL+serviceKey , { method : "GET"} );
    const data = await response.json();
    console.log( data );
    // 3. 사이드바 정보 출력하기(위도/경도 제외한->지도에서 사용) , 소재지도로명주소/약국명/전화번호
    const sidebar = document.querySelector('#sidebar');
    let html = '';
        data.data.forEach( (value)=>{
            html += `<div id="school">
                        <div> 학교명 :  ${ value.학교명 } </div>
                        <div> 행정실 전화번호 : ${ value.행정실 } </div>
                        <div> 주소 : ${ value.주소 } </div>
                    </div>`
        });
    sidebar.innerHTML = html;
}

dataAPI();

// [2] 카카오맵 클러스터 라이브러리 , https://apis.map.kakao.com/web/sample/addClustererClickEvent
const kakaMap =  async ()=>{

    // (1) 지도를 표시할 div , 지도의 중심좌표
    var map = new kakao.maps.Map(document.getElementById('map'),
    // 연수구 좌표 넣기!
    { center : new kakao.maps.LatLng(37.41283,126.70004), level : 10  });

    // (2)마커 클러스터러( 여러가 마커가 겹칠때 도형으로 마커수를 표현 ) 를 생성합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // (3) FETCH 이용한 공공데이터 자료 활용
    const serviceKey = "4n%2BzSPF7At0bR63Tzm0UeoDp3kyhESO5NeMzr4erod46S%2B4MsH%2F19WIniGUGtjCXN%2FP6WW88URdCKazOxcXfkg%3D%3D";
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=72&serviceKey=";
    const response = await fetch( URL+serviceKey , { method : "GET"} );
    const data = await response.json(); console.log( data );

    // (4) map 반복문을 이용하여 마커를 하나씩 생성하여 return 한 마커를 markers 변수(배열)에 대입한다.
    let markers = data.data.map( ( value ) => { // forEach 리턴없다 vs map 리턴있다.
        // (5-1) 마커 생성
        let marker = new kakao.maps.Marker({
            position : new kakao.maps.LatLng( value.위도, value.경도 ) // 위도( Latitude ), 경도( Longitude ) 약어
        });
        // (5-2)마커 클릭 이벤트 넣기. //kakao.maps.event.addListener( marker , 'click' , ()=>{})
        kakao.maps.event.addListener( marker , 'click' , ()=>{
            // (*) 내가 클릭한 마커의 약국 정보를 사이드바(특정2. html)에 출력하기
            const sidebar = document.querySelector('#sidebar');
            let html = ` <button type="button" onclick="dataAPI()"> 전체보기 </button>
                                    <div id="school">
                                        <div> 학교명 :  ${ value.학교명 } </div>
                                        <div> 행정실 전화번호 : ${ value.행정실 } </div>
                                        <div> 주소 : ${ value.주소 } </div>
                                    </div>`;
            sidebar.innerHTML = html;
        })
        // (5-3) 마커 리턴
        return marker;
    }); // map end

    // (6) 여러개 마커를 가진 markers 변수를 클러스터에 등록
    clusterer.addMarkers(markers);

    // (7)마커 클러스터러에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {
        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;
        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });

}
kakaMap();