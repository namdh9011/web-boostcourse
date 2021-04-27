# 4) Request, Response 객체 이해하기-1

**들어가기 전에**

이번 파트를 학습하다 보면 '요청', '응답'이라는 용어가 많이 등장합니다.

이번 학습에서는 클라이언트가 서버에게 보낸 요청을 추상화한 객체 HttpServletRequest 와 서버가 클라이언트에게 응답하기 위한 정보를 추상화한 객체 HttpServletResponse에 대해서 알아봅니다.

 

 

------

**학습 목표**

1. HttpServletRequest 객체를 이해한다.
2. HttpServletResponse 객체를 이해한다.

 



------

**핵심 개념**

- HttpServletRequest
- HttpServletResponse

 

**학습하기**

- **Request, Response 이해하기**

  영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.

![4_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/5_Servlet_BE/image/4_1.png)

- **요청과 응답**

**요청과 응답**

WAS는 웹 브라우저로부터 Servlet요청을 받으면,

- 요청할 때 가지고 있는 정보를 HttpServletRequest객체를 생성하여 저장합니다.
- 웹 브라우저에게 응답을 보낼 때 사용하기 위하여 HttpServletResponse객체를 생성합니다.
- 생성된 HttpServletRequest, HttpServletResponse 객체를 서블릿에게 전달합니다.

 

**HttpServletRequest**

- http프로토콜의 request정보를 서블릿에게 전달하기 위한 목적으로 사용합니다.
- 헤더정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽어 들이는 메소드를 가지고 있습니다.
- Body의 Stream을 읽어 들이는 메소드를 가지고 있습니다.



**HttpServletResponse**

- WAS는 어떤 클라이언트가 요청을 보냈는지 알고 있고, 해당 클라이언트에게 응답을 보내기 위한 HttpServleResponse객체를 생성하여 서블릿에게 전달합니다.
- 서블릿은 해당 객체를 이용하여 content type, 응답코드, 응답 메시지등을 전송합니다.

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180309_111/1520586077056udVfE_PNG/b278TiLhumy84AYf7RJT.png?type=mfullfill_199_148)**[참고링크\] HTTP headers**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers)