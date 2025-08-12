console.log("update.js open!");


// [1] 수정하기 전 내용물 확인용 => 개별 조회
const waitingUpdateFind = async () => {
    const seq = new URLSearchParams( location.search ).get('seq');

    const response = await fetch(`/waiting/find?seq=${seq}`);

    const data = await response.json();

    const phone = document.querySelector(".phone");
    const count = document.querySelector(".count");

    const phonec = data.phone;
    const countc = data.count;

    phone.value = phonec;
    count.value = countc;

} 
waitingUpdateFind();

const edit1 = async() => {
    const seq = new URLSearchParams( location.search ).get('seq');
    
    const phoneInput = document.querySelector('.phone');
    const countInput = document.querySelector('.count');

    const phone = phoneInput.value;
    const count = countInput.value;

    const object = { seq , phone , count  };

    // 3. fetch option , get/delete vs post/put
    const option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( object )
    } // option end

    const response = await fetch( "/waiting" , option );
    const data = await response.json();

    if( data == true ){
        alert('수정 성공'); 
        location.href=`/waiting/view.jsp?seq=${seq}`; 
    }else{  alert('수정 실패'); }

}