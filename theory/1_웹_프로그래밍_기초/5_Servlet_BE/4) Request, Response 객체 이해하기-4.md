# 4) Request, Response 객체 이해하기-4

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

- 그외의 요청정보 출력
- URI, URL, PATH, Remote host등에 대한 정보 출력
- http://localhost:8080/firstweb/info
- package name : examples
- class name : InfoServlet
- url mapping : /info



**실습코드**

InfoServlet.java

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
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
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
		out.println("<head><title>info</title></head>");
		out.println("<body>");

		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String contentPath = request.getContextPath();
		String remoteAddr = request.getRemoteAddr();
		
		
		out.println("uri : " + uri + "<br>");
		out.println("url : " + url + "<br>");
		out.println("contentPath : " + contentPath + "<br>");
		out.println("remoteAddr : " + remoteAddr + "<br>");
		
		out.println("</body>");
		out.println("</html>");
	}


}
```





------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180309_111/1520586077056udVfE_PNG/b278TiLhumy84AYf7RJT.png?type=mfullfill_199_148)**[참고링크\] HTTP headers**https://developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers)