# 2) JSP 라이프싸이클

**들어가기 전에**

WAS는 웹 브라우저로부터 JSP에 대한 요청을 받게 되면, JSP코드를 서블릿 소스코드로 변환한 후 컴파일 하여 실행되게 됩니다.

서블릿으로 컴파일되어 실행될 때 상황에 따라서 어떤 메소드들이 실행되는지 잘 알아야, JSP를 알맞게 작성할 수 있습니다.

 



------

**학습 목표**

1. jsp의 라이프 사이클을 이해한다. 
2. jsp를 이용해서 init, destroy 메소드를 이용할 수 있다. 

 



------

**핵심 개념**

- jsp라이프 사이클

 



------

**학습하기**

**실습**

firstweb>webcontent>jsp>lifecycle.jsp



**노트**

- jsp는 servlet로 변환되서 실행된다.
- <%! %> 선언식
- <% %>와 같은 스크립트 릿은 service 라이프사이클에서 실행된다.
- 선언식의 경우 servlet 파일이 만들어지기 실행되므로 다른 라이프사이클을 호출하는 것이 가능하다.




1에서 10까지 출력하는 jsp가 서블릿으로 변경 된 파일입니다. 

```java
public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    .....

    try {
      .....

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>sum10</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");

	int total = 0;
	for(int i = 1; i <= 10; i++){
		total = total + i;
	}

      out.write("\n");
      out.write("\n");
      out.write("1부터 10까지의 합 : ");
      out.print(total );
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      .....
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
```

스크립틀릿 부분이라고 java 코드를 입력한 부분은 다음과 같이 입력되어 있습니다.

```java
int total = 0;
for(int i = 1; i <= 10; i++){
    total = total + i;
}
```

표현식으로 출력한 부분은 다음과 같습니다.

```java
out.print(total );
```



**JSP의 실행순서**

1. 브라우저가 웹서버에 JSP에 대한 요청 정보를 전달한다.
2. 브라우저가 요청한 JSP가 최초로 요청했을 경우만 JSP로 작성된 코드가 서블릿으로 코드로 변환한다. (java 파일 생성)
3. 서블릿 코드를 컴파일해서 실행가능한 bytecode로 변환한다. (class 파일 생성)
4. 서블릿 클래스를 로딩하고 인스턴스를 생성한다.
5. 서블릿이 실행되어 요청을 처리하고 응답 정보를 생성한다.



lifecycle.jsp

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
hello
<%
	System.out.println("_jspService()");
%>

<%!
public void jspInit() {
	System.out.println("jspInit()!");
}

public void jspDestroy() {
	System.out.println("jspDestroy()");
}
%>

</body>
</html>
```

 

 

------

**생각해보기**

1. 서블릿 라이프 싸이클에서 실행되는 메소드와 JSP 라이프 싸이클에서 실행되는 메소드의 이름을 비교해 봅시다.



 

------

**참고 자료**

[**[참고링크\] Java Server Pages (JSP) Life Cycle**https://beginnersbook.com](https://beginnersbook.com/2013/05/jsp-tutorial-life-cycle/)

[**[참고링크\] Lifecycle of JSP**https://www.studytonight.com](https://www.studytonight.com/jsp/lifecycle-of-jsp.php)