<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello~~
<%-- service Lifecycle 에서 실행 --%>
<%
	System.out.print("jspService()");
%>

<%-- init Lifecycle 에서 실행 --%>
<%!
	public void jspInit(){
		System.out.println("jspInit()");
	}
%>

<%-- destroy Lifecycle 에서 실행 --%>
<%!
	public void jspDestroy(){
		System.out.println("jspdestroy()");
	}
%>
</body>
</html>