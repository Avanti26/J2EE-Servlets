package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextlink")
public class BillCalculation extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		//fetch values from html page
		String current=req.getParameter("current");
		String previous=req.getParameter("previous");
		String type=req.getParameter("customertype");
		
		//parsing
		int currentreading=Integer.parseInt(current);
		int previousreading=Integer.parseInt(previous);
		
		//calculate total reading
		int totalReading=currentreading-previousreading;
		
		//Get the values from attribute (Upcasting/Downcasting)
		double resunit=(double)req.getAttribute("unit1");
		double comunit=(double)req.getAttribute("unit2");
		
		pw.print("<h1>ELECTRICITY BILL DETAILS</h1>");
		
		pw.print("<h1>CURRENT READING: "+currentreading+"</h1>");
		pw.print("<h1>PREVIOUS READING: "+previousreading+"</h1>");
		
		if(type.equals("residential"))
		{
			double totalAmount=totalReading*resunit;
			
			pw.print("<h1>FINAL BILL AMOUNT IS "+totalAmount+"</h1>");
		}
		else if(type.equals("commercial"))
		{
			double totalAmount=totalReading*comunit;
			
			pw.print("<h1>FINAL BILL AMOUNT IS "+totalAmount+"</h1>");
		}
	}
}
