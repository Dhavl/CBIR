import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JavaWalkBufferedImageTest1 extends Component {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1156180866775904608L;

	int red=0,green=0,blue=0;
	public String printPixelARGB(int pixel) {
	String color=null;
   
    red += ((pixel >> 16) & 0xff);
    green += ((pixel >> 8) & 0xff);
    blue += ((pixel) & 0xff);
    if(red>green&&red>blue)
    	color="red";
    else if(green>blue)
    	color="green";
    else
    	color="blue";
    return color;
  }

  private String marchThroughImage(BufferedImage image) {
	  String color = null;
    int w = image.getWidth();
    int h = image.getHeight();
    //System.out.println("width, height: " + w + ", " + h);

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        //System.out.println("x,y: " + j + ", " + i);
        int pixel = image.getRGB(j, i);
        color=printPixelARGB(pixel);
        //System.out.println("");
      }
    }
    return color;
  }

  String getPixelcolor(String path) {
	  String color = null;
    try {
      BufferedImage image = ImageIO.read(new File(path));
      color=marchThroughImage(image);
    } 
    catch (IOException e) 
    {
    	 System.out.println("call came to exception");
      System.err.println(e.getMessage());
    }
    System.out.println( red + ", " + green + ", " + blue);
	return color;
  }

  /*public static void main(String[] foo) {
	  JavaWalkBufferedImageTest1 d=new JavaWalkBufferedImageTest1();
	 
    }*/

}
