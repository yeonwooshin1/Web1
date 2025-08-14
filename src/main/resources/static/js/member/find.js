console.log("find.jsp");

const idFind = async() => {
    const mnameInput = document.querySelector(".mname").value;
    const mphoneInput = document.querySelector(".mphone1").value;
    const resultFind = document.querySelector("#resultFind");

    const mname = mnameInput;
    const mphone = mphoneInput;
    
    const obj = { mname , mphone };
    try {
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }

        const response = await fetch("/member/find" , option );

        const data = await response.json();

        if(data.mid == "") {
            alert("입력하신 정보가 일치하지 않습니다.");
            return;
        } 
        const result = "회원님의 아이디는 : " + data.mid +" 입니다."

        resultFind.innerHTML = result;

    } catch {
        alert("잘못된 접근입니다.");
        return;
    }   // try end

}

const pwdFind = async() => {
    const midInput = document.querySelector(".mid");
    const mphoneInput = document.querySelector(".mphone2");
    const resultFind = document.querySelector("#resultFind");

    const mid = midInput.value;
    const mphone = mphoneInput.value;

    const obj = { mid , mphone };
    try {
        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }

        const response = await fetch("/member/find" , option );

        const data = await response.json();

        if(data.status == "bad") {
            alert("입력하신 정보가 일치하지 않습니다.");
            return;
        } 
        const result = "임시 비밀번호는 : " + data.status + " 입니다. 로그인 새로운 비밀번호로 변경하세요."
        resultFind.innerHTML = result ;

    } catch {
        alert("잘못된 접근입니다.");
       return;
    }   // try end
}