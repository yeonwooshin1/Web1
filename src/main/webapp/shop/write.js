const memberWrite = async() => {
    // 입력받은 값을 가져오기
    const customerNameInput = document.querySelector('.customerName');
    const phoneInput = document.querySelector('.phone');
    const addressInput = document.querySelector('.address');
    const joinDateInput = document.querySelector('.joinDate');
    const gradeInput = document.querySelector('.grade');
    const cityInput = document.querySelector('.city');


    const customerName = customerNameInput.value;
    const phone = phoneInput.value;
    const address = addressInput.value;
    const joinDate = joinDateInput.value;
    const grade = gradeInput.value;
    const city = cityInput.value;

    if( customerName == null ) {
        alert("회원성명이 입력되지 않았습니다.");
        return
    }

    if( phone == null ) {
        alert("회원전화가 입력되지 않았습니다.");
        return
    }

    if( address == null ) {
        alert("회원주소가 입력되지 않았습니다.");
        return
    }

    if (joinDate && joinDate.length !== 8) {
        alert("가입일자는 8자리로 입력 혹은 비어있어야 합니다.");
        return;
    }

    if( grade !== "A" && grade !== "B" && grade !== "C" ) {
        alert("회원 등급은 A , B , C 만 입력 가능합니다.");
        return
    }

    if( city == null ) {
        alert("도시코드가 입력되지 않았습니다.");
        return
    }

    const object = { customerName , phone , address  , joinDate , grade , city };

    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( object )
    }

    const response = await fetch("/member", option);
    
    const data = await response.json();

    if(data == true){
        alert('등록이 완료되었습니다.');
        location.href="/member/memberList.jsp"; 
    } 
    else {
        alert('등록이 실패되었습니다.')
    }   // if end
    
}   // func end
