# 3) Servlet 라이프 싸이클-1

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

1. firstweb 프로젝트에 LifecycleServlet 생성.
2. init, service, destroy 메소드 체크
3. 코드 작성해서 실행하면 콘솔에 출력 됨.
4. 새로고침 눌러보면 service 호출.
5. 코드를 중간에 바꾸면 destroy 호출 됨.
6. 새로고침하면 새로 메모리에 올라가므로 메소드 다시 호출됨.



**LifecycleServlet**

HttpServlet의 3가지 메소드를 오버라이딩

- init()
- service(request, response)
- destroy()



 

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
       {
		System.out.println("service호출!!");		
	}
	
}

```





------

**참고 자료**

[**[참고링크\] 템플릿 메소드 패턴**http://jdm.kr](http://jdm.kr/blog/116)