<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GET AREA OF CIRCLE</title>
</head>
<body>
	<%--FETCH THE VALUE FROM HTML --%>
	<%
		String var=request.getParameter("radius");
	
		double rad=Double.parseDouble(var);
		
	%>
	<h1 style='color:green'>AREA OF CIRCLE IS <%=3.14*rad*rad %></h1>
</body>
</html>