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

@WebServlet("/addmovielink")
public class AddMovie extends HttpServlet
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
			//load and register driver
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the values from html page
		String moviename=req.getParameter("moviename");
		String movierating=req.getParameter("movierating");
		String movieprice=req.getParameter("movieprice");
		String releaseddate=req.getParameter("releaseddate");
		String movielanguage=req.getParameter("movielanguage");
		
		//parsing
		int rating=Integer.parseInt(movierating);
		double price=Double.parseDouble(movieprice);
		int reldate=Integer.parseInt(releaseddate);
		
		PreparedStatement pstmt=null;
		
		String query="insert into movie_rentals values(?,?,?,?,?,?)";
		
		try 
		{
			//create platform
			pstmt=con.prepareStatement(query);
			
			//set the values for placeholders
			pstmt.setInt(1, 0);
			pstmt.setString(2, moviename);
			pstmt.setInt(3, rating);
			pstmt.setDouble(4, price);
			pstmt.setInt(5, reldate);
			pstmt.setString(6, movielanguage);
			
			//execute sql query
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			
			pw.print("<h1 style='color:green'>"+count+" MOVIE ADDED SUCCESSFULLY</h1>");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
