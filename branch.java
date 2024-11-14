

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
 * Servlet implementation class branch
 */
@WebServlet("/branch")
public class branch extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public branch() 
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
		String bnm = request.getParameter("bnm");
		String bid = request.getParameter("bid");
		String brn = request.getParameter("brn");
		String bhod = request.getParameter("bhod");
		
	
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into branch values (?,?,?,?)");
			stmt.setString(1,bnm);
			stmt.setString(2,bid);
			stmt.setString(3,brn);
			stmt.setString(4,bhod);
			stmt.executeUpdate();
			con.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
     
		response.sendRedirect("address.html");
	}

}
