# 6) float 기반 샘플 화면 레이아웃 구성

**들어가기 전에**

웹페이지의 레이아웃을 float 속성을 중심으로 어떻게 만드는지 실제 코드구현 과정을 이해합니다.



 

------

**학습 목표**

1. float로 웹사이트의 레이아웃을 구성할 수 있습니다.



 

------

**핵심 개념**

- float
- layout



 

------

**학습하기**

기본배치를 한 이후에 필요한 부분을 float를 사용해서 좌/우로 배치하는 것이 일반적입니다.

비율조정은 %를 사용해서 배치할 수도 있습니다.

 

 

------

**실습코드**

html 

```html
<header>부스트코스는 정말 유익합니다.</header>
<div id="wrap">
   <nav class="left">
      <ul>
         <li>menu</li>
         <li>home</li>
         <li>name</li>
      </ul>
   </nav>
   <div class="right">
      <h2>
         <span>반가워요!</span>
         <div class="emoticon">:-)</div>
      </h2>
   <ul>
      <li>crong</li>
      <li>jk</li>
      <li>honux</li>
      <li>pobi</li>
   </ul>
   </div>
   <div class="realright">
      oh~ right
   </div>
</div>
<footer>코드스쿼드(주)</footer>
```

css

```css
li {
   list-style:none;
}

header {
   background-color : #eee;
}

#wrap {
   overflow:auto;
   margin:20px 0px;
}

.left, .right, .realright {
   float:left;
   height: 200px;
}

.left {
   width:17%;
   margin-right:3%;
   background-color : #47c;
}

.right {
   width : 60%;
   text-align:center;
   background-color : #47c;
}

.realright {
   width: 17%;
   margin-left:3%;
   background-color : #67c;
}

.right > h2 {
   position:relative;
}

.right .emoticon {
   position:absolute;
   top:0px;
   right:5%;
   color:#fff;
}

footer {
   background-color : #eee;
   clear:left;
}
```

 

 

------

**생각해보기**

1. 레이아웃을 배치하는데 flex라는 속성도 있습니다. flex 속성은 많은 기능을 제공하지만, 간단히 좌/우로 배치하는 방식이 어떻게 구현하는지 찾아봅니다.
2. float와의 차이점을 느껴보세요.