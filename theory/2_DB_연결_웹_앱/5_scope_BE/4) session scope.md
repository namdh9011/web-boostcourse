# 4) session scope

**들어가기 전에**

접속한 웹 브라우저별로 정보를 관리 하고 싶을 때 세션 scope를 사용합니다.

이번 시간엔 이러한 세션 스코프에 대해서 좀 더 자세히 알아보도록 하겠습니다.

 



------

**학습 목표**

1. session scope를 이해한다.
2. session scope를 사용할 수 있다. 

 



------

**핵심 개념**

- HttpSession
- session.setAttribute()
- session.getAttribute()

 



------

**학습하기**

**노트**

- 서버는 클라이언트가 여럿일때 각각의 클라이언트 마다 Session scope를 준다.



**Session Scope**

- 웹 브라우저별로 변수를 관리하고자 할 경우 사용한다.
- 웹 브라우저간의 탭 간에는 세션정보가 공유되기 때문에, 각각의 탭에서는 같은 세션정보를 사용할 수 있다.
- HttpSession 인터페이스를 구현한 객체를 사용한다.
- JSP에서는 session 내장 변수를 사용한다.
- 서블릿에서는 HttpServletRequest의 getSession()메소드를 이용하여 session 객체를 얻는다.
- 값을 저장할 때는 session 객체의 setAttribute()메소드를 사용한다.
- 값을 읽어 들일 때는 session 객체의 getAttribute()메소드를 사용한다.
- 장바구니처럼 사용자별로 유지가 되어야 할 정보가 있을 때 사용한다.





------

**생각해보기**

1. session scope는 어떤 경우에 이용하는 것이 좋을까요? 예를 한번 생각해보세요.





------

**참고 자료**

[**[참고링크\] JSP Scopes Example - Dinesh on Java**https://www.dineshonjava.com](https://www.dineshonjava.com/jsp-scopes-example/)