console.log("write.js open");

const boardWrite = async() => {

    const bcontent = document.querySelector(".bcontent").value;
    const bwriter = document.querySelector(".bwriter").value;

    // 입력받은 데이터를 객체화한다.
    const object = { "bcontent" : bcontent , "bwriter" : bwriter };

    // fetch 옵션
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } ,
        body : JSON.stringify(object)
    }

    // fetch 실행
    const response = await fetch("/board" , option );

    // 응답자료 타입변환
    const data = await response.json();

    if(data == true){
        alert("글쓰기 성공!");
        location.href = "/board/list.jsp"   // 페이지 이동
    } else {
        alert("글쓰기 실패!");
    }
    
}