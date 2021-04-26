# 3) HTML 구조설계

**들어가기 전에**

웹페이지를 만드는 것은 문서의 구조를 잡는 것과 같습니다.

제목, 단락 등이 있는 것과 같습니다.

그런 관점으로 웹사이트의 문서구조를 만드는 것이 가장 먼저 할 일 입니다.



 

------

**학습 목표**

1. CSS 없이 먼저 HTML구조를 설계할 수 있습니다.



 

------

**핵심 개념**

- HTML구조화 설계



 

------

**학습하기**

**HTML 구조설계**

구조화 설계는 마치 문서를 쓴다고 생각하면 쉽습니다.

현업에서는 Presentation 문서형태의 기획서나 디자인 파일을 받아서 그것을 기반으로 HTML개발을 시작합니다.

즉 어떠한 화면을 보면서 그대로 구현하는 것이죠. 

그 화면을 보면서 구조를 분석해야 합니다. 

먼저 영역을 나눠서 상단/본문/네비게이션 이런 식으로 큰 부분부터 분리합니다.

그 뒤에 각 영역 안에 내용의 구조를 잡는 것이 일반적입니다.

각 영역 안의 내용 역시 여러 가지 형태일 겁니다.

목록을 나타내거나, 이미지를 나타내거나, 문단을 나타낼 수 있습니다.

이때마다 적절한 태그를 쓰면 됩니다.

그러면서 영역 안에 또 다른 영역이 있다면 점점 안으로 좁혀가면서 HTML tag를 사용하면서 완성해나가는 겁니다.

이때 CSS코드를 같이 구현하지 않고 HTML로 먼저 문서의 구조를 잡아나가는 것이 개발 단계에서 유리합니다.

그래야 전체 뼈대가 튼튼하게 되는 것이죠.



 

------

**실습코드**

강의에서 진행한 실습용 코드입니다.

여러분들도 비슷한 방식으로 한번 따라 해보면 좋겠습니다.

```markup
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <header>
  <h1>Company Name</h1>
  <img src="..." alt="logo">
  </header>
  
  <div>  <!-- section태그를 사용했었지만, 별 의미없는 container에는 section태그가 적절하지 않아서 수정합니다 -->
    <nav><ul>
      <li>Home</li>
      <li>Home</li>
      <li>About</li>
      <li>Map</li>
      </ul></nav>
    
    <div>  
      <button></button>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <button></button>
    </div>
    <div>
      <ul>
        <li>
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
        <li>
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique accusamus, corporis, dolorum fugiat tenetur porro. Aspernatur commodi, ea suscipit non? Molestiae nulla explicabo debitis provident nostrum dolorem minima reiciendis suscipit?</div>
        </li>
        <li>
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
      </ul>
    </div>
  </div>
  <footer>
    <span>Copyright @codesquad</span>
  </footer>
</body>
</html>
```

\# 덧붙임.

\- 예제의 lorem... 은 별의미없는 글자들을 채우기 위해서 보통 사용하는 문장입니다.

 

------

**생각해보기**

1. 여러분들이 자주 사용하는 웹사이트의 일부 영역의 HTML 코드를 한번 살펴보세요.
2. 다 보는 것보다 상단영역이나 하단영역 위주로 살펴보면서 어떤 HTML 코드를 사용했는지 살펴보면 좋습니다.
3. 그리고 여러분만의 하단영역(footer)을 정의해보고 HTML 코드를 한번 만들어보세요. 