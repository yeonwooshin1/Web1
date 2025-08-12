const memberList = async () => {
    
    const option = { method : "GET" }
    
    const response = await fetch("/member" , option )

    const data = await response.json();
    
    // 쿼리 셀렉터
    const memberTbody = document.querySelector("#memberTbody");
    // html 생성 (빈거)
    let html = "";

    // 순회하면서 출력
    for(let i = 0; i < data.length ; i++ ) {
        const memberList = data[i];
        if(memberList.grade == 'A') memberList.grade = "VIP";
        if(memberList.grade == 'B') memberList.grade = "일반";
        if(memberList.grade == 'C') memberList.grade = "직원";

        html += `<tr>
                    <td> <a href="/shop/find.jsp?customerNo=${memberList.customerNo}">${ memberList.customerNo } </td>  
                    <td> ${ memberList.customerName } </td>
                    <td> ${ memberList.phone }</td>
                    <td> ${memberList.address }</td>
                    <td> ${memberList.joinDate }</td>
                    <td> ${memberList.grade }</td>
                    <td> ${memberList.city }</td>
                </tr>`
    }
    // innerHTML 
    memberTbody.innerHTML = html;
}   // func end

memberList();
