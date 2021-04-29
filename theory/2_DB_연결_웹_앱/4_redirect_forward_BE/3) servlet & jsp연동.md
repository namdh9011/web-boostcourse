# 3) servlet & jsp연동

**들어가기 전에**

서블릿과 JSP는 서로 상호 보완적인 관계를 가지고 있습니다.

서블릿은 로직을 구현하기에 알맞지만, HTML을 출력하기엔 불편합니다.

JSP는 로직을 구현하는 것은 불편하지만 HTML을 출력하기엔 편리합니다.

이러한 서블릿과 JSP를 좀 더 잘 사용하기 위해서 forward가 사용되는 경우가 많습니다.

이번 시간엔 서블릿과 JSP의 연동에 대해 알아보도록 하겠습니다.

 



------

**학습 목표**

1. 서블릿과 JSP를 적절히 이용해서 포워딩을 효율적으로 사용할 수 있다. 

 



------

**핵심 개념**

- forward
- request.setAttribute()
- request.getAttribute()

 



------

**학습하기**

**실습**

firstweb>src>examples>LogicServlet.java

firstweb>webcontent>jsp>result.jsp



**노트**

jsp파일에 servlet으로 변하는 java코드가 계속 나오는게 안좋아서 el이나 jstl 같은 것이 나오게됨.



**Servlet과 JSP연동**

- Servlet은 프로그램 로직이 수행되기에 유리하다. IDE 등에서 지원을 좀 더 잘해준다.
- JSP는 결과를 출력하기에 Servlet보다 유리하다. 필요한 html문을 그냥 입력하면 됨.
- 프로그램 로직 수행은 Servlet에서, 결과 출력은 JSP에서 하는 것이 유리하다.
- Servlet과 JSP의 장단점을 해결하기 위해서 Servlet에서 프로그램 로직이 수행되고, 그 결과를 JSP에게 포워딩하는 방법이 사용되게 되었다. 이를 Servlet과 JSP연동이라고 한다.



![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/4_redirect_forward_BE/image/3_1.png)

- **servlet jsp연동**

------

**실습코드**

LogicServlet.java

```java
package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/LogicServlet")
public class LogicServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int v1 = (int)(Math.random() * 100) + 1;
        int v2 = (int)(Math.random() * 100) + 1;
        int result = v1 + v2;
        
        request.setAttribute("v1", v1);
        request.setAttribute("v2", v2);
        request.setAttribute("result", result);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);
    }

}
```


result.jsp

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
EL표기법으로 출력합니다.<br>
${v1} + ${v2} = ${result} <br><br>

스클립틀릿과 표현식을 이용해 출력합니다.<br>
<%
    int v1 = (int)request.getAttribute("v1");
    int v2 = (int)request.getAttribute("v2");
    int result = (int)request.getAttribute("result");
%>

<%=v1%> + <%=v2 %> = <%=result %>
</body>
</html>
```

 

 

------

**생각해보기**

1. 객체지향에서 객체는 관련된 것들을 모아서 가지고 있는 특징이 있습니다. 웹 페이지 URL도 관련된 URL이 있습니다. 예를 들어, 게시판 글쓰기, 읽기, 목록 보기 등은 모두 게시판과 관련된 URL일 것입니다. 하지만 지금까지의 예제들을 보면 서블릿은 하나의 URL만 처리하고 있습니다. 하나의 서블릿이 여러 개의 요청을 받을 수는 없을까요?
   (힌트 : 서블릿 URL mapping에서 와일드카드('*'기호)를 사용하는 방법에 대해서 조사해보세요.)





------

**참고 자료**

[**[참고링크\] URL Patterns**http://docs.roguewave.com](http://docs.roguewave.com/hydraexpress/3.5.0/html/rwsfservletug/4-3.html)