# 4) JSP 내장객체

**들어가기 전에**

JSP에서는 개발자가 선언하지 않아도, 사용할 수 있는 미리 선언된 변수가 존재합니다.

이를 내장객체라고 합니다.

개발자가 선언하지 않았음에도 어떻게 JSP에서 내장객체를 사용할 수 있는지,

그리고 이 내장 객체를 어떻게 사용해야 하는지에 대해서 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. 내장객체가 무엇인지 이해한다. 
2. 내장객체 종류를 알고 이용할 수 있다. 

 

 

------

**핵심 개념**

- request
- response
- out
- application
- page
- session

 

 

------

**학습하기**



**JSP 내장 객체란?**

- JSP를 실행하면 서블릿 소스가 생성되고 실행된다.
- JSP에 입력한 대부분의 코드는 생성되는 서블릿 소스의 _jspService() 메소드 안에 삽입되는 코드로 생성된다.
- _jspService()에 삽입된 코드의 윗부분에 미리 선언된 객체들이 있는데, 해당 객체들은 jsp에서도 사용 가능하다.
- response, request, application, session, out과 같은 변수를 내장객체라고 한다.



**내장 객체의 종류**

![4_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/3_JSP_BE/image/4_1.png)

- **내장 객체의 종류**

------

**실습코드**

- 내장객체를 사용하는 간단한 예제를 작성해 보도록 하겠습니다.
- ImplicitObjects.jsp 를 작성해보도록 하겠습니다.

 

ImplicitObjects.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL();

    out.println("url : " + url.toString());
    out.println("<br>");
%>
</body>
</html>
```



ImplicitObjects_jsp.java

```java
  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    ......

    javax.servlet.jsp.JspWriter _jspx_out = null;

    ......

    out = pageContext.getOut();
    ......


        StringBuffer url = request.getRequestURL();

        out.println("url : " + url.toString());
        out.println("<br>");
```

   

 

------

**생각해보기**

1. 내장객체를 JSP 선언문에서 사용할 수 있을까요? 사용할 수 없다면 왜 그럴까요?



 

------

**참고 자료**

[**[참고링크\] JSP Implicit Objects - javatpoint**https://www.javatpoint.com](https://www.javatpoint.com/jsp-implicit-objects)