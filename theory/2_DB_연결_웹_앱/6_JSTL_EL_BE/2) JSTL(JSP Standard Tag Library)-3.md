# 2) JSTL(JSP Standard Tag Library)-3

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

- firstweb>Webcontent>jsp>jstl04.jsp
- firstweb>Webcontent>jsp>jstl05.jsp
- firstweb>Webcontent>jsp>jstlValue.jsp

**코어 태그: 흐름제어 태그 - forEach**

![2_9](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_9.png)

- **흐름제어태그 forEach**

**실습코드**

jstl04.jsp

forEach의 활용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.*" %>
<%
    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("!!!");
    request.setAttribute("list", list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list}" var="item">
${item } <br>
</c:forEach>
</body>
</html>
```



**코어 태그: 흐름제어태그 - import**

![2_10](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_10.png)

- **흐름제어태그 import**

**실습코드**

jstlValue.jsp

import의 활용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Kang kyungmi
```

jstl05.jsp

import의 활용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.*" %>
<c:import url="http://localhost:8080/webapp/jstlValue.jsp" var="urlValue" scope="request"></c:import>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
읽어들인 값 : ${urlValue}
</body>
</html>
```

**
**

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180130_183/151729382379827MW5_JPEG/CtgvK1xoWQqWKyALhO6q.pdf.jpg?type=mfullfill_199_148)**[참고링크\] jstl-quick-reference.pdf**http://cs.roosevelt.edu](http://cs.roosevelt.edu/eric/books/JSP/jstl-quick-reference.pdf)