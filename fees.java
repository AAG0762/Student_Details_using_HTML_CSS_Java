

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fees
 */
@WebServlet("/fees")
public class fees extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fees() 
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
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer rank = Integer.parseInt(request.getParameter("rank"));
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement pstmt = con.prepareStatement("insert into srinu values (?, ?, ?)");
			
            	        double amount = 0.0;

            	        if (rank < 1000) 
            	        {
            	           amount = 0;
            	        } 
            	        else if (rank < 5000) 
            	        {
            	        	amount = (133200/100.0)*10.0;
            	        } 
            	        else if (rank < 10000) 
            	        {
            	        	amount = (133200/100.0)*20.0;
            	        } 
            	        else if (rank < 20000) 
            	        {
            	        	amount = (133200/100.0)*40.0; 
            	        } 
            	        else if (rank < 30000) 
            	        {
            	        	amount = (13200/100.0)*70.0; 
            	        } 
            	        else 
            	        {
            	        	amount = 133200.0;
            	        }
            	        
            	        PrintWriter out = response.getWriter();
            	        
            	        // Display results
            	        out.println("\nYear of study: " + year);
            	        out.println("EAMCET RANK : " + rank);
            	        out.println("Total Fees (with tax): rupees" + amount);
            	        
            	        pstmt.setInt(1, year);
            			pstmt.setInt(2, rank);
            			pstmt.setDouble(3, amount);
            	        
            	        // Execute the update
            	        pstmt.executeUpdate();

		}
		catch(Exception e)
		{
		
			e.printStackTrace();
		}
	}

}
