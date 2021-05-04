<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<String> list = new ArrayList<>();
	list.add("Hello");
	list.add("World");
	list.add("!!!!");
	
	request.setAttribute("list", list);
%>
<c:set var="n" scope="request" value="10"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="item">
	${item }<br>
</c:forEach>
<br>

<c:forEach items="${list }" var="item" begin="1">
	${item }<br>
</c:forEach>

<br>

<c:forEach items="${list }" var="item" begin="1" end="1">
	${item }<br>
</c:forEach>
</body>
</html>