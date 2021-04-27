# 4) Request, Response 객체 이해하기-3

**들어가기 전에**

이번 파트를 학습하다 보면 '요청', '응답'이라는 용어가 많이 등장합니다.

이번 학습에서는 클라이언트가 서버에게 보낸 요청을 추상화한 객체 HttpServletRequest 와 서버가 클라이언트에게 응답하기 위한 정보를 추상화한 객체 HttpServletResponse에 대해서 알아봅니다.

 

 

------

**학습 목표**

1. HttpServletRequest 객체를 이해한다.
2. HttpServletResponse 객체를 이해한다.

 



------

**핵심 개념**

- HttpServletRequest
- HttpServletResponse

 

**학습하기**

**필기**

- 파라미터 읽어 들이기
- URL주소의 파라미터 정보를 읽어 들여 브라우저 화면에 출력한다.
- http://localhost:8080/firstweb/param?name=kim&age=5
- package name : examples
- class name : ParameterServlet
- url mapping : /param



**실습코드**

ParameterServlet.java

```java
package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		out.println("name : " + name + "<br>");
		out.println("age : " +age + "<br>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180309_111/1520586077056udVfE_PNG/b278TiLhumy84AYf7RJT.png?type=mfullfill_199_148)**[참고링크\] HTTP headers**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers)