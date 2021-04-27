# 4) Request, Response 객체 이해하기-2

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

- **Request, Response 이해하기**

  영상 우측 하단에 자막 스크립트 ON 설정을 한 후 강의를 시청하시면 학습에 도움이 됩니다.



**실습**

- 웹 브라우저가 요청정보에 담아서 보내는 header값을 읽어 들여 브라우저 화면에 출력한다.
- http://localhost:8080/firstweb/header
- package name : examples
- class name : HeaderServlet
- urlMapping: /header



**실습코드**

HeaderServlet.java

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
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderServlet() {
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

		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println(headerName + " : " + headerValue + " <br> ");
		}		
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
```

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180309_111/1520586077056udVfE_PNG/b278TiLhumy84AYf7RJT.png?type=mfullfill_199_148)**[참고링크\] HTTP headers**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers)