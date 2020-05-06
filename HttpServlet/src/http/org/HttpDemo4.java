package http.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo4 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		if(user.equals("admin") && pass.equals("123"))
		{
			pw.print("<h1 style='color:green'>LOGIN SUCCESSFUL</h1>");
		}
		else
		{
			pw.print("<h1 style='color:red'>INVALID LOGIN CREDENTIALS</h1>");
		}
		
	}
}
