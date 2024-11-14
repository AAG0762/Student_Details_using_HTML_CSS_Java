

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
 * Servlet implementation class details
 */
@WebServlet("/details")
public class details extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() 
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
		String snm = request.getParameter("snm");
		String mail = request.getParameter("mail");
		String htn = request.getParameter("htn");
		String psw = request.getParameter("psw");
		
	
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into details values (?,?,?,?)");
			stmt.setString(1,snm);
			stmt.setString(2,mail);
			stmt.setString(3,htn);
			stmt.setString(4,psw);	
			stmt.executeUpdate();
			con.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
     
		response.sendRedirect("branch.html");
	}

}
