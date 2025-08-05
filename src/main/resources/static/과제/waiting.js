// 확인용 콘솔
console.log("확인");

// 함수
// 글 등록
const waitingWrite = () => {
    console.log("waitingWrite.exe");
    let data = { "phone" : "010-1234-1234" , "count" : "2" }
    let option = {
        method : "POST" ,
        headers : {"Content-Type" : "application/json"} ,
        body : JSON.stringify(data)   // body
    }
    fetch("/waiting" , option).then( rs => rs.json() ).then( data => { console.log(data) } ).catch( error => { console.log(error) } )
}
// 글 보기
const waitingPrint = () => {
    console.log("waitingPrint.exe");
    let option = {
        method : "GET"
    }
    fetch("/waiting" , option).then( rs => rs.json() ).then( data => { console.log(data) } ).catch( error => { console.log(error) } )
}

// 글 삭제
const waitingDelete = () => {
    console.log("waitingDelete.exe");
    let seq = 2;
    let option = {
        method : "DELETE"
    }
    fetch(`/waiting?seq=${seq}` , option).then( rs => rs.json() ).then( data => { console.log(data) } ).catch( error => { console.log(error) } )
}

// 글 수정
const waitingUpdate = () => {
    console.log("waitingUpdate.exe");
    data = { "seq" : "3" , "count" : "3" }
    option = {
        method : "PUT" ,
        headers : {"Content-Type" : "application/json"} ,
        body : JSON.stringify(data)   // body
    }
    fetch("/waiting" , option).then( rs => rs.json() ).then( data => { console.log(data) } ).catch( error => { console.log(error) } )
}
