# 2) DOM과 querySelector

**들어가기 전에**

우리가 댓글을 입력할 때 댓글이 바로 화면에 추가되는 걸 볼 수 있죠?

이외에도 받은 이메일함의 개수가 증가하기도 하고요.

이렇게 HTML 내의 구조와 데이터는 변경됩니다.

자바스크립트로 이를 변경시킬 수도 있는데요. 어떻게 할 수 있을까요? 

DOM을 이해하면 됩니다.





------

**학습 목표**

1. DOM(Document Object Model)을 이해한다.





------

**핵심 개념**

- DOM Tree
- DOM API
- querySelector





------

**학습하기**

**1. DOM**

브라우저에서는 HTML코드를 DOM(Document Object Model)이라는 객체형태의 모델로 저장합니다. 

그렇게 저장된 정보를 DOM Tree라고 합니다.

결국 HTML element는 Tree 형태로 저장됩니다.

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/2_WEB_UI_%EA%B0%9C%EB%B0%9C_FE/image/2-1.png)

- **Dom tree**

복잡한 DOM Tree를 탐색하기 위해 JavaScript로 탐색알고리즘을 구현하면 너무 힘듭니다.

그래서 브라우저에서는 DOM(document object model)이라는 개념을 통해서, 다양한 DOM API(함수 묶음정도)를 제공하고 있습니다.

브라우저는 DOM Tree찾고 조작하는 걸 쉽게 도와주는 여러 가지 메서드를(DOM API)를 제공합니다.



**2. getElementById()**

ID 정보를 통해서 찾을 수 있습니다.

MDN사이트를 참고해서 이를 테스트해봅시다.

테스트를 할 때는 특정 웹사이트에 접속한 후, 크롬 개발자도구-콘솔을 열어서 그곳에서 코딩을 해보면서 찾을 수 있습니다. 



**3 Element.querySelector()**

DOM을 찾는데 특히 유용한 querySelector 메서드입니다.

CSS 스타일을 결정할 때 사용하던, Selector 문법을 활용해 DOM에 접근할 수 있습니다.

DOM을 찾을 때 querySelector만 써도 충분하고 빠릅니다.

참고로, 비슷하지만 다른 querySelectorAll이 있습니다. 

이 녀석은 어떤 역할을 하는지, 그 반환 값은 무엇인지 확인해보세요.

특정 웹사이트에 접속한 후, 크롬 개발자도구를 열어 콘솔 창에서 querySelectorAll을 활용해서 다양한 UI 영역을 찾아보세요.



**4. css selector**

selector문법은 querySelector와 querySelectorAll메서드에서 사용할 수 있으며, css 스타일을 부여했을 때 익혔던 selector문법과 동일하다고 생각하고 사용할 수가 있습니다.

다양한 css selector문법을 사용해서 원하는 엘리먼트를 찾을 수 있습니다.





------

**생각해보기**

1. 이번 기회에 다양한 CSS Selector 문법들을 좀 더 찾아보세요! 잘 쓸수록 막강합니다.
2. 여러분들이 즐겨 찾는 웹사이트에 접속해서 특정 UI 영역을 querySelector로 찾아보세요.
3. DOM 에서 훨씬 더 많은 함수가 존재합니다. DOM을 추가하고 삭제하고, 그리고 DOM을 탐색할 수 있는(위아래로 이동) 속성들도 있습니다. 궁금한 분들이 미리 찾아보세요.



 

------

**참고 자료** 

[ ![img](https://cphinf.pstatic.net/mooc/20180126_259/15169545123301ghAu_PNG/vH8TArEvv70ofzBznl1g.png?type=mfullfill_199_148)**[참고링크\] 위키피디아 DOM설명**https://en.wikipedia.org](https://en.wikipedia.org/wiki/Document_Object_Model)