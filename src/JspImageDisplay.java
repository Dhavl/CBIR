

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: JspImageDisplay
 *
 */
 public class JspImageDisplay extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public JspImageDisplay() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null;   
		String id=request.getParameter("id");
	    try
	    {
	 	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}
		catch(Exception e)
		{
			System.out.println("Exception Raised");
			System.out.println(e);
		}
		System.out.println("class instantiated");
      	String sql = "SELECT * FROM `test`.`imagestore` where id="+id;
      	System.out.println(sql);
    	PreparedStatement stmt = null;
    	ResultSet resultSet = null;
		try 
		{
		stmt = conn.prepareStatement(sql);
		resultSet = stmt.executeQuery();
		}
		catch (SQLException e1)
		{	
			System.out.println("got error in prepared statement");
			e1.printStackTrace();
		}
        Blob img;
		try
        {
			response.setContentType("image/jpeg");
			        if(resultSet.next())
		            {
			        img= resultSet.getBlob(3);
		 			byte[] imgData = img.getBytes(1,(int)img.length());
					try {
					  	response.getOutputStream().write(imgData);
					
					  } catch (Exception e) {
						e.printStackTrace();
					}
    				}

    				response.getOutputStream().flush();
			  		response.getOutputStream().close();
			       
		}
		catch(Exception e)
		{
		System.out.println("got the fault");
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  	    
}