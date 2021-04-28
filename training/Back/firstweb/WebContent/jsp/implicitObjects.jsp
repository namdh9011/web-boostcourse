<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//request 선언한 적 없는데 어떻게 사용가능??
	//request나 out 같은 내장객체가 존재
	StringBuffer url = request.getRequestURL();

	out.print("url :" + url.toString());
	out.print("<br>");
%>
</body>
</html>