package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaymovie")
public class DisplayMovie extends HttpServlet
{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		ServletContext context=config.getServletContext();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		
		try 
		{
			//step-1 load and register driver
			Class.forName(driver);
			
			//establish connection
			con=DriverManager.getConnection(url, user, password);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from movie_rentals";
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			pw.print("<table border='2'>");
			pw.print("<tr>");
			pw.print("<th>ID</th>");
			pw.print("<th>MOVIE</th>");
			pw.print("<th>RATINGS</th>");
			pw.print("<th>PRICE</th>");
			pw.print("<th>RELEASE DATE</th>");
			pw.print("<th>LANGUAGE</th>");
			pw.print("<tr>");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String movie=rs.getString(2);
				int rating=rs.getInt(3);
				double price=rs.getDouble(4);
				int reldate=rs.getInt(5);
				String language=rs.getString(6);
				
				pw.print("<tr>");
				pw.print("<td>"+id+"</td>");
				pw.print("<td>"+movie+"</td>");
				pw.print("<td>"+rating+"</td>");
				pw.print("<td>"+price+"</td>");
				pw.print("<td>"+reldate+"</td>");
				pw.print("<td>"+language+"</td>");
				pw.print("</tr>");
			}
			pw.print("</table>");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
