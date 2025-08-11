const write1 = async() => {
    // 입력받은 값을 가져오기
    const phoneInput = document.querySelector('.phone');
    const countInput = document.querySelector('.count');

    const phone = phoneInput.value;
    const count = countInput.value;

    const object = {phone , count};

    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( object )
    }

    const response = await fetch("/waiting/write" , option);
    
    const data = await response.json();

    if(data == true){
        alert('등록이 완료되었습니다.');
        location.href="/waiting/print.jsp"; 
    } 
    else {
        alert('등록이 실패되었습니다.')
    }   // if end
    
}   // func end