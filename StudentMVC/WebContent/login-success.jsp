<%@page import="model.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="model.LoginBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
	<style type="text/css">
		body 
		{
			background-color: black;
		}
	</style>
</head>
<body>
	<h1 style='color:lightgreen'>YOU ARE SUCCESSFULLY LOGGED IN!</h1>
	
	<%
		LoginBean bean=(LoginBean)request.getAttribute("bean");	
	%>
	<h2 style='color:orange'>Welcome, <%=bean.getName() %></h2>
</body>
</html>