# 2) Servlet 작성 방법-2

**들어가기 전에**

현재 프로젝트에서 웹을 개발할 때 서블릿을 직접 써서 개발하지는 않습니다.

조금 더 편하게 사용할 수 있게 도와주는 다양한 프레임워크를 사용해서 개발하는 경우가 더 많습니다.

하지만, 그 프레임워크들도 서블릿이 없이는 동작할 수 없기 때문에 서블릿의 기본적인 작성법이나, 서블릿의
라이프 사이클을 이해하고 있다면 웹의 동작을 이해하는 데 많은 도움이 됩니다.



 

------

**학습 목표**

1. 서블릿을 작성할 수 있습니다.
2. 서블릿 버전에 따른 web.xml을 적절하게 작성할 수 있습니다.



 

------

**핵심 개념**

- HttpServlet
- web.xml



 

------

**학습하기**

**Servlet 3.0 spec 이상에서 사용하는 방법**

Servlet3.1 spec으로 exam31이라는 프로젝트를 생성해서 실습.

프로젝트 생성시 Dynamic web module version을 3.1로 해준다.

web.xml 생성에 체크 하지 않는다.

class name은 TenServlet로 해주고 URL mappings을 /ten으로 바꾼다.

servlet위에 어노테이션이 생김.



web 3.0 이상의 버전은 web.xml 파일 없이 어노테이션을 통해서 주소를 설정 할 수 있다.

servlet의 경우 그렇지만 Springframework 같은 큰 범위의 프로젝트를 할때는 web.xml 파일이 필요할 경우도 생기기 때문에  web.xml 파일을 생성해준다.

**실습코드**

TenServlet.java

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
 * Servlet implementation class TenServlet
 */
@WebServlet("/ten")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>1부터 10까지 출력합니다.<h1>");
		for(int i = 1; i<=10; i++) {
			out.print(i+"<br>");
		}
		out.close();
	}

}
```

 

 



 

------



[ ![img](https://cphinf.pstatic.net/mooc/20191203_6/1575304675591vXQd7_PNG/6LeVHS5O6y7fYwKJ8tw7.png?type=ffn199_148)**<강좌 추천> 예비 개발자의 좋은 시작, [부스트코스 : 웹 UI 개발\]**https://www.edwith.org부스트코스는 NAVER 계열사 등과 함께 만들어가는 현장 중심 온라인 교육 프로그램입니다.
현업 전문가들이 고민하여 만들고 1:1 코드리뷰도 받을 수 있는 부스트코스에서 기업이 원하는 유능한 개발자로 boost하세요!](https://www.edwith.org/boostcourse-ui)