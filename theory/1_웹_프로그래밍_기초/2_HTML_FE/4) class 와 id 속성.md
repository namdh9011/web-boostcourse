# 4) class 와 id 속성

**들어가기 전에**

HTML 속성 중 class와 id란 무엇이며 어떻게 사용할까요?

이번 시간에는 고유한 값인 id와 중복 사용이 가능한 class의 활용 방법에 대해 알아보도록 하겠습니다.

다른 웹 사이트에서 class와 id를 어떻게 사용했는지 확인해보며 이해를 도모하는 것도 좋은 방법입니다.





------

**학습 목표**

1. CLASS와 ID의 목적을 이해하고, 구분해서 작성할 수 있다.





------

**핵심 개념**

- HTML 태그 안에서 사용되는 class속성과 ID속성





------

**학습하기**

- **class와 id속성**

  영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.  [영상보강] 영상 4:38 에 소개된 nav-section 클래스를 가진 section엘리먼트는 유심히 보면, nav만 감싸있는게 아닙니다. nav와 아래 section등도 모두 포함한 wrapper역할을 합니다. 영상에서는 nav-section이라는 이름을 주었지만,전체 영역을 모두 커버하는 class이름이 더 적당할 거 같네요. nav-section 클래스 이름이 적당한 엘리먼트는 그럼 무엇일까요? 네 section 바로 아래있는 nav엘리먼트에 그 클래스 이름을 주는 것이 어울 걸 겁니다.   

**ID**

- 고유한 속성으로 한 HTML 문서에 하나만 사용 가능합니다.
- 고유한 ID 값이 있으면 하나하나에 특별한 제어를 할 수 있으며 검색에도 용이합니다.



**Class**

- 하나의 HTML문서 안에 중복해서 사용 가능합니다.
- 하나의 태그에 여러 개의 다른 class 이름을 공백을 기준으로 나열할 수가 있습니다.
- 홈페이지 전체적인 스타일을 일관성 있게 지정하기 위해서는 class의 사용이 필수적입니다.

이렇게 구분할 수 있지만, 많은 회사마다 개발단계에서 어떠한 약속(convention)을 만들어서 자신들만의 규칙을 사용하기도 합니다.

예를 들어 ID사용을 금하는 곳도 있습니다.

class로만 사용하는 곳도 있습니다.

그건 팀이 결정하기 나름입니다.

하지만 반대의 경우 즉 모든 것을 id만으로 사용하는 것은 없겠죠? 



 

------

**실습코드**

강의에서 진행한 실습 코드입니다.

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
  
  <section id="nav-section">
    <nav><ul>
      <li>Home</li>
      <li>Home</li>
      <li>About</li>
      <li>Map</li>
      </ul>
    </nav>
    
    <section id="roll-section">
      <button></button>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <button></button>
    </section>
    <section>
      <ul>
        <li class="our_diescriptipn">
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
        <li class="our_diescriptipn">
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique accusamus, corporis, dolorum fugiat tenetur porro. Aspernatur commodi, ea suscipit non? Molestiae nulla explicabo debitis provident nostrum dolorem minima reiciendis suscipit?</div>
        </li>
        <li class="our_diescriptipn">
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
      </ul>
    </section>
  </section>
  <footer>
    <span>Copyright @codesquad</span>
  </footer>
</body>
</html>
```

 

 

------

**생각해보기**

1. 좋은 class 이름을 짓는 규칙은 무엇일까요? id를 다른 웹사이트들에서는 어떻게 실제로 사용할까요? 어디에 id속성을 부여했는지 한번 찾아보세요.
2. 요즘에는 data속성이라는 것도 자주 사용합니다. tag에 추가적인 데이터 정보를 표현하기 위함입니다. 이 부분도 같이 살펴보면 좋습니다. 