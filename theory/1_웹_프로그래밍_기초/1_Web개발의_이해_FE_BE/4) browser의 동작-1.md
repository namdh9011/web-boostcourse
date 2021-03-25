# browser의 동작-1

### 학습 목표

1.  HTML파일이 올 때 브라우저가 어떻게 렌더링과정을 거쳐서 화면에 보이게 되는지 간단히 이해한다.


### 핵심 개념
- Web Browser Rendering

### 학습하기

**browser의 동작 1.**

크로미움은 V8 + Blink을 포함한 구글 브라우저 오픈소스 애플리케이션 입니다. 또한 크롬은 바로 이 크로미움을 기반으로 만들어집니다. 크로미움은 여전히 렌더링 엔진으로 Blink를(webkit에서 fork된) 사용합니다. Blink 라는 용어보다도 보통 크롬의 크로미움을 주로 이야기하지만, Blink가 크로미움으로 바뀐 것이 아님을 알려드립니다. 

------

브라우저는 월드와이드웹(WWW)에서 정보를 검색, 표현하고 탐색하기 위한 소프트웨어입니다.

 

인터넷에서 특정 정보로 이동할 수 있는 주소 입력창이 있고 서버와 HTTP로 정보를 주고 받을 수 있는 네트워크 모듈도 포함하고 있습니다.

그리고 서버에서 받은 문서(HTML, CSS, Javascript)를 해석하고 실행하여 화면에 표현하기 위한 해석기(Parser)들을 가지고 있습니다.

브라우저마다 서로 다른 엔진을 포함하고 있습니다.

아래 그림이 대표적인 내용입니다.

[![img](https://cphinf.pstatic.net/mooc/20171231_32/1514692895834EoHUo_PNG/webkitflow.png?type=w760)](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/1_Web%EA%B0%9C%EB%B0%9C%EC%9D%98_%EC%9D%B4%ED%95%B4_FE_BE/image/4_1_Rendering.png)

- **사파리 브라우저에서 처리되는 webkit렌더링엔진의 처리과정**

  출처 https://www.html5rocks.com/en/tutorials/internals/howbrowserswork/

HTML을 해석해서 DOM Tree를 만들고, CSS를 해석해서 역시 CSS Tree(CSS Object Model)을 만듭니다. 

이 과정에서 Parsing 과정이 필요하며 토큰 단위로 해석되는 방식은 일반적인 소스코드의 컴파일 과정이라고 보시면 됩니다.

DOM Tree와 CSS Tree, 이 두 개는 연관되어 있으므로 Render Tree로 다시 조합됩니다.

이렇게 조합된 결과는 화면에 어떻게 배치할지 크기와 위치 정보를 담고 있습니다.

이후에 이렇게 구성된 Render Tree정보를 통해서 화면에 어떤 부분에 어떻게 색칠을 할지 Painting과정을 거치게 됩니다.



 

------

**생각해보기**

1. 우리가 흔히 브라우저 탐색을 할 때 스크롤을 하거나, 어떤 것을 클릭하면서 화면의 위치를 바꿀 때, 브라우저는 어떻게 다시 화면을 그릴까요?
2. 위에서 표현된 그림처럼 다시 렌더링 되지 않을까요? 



 

------

**참고 자료**

[**[참고링크\] How Browsers Work: Behind the scenes of modern web browsers**https://www.html5rocks.com](https://www.html5rocks.com/en/tutorials/internals/howbrowserswork/)

[**[참고링크\] 브라우저는 어떻게 동작하는가?**http://d2.naver.com위의 [참고링크] How Browsers Work: Behind the scenes of modern web browsers 의 번역본입니다.](http://d2.naver.com/helloworld/59361)