

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class address
 */
@WebServlet("/address")
public class address extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public address() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String hno = request.getParameter("hno");
		String stn = request.getParameter("stn");
		String coln = request.getParameter("coln");
		String arn = request.getParameter("arn");
		String cin = request.getParameter("cin");
		String stan = request.getParameter("stan");
		String ctn = request.getParameter("ctn");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into address values (?,?,?,?,?,?,?)");
			stmt.setString(1,hno);
			stmt.setString(2,stn);
			stmt.setString(3,coln);
			stmt.setString(4,arn);
			stmt.setString(5,cin);
			stmt.setString(6,stan);
			stmt.setString(7,ctn);
			stmt.executeUpdate();
			con.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
     
		response.sendRedirect("marks.html");
	}

}
