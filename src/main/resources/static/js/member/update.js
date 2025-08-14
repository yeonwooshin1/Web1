console.log("update.js open");


// 기존 정보 가져오기
const getInfo = async () => {
    const mno = document.querySelector(".mno");
    const mid = document.querySelector(".mid");
    const mname = document.querySelector(".mname");
    const mphone = document.querySelector(".mphone");

    try {
        
        const option = { method : "GET" };

        const response = await fetch("/member/info" , option );

        const data = await response.json();

        console.log("데이터 불러오기 " + data);

        mno.innerHTML = data.mno;
        mid.innerHTML = data.mid;
        mname.value = data.mname;
        mphone.value = data.mphone;

    } catch {
        alert("잘못된 접근입니다.");
        location.href = "/member/login.jsp";
    }   // try end
    
}   // func end
getInfo();

// 수정 하기 
const onUpdate = async( ) => {
    const mnameInput = document.querySelector(".mname").value;
    const mphoneInput = document.querySelector(".mphone").value;

    const mname = mnameInput;
    const mphone = mphoneInput;

    const obj = { mname , mphone };
    
    try {

        const option = { 
            method : "PUT",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        
        const response = await fetch( "/member/update" , option );
        
        const data = await response.json();

        if(data) {
            alert("수정이 완료되었습니다.");
            location.href = "/member/info.jsp";
        } else {
            alert("오류가 발생했습니다.")
            return;
        }   // if end
        
    } catch {
        alert("오류가 발생하였습니다. 관리자에게 문의하세요. ")
    }   // try end;;

}   // func end