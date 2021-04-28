# 1) redirect

**들어가기 전에**

게시판 같은 곳에서 글을 작성하는 경우가 있습니다.

글을 모두 작성한 후에 글 작성 버튼을 클릭하겠죠?

이때 클라이언트가 서버에게 글을 작성해주세요 라는 요청을 보내게 됩니다.

서버는 해당 글을 저장한 후, 웹 브라우저에게 글 목록으로 이동하라고 응답을 보내게 됩니다.

웹 브라우저는 글 목록으로 이동하라는 서버의 요청을 받은 후, 자동으로 서버에게 글 목록을 요청하여 응답받아 출력하게 됩니다.

서버가 클라이언트에게 어떤 URL로 이동하라는 요청을 보내는 것을 리다이렉트라고 합니다.

 

 

------

**학습 목표**

1. 리다이렉트를 이해한다. 
2. 리다이렉트를 사용 할 수 있다. 

 

 

------

**핵심 개념**

- HttpServletResponse 
- sendRedirect() 

 

 

------

**학습하기**

**실습**
firstweb>webcontent>jsp>redirect01.jsp
firstweb>webcontent>jsp>redirect02.jsp


**리다이렉트 (redirect)**

- 리다이렉트는 HTTP프로토콜로 정해진 규칙이다.
- 서버는 클라이언트의 요청에 대해 특정 URL로 이동을 요청할 수 있다. 이를 리다이렉트라고 한다.
- 서버는 클라이언트에게 HTTP 상태코드 302로 응답하는데 이때 헤더 내 Location 값에 이동할 URL 을 추가한다. 클라이언트는 리다이렉션 응답을 받게 되면 헤더(Location)에 포함된 URL로 재요청을 보내게 된다. 이때 브라우저의 주소창은 새 URL로 바뀌게 된다..
- 클라이언트는 서버로부터 받은 상태 값이 302이면 Location헤더값으로 재요청을 보내게 된다. 이때 브라우저의 주소창은 전송받은 URL로 바뀌게 된다.
- 서블릿이나 JSP는 리다이렉트하기 위해 HttpServletResponse 클래스의 sendRedirect() 메소드를 사용한다.

 

 

**브라우저에서 리다이렉트 확인**

- 크롬에서 우측버튼을 누르고 검사를 선택한 후 Network탭을 선택한다.
- redirect01.jsp를 실행하면 서버로부터 응답코드로 302를 받는 것을 알 수 있다.

![1_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/4_redirect_forward_BE/image/1_1.png)

- **브라우저에서 리다이렉트 확인**

**예제 동작 설명**

![1_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/4_redirect_forward_BE/image/1_2.png)

- **예제 동작 설명**

------

**실습코드**

- redirect01.jsp, redirect02.jsp 파일을 작성
- 웹 브라우저가 redirect01.jsp을 요청
- redirect01은 redirect02.jsp로 리다이렉팅하는 로직이 실행되도록 함
- 결과 확인

 

redirect01.jsp

```markup
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    response.sendRedirect("redirect02.jsp");
%>    
```

 

redirect02.jsp

```markup
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
redirect된 페이지 입니다.
</body>
</html>
```

 

 

------

**생각해보기**

1. 리다이렉션의 장점과 단점에 대해서 알아봅시다.

 

 

------

**참고 자료**

[**[참고링크\] Servlet Tutorial: sendRedirect method - javatpoint**https://www.javatpoint.com](https://www.javatpoint.com/sendRedirect()-method)

[ ![img](https://cphinf.pstatic.net/mooc/20180312_175/1520844330480c3TJp_PNG/pPHMXmNLt15fNECwGIJj.png?type=mfullfill_199_148)**[참고링크\] HTTP 상태 코드**https://developer.mozilla.org](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)

[**[참고링크\] HTTP Status Code**http://ooz.co.kr](http://ooz.co.kr/260)

[ ![img](https://cphinf.pstatic.net/mooc/20180312_196/1520844417735bQsSX_PNG/fy6AWsRsLfSuBdPajDaC.png?type=mfullfill_199_148)**[참고링크\] Redirections in HTTP**https://developer.mozilla.org](https://developer.mozilla.org/ko/docs/Web/HTTP/Redirections)

[**[참고링크\] URL Shortener and Link Management Platform**https://bitly.com](https://bitly.com/)

[**[참고링크\] Google URL Shortener**https://goo.gl](https://goo.gl/)