console.log("view.js open!");

// [1] 개별조회
const waitingFind = async () => {
    
        // 1. 주소상(URL) 경로상 쿼리스트링 가져오기
    // + 클릭한 bno 가져오기
        // (1) 경로상의 웹주소 가져오기
    const url = new URLSearchParams( location.search );
        // (2) 웹주소에서 쿼리스트링 값 가져오기
    const seq = url.get('seq');


    // 2. 클릭한 bno를 fetch로 통신하기 
    const response = await fetch(`/waiting/find?seq=${seq}`);

    const data = await response.json();

    // 3. 어디에 
    const seqBox = document.querySelector(".seqBox");
    const phoneBox = document.querySelector(".phoneBox");
    const countBox = document.querySelector(".countBox");
    const dateBox = document.querySelector(".dateBox");
    // 4. 무엇을
    const phone = data.phone;
    const count = data.count;
    const date = data.date;
    
    // 5. 출력
    seqBox.innerHTML = seq;
    phoneBox.innerHTML = phone;
    countBox.innerHTML = count;
    dateBox.innerHTML = date;
    
    
}
waitingFind();

// [2] 삭제
const waitingDelete = async () => { console.log("delete");
    // 1. 현재 삭제할 게시물 번호 주소에서 가져오기
    const url = new URLSearchParams(location.search);
    const seq = url.get('seq');
    // 2. 확인
    let check = confirm("정말 삭제하세요??");
    if(check) {
        // 3. fetch
        const option = { method : "DELETE" }

        const response = await fetch(`/waiting?seq=${seq}` , option);
        
        const data = await response.json();
        
        // 4. 유효성 검사
        if( data == true ){
        alert(" 삭제 성공! ");
        location.href = "/waiting/list.jsp";
        } else { alert(" 삭제 실패 : 관리자에게 문의하세요! "); }
    }
}   // func end

// [3] 수정 페이지로 이동
const waitingUpdateView = () => {
    // 현재 수정할 게시물 번호 가져오기
    const seq = new URLSearchParams(location.search).get('seq');
    // 수정 페이지에게 bno 전달하기
    location.href = `/waiting/update.jsp?seq=${seq}`;
}
