package javaTools.draw;
import java.awt.*;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
    /**
	 *<b><u>+ Designs: +</u></b><br>
	 *<p>
	 *- <i><b>Grid</b>:  Draws a 10px10p-Square Grid + 100p Marker</i><br>
	 *- <i><b>Clear</b>: Fills the Background <b>WHITE</b></i><br>
	 *- <i><b>Frame</b>: Adds a Gray Frame around the Window</i>
	 *</p>
	 */
    public static void fillBackground(Graphics stift, String Design, int frame_x, int frame_y) 
    {
    	if (Design.equals("Grid"))
    	{
    		for (int x = 10; x <= frame_x; x = x + 10) 
    		{
    			if (x % 100 == 0) stift.setColor(Color.BLACK);;   // Collumn creation
    			stift.drawLine(x, 0, x, frame_y);
    			stift.setColor(Color.LIGHT_GRAY);
    		}
    		for (int y = 40; y <=frame_y; y = y + 10)
    		{
    			if (y % 100 == 0) stift.setColor(Color.BLACK);;  //  Row creation
    			stift.drawLine(0, y, frame_x, y);
    			stift.setColor(Color.LIGHT_GRAY);
    		}
    		return;
    	}
    	if (Design.equals("Clear")) 
    	{
    		stift.setColor(Color.WHITE);
    		stift.fillRect(0, 0, frame_x, frame_y); // clear
    		return;
    	}
    	if (Design.equals("Frame")) 
    	{
    		int Outer_x[] = {0, frame_x, frame_x, 0, 0, 40, 40, frame_x-40, frame_x-40, 40};  // Frame Nodes
    		int Outer_y[] = {0, 0, frame_y, frame_y, 0, 65, frame_y-45, frame_y-45, 65, 65};

    		stift.setColor(Color.GRAY);
    		stift.fillPolygon(Outer_x, Outer_y, Outer_x.length); // Frame creation
    		return;
    	}
    }
}
