console.log("info.js open!!!  ");

const getInfo = async() => {
    const memberTbody = document.querySelector("#memberTbody");

    let html = '';
    try {
        const option = { method : "GET" };

        const response = await fetch("/member/info" , option );

        const data = await response.json();
        console.log(data);
        html += `<tr>
                    <th>${data.mno} </th> <th>${data.mid} </th> <th>${data.mname} </th> 
                    <th>${data.mphone} </th> <th>${data.mdate} </th> 
                </tr>`;
        
        memberTbody.innerHTML = html;
    } catch {
        alert("잘못된 접근입니다.");
        location.href = "/member/login.jsp";
    }   // try end
}   // func end
getInfo();

// 회원 탈퇴
// alert : 알림창 , prompt : 입력상자 알림창 , confirm : 확인/취소 알림창
const onDelete = async() => {
    try {
        if(!confirm("정말 탈퇴하시겠습니까?")) { return; }
        
        
        let oldpwd = prompt("현재 회원 비밀번호를 입력해주세요.");
        
        const option = { method : "DELETE" };

        const response = await fetch( `/member/delete?oldpwd=${oldpwd}` , option );

        const data = await response.json();

        if (!data) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        } else {
            alert("회원탈퇴 되었습니다.");
            location.href = "/index.jsp";
        }
    } catch {
        alert("오류입니다. 관리자에게 문의하세요.")
    }   // try end
    
}   // func end

