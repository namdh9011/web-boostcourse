# 3) Browser Event, Event object, Event handler

**들어가기 전에**

어떤 영역을 마우스 클릭하거나, 화면을 스크롤 하거나 하는 작업에 따라서 브라우저는 반응합니다.

이런 것들은 모두 브라우저가 Event기반으로 동작되게 만들어졌기 때문입니다.

다양한 Event를 알아보면서 웹프론트엔드 개발을 이해해봅시다.





------

**학습 목표**

1. Event listener 무엇인지 이해합니다.
2. Event객체를 사용할 수 있습니다.





------

**핵심 개념**

- Event listener
- addEventListener
- event object





------

**학습하기**

**Event**

브라우저에는 많은 이벤트가 발생합니다.

브라우저 화면의 크기를 마우스로 조절할 때도, 스크롤을 할 때도, 마우스로 이동하거나 무언가를 선택할 때도 
이벤트가 발생합니다.

이벤트를 브라우저가 발생시켜주니, 우리는 그때 어떤 일을 하라고 할 일을 등록할 수가 있습니다.

다시 말해, HTML엘리먼트별로 어떤 이벤트(주로 키보드나 마우스 관련)가 발생했을 때 특정 행위를(어떤 일) 하고 싶다면, 대상엘리먼트를 찾고 어떤 일을 등록하면 된다.

그것을 자바스크립트로 구현할 수 있습니다.



**이벤트 등록**

이벤트 등록 표준방법입니다.

addEventListener 함수를 사용할 수 있습니다.

```javascript
var el = document.querySelector(".outside");
el.addEventListener("click", function(){
//do something..
}, false);
```

addEventListener 함수의 두 번째 인자는 함수입니다.

이 함수는 나중에 이벤트가 발생할 때 실행되는 함수로 이벤트핸들러(Event Handler) 또는 이벤트리스너(Event Listener)라고 합니다.

콜백함수는 이벤트가 발생할 때 실행됩니다. 



**이벤트 객체**

브라우저는 이벤트 리스너를 호출할 때, 사용자로부터 어떤 이벤트가 발생했는지에 대한 정보를 담은 이벤트 객체를 생성해서 리스너 함수에 전달합니다.

따라서 이벤트리스너 안에서는 이벤트객체를 활용해서 추가적인 작업을 할 수 있게 됩니다. 

```javascript
var el = document.getElementById("outside");
el.addEventListener("click", function(evt){
 console.log(evt.target);
 console.log(evt.target.nodeName);
}, false);
```

가장 많이 쓰이는 건 event.target입니다.

event.target은 이벤트가 발생한 element를 가리킵니다. 

element도 객체이므로 안에 nodeName이나 classname과 같이 element가 가진 속성을 사용할 수 있습니다.



 

------

**생각해보기**

1. event type에는 어떤 것들이 있나요? 마우스, 키보드 관련 타입 들을 자세히 알아보세요.



 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180126_55/15169568810802QCsn_PNG/KVC6PgEQdxRFFQSksgBT.png?type=mfullfill_199_148)**[참고링크\] 위키피디아 DOM설명**https://en.wikipedia.org](https://en.wikipedia.org/wiki/Document_Object_Model)

[ ![img](https://cphinf.pstatic.net/mooc/20180223_1/1519362082536vpsNN_PNG/VTbYHok1dcs8qffmFWju.png?type=mfullfill_199_148)**[참고링크\] Introduction to events**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Building_blocks/Events#Event_handler_properties)

[ ![img](https://cphinf.pstatic.net/mooc/20180223_213/15193620944651MjCl_PNG/bfePDa1oKjyKZKptcJly.png?type=mfullfill_199_148)**[참고링크\] Event reference**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Web/Events)