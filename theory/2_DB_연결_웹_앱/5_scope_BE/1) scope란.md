# 1) scope란?

**들어가기 전에**

Servlet과 JSP를 개발하다보면 변수를 많이 다루게 됩니다.

어떤 변수는 웹 어플리케이션에서 공유하고 싶은 변수가 있을 수도 있고, 어떤 변수는 사용자 별로 유지하고 싶은 변수가 있을 수 있습니다.

또 어떤 변수는 포워딩 되는 동안 유지하고 싶은 변수가 있습니다.

이렇게 변수를 어떤 범위 내에서 사용하기 위해서는 스코프(scope)라는 것에 대해서 알아야 합니다.

이번 시간엔 scope에 대해서 알아보도록 하겠습니다.





------

**학습 목표**

1. 4가지 scope에 대해서 이해한다.





------

**핵심 개념**

- application scope
- session scope
- request scope
- page scope





------

**학습하기**
![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/5_scope_BE/image/1_1.jpg)

- 

  출처 http://inheritingjava.blogspot.kr/2011/04/chapter-42-scope-of-javabeans-in-jsp.html

**4가지 Scope**

- Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용
- Session : 웹 브라우저 별로 변수가 관리되는 경우 사용
- Request : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용
- Page : 페이지 내에서 지역변수처럼 사용

 



------

**생각해보기**

1. 회사 관리 프로그램을 만듭니다. 회사 전체적으로 사용되는 특정 정보가 약 1메가 정도 있습니다. 이 정보는 자주 바뀌지 않고, 모든 사원들이 공통적으로 사용하는 코드입니다. 이러한 정보는 어떤 scope로 사용하는 것이 좋을까요?



 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180129_106/15172060576934hGiQ_JPEG/60HDBouuy8bGvYbNYlIl.jpg?type=mfullfill_199_148)**[참고링크\] Application, Request, Session and Page Scopes in Servlets and JSPs**http://www.javajee.com](http://www.javajee.com/application-request-session-and-page-scopes-in-servlets-and-jsps)