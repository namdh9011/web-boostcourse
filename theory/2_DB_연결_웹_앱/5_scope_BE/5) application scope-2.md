# 5) application scope-2

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

**실습**

firstweb>src>ApplicationScope01.java

firstweb>src>ApplicationScope02.java

firstweb>webcontent>jsp>ApplicationScope01.jsp

**노트**
- servlet파일과 jsp 파일을 모두 실행해 줌.
- scope02나 jsp 파일을 먼저 실행하면 설정된 값이 없다고 나온다 value가 선언되지 않았기 때문.
- 새로고침 해주면 계속 공유해서 값을 써준다는 것을 알 수 있음.



**실습코드**

ApplicationScope01.java

```java
package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope01
 */
@WebServlet("/ApplicationScope01")
public class ApplicationScope01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScope01() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        
        ServletContext application = getServletContext();
        int value = 1;
        application.setAttribute("value", value);
        
        
        out.println("<h1>value : " + value + "</h1>");
        
    }

}
```



ApplicationScope02.java

```java
package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope01
 */
@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationScope02() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        ServletContext application = getServletContext();
        
        
        try {
            int value = (int)application.getAttribute("value");
            value++;
            application.setAttribute("value", value);
            out.println("<h1>value : " + value + "</h1>");
        }catch(NullPointerException ex) {
            out.println("value가 설정되지 않습니다.");
        }
        
        
    }

}
```



applicationscope01.jsp

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
    try{
        int value = (int)application.getAttribute("value");
        value = value + 2;
        application.setAttribute("value", value);
%>
        <h1><%=value %></h1>
<%        
    }catch(NullPointerException ex){
%>
        <h1>설정된 값이 없습니다.</h1>
<%        
    }
%>

</body>
</html>
```

 



------

**생각해보기**

1. 어플리케이션 스코프에 List객체를 저장했습니다. 이 List객체에 주기적으로 값이 저장은 되지만, 삭제는 되지 않고 있습니다. 이 경우 어떤 문제가 발생할 수 있을까요?





------

**참고 자료**

[**[참고링크\] Web Application Scope**https://www.pearsonitcertification.com](https://www.pearsonitcertification.com/articles/article.aspx?p=30082&seqNum=6)
