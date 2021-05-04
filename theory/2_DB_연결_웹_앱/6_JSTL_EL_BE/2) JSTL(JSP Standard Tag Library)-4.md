# 2) JSTL(JSP Standard Tag Library)-4

**들어가기 전에**

프론트 개발자가 JSP를 수정하는데, JSP 안에 자바코드와 HTML코드가 섞여 있다면 수정할 때 굉장히 어려움을 느끼게 될 가능성이 큽니다.

이런 문제를 해결하기 위해서 등장한 것이 JSTL입니다.

JSTL을 이용하면 태그형식으로 조건문, 반복문 등을 사용할 수 있습니다.

그리고, 앞에서 배운 EL과 연동하면 더욱 강력하게 사용 가능합니다. 

이번 시간엔 이러한 JSTL에 대해서 알아보도록 하겠습니다.

 



------

**학습 목표**

1. JSTL을 이해한다.
2. JSTL을 사용할 수 있다. 

 



------

**핵심 개념**

- JSTL
- core tag





------

**학습하기**
**실습**

- firstweb>Webcontent>jsp>jstl06.jsp
- firstweb>Webcontent>jsp>jstl07.jsp
- firstweb>Webcontent>jsp>jstlRedirectPage.jsp
**코어 태그: 흐름제어태그 - redirect**

![2_11](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_11.png)

- **흐름제어태그 redirect**

**실습코드**

jtl06.jsp

redirect의 활용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:redirect url="jstlRedirectPage.jsp"></c:redirect>
```



jstlRedirectPage.jsp

redirect의 활용

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
<h1> redirect된 화면입니다.</h1>
</body>
</html>
```



**코어 태그: 기타태그 - out**

![2_12](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_12.png)

- **흐름제어태그 choose**

**코드실습**

jstl07.jsp

out의 활용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>" />
${t}
<c:out value="${t}" escapeXml="true" />
<c:out value="${t}" escapeXml="false" />
</body>
</html>
```

 

 

------

**생각해보기**

1. JSTL의 태그는 XML태그 문법을 사용합니다. 그래서 반드시 태그가 닫히거나 '/>'로 끝나야 합니다. JSP가 제공하는 문법 중 사용자 정의 태그라는 것을 통해 만들어졌기 때문입니다. 이번 시간엔 JSTL의 core태그에 대해서 살펴봤는데요. 그 외의 태그들에는 어떤 게 있는지 찾아보고, 왜 그러한 태그가 필요한지 생각해보세요.

 

 

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180130_183/151729382379827MW5_JPEG/CtgvK1xoWQqWKyALhO6q.pdf.jpg?type=mfullfill_199_148)**[참고링크\] jstl-quick-reference.pdf**http://cs.roosevelt.edu](http://cs.roosevelt.edu/eric/books/JSP/jstl-quick-reference.pdf)