console.log("pwdupdate.js open!");

// 비밀번호 수정 하기 
const onPwdUpdate = async( ) => {
    const oldpwdInput = document.querySelector(".oldpwd").value;
    const newpwdInput = document.querySelector(".newpwd").value;

    const oldpwd = oldpwdInput;
    const newpwd = newpwdInput;

    const obj = { oldpwd , newpwd };
    
    try {

        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        
        const response = await fetch( "/member/update/password" , option );
        
        const data = await response.json();

        if(data) {
            alert("비밀번호 수정이 완료되었습니다. 다시 로그인 해주세요.");
            location.href = "/member/login.jsp";
        } else {
            alert("현재 비밀번호가 일치 하지 않습니다.")
            return;
        }   // if end
        
    } catch {
        alert("잘못된 접근입니다.");
        location.href = "/member/login.jsp";
    }   // try end;;
}   // func end