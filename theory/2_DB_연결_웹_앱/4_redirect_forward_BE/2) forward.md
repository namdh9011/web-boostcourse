# 2) forward

**들어가기 전에**

WAS의 서블릿이나 JSP가 요청을 받은 후 그 요청을 처리하다가, 추가적인 처리를 같은 웹 어플리케이션안에 포함된 다른 서블릿이나 JSP에게 위임하는 경우가 있습니다.

이렇게 위임하는 것을 포워드(forward)라고 합니다.

이번 시간엔 이러한 포워드에 대해서 좀 더 자세히 알아보도록 하겠습니다.





------

**학습 목표**

1. foward를 이해한다. 
2. foward를 사용 할 수 있다. 





------

**핵심 개념**

- RequestDispatcher
- forward()





------

**학습하기**

**실습**

firstweb>src>examples>

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/4_redirect_forward_BE/image/2_1.png)



**노트**

redirect는 주소값이 변하지만 forward는 주소값이 변하지 않는다는 것 기억.



- **forward**

  출처 http://java.scwcd.jobs4times.com/Web-Container-Model.html

**forward란?**

1. 웹 브라우저에서 Servlet1에게 요청을 보냄
2. Servlet1은 요청을 처리한 후, 그 결과를 HttpServletRequest에 저장
3. Servlet1은 결과가 저장된 HttpServletRequest와 응답을 위한 HttpServletResponse를 같은 웹 어플리케이션 안에 있는 Servlet2에게 전송(forward)
4. Servlet2는 Servlet1으로 부터 받은 HttpServletRequest와 HttpServletResponse를 이용하여 요청을 처리한 후 웹 브라우저에게 결과를 전송**
   **





------

**실습코드**

FrontServlet.java

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
 * Servlet implementation class FrontServlet
 */
@WebServlet("/front")
public class FrontServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            int diceValue = (int)(Math.random() * 6) + 1; 
            request.setAttribute("dice", diceValue);
            
            RequestDispatcher requestDispatehcer = request.getRequestDispatcher("/next");
            requestDispatehcer.forward(request, response);
    }

}
```


NextSevlet.java

```java
package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        int dice = (Integer)request.getAttribute("dice");
        out.println("dice : " + dice);
        for(int i = 0; i < dice; i++) {
            out.print("<br>hello");
        }
        out.println("</body>");
        out.println("</html>");
    }

}
```





------

**생각해보기**

1. 서블릿은 프로그램 로직을 개발하기에 편리하지만, HTML 태그를 출력하기엔 불편합니다. JSP는 프로그램 로직을 개발하기는 좀 불편하지만, HTML 태그를 출력하기엔 편리합니다. 서블릿과 JSP는 서로 장단점이 반대입니다. 포워드를 이용해서 이러한 단점을 해결하고 싶습니다. 어떻게 해야 할까요?





------

**참고 자료**

[**[참고링크\] Servlet forward example - How to forward from a servlet to a JSP**https://alvinalexander.com](https://alvinalexander.com/blog/post/servlets/forwarding-from-servlet-jsp)