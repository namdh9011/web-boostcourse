# 4) CSS 기본 Style 변경하기

**들어가기 전에**

글자색, 배경색, 글꼴은 어떻게 바꾸는 것일까요?

이번 시간에는 텍스트 속성 및 옵션값을 변경하는 방법에 대해서 배워보도록 하겠습니다.



 

------

**학습 목표**

1. CSS 없이 먼저 HTML구조를 설계할 수 있다.



 

------

**핵심 개념**

- font-size
- background-color
- font-family





------

**학습하기**

 CSS style 적용은 글자색, 배경색 등이 가장 자주 사용되는 것들입니다.

이런 속성은 위치 값과 크기를 지정하는 것과 달리, 색상 위주로 값을 부여합니다.

색상 관련 값은 다양한 색을 일관된 방법으로 표현하기 위해 주로 16진수 표기법을 사용합니다.

 

**font 색상 변경**

- color : red;
- color : rgba(255, 0, 0, 0.5);
- color : #ff0000;  //16진수 표기법으로 가장 많이 사용되는 방법이죠.

 

**font 사이즈 변경**

- font-size : 16px;
- font-size : 1em;

 

**배경색** 

- background-color : #ff0;
- background-image, position, repeat 등의 속성이 있습니다.
- background : #0000ff url(“.../gif”) no-repeat center top; //한 줄로 정의도 가능

 

**글씨체/글꼴**

- font-family:"Gulim";
- font-family : monospace;



 

------

**실습 코드**

강의에서 진행한 실습용 코드입니다.

여러분들도 비슷한 방식으로 한번 따라 해보면 좋겠습니다.

```css
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
  <style>
    body > div {
      font-size:16px;
      background-color: #ff0;
      font-family:"Gulim";
    }
    
    .myspan {
      color : #f00;
      font-size:2em;
    }
  </style>
</head>
<body>
  <div>
    <span class="myspan">my text is upper!</span>
  </div>
</body>
</html>
```

 

**웹 폰트**

웹폰트는 브라우저에서 기본으로 지원하지 않는 폰트를 웹으로부터 다운로드 받아 사용할 수 있는 방법입니다.

다양하고 예쁜 폰트들을 웹폰트로 사용할 수 있긴 하지만 다운로드를 받아야 한다는 단점이 있습니다.

다운로드 시간이 오래 걸리게 되면 화면에 노출되는 시간이 느려져 오히려 사용자에게 불편함을 느끼게 할 수 있는 것 입니다.

또한 다양한 해상도에서 깨지는 문제도 발생할 수 있습니다.

웹폰트는 수많은 종류가 있습니다.

대표적으로 구글 웹폰트가 있으며 최근에는 다양한 크기에서 품질을 유지하는 벡터 방식의 아이콘 웹폰트도 등장했습니다.

(unicode영역 중 Private Use Area (PUA) 영역을 활용해서 제작)

또한 웹폰트 방식말고, 기본 unicode를 사용해서 간단한 아이콘을 표현하는 것도 가능합니다.

아래 unicode를 사용한 HTML 코드를 참고하세요.

```css
 <div> 안녕하세요 &#x263a;</div> //☺  웹 화면에는 웃음 표시가 표현되는 코드입니다.
```

 

 

------

**참고 자료**

[**[참고링크\] bootstrap**http://getbootstrap.com](http://getbootstrap.com/components/)