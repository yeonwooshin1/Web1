const moneyList = async () => {
    
    const option = { method : "GET" }
    
    const response = await fetch("/money" , option )

    const data = await response.json();
    
    // 쿼리 셀렉터
    const moneyTbody = document.querySelector("#moneyTbody");
    // html 생성 (빈거)
    let html = "";

    // 순회하면서 출력
    for(let i = 0; i < data.length ; i++ ) {
        const moneyList = data[i];
        if(moneyList.grade == 'A') moneyList.grade = "VIP";
        if(moneyList.grade == 'B') moneyList.grade = "일반";
        if(moneyList.grade == 'C') membermoneyListList.grade = "직원";

        html += `<tr>
                    <td> ${ moneyList.customerNo } </td>  
                    <td> ${ moneyList.customerName } </td>
                    <td> ${ moneyList.grade }</td>
                    <td> ${moneyList.sales }</td>
                </tr>`
    }
    // innerHTML 
    moneyTbody.innerHTML = html;
}   // func end

moneyList();