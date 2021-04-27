# 2) Servlet 작성 방법-3

**들어가기 전에**

현재 프로젝트에서 웹을 개발할 때 서블릿을 직접 써서 개발하지는 않습니다.

조금 더 편하게 사용할 수 있게 도와주는 다양한 프레임워크를 사용해서 개발하는 경우가 더 많습니다.

하지만, 그 프레임워크들도 서블릿이 없이는 동작할 수 없기 때문에 서블릿의 기본적인 작성법이나, 서블릿의
라이프 사이클을 이해하고 있다면 웹의 동작을 이해하는 데 많은 도움이 됩니다.



 

------

**학습 목표**

1. 서블릿을 작성할 수 있습니다.
2. 서블릿 버전에 따른 web.xml을 적절하게 작성할 수 있습니다.



 

------

**핵심 개념**

- HttpServlet
- web.xml



 

------

**학습하기**

**Servlet 3.0 spec 미만에서 사용하는 방법**

Servlet2.5 spec으로 exam25이라는 프로젝트를 생성해서 실습.

프로젝트 생성시 Dynamic web module version을 2.5로 해준다.

web.xml 생성에 체크 해준다.

class name은 TenServlet로 해주고 URL mappings을 /ten으로 바꾼다.

servlet에 어노테이션이 없다 대신 web.xml에 servlet태그가 생긴다.

web.xml 파일을 살펴보면 <url-pattern>에서 /ten 이라고mapping된 애가 들어오면 <servlet>에 <servlet-name>이 같은 것을 찾아서 실행시킬 servlet의 경로를 확인한다.



**실습코드**

web.xml

```markup
<?xml version="1.0" encoding="UTF-8"?>
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xmlns="http://java.sun.com/xml/ns/javaee" 
xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" 
version="2.5">
    <display-name>exam25</display-name>
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
        <welcome-file>default.html</welcome-file>
        <welcome-file>default.htm</welcome-file>
        <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>
    <servlet>
        <description></description>
        <display-name>TenServlet</display-name>
        <servlet-name>TenServlet</servlet-name>
        <servlet-class>exam.TenServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>TenServlet</servlet-name>
        <url-pattern>/ttt</url-pattern>
    </servlet-mapping>
</web-app>
```

 

 

**생각해보기**

1. HelloServlet 클래스 파일을 작성할 때 HttpServlet을 상속하지 않았다면 어떻게 동작할까요? 

 

 



 

------



[ ![img](https://cphinf.pstatic.net/mooc/20191203_6/1575304675591vXQd7_PNG/6LeVHS5O6y7fYwKJ8tw7.png?type=ffn199_148)**<강좌 추천> 예비 개발자의 좋은 시작, [부스트코스 : 웹 UI 개발\]**https://www.edwith.org부스트코스는 NAVER 계열사 등과 함께 만들어가는 현장 중심 온라인 교육 프로그램입니다.
현업 전문가들이 고민하여 만들고 1:1 코드리뷰도 받을 수 있는 부스트코스에서 기업이 원하는 유능한 개발자로 boost하세요!](https://www.edwith.org/boostcourse-ui)