console.log("list.js open");
// 전체 조회
const boardPrint = async () => {
    
    const option = { method : "GET" }

    const response = await fetch("/board" , option)

    const data = await response.json();

    const listTbody = document.querySelector("#listTbody");

    let html ='';

    for(let i = 0; i < data.length ; i++){
        const list = data[i];
        
        html += `<tr>
                    <td> ${ list.bno } </td>
                    <td> <a href="/board/view.jsp?bno=${list.bno}">${ list.bcontent }</a></td> 
                    <td> ${ list.bwriter }</td>
                </tr>`
    }

    listTbody.innerHTML = html;
}

boardPrint();
