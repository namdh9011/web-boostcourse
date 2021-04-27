# 3) CSS Selector

**들어가기 전에**

특정 엘리먼트에 스타일을 적용하기 위해서는 해당 엘리먼트를 잘 찾아야 합니다.

특정 엘리먼트뿐 아니라 여러 개의 엘리먼트일 수도 있습니다.

엘리먼트를 쉽고 빠르게 찾을 수 있는 CSS Selector 문법을 알아보겠습니다.





------

**학습 목표**

1.  기본적인 Selector 문법을 이해한다.





------

**핵심 개념**

- CSS Selector
- id, class, tag selector
- nth-child





------

**학습하기**

**CSS selector**

HTML의 요소를 tag, id, html 태그 속성 등을 통해 쉽게 찾아주는 방법입니다.



**element에 style 지정을 위한 3가지 기본 선택자**

- tag로 지정하기

```css
<style>
     span {
       color : red;
     }
 </style>
```

- id로 지정하기

```css
<style>
     #spantag {
       color : red;
     }
</style>

<body>
     <span id="spantag"> HELLO World! </span>
</body>
```

- class로 지정하기

```css
<style>
     .spanClass {
     color : red
     }
</style>

<body>
     <span class="spanClass"> HELLO World! </span>
</body>
```

 

**CSS Selector의 다양한 활용**

- id, class 요소 선택자와 함께 활용

```css
#myid { color : red }
div.myclassname { color : red }
```

- 그룹 선택 (여러 개 셀렉터에 같은 style을 적용해야 한다면)

```css
h1, span, div { color : red }
h1, span, div#id { color : red }
h1.span, div.classname { color : red }
```

- 요소 선택 (공백) : 자손요소
- 아래 모든 span태그에 red색상이 적용됨

```css
<div id="jisu">
  <div>
    <span> span tag </span>
  </div>
  <span> span tag 2 </span>
</div>
#jisu span { color : red }
```

- 자식 선택 (>) : 자식은 바로 하위엘리먼트를 가리킵니다.
- 아래는 span tag 2만 red 색상이 적용됩니다.

```css
<div id="jisu">
  <div>
    <span> span tag </span>
  </div>
  <span> span tag 2 </span>
</div>
#jisu > span { color : red }
```

- n번째 자식요소를 선택합니다. (nth-child)
- 첫번째 단락에 red 색상이 적용됩니다.

```css
<div id="jisu">
  <h2>단락 선택</h2>
  <p>첫번째 단락입니다</p>
  <p>두번째 단락입니다</p>
  <p>세번째 단락입니다</p>
  <p>네번째 단락입니다</p>
</div>
#jisu > p:nth-child(2) { color : red }
```

 

 

------

**생각해보기**

1.  pseudo-class인 nth-child 와 nth-of-type의 차이점은 무엇일까요? 두 개의 차이점을 꼭 기억하시기 바랍니다.



 

------

**참고 자료** 

[ ![img](https://cphinf.pstatic.net/mooc/20190312_271/1552359911027AmtoD_PNG/IrJ8blUSIoPc2CXd5Hxi.png?type=ffn199_148)**CSS Selectors Cheatsheet**https://gist.github.comCSS Selectors Cheatsheet. GitHub Gist: instantly share code, notes, and snippets.](https://gist.github.com/magicznyleszek/809a69dd05e1d5f12d01)

[ ![img](https://cphinf.pstatic.net/mooc/20180124_182/1516772615660Fa6WL_PNG/KZ6jJhiXNKrHiYyHvYO1.png?type=mfullfill_199_148)**[참고링크\] Specificity**http://developer.mozilla.org](http://developer.mozilla.org/en-US/docs/Web/CSS/Specificity)