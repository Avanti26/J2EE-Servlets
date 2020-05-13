<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Odd No</title>
</head>
<body>
	<h1>ODD NUMBERS</h1>
	<h2><%
		String lower=request.getParameter("lower");
		String upper=request.getParameter("upper");
		
		int n1=Integer.parseInt(lower);
		int n2=Integer.parseInt(upper);
		
		for(int i=n1;i<=n2;i++)
		{
			if(i%2!=0)
			{
				out.print(i+"<br>");
			}
		}
	%></h2>
</body>
</html>