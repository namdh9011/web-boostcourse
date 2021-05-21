// window.setTimeout()
// setTimeout() //window는 전역객체라서 생략 가능하다.

function runsetTimeout(){
    console.log("Run Start");
    setTimeout(function(){
        var msg = "Hello World!"
        console.log(msg);   //이 메시지는 즉시 실행되지 않습니다.
    }, 1000);               //여기에 지정해준 시간만큼 지난 후 동작
    console.log("Run End");
}

function runsetInterval(){
    console.log("Run Start");
    setInterval(function(){
        var msg = "Hello World!"
        console.log(msg);
    }, 1000);               //여기에 지정해준 시간 간격으로 계속 동작
    console.log("Run End");
}

console.log("Start");
runsetTimeout();
runsetInterval();
console.log("End")



//실행 결과 생각
//time out 시간을 0으로 했을때도 생각.
//ctrl+alt+m 실행 중지