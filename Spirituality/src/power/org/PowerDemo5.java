package power.org;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PowerDemo5 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1 style='color:lightblue'>Just go out and live peacefully..listen,, understand,, respect,,love,,accept them who they are..Everyone will connect automatically</h1>");
	}

}
