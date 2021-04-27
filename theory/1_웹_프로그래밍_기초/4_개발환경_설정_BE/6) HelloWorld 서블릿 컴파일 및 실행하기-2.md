# 6) HelloWorld 서블릿 컴파일 및 실행하기-2

**들어가기 전에**

모든 프로그램의 시작은 "Hello World" 를 한 번 출력해 보는거 아시죠?

이번 학습에서는 편안한 마음으로 따라 하면서 Hello World를 한 번 출력해봄으로써 내가 웹개발을 할 수 있는 준비가 다 되었구나 정도만 느끼면 좋을것 같습니다.



 

------

**학습 목표**

  \1. 자바 웹 어플리케이션을 작성할 수 있습니다.



 

------

**핵심 개념**

- 자바 웹 어플리케이션
- HttpServlet
- Dynamic Web Project

 

**학습하기**

**URL 주소**

http://localhost:8080/{프로젝트이름}/{URL Mapping값}

http://localhost:8080/firstweb/HelloServlet

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
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello World</h1>");
	}

}
 
```



------

**생각해보기**

1. 어떤 과정을 거쳐서 브라우져에 'Hello World' 가 출력될까요?

[ ![img](https://cphinf.pstatic.net/mooc/20191203_178/1575304993554juBn0_PNG/wciFTTs4Kowf39Ag66cO.png?type=ffn199_148)**<강좌 추천> 예비 개발자의 좋은 시작, [부스트코스 : 웹 UI 개발\]**https://www.edwith.org부스트코스는 NAVER 계열사 등과 함께 만들어가는 현장 중심 온라인 교육 프로그램입니다.
현업 전문가들이 고민하여 만들고 1:1 코드리뷰도 받을 수 있는 부스트코스에서 기업이 원하는 유능한 개발자로 boost하세요!](https://www.edwith.org/boostcourse-ui)