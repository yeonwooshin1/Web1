const edit = async() => {
    const seqInput = document.querySelector('.seq');
    const countInput = document.querySelector('.count');

    const seq = seqInput.value;
    const count = countInput.value;

    const object = { seq , count  }
    // 3. fetch option , get/delete vs post/put
    const option = {
        method : "PUT" ,
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( object )
    } // option end

    const response = await fetch( "/waiting/edit" , option );
    const data = await response.json();

    if( data == true ){
        alert('수정 성공'); 
        location.href="/waiting/print.jsp"; 
    }else{  alert('수정 실패'); }
}