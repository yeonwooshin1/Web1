console.log("update.js open!");


// [1] 수정하기 전 내용물 확인용 => 개별 조회
const boardUpdateFind = async () => {
    const bno = new URLSearchParams( location.search ).get('bno');

    const response = await fetch(`/board/find?bno=${bno}`);

    const data = await response.json();

    const bcontent = document.querySelector(".bcontent");

    const bcon = data.bcontent;

    bcontent.innerHTML = bcon;

} 
boardUpdateFind();


// [2] 개별 수정 
const boardUpdate = async ( ) => { console.log( "boardUpdate exe");
    // 1. 현재 수정할 게시물 번호 가져오기 
    const bno = new URLSearchParams( location.search ).get('bno');
    // 2. 수정할 입력받은 값 가져오기 
    const bcontent = document.querySelector('.bcontent').value;
    // 3. 객체화 
    const obj = { "bno" : bno , "bcontent" : bcontent };
    // 4. fetch 옵션 
    const option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( obj )
    }
    // 5. fetch 실행 
    const response = await fetch( "/board" , option );
    const data = await response.json();
    // 6. fetch 결과
    if( data == true ){
        alert('수정 성공');
        location.href=`/board/view.jsp?bno=${ bno }`
    }else{
        alert('수정 실패');
    }
}