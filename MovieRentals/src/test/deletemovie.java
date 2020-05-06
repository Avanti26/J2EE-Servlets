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

@WebServlet("/deletemovielink")
public class deletemovie extends HttpServlet
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
		String movie=req.getParameter("moviename");
		
		PreparedStatement pstmt=null;
		
		String query="delete from movie_rentals where movie=?";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, movie);
			
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			
			pw.print("<h1 style='color:red'>"+count+" REMOVED FROM MOVIE RENTALS</h1>");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
