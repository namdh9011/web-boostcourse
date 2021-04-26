# 5) browser에서의 웹 개발-2

**들어가기 전에**

웹 클라이언트 코드는 브라우저 안에서 동작합니다.

HTML, CSS, JavaScript의 실제 소스코드를 보면서 웹페이지 소스의 구성을 살펴봅니다.



 

------

**학습 목표**

1. HTML 요청 이후 브라우저에서 해석되는 웹페이지(HTML) 안의 내용구성과 소스코드를 어떻게 위치시키면
   될지 이해한다.



 

------

**핵심 개념**

- Browser 안에서 동작할 수 있는 HTML, CSS, JavaScript의 코드구현 방법



 

------

**학습하기**

html 실습 웹 : jsbin.com

```markup
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>저를소개해요</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/start.js"></script>
  </head>
  <body>
    <h1>안녕하세요</h1>
    <div>코드스쿼드 크롱이라고 합니다</div>
    <script src="js/library.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>
```

HTML 문서 안에 HTML태그뿐 아니라 CSS, JavaScript코드가 존재합니다.

JavaScript 코드는 body 태그 닫히기 전에 위치하는 것이 렌더링을 방해하지 않아도 좋고, css코드는 head 안에 위치해서 렌더링 처리 시에 브라우저가 더 빨리 참고할 수 있게 하는 것이 좋습니다.



 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20171231_271/1514698444546EHyHU_PNG/369hrBAR4K6I8IgPu6lz.png?type=mfullfill_199_148)**[참고링크\] 웹에서 html, css, javascript를 쉽게 테스트 할 수 있는 웹사이트**http://www.jsbin.com](http://www.jsbin.com/)



 

 

------

 

 

[ ![img](https://cphinf.pstatic.net/mooc/20191203_189/15753047660972UJKv_PNG/1lnd17zL10O8p6HaaG82.png?type=ffn199_148)**<강좌 추천> 예비 개발자의 좋은 시작, [부스트코스 : 웹 UI 개발\]**https://www.edwith.org부스트코스는 NAVER 계열사 등과 함께 만들어가는 현장 중심 온라인 교육 프로그램입니다.
현업 전문가들이 고민하여 만들고 1:1 코드리뷰도 받을 수 있는 부스트코스에서 기업이 원하는 유능한 개발자로 boost하세요!](https://www.edwith.org/boostcourse-ui)