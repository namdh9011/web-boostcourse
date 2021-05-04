# 2) JSTL(JSP Standard Tag Library)-1

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

- firstweb>Webcontent>jsp>jstl01.jsp
- WEB-INF>lib 에 파일 추가

**JSTL이란?**

- JSTL(JSP Standard Tag Library)은 JSP 페이지에서 조건문 처리, 반복문 처리 등을 html tag형태로 작성할 수 있게 도와줍니다.

![2_1](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_1.png)

- **jstl이란**

**JSTL을 사용하려면?**

- http://tomcat.apache.org/download-taglibs.cgi
- 위의 사이트에서 3가지 jar파일을 다운로드 한 후 WEB-INF/lib/ 폴더에 복사를 한다.

![2_2](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_2.png)

- **jstl을 사용하려면**

**JSTL이 제공하는 태그의 종류**

![2_3](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_3.png)

- **jstl이 제공하는 태그의 종류**

**코어 태그**

![2_4](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_4.png)

- **jstl 코어태그**

**코어 태그: 변수 지원 태그 - set, remove**



![2_5](https://github.com/namdh9011/web-boostcourse/blob/master/theory/2_DB_%EC%97%B0%EA%B2%B0_%EC%9B%B9_%EC%95%B1/6_JSTL_EL_BE/image/2_5.png)

- **변수 지원 태그**

**실습코드**

jstl01.jsp

set, remove의 활용

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="value1" scope="request" value="kang"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

성 : ${value1} <br>

<c:remove var="value1" scope="request"/>

성 : ${value1 }
</body>
</html>
```

**
**

------

**참고 자료**

[ ![img](https://cphinf.pstatic.net/mooc/20180130_183/151729382379827MW5_JPEG/CtgvK1xoWQqWKyALhO6q.pdf.jpg?type=mfullfill_199_148)**[참고링크\] jstl-quick-reference.pdf**http://cs.roosevelt.edu](http://cs.roosevelt.edu/eric/books/JSP/jstl-quick-reference.pdf)