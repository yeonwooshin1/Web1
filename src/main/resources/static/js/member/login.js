const login = async() => {
    const idInput = document.querySelector("#idInput");
    const pwdInput = document.querySelector("#pwdInput");

    const mid = idInput.value;
    const mpwd = pwdInput.value;
    
    const obj = { mid , mpwd };
    
    try{
        console.log(obj);
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/login" , option );
        const data = await response.json();
        
        console.log(data);
        if (data == 0) {
            alert("로그인 실패");
            return;
        } else if( data > 0 ) {
            alert("로그인 성공");
            location.href = "/index.jsp";
        }

    }catch{}
}