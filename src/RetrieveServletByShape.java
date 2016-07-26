import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

/**
 * Servlet implementation class for Servlet: RetrieveServletByTexture
 *
 */
 public class RetrieveServletByShape extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public RetrieveServletByShape() {
		super();
	}   	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Retrieval by shape");
		String filepath=request.getParameter("shape1");
		System.out.println("The path is"+filepath);
		ImageIcon icon = new ImageIcon(filepath);
        Image image = icon.getImage();
        System.out.println(image.getHeight(null));

        // Create empty BufferedImage, sized to Image
        BufferedImage frame =
                new BufferedImage(
                        image.getWidth(null),
                        image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );

        // Draw Image into BufferedImage
        Graphics g = frame.getGraphics();
        g.drawImage(image, 0, 0, null);

        //create the detector
        CannyEdgeDetector detector = new CannyEdgeDetector();
        //adjust its parameters as desired
       // detector.setLowThreshold(0.5f);
       // detector.setHighThreshold(1f);//apply it to an image
        detector.setGaussianKernelRadius(1.75f);
        detector.setGaussianKernelWidth(32);
        detector.setSourceImage(frame);
        detector.process();
        BufferedImage edges = detector.getEdgesImage();
        try {
			ImageIO.write(edges, "jpg", new File("img1.jpg"));
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Double entVal=new Entropy().calculateEntropy("img1.jpg");
		
		System.out.println("The Edge Detected entropy is "+entVal);
		
		Double lower=entVal-0.001;
		Double higher=entVal+0.001;
		String sql="SELECT * FROM `test`.`imagestore`WHERE shape BETWEEN "+entVal+" AND "+higher+" OR entropy BETWEEN "+entVal+" AND "+lower;
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
		System.out.println("Class Instantiated..");
      
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
			System.out.println("Got error in prepared statement");	
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
				        data+="<img src=\"/FinalCBIR/JspImageDisplay?id="+resultSet.getInt(1)+"\" width=\"160\" height=\"130\" /></a>";
				        //data+="&nbsp;&nbsp;&nbsp;";
			        }

			        System.out.println(data);
    				response.getWriter().write(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		System.out.println("Got the Exception");
		}
	}   	  	  
}