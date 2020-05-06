package power.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PowerDemo2 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1 style='color:green'>You don't need to know what is happening, or exactly where it is all going..Something big is surely on your way !!</h1>");
	}

}
