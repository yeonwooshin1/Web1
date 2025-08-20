// * JS 실행 확인 
console.log( "header.js open");

// [1] 내정보 요청해서 헤더 메뉴 나누기.
const myinfo = async() =>{  console.log("myinfo func")
    const logMenu = document.querySelector('#log-menu'); // (1) 어디에
    let html ='' // (2) 무엇을
    try{
        // 1. fetch 실행 
        const option = { method : "GET"}
        const response = await fetch( "/member/info" , option );
        const data = await response.json(); console.log( data );

        // 포인트 요청
        const pointRes = await fetch("/point/total");
        const totalPoint = await pointRes.json();

        // 2. 로그인 했을때 정상 통신 fetch
        // toLocaleString => 표시 1,000 이렇게 해줌
        html += ` <li> <span> ${ data.mid } 님  (현재 포인트: <strong>${totalPoint.toLocaleString()} 점</strong>) </span> </li>
            <li> <a href="/member/info.jsp"> 내정보 </a> </li>
            <li> <a href="#" onclick="logout()"> 로그아웃 </a> </li>`;

    }catch{
        // 2. [비로그인중]로그인 안했을때 비정상 통신 fetch 
        html += `<li> <a href="/member/login.jsp"> 로그인 </a></li>
               <li> <a href="/member/signup.jsp"> 회원가입 </a></li>`
    }
    logMenu.innerHTML = html; // (3) 출력
} // func end 
myinfo(); // header.jsp 열릴때마다 1번 최초 실행 


// [2] 로그아웃. 
const logout = async() =>{
    try{
        // 1. fetch 실행 
        const option = { method : "GET"}
        const response = await fetch( "/member/logout" , option );
        const data = await response.json();
        // 2. fetch 통신 결과
        if( data == true ){
            alert('로그아웃 했습니다');
            // 로그아웃 성공시 메인페이지로 이동
            location.href="/index.jsp";
        }else{
            alert('비정상 요청 및 관리자에게문의');
        }
    } catch{}
}   // func end