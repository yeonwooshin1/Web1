// *
console.log( "print.js open")

const print = async () => {
    const option = { method : "GET" }
    
    const response = await fetch("/waiting/print" , option )

    const data = await response.json();
    
    // 쿼리 셀렉터
    const waitingTbody = document.querySelector("#waitingTbody");
    // html 생성 (빈거)
    let html = "";

    // 순회하면서 출력
    for(let i = 0; i < data.length ; i++ ) {
        const waitingList = data[i];

        html += `<tr>
                    <td> ${ waitingList.seq } </td>  <td> ${ waitingList.phone } </td>
                    <td> ${ waitingList.count } 명</td> 
                    <td> 
                    <button class ="del" onclick="del(${waitingList.seq})"> 삭제 </button> 
                    </td>
                </tr>`
    }
    // innerHTML 
    waitingTbody.innerHTML = html;
}   // func end

print();

const del = async(seq) => {
    
    const option = { method : "DELETE" }

    const response = await fetch(`/waiting/delete?seq=${seq}` , option )

    const data = await response.json();

    if( data == true ){
        alert('삭제 성공');
    }else{  alert('삭제 실패'); }
    print();
}   // func end