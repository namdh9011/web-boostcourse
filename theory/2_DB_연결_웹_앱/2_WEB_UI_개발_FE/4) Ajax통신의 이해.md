# 4) Ajax통신의 이해

**들어가기 전에**

브라우저의 새로고침 없이 데이터를 얻어오는 방법이 있습니다.

이는 사용자가 더 빠르게 변경된 데이터를 화면의 새로고침 없이 확인할 수 있는 방법으로 더 좋은 UX(User Experience)에 해당하는 방법입니다.

어떻게 구현하는지 알아보겠습니다.





------

**학습 목표**

1. Ajax기술은 왜 나왔고, 어떻게 사용하는지 이해한다.





------

**핵심 개념**

- XMLHTTPRequest
- Ajax





------

**학습하기**

[영상보강] 02:33부분에서 '표준적인 데이터 포맷을 결정하기 위해서 주로 JSON(JavaScript Object Notation) 포맷을 사용' 이라고 표현되어 있는데요, 이부분 표현이 어색해서 오해하실 수 있을것 같네요. 데이터 포맷을 결정하기 위해서라면 JSON이 아니라 'HTTP Header'가 그 역할을 합니다. 물론 JSON 포맷은 Ajax를 위한 대표적인 포맷은 맞습니다. ^^

**1. Ajax (XMLHTTPRequest 통신)**

이 기술은 웹에 데이터를 갱신할 때, 브라우저 새로고침 없이 서버로부터 데이터를 받는 것이 좋겠다는 생각에서 출발했습니다.

더 좋은 UX를 제공할 수 있는 기술입니다.

아래 탭 UI를 살펴봅시다.

상단에 탭을 누를때마다 컨텐츠가 달라집니다.

누르지도 않은 탭의 컨텐츠까지 초기로딩시점에 모두 불러온다면 초기로딩속도에 영향을 줄 것이다.

따라서 동적으로 필요한 시점에 컨텐츠를 받아와서 표현하면 더 좋습니다.

이 경우가 Ajax기술을 활용할 수 있는 대표적인 경우입니다.

![4_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/2_WEB_UI_%EA%B0%9C%EB%B0%9C_FE/image/4_1.png)

- **Ajax통신의 이해**

Ajax 통신으로는 XML, Plain Text, JSON 등 다양한 포맷의 데이터를 주고받을 수 있지만, 일반적으로 사용이 편리한 JSON포맷으로 데이터를 주고 받습니다

JSON이 무엇인지 찾아보고, JSON 포맷으로 데이터를 작성하려면 어떤 규칙이 필요한지 알아보세요.



**2. AJAX 실행코드**

AJAX 실행 코드는 아래와 같습니다.

아래 방법은 XMLHTTPRequest 객체를 사용하는 표준방법입니다.

```javascript
function ajax(data) {
 var oReq = new XMLHttpRequest();
 oReq.addEventListener("load", function() {
   console.log(this.responseText);
 });    
 oReq.open("GET", "http://www.example.org/getData?data=data");//parameter를 붙여서 보낼수있음. 
 oReq.send();
}
```

[링크 바로가기](https://developer.mozilla.org/en/docs/Web/API/XMLHttpRequest/Using_XMLHttpRequest)

XMLHttpRequest객체를 생성해서, open메서드로 요청을 준비하고, send메서드로 서버로 보냅니다. 

요청처리가 완료되면(서버에서 응답이 오면) load이벤트가 발생하고, 콜백함수가 실행됩니다.

콜백함수가 실행될 때는 이미 ajax함수는 반환하고 콜스택에서 사라진 상태입니다. 

이는 setTimeout함수의 콜백함수의 실행과 유사하게 동작하는 '비동기'로직 입니다.



 

------

**생각해보기**

1. Ajax는 비동기로 통신을 합니다. Ajax코드의 다양한 예제를 익혀보도록 해보세요.
2. 특히 post방식으로 데이터를 전송하는 방법도 공부해보면 좋습니다.
3. CORS라는 기술은 무엇인지도 살펴봅니다. 이 기술이 왜 나왔는지 이해하는게 중요합니다.

 

 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180127_165/1517019699902jEdF3_PNG/KbpY9sRXko4jhofcqjov.png?type=mfullfill_199_148)**[참고링크\] Ajax사용 예제**https://developer.mozilla.org](https://developer.mozilla.org/en/docs/Web/API/XMLHttpRequest/Using_XMLHttpRequest)