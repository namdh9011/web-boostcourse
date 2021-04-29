# 5) application scope-1

**들어가기 전에**

하나의 웹 어플리케이션에서 공유하고 싶은 변수가 있을 때 application scope를 사용합니다.

이번 시간엔 어플리케이션 스코프에 대해서 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. application scope를 이해한다.
2. application scope를 사용할 수 있다. 

 

 

------

**핵심 개념**

- ServletContext
- setAttribute
- getAttribute

 

------

**학습하기**

**노트**

- 모든 클라이언트가 공통으로 사용하는 값이 있을 때 사용.
- 클라이언트마다 가지는 영역이 아니다.

**Application Scope**

- 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용할 수 있다.
- ServletContext 인터페이스를 구현한 객체를 사용한다.
- jsp에서는 application 내장 객체를 이용한다.
- 서블릿의 경우는 getServletContext()메소드를 이용하여 application객체를 이용한다.
- 웹 어플리케이션 하나당 하나의 application객체가 사용된다.
- 값을 저장할 때는 application객체의 setAttribute()메소드를 사용한다.
- 값을 읽어 들일 때는 application객체의 getAttribute()메소드를 사용한다.
- 모든 클라이언트가 공통으로 사용해야 할 값들이 있을 때 사용한다.



------

**참고 링크**

[**[참고링크\] Web Application Scope**https://www.pearsonitcertification.com](https://www.pearsonitcertification.com/articles/article.aspx?p=30082&seqNum=6)