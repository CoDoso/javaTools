package javaTools.draw;

import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	private static Random random = new Random();
	public final static String[] design_list = {"Grid", "Clear", "Frame", "Diamond"};
	/**
	 *<b><u>+ Designs: +</u></b><br>
	 *<p>
	 *- <i><b>Grid</b>:  Draws a 10px10p-Square Grid + 100p Marker</i><br>
	 *- <i><b>Clear</b>: Fills the Background <b>WHITE</b></i><br>
	 *- <i><b>Frame</b>: Adds a Gray Frame around the Window</i><br>
	 *- <i><b>Diamond</b>: Adds a Thread Plate Pattern of Diamonds</i>
	 *</p>
	 */
    public static void fillBackground(Graphics curFrame, String Design, int frame_x, int frame_y) 
    {
    	if (Design.equals("Grid"))
    	{
    		for (int x = 10; x <= frame_x; x = x + 10) 
    		{
    			if (x % 100 == 0) curFrame.setColor(Color.BLACK);;   // Collumn creation
    			curFrame.drawLine(x, 0, x, frame_y);
    			curFrame.setColor(Color.LIGHT_GRAY);
    		}
    		for (int y = 40; y <=frame_y; y = y + 10)
    		{
    			if (y % 100 == 0) curFrame.setColor(Color.BLACK);;  //  Row creation
    			curFrame.drawLine(0, y, frame_x, y);
    			curFrame.setColor(Color.LIGHT_GRAY);
    		}
    		return;
    	}
    	if (Design.equals("Clear")) 
    	{
    		curFrame.setColor(Color.WHITE);
    		curFrame.fillRect(0, 0, frame_x, frame_y); // clear
    		return;
    	}
    	if (Design.equals("Frame")) 
    	{
    		int Outer_x[] = {0, frame_x, frame_x, 0, 0, 40, 40, frame_x-40, frame_x-40, 40};  // Frame Nodes
    		int Outer_y[] = {0, 0, frame_y, frame_y, 0, 65, frame_y-45, frame_y-45, 65, 65};

    		curFrame.setColor(Color.GRAY);
    		curFrame.fillPolygon(Outer_x, Outer_y, Outer_x.length); // Frame creation
    		return;
    	}
    	if (Design.equals("Diamond"))
    	{
    		curFrame.setColor(new Color(211, 211, 211));
    		curFrame.fillRect(0, 0, frame_x, frame_y);
    		
    		curFrame.setColor(Color.LIGHT_GRAY);
    		int[] y = {0, 15, 30, 15};
    		for (int Row = 0; Row <= frame_y/30;Row++)
    		{
    			int[] x = {0, 10, 0, -10};
    			for (int Collumn= 0; Collumn <= frame_x/20;Collumn++)
        		{
            		curFrame.fillPolygon(x, y, 4);
            		for (int i = 0; i != x.length;i++)
            			x[i] += 20;
        		}
    			for (int i = 0; i != y.length;i++)
        			y[i] += 30;
    		}
    		return;
    	}
    }
}
