console.log( 'signup.js open');

// [1] 회원가입
const signup = async() =>{
    // 만약에 유효성검사 체크리스트에 false 가 존재하면 회원가입 진행 불가능.
    if( signPass[0] == false ){ 
        alert('올바른 정보를 입력후 가능합니다.');
        return;
    }

    // 1. 마크업의 DOM객체 가져오기 
    const idInput = document.querySelector('.idInput'); 
    const pwdInput = document.querySelector('.pwdInput'); 
    const nameInput = document.querySelector('.nameInput');
    const phoneInput = document.querySelector('.phoneInput');
    // 2. DOM객체에서 입력받은 값 가져오기
    const mid = idInput.value;          const mpwd = pwdInput.value;
    const mname = nameInput.value;       const mphone = phoneInput.value;
    // 3. 객체화 
    const obj = { mid , mpwd , mname , mphone }; 
    try{ // 4. fetch 실행 
        const option = { method : "POST" , headers : {"Content-Type" : "application/json"} , body : JSON.stringify(obj) }
        const response = await fetch( '/member/signup' , option );
        const data = await response.json();
        // 5. fetch 결과 
        if( data > 0 ){ alert("회원가입 성공"); location.href="/member/login.jsp"; }
        else{ alert('회원가입 실패'); }
    }catch(error) { console.log( error); }
} // func end 

// <마크업> 이벤트 : onClick( 해당 마크업을 클릭했을때 ) , onkeyup( 해당 마크엡에 키를 떼었을때 )

// *** 유효성검사 체크리스트 ***
const signPass = [ false ]; // 초기값은 실패 , 0인덱스:아이디체크 , 1인덱스 : 연락처체크

// [2] 아이디중복검사 : 입력할때마다 발동 
const idcheck = async () =>{
    const mid = document.querySelector('.idInput').value;  // 1.  // 2. 
    const idCheck = document.querySelector('.idCheck');
    // 2. 유효성검사1 길이검사 
    if( mid.length < 6 ){ // 만약에 아이디가 6글자 미만이면  
        idCheck.innerHTML = "아이디는 6글자 이상으로 가능합니다.";
        signPass[0] = false; // 유효성검사 상태 변경
        return; // 함수 강제 종료 함으로써 아래 코드는 실행안됨.
    }
    // 2. 유효성검사2 중복검사 , /member/check?type=검사할속성명&data=${검사할데이터}
    // 3. fetch 실행 
    const option = { method : "GET" }
    const response = await fetch( `/member/check?type=mid&data=${mid}` , option  );
    console.log("test");
    const data = await response.json();
    console.log(data);
    // 4. fetch 결과
    if( data == true ){
        idCheck.innerHTML = "사용중인 아이디 입니다."
        signPass[0] = false; // 유효성검사 상태 변경
    }else{
        idCheck.innerHTML = "사용가능한 아이디 입니다."
        signPass[0] = true; // 유효성검사 상태 변경
    }
}
// [3] 연락처중복검사 : 입력할때마다 발동