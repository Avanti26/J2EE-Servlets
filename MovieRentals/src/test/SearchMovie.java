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

@WebServlet("/searchmovielink")
public class SearchMovie extends HttpServlet
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
			
			//step-2 establish connection
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
		//fetch the rating from html page
		String ratings=req.getParameter("movierating");
		
		//parsing
		int rating=Integer.parseInt(ratings);
		
		//declare resources
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		//sql query
		String query="select id,movie,price,released_date,language from movie_rentals where ratings=?";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, rating);
			
			rs=pstmt.executeQuery();
			
			pw.print("<table border='2'>");
			pw.print("<tr>");
			pw.print("<th>MOVIE</th>");
			pw.print("<th>PRICE</th>");
			pw.print("<th>RELEASE DATE</th>");
			pw.print("<th>LANGUAGE</th>");
			pw.print("</tr>");
			while(rs.next())
			{
				String movie=rs.getString("movie");
				double price=rs.getDouble("price");
				int reldate=rs.getInt("released_date");
				String language=rs.getString("language");
				
				pw.print("<tr>");
				pw.print("<td>"+movie+"</td>");
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
