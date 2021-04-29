# 2) page scope

**들어가기 전에**

특정 서블릿이나 JSP가 실행되는 동안에만 정보를 유지 하고 싶은 경우가 있습니다.

이 경우에 사용되는 것이 page scope입니다.

이번 시간에는 page scope에 대해서 알아보도록 하겠습니다.

 



------

**학습 목표**

1. page scope를 이해한다. 
2. page scope를 사용할 수 있다. 

 



------

**핵심 개념**

- PageContext

  

------

**학습하기**

**Page Scope**

- PageContext 추상 클래스를 사용한다.
- JSP 페이지에서 pageContext라는 내장 객체로 사용 가능 하다.
- forward가 될 경우 해당 Page scope에 지정된 변수는 사용할 수 없다.
- 사용방법은 Application scope나 Session scope, request scope와 같다.
- 마치 지역변수처럼 사용된다는 것이 다른 Scope들과 다릅니다.
- jsp에서 pageScope에 값을 저장한 후 해당 값을 EL표기법 등에서 사용할 때 사용됩니다.
- 지역 변수처럼 해당 jsp나 서블릿이 실행되는 동안에만 정보를 유지하고자 할 때 사용됩니다.

 



------

**생각해보기**

1. page scope를 이용하여 사용되는 변수와 지역변수는 거의 유사합니다. 하지만, 앞으로 배울 EL과 JSTL을 이용할 경우에는 구분되어 사용될 경우가 발생합니다. page scope와 지역변수가 유사하다고 하였는데요. 어떤 부분에서 유사할까요?

 



------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180129_11/1517206367250Mtoba_JPEG/yI2Q45VQpDZeQ8nmT5zP.jpg?type=mfullfill_199_148)**[참고링크\] Application, Request, Session and Page Scopes in Servlets and JSPs**http://www.javajee.com](http://www.javajee.com/application-request-session-and-page-scopes-in-servlets-and-jsps)