# 1) JSP란?

**들어가기 전에**

마이크로소프트의 ASP(Active Server Pages)와 같은 스크립트 형태의 개발 방법이 인기를 얻게 되면서, 자바 진영에서도 대항하기 위해서 JSP를 발표하게 됩니다.

스크립트 언어인 JSP에 대해서 알아보도록 하겠습니다.





------

**학습 목표**

1. jsp가 무엇인지 이해한다. 
2. jsp의 간단한 사용법을 알아본다. 





------

**핵심 개념**

- jsp (java server page)





------

**학습하기**

**실습**

firstweb Project의 webcontent>jsp>sum10.jsp

**노트**
- jsp는 sevelet로 바뀌어서 실행된다.
- <% %> 와 같은 스크립트릿은 servlet로 바뀌어서 어떻게 실행될지 알려주는 부분
- <%@ %> 지시자
- <%= %> 표현식		==>	out.print();


**실습코드**

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sum10</title>
</head>
<body>

<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }
%>

1부터 10까지의 합 : <%=total %>

</body>
</html>
```



**JSP 등장 배경**

- 마이크로소프트에서 ASP(Active Server Page)라는 쉽게 웹을 개발할 수 있는 스크립트(script) 엔진을 발표함 (1998년
- 1997년에 발표된 서블릿은 ASP에 비하여 상대적으로 개발 방식이 불편함
- ASP에 대항하기 위하여 1999년 썬마이크로시스템즈에서 JSP를 발표
- JSP는 실제로 서블릿 기술을 사용





------

**생각해보기**

1. 1부터 10까지의 합을 구하는 서블릿과 JSP를 비교해봤을 때 JSP가 어떤 부분에서 편리한것 같나요?





------

**참고 자료**

[**[참고링크\] JavaServer Pages(TM) Specification 2.0 Final Release**http://download.oracle.com](http://download.oracle.com/otndocs/jcp/jsp-2.0-fr-oth-JSpec/)