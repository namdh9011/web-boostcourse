# 3) Servlet 라이프 싸이클-2

**들어가기 전에**

어떤 객체의 생성부터 소멸까지의 과정을 라이프 사이클(Life Cycle)라고 합니다.

이번 학습에서는 서블릿의 라이프 사이클을 알아봅니다.

 

 

------

**학습 목표**

1. 서블릿의 생명주기를 이해합니다.

 



------

**핵심 개념**

- init
- service
- destory

 



------

**학습하기**

![3_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/1_%EC%9B%B9_%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D_%EA%B8%B0%EC%B4%88/5_Servlet_BE/image/3_1.png)

- **Servlet**

**Servlet 생명주기**

- WAS는 서블릿 요청을 받으면 해당 서블릿이 메모리에 있는지 확인합니다.
-  if (메모리에 없음) {
   \- 해당 서블릿 클래스를 메모리에 올림
   \- init() 메소드를 실행
  }
   \- service()메소드를 실행
- was가 종료되거나, 웹 어플리케이션이 새롭게 갱신될 경우 destroy() 메소드가 실행됩니다.

------

**필기**

servlet에서 service() 메서드를 따로 지정하지 않으면 알아서 부모 메소드인 HttpServlet의 service 메소드가 상속되어 불려온다.

- service(request, response) 메소드
  1. HttpServlet의 service메소드는 템플릿 메소드 패턴으로 구현
     - 클라이언트의 요청이 GET일 경우에는 자신이 가지고 있는 doGet(request, response) 메소드를 호출
     - 클라이언트의 요청이 Post일 경우에는 자신이 가지고 있는 doPost(request, response) 메소드를 호출

- 실습
  1. service(request, response) 메소드 주석처리
  2. HttpServlet의 doGet(request, response) 메소드 오버라이딩
  3. HttpServlet의 doPost(request, response) 메소드 오버라이딩

 

------

**실습코드**

LifecycleServlet.java

```java
package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성!!");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init test 호출!!");
	}

	
	public void destroy() {
		System.out.println("destroy 호출!!");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstweb/LifecycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service 호출!!");
//	}
//	
	

}
```

 

**service(request, response) 메소드**

HttpServlet의 service메소드는 템플릿 메소드 패턴으로 구현합니다.

- 클라이언트의 요청이 GET일 경우에는 자신이 가지고 있는 doGet(request, response)메소드를 호출
- 클라이언트의 요청이 Post일 경우에는 자신이 가지고 있는 doPost(request, response)를 호출


**LifecycleServlet 수정 실습**

- Service(request, response)메소드 주석처리
- HttpServlet의 doGet(request, response)메소드 오버라이딩
- HttpServlet의 doPost(request, response)메소드 오버라이딩

 

------

**참고 자료**

[**[참고링크\] 템플릿 메소드 패턴**http://jdm.kr](http://jdm.kr/blog/116)