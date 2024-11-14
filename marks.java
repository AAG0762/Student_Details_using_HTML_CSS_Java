

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
 * Servlet implementation class marks
 */
@WebServlet("/marks")
public class marks extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public marks() 
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
		String fsm = request.getParameter("fsm");
		String ssm = request.getParameter("ssm");
		String tsm = request.getParameter("tsm");
		String fosm = request.getParameter("fosm");
		String fism = request.getParameter("fism");
		String sism = request.getParameter("sism");
		String sesm = request.getParameter("sesm");
		String esm = request.getParameter("esm");

		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into marks values (?,?,?,?,?,?,?,?)");
			stmt.setString(1,fsm);
			stmt.setString(2,ssm);
			stmt.setString(3,tsm);
			stmt.setString(4,fosm);
			stmt.setString(5,fism);
			stmt.setString(6,sism);
			stmt.setString(7,sesm);
			stmt.setString(8,esm);
			stmt.executeUpdate();
			con.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
     
		response.sendRedirect("bus.html");
	}

}
