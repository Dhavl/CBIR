

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

/**
 * Servlet implementation class for Servlet: Store
 *
 */
 public class Store extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Store() {
		super();
	}   	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter pw = response.getWriter();
		String path=request.getParameter("datafile").toString();
		JavaWalkBufferedImageTest1 d1=new JavaWalkBufferedImageTest1();
		String color=d1.getPixelcolor(path);
		Double entropy=new Entropy().calculateEntropy(path);
		
		System.out.println("The entropy is "+entropy);
		
		//to store canny edge op
		ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();

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
        Double edgeentropy=new Entropy().calculateEntropy("img1.jpg");
		
		System.out.println("The Edge Detected entropy is "+edgeentropy);
		
		Database d=new Database();
		d.connect();
		//pw.println(path);
		d.store(path,color,entropy,edgeentropy);
		//pw.println("successfully stored");	
		response.sendRedirect("home.jsp?value=Image inserted in Database");
		
		
	}   	  	    
}