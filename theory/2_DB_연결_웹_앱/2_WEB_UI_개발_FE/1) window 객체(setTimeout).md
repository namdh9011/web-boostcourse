# 1) window 객체(setTimeout)

**들어가기 전에**

전역객체(window)에 속한 메서드에는 경고창을 띄워주는 alert 그리고 setTimeout이라는 메서드등이 있습니다.

이를 어떻게 사용하는지 그리고 다른 함수와 조금 다르게 동작하는 setTimeout의 특성을 이해해봅니다.



 

------

**학습 목표**

1. setTimeout을 필요한 곳에 사용할 수 있다.
2. 비동기가 무엇인지 기본개념을 이해한다.



 

------

**핵심 개념**

- setTimeout과 비동기



 

------

**학습하기**

 [영상보강] 1:46 콜백함수는 callback 함수라고 합니다. 보통은 즉시 실행되지 않고, 나중에 필요한 시점에 실행되거나, 실행이 안 될 수도 있습니다. callback의 의미를 단어에서 좀 더 유추해보면 호출한 (call) 대상에서 되부름 (call back)되기 때문에 callback이라고 합니다. 실제로 callback 함수를 전달받은 쪽의 필요에 따라 즉시 실행될 수도 있답니다. ( ex> array.map(callback) ) 

**window 객체**

브라우저 개발을 하다 보면, window라는 객체가 있습니다.

window에는 많은 메서드들이 존재하며, 아래처럼 사용할 수 있습니다.

window는 디폴트의 개념이므로 생략할 수 있습니다.

```javascript
window.setTimeout()
setTimeout() //window는 전역객체라서 생략 가능하다.
```



**setTimeout 활용**

setTimeout은 낯설게 동작합니다.

인자로 함수를 받고 있으며, 보통 나중에 실행되는 함수를 콜백함수라고도 합니다.

자바스크립트는 함수를 인자로 받을 수 있는 특징이 있습니다.

참고로 함수를 반환할 수도 있고요.

```javascript
function run() {
    setTimeout(function() {
        var msg = "hello codesquad";
        console.log(msg);  //이 메시지는 즉시 실행되지 않습니다.
    }, 1000);
}

run();
```

setTimeout의 특성을 잘 이해하고, 지연실행이 필요한 경우에 잘 활용하면 좋습니다.

**setTimeout 실행 순서**

setTimeout의 실행은 비동기(asynchronous)로 실행되어 동기적인 다른 실행이 끝나야 실행됩니다.

```javascript
function run() {
    console.log("start");
    setTimeout(function() {
        var msg = "hello codesquad";
        console.log(msg);  //이 메시지는 즉시 실행되지 않습니다.
    }, 1000);
    console.log("end");
}

run();
```

즉 setTimeout 안의 함수(콜백함수)는 run함수의 실행이 끝나고 나서, (정확히는 stack에 쌓여있는 함수의 실행이 끝나고 나서 실행됨) 실행됩니다.

디버거를 통해서 이를 스스로 직접 확인하는 것이 학습이 도움이 됩니다. 





------

**생각해보기**

1. 자바스크립트 비동기 예제를 좀 더 찾아보세요. setTimeout 말고도 비슷하게 동작하는 것들이 무엇이 있는지 알아보세요.
2. setInterval이라는 메서드도 있습니다. 비슷한 동작인데 사용방법을 익혀두면 좋아요.