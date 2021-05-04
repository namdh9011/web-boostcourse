<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setAttribute("scope", 83);
%>
<c:set var="n" scope="request" value="10"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${scope >= 90 }">
	A학점입니다.
	</c:when>
	<c:when test="${scope >= 80 }">
	B학점입니다.
	</c:when>
	<c:when test="${scope >= 70 }">
	C학점입니다.
	</c:when>
	<c:when test="${scope >= 60 }">
	D학점입니다.
	</c:when>
	<c:otherwise>
	F학점입니다.
	</c:otherwise>
</c:choose>
</body>
</html>