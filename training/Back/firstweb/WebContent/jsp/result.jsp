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
	int v1 = (int)request.getAttribute("v1");
	int v2 = (int)request.getAttribute("v2");
	int result = (int)request.getAttribute("result");

%>
<%=v1 %> + <%=v2 %> = <%=result %>

<%-- 이렇게 servlet으로 변하는 코드가 계속 나오는게 안좋아서 el이나 jstl 같은 것이 나오게됨. --%>
${v1 } + ${v2 } = ${result }

</body>
</html>