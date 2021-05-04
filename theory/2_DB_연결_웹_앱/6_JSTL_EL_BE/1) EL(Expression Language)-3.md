# 1) EL(Expression Language)-3

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

- firstweb>Webcontents>jsp>el02.jsp





**실습코드**

el02.jsp

표현 언어의 연산

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setAttribute("k", 10);
    request.setAttribute("m", true);
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
k : ${k } <br>
k + 5 : ${ k + 5 } <br>
k - 5 : ${ k - 5 } <br>
k * 5 : ${ k * 5 } <br>
k / 5 : ${ k div 5 } <br>


k : ${k }<br>
m : ${m }<br>
k > 5 : ${ k > 5 } <br>
k < 5 : ${ k < 5 } <br>
k <= 10 : ${ k <= 10} <br>
k >= 10 : ${ k >= 10 } <br>
m : ${ m } <br>
!m : ${ !m } <br>

</body>
</html>
```

EL 문법 사용하지 않고 문자열 그대로 표시할 때

```jsp
<%@ page isELIgnored = "true" %> 
```





------

**생각해보기**

1. 표현식으로 값을 출력하는 것과 EL을 이용해서 값을 출력하는 것 중 어떤 게 편해 보이나요? 혹시 표현식으로 표현하는 것이 좀 더 편리해 보인다 하더라도 실망하지 마세요. EL은 다음 시간에 배우게 될 JSTL과 함께 사용하면 더 효율적으로 사용할 수 있습니다.



 

------

**참고 자료**

[**[참고링크\] JSP Expression Language | EL - javatpoint**https://www.javatpoint.com](https://www.javatpoint.com/EL-expression-in-jsp)