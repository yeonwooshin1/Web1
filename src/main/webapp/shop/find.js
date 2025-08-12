// [1] 수정하기 전 내용물 확인용 => 개별 조회
const memberUpdateFind = async () => {
    console.log("hi");
    const customerNo = new URLSearchParams( location.search ).get('customerNo');

    const response = await fetch(`/member/find?customerNo=${customerNo}`);

    console.log(response);

    const data = await response.json();

    document.querySelector('.customerNo').value = customerNo;
    const customerName = document.querySelector('.customerName');
    const phone = document.querySelector('.phone');
    const address = document.querySelector('.address');
    const joinDate = document.querySelector('.joinDate');
    const grade = document.querySelector('.grade');
    const city = document.querySelector('.city');

    const customerNameValue = data.customerName;
    const phoneValue = data.phone;
    const addressValue = data.address;
    const joinDateValue = data.joinDate;
    const gradeValue = data.grade;
    const cityValue = data.city;

    customerName.value = customerNameValue;
    phone.value = phoneValue;
    address.value = addressValue;
    joinDate.value = joinDateValue.replaceAll('-', '');
    grade.value = gradeValue;
    city.value = cityValue;
} 
memberUpdateFind();

const memberUpdate = async() => {
    
    const customerNo = new URLSearchParams( location.search ).get('customerNo');
    
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
    
    if( customerName.trim() === '' ) {
        alert("회원성명이 입력되지 않았습니다.");
        return;
    }

    if( phone.trim() == '' ) {
        alert("회원전화가 입력되지 않았습니다.");
        return;
    }

    if( address.trim() == '' ) {
        alert("회원주소가 입력되지 않았습니다.");
        return;
    }

    if (joinDate.trim() == '' && joinDate.length !== 8) {
        alert("가입일자는 8자리로 입력 혹은 비어있어야 합니다.");
        return;
    }

    if( grade !== "A" && grade !== "B" && grade !== "C" ) {
        alert("회원 등급은 A , B , C 만 입력 가능합니다.");
        return;
    }

    if( city.trim() == '' ) {
        alert("도시코드가 입력되지 않았습니다.");
        return;
    }

    const object = { customerNo, customerName , phone , address  , joinDate , grade , city };

    const option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( object )
    }

    const response = await fetch( "/member" , option );
    
    const data = await response.json();

    if(data == true){
        alert('수정이 완료되었습니다.');
        location.href="/shop/memberList.jsp"; 
    } 
    else {
        alert('수정이 실패되었습니다.')
    }   // if end
}