<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TAXI FARE</title>
<style type="text/css">
	#amt
	{
		color:white;
		background-color: teal;
		padding: 20px;
		border:5px solid teal;
	}
</style>
</head>
<body>
	<%
		double basicAmount=(double)request.getAttribute("fareamount");
		int waitingAmount=(int)request.getAttribute("waitingcharge");
	%>
	
	<h1>BASIC FARE AMOUNT <%=basicAmount %></h1>
	
	<h1>WAITING CHARGES <%=waitingAmount %></h1>
	
	<h1 id="amt">TOTAL AMOUNT <%=(basicAmount+waitingAmount) %></h1>
</body>
</html>