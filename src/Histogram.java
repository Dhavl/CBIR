

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
class Histogram extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
    int iw,ih;
    int pixels[];
    int w,h;
    int his[]=new int[256];
    int max_his=0;


	int[] histogram(String file)
    {
		System.out.println("Calculating histogram of the image file=>"+file);
            try
         {
             Image img=Toolkit.getDefaultToolkit().getImage(file);
           
            Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
            //img=file;         
            MediaTracker t=new MediaTracker(this);
            t.addImage(img,0);
            //setResizable(false);
            t.waitForID(0);
            h=(int)d.getHeight();
            w=(int)d.getWidth();
            iw=img.getWidth(null);
            ih=img.getHeight(null);
            pixels=new int[iw*ih];
            PixelGrabber pg=new PixelGrabber(img,0,0,iw,ih,pixels,0,iw);
            pg.grabPixels();
        }
        catch(Exception e)
        {
        }

        for(int i=0;i<iw*ih;i++)
        {
            int p=pixels[i];
            int r=0xff & (p>>16);
            int g=0xff & (p>>8);
            int b=0xff & (p);
            int y=(int) (.33*r+.56*g+.11*b);
            his[y]++;
        }

        for(int i=0;i<256;i++)
        {
            if (his[i]>max_his)
            max_his=his[i];
        }
		return his;
    }

}