import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: RetrieveServletByTexture
 *
 */
 public class RetrieveServletByTexture extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public RetrieveServletByTexture() {
		super();
	}   	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String filepath=request.getParameter("texture");
		System.out.println("The path is"+filepath);
		Double entVal=new Entropy().calculateEntropy(filepath);
		System.out.println("The entropy value is "+entVal);
		Double lower=entVal-0.4;
		Double higher=entVal+0.4;
		String sql="SELECT * FROM `test`.`imagestore`WHERE entropy BETWEEN "+entVal+" AND "+higher+" OR entropy BETWEEN "+entVal+" AND "+lower;
		Connection conn = null;   
	    try
	    {
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
				} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}
		catch(Exception e)
		{
			System.out.println("Exception Raised");
			System.out.println(e);
		}
		System.out.println("class instantiated");
      
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
        //Blob img;
		String data="";
		try
        {
			System.out.println("Result Set has "+resultSet);
			        while(resultSet.next())
		            {
			        	data+="<a href=\"/FinalCBIR/JspImageDisplay?id="+resultSet.getInt(1)+"\" >";
				        data+="<img src=\"/FinalCBIR/JspImageDisplay?id="+resultSet.getInt(1)+"\" width=\"200\" height=\"120\" /></a>";
				        //data+="&nbsp;&nbsp;&nbsp;";
			        }

			        System.out.println(data);
    				response.getWriter().write(data);
		}
		catch(Exception e)
		{
		System.out.println("got the fault");
		}
		
	}   	  	  
}