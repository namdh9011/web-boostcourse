# 1) EL(Expression Language)-2

**들어가기 전에**

jsp에서 표현식을 이용해 값을 출력할 때 변수의 값이 null이면 화면에 null이 출력되었습니다.

이 경우 null인지를 check한 후 null이면 아무것도 없는 문자열을 출력해야 하는 등 불편한 과정을 거쳐야 합니다.

EL을 사용하면 좀 더 편리하게 변수를 JSP에서 사용할 수 있습니다.

그럼 EL에 대해 알아보도록 하겠습니다.

 

 

------

**학습 목표**

1. EL을 이해한다.
2. EL을 사용할 수 있다. 

 

 

------

**핵심 개념**

- EL
- isELIgnored

 

 

------

**학습하기**

**실습**

- firstweb>webContent>jsp>el01.jsp

**노트**

- 변수명이 다르다면 변수명만 써주면 되지만 명시적으로 scope를 써주는 것이 좋다.

- 변수명 같은게 있을 경우 작은 스코프를 출력해준다.



**실습코드**

el01.jsp

Scope별 표현 언어의 사용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("p1", "page scope value");
    request.setAttribute("r1", "request scope value");
    session.setAttribute("s1", "session scope value");
    application.setAttribute("a1", "application scope value");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
pageContext.getAttribute("p1") : ${pageScope.p1 }<br>
request.getAttribute("r1") : ${requestScope.r1 }<br>
session.getAttribute("s1") : ${sessionScope.s1 }<br>
application.getAttribute("a1") : ${applicationScope.a1 }<br>
<br><br>
pageContext.getAttribute("p1") : ${p1 }<br>
request.getAttribute("r1") : ${r1 }<br>
session.getAttribute("s1") : ${s1 }<br>
application.getAttribute("a1") : ${a1 }<br>

</body>
</html>
```

------

**참고 자료**

[**[참고링크\] JSP Expression Language | EL - javatpoint**https://www.javatpoint.com](https://www.javatpoint.com/EL-expression-in-jsp)