

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
 * Servlet implementation class Bus
 */
@WebServlet("/Bus")
public class Bus extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bus() 
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
		String hto = request.getParameter("hto");
		String brn = request.getParameter("brn");
		String pdp = request.getParameter("pdp");
		String bfs = request.getParameter("bfs");
		
		
	
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into bus values (?,?,?,?)");
			stmt.setString(1,hto);
			stmt.setString(2,brn);
			stmt.setString(3,pdp);
			stmt.setString(4,bfs);
			stmt.executeUpdate();
			con.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
     
		response.sendRedirect("fees.html");

	}

}
