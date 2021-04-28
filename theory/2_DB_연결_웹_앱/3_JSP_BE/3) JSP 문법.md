# 3) JSP 문법

**들어가기 전에**

JSP는 HTML태그와 자바코드를 섞어서 개발할 수 있습니다.

JSP에서 자바코드는 어떻게 입력을 하는지, 어떤 결과를 출력하려면 어떤 것을 사용해야 하는지에 대해서 알아보도록 하겠습니다.

 



------

**학습 목표**

1. JSP에서 선언문을 이용해 필드와 메소드를 선언할 수 있다.
2. JSP에서 자바 코드를 입력하는 방법을 알 수 있다.
3. JSP에서 변수값을 출력할 수 있다.
4. JSP에서 주석문을 작성할 수 있다.

 



------

**핵심 개념**

- 선언문(Declaration)
- 스크립트릿(Scriptlet)
- 표현식(Expression) 
- 주석(Comment) 

 



------

**학습하기**
**실습**
firstweb>webcontent>jsp>exam1.jsp
firstweb>webcontent>jsp>exam2.jsp

**노트**
- jsp주석, java주석, html주석이 각각 동작하는 위치가 다르다.
- jsp는 jsp에서 바로 동작 java주석은 servlet 파일로 바뀐 후 동작, html은 실제 실행될때 동작.

**스크립트 요소의 이해**

- JSP 페이지에서는 선언문(Declaration), 스크립트릿(Scriptlet), 표현식(Expression) 이라는 3가지의 스크립트 요소를 제공

![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/3_JSP_BE/image/3_1.png)

- **스크립트 요소의 이해**

 **선언문**

- 선언문 : <%! %>
- 선언문은 JSP 페이지 내에서 필요한 멤버변수나 메소드가 필요할 때 선언해 사용하는 요소
- 선언문의 문법
- <%! 문장 %>



exam1.jsp

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

id : <%=getId() %>
</body>
</html>

<%!
    String id = "u001"; //멤버변수 선언
    public String getId( ) { //메소드 선언
        return id;
    }
%>
```



**스크립트릿**

- 스크립트릿 : <% %>
- 가장 일반적으로 많이 쓰이는 스크립트 요소
- 주로 프로그래밍의 로직을 기술할 때 사용
- 스크립트릿에서 선언된 변수는 지역변수
- 스크립트릿의 문법
- <% 문장%>


exam02.jsp

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
for(int i = 1; i <= 5; i++){
%>
<H<%=i %>> 아름다운 한글 </H<%=i %>>
<%
}
%>
</body>
</html>
```


html 소스보기 결과

```jsp
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<H1> 아름다운 한글 </H1>

<H2> 아름다운 한글 </H2>

<H3> 아름다운 한글 </H3>

<H4> 아름다운 한글 </H4>

<H5> 아름다운 한글 </H5>

</body>
</html>
```

 

서블릿으로 변환된 코드 주요부분

```java
for(int i = 1; i <= 5; i++){

      out.write('\n');
      out.write('<');
      out.write('H');
      out.print(i );
      out.write("> 아름다운 한글 </H");
      out.print(i );
      out.write('>');
      out.write('\n');

}
```



**표현식(Expression)**

- 표현식 : <%=%>
- JSP 페이지에서 웹 브라우저에 출력할 부분을 표현 (즉, 화면에 출력하기 위한 것)
- 스크립트릿내에서 출력할 부분은 내장객체인 out 객체의 print() 또는 println() 메소드를 사용해서 출력
- 표현식의 문법
- <%=문장%>



**주석(Comment)**

- JSP페이지에서 사용할 수 있는 주석
- HTML주석, 자바주석, JSP주석

 

\1. HTML 주석

- HTML 주석은 <!--로 시작해서 -->로 끝나는 형태
- HTML 주석은 HTML주석을 사용한 페이지를 웹에서 서비스할 때 화면에 주석이 내용이 표시되지는 않으나 , [소스보기]수행하면 HTML주석의 내용이 화면에 표시.
- HTML주석의 예시

```html
<!-- html 주석입니다. -->
```

\2. JSP주석

- JSP 페이지에서만 사용되며 <%--로 시작해서 --%>로 끝나는 형태
- JSP 주석은 해당 페이지를, 웹 브라우저를 통해 출력 결과로서 표시하거나, 웹 브라우저 상에서 소스 보기를 해도 표시 되지 않음. 또한 JSP주석 내에 실행코드를 넣어도 그 코드는 실행되지 않음.
- JSP주석의 예시

```jsp
<%-- JSP 주석입니다. --%>
```

\3. 자바주석

- 자바 주석은 //, /**/을 사용해서 작성.
- //은 한 줄짜리 주석을 작성할 때 사용되고, /**/은 여러 줄의 주석을 작성할 때 사용
- 스크립트릿이나 선언문에서 사용되는 주석으로, 자바와 주석 처리 방법이 같음
- 자바주석의 예시

```java
//주석

/*주석

여러 줄에 걸친 주석이다.

*/
```



**주석 실습코드**

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
<%--jsp 주석문입니다.
여러줄을 입력할 수 있습니다. --%>
<!-- html 주석문입니다. -->
<%
/*
자바 여러줄 주석문입니다.
*/
for(int i = 1; i <= 5; i++){ // java 한줄 주석문입니다.
%>
<H<%=i %>> 아름다운 한글 </H<%=i %>>
<%
}
%>
</body>
</html>
```

 



------

**생각해보기**

1. JSP는 서블릿 소스코드로 변환된다고 했습니다.
2. 이번 시간에 배웠던 JSP들이 서블릿 소스로 변환될 때 스크립틀릿, 표현식, 선언문이 어떻게 변환될지 예상해 봅시다.





------

**참고 자료**

[**[참고링크\] JSP Declaration Scripting Element**http://www.w3processing.com](http://www.w3processing.com/index.php?subMenuLoad=JSP/DeclarationScripting.php)

[**[참고링크\] JSP Scriptlet Scripting Element**http://www.w3processing.com](http://www.w3processing.com/index.php?subMenuLoad=JSP/Elements/Scripting/ScriptletScripting.php&environmentPath=NB/GF)

[**[참고링크\] JSP Expression Scripting Element**http://www.w3processing.com](http://www.w3processing.com/index.php?subMenuLoad=JSP/Elements/Scripting/ExpressionScripting.php&environmentPath=NB/GF)