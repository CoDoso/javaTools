package javaTools.draw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javaTools.generate.RGBColor;


@SuppressWarnings("serial")
public class BarChart extends JFrame {
    
	private int[] data;
	/** <b><u>+ Draw a Bar-Chart of your Data! +</u></b><br>
	 *@param data ( int[] ) The Data that you want to be visualized !
	 */
	public BarChart(int[] data) 
	{
        this.data = data;
        setSize(500, 500);
        setLocation(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BarChart");
        setVisible(true);
        getContentPane().setBackground(new Color(255,255,255));
    }
    public void paint(Graphics stift)
    {
    	super.paint(stift);
    	stift.setColor(Color.BLACK);
    	stift.fillRect(25, 450, ((data.length)*50)+45, 27);
    	stift.drawRect(25, 75, ((data.length)*50)+45, 15*25+27);
    	stift.fillRect(18, 75, 27, 403);
    	
    	int num = 14;
    	for (int y = 100; y != 475; y+=25)
    	{
    		stift.setColor(Color.BLACK);
    		stift.drawLine(50, y, 35, y);
    		stift.setColor(Color.WHITE);
    		stift.drawString(num+"", 25, y+5);
    		num -= 1;
    	}
    	int i = 0;
    	for (int x = 70; i != data.length;x += 50)
    	{
    		stift.setColor(RGBColor.get_random());
    		stift.fillRect(x, (450 - (data[i] * 25)), 30, (data[i] * 25)+1);
        	stift.setColor(Color.WHITE);
    		stift.drawString(data[i]+"", x +12, 470);
    		i++;
    	}
    	stift.setColor(Color.WHITE);
    	int x[] = {18, 50, 50, (data.length)*50+70, (data.length)*50+70, 18};
    	int y[] = {75, 75, 450, 450, 477, 477};
    	stift.drawPolygon(x, y, 6);
    }
}
