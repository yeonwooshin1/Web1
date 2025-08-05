// 1. console.log 연동 확인
console.log("확인용");

// 2. 함수 연동 확인
const boardWrite = () => {
    console.log("boardWrite.exe");
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data = { "bcontent" : "JS테스트중" , "bwriter" : "유재석" };
    //  (2) fetch 옵션 : 3자기 (method , header, body)
    let option = {
        method : "POST" ,
        headers : {"Content-Type" : "application/json"} ,
        body : JSON.stringify(data)   // body
    }
    // 3 fetch
    fetch( "/board" , option ).then( rs => rs.json() ).then( data => { console.log(data) } ).catch( error => { console.log(error) } )
}
const boardPrint = () => {
    console.log("boardPrint.exe");
    let option = {
        method : "GET"
    }
    fetch("/board" , option).then(rs => rs.json()).then(data => { console.log(data) } ).catch(error => {console.log(error)} )
}

const boardDelete = () => {
    console.log("boardDelete.exe");
    let bno = 3;
    let option = {
        method : "DELETE"
    }
    fetch(`/board?bno=${bno}` , option).then(rs => rs.json()).then(data => { console.log(data)}).catch(error => {console.log(error)})
}

const boardUpdate = () => {
    console.log("boardUpdate.exe");
    let data = { "bcontent" : "수정테스트" , "bno" : "5" }
    let option = {
        method : "PUT" ,
        headers : {"Content-Type" : "application/json"} ,
        body : JSON.stringify(data)   // body
    }
    fetch("/board" , option).then(rs => rs.json()).then(data => { console.log(data)}).catch(error => {console.log(error)})
}