# 3) request scope

**들어가기 전에**

웹 브라우저로부터 WAS가 요청을 받은 후, 포워드 되는 동안 유지하고 싶은 정보가 있을 경우 request scope를 사용합니다.

이번 시간에는 request scope에 대해 알아보도록 하겠습니다.

 



------

**학습 목표**

1. request scope를 이해한다.
2. request scope를 사용 할 수 있다. 

 

 

------

**핵심 개념**

- HttpServletRequest
- forward
- request.setAttribute()
- request.getAttribute()

 



------

**학습하기**

**Request Scope**

- http 요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수값을 유지하고자 할 경우 사용한다.
- HttpServletRequest 객체를 사용한다.
- JSP에서는 request 내장 변수를 사용한다.
- 서블릿에서는 HttpServletRequest 객체를 사용한다.
- 값을 저장할 때는 request 객체의 setAttribute()메소드를 사용한다.
- 값을 읽어 들일 때는 request 객체의 getAttribute()메소드를 사용한다.
- forward 시 값을 유지하고자 사용한다.
- 앞에서 forward에 대하여 배울 때 forward 하기 전에 request 객체의 setAttribute() 메소드로 값을 설정한 후, 서블릿이나 jsp에게 결과를 전달하여 값을 출력하도록 하였는데 이렇게 포워드 되는 동안 값이 유지되는 것이 Request scope를 이용했다고 합니다.

 

 

------

**생각해보기**

1. 리다이렉트 될 경우에도 request scope를 이용하면 정보를 유지할 수 있을까요?
2. 만약 정보를 유지할 수 없다면 이유가 무엇일까요?

 



------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180129_21/1517206744022rWGm3_JPEG/yJ3rcHQEvJwfOCuAYUwi.jpg?type=mfullfill_199_148)**[참고링크\] Application, Request, Session and Page Scopes in Servlets and JSPs**http://www.javajee.com](http://www.javajee.com/application-request-session-and-page-scopes-in-servlets-and-jsps)