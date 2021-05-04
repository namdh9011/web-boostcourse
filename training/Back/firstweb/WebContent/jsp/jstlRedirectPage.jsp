<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:import url="http://localhost:8080/firstweb/jsp/jstlValue.jsp" var="urlValue" scope="request"></c:import> --%>
<c:import url="http://www.google.co.kr" var="urlValue" scope="request"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${urlValue }
</body>
</html>