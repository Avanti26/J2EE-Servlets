package power.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PowerDemo3 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1 style='color:purple'>You are highly connected with each soul on this universe. Your purpose to live is to make every soul happy and peaceful.</h1>");
	}

}
