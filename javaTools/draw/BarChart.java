package javaTools.draw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javaTools.generate.RGBColor;


@SuppressWarnings("serial")
public class BarChart extends JFrame {
    
	private int[] data;
	private String background = null;
	/** <b><u>+ Draw a Bar-Chart of your Data! +</u></b><br>
	 *@param data ( int[] ) The Data that you want to be visualized !
	 */
	public BarChart(int[] data) 
	{
	this.data = data;
        if (data.length <= 8) 
        {
        setSize(500, 500);
        setLocation(1000, 300); 
        } else {
        	setSize(500+(40*data.length), 500);
            setLocation(1000-(20*data.length), 300);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BarChart");
        setVisible(true);
        getContentPane().setBackground(new Color(255,255,255));
    }
public void addBackground(String Design) 
    {
    	for (String design :Window.design_list)
    		if (design.equals(Design))
        	{
        		background = Design;
            	repaint();
            	break;
        	}
    }
    public void paint(Graphics barChartFrame)
    {
    	super.paint(barChartFrame);
    	if (background != null)
        	Window.fillBackground(barChartFrame, background, getSize().width, 500);
    	{   // Value Display Bars
    		barChartFrame.setColor(Color.BLACK);
        	barChartFrame.fillRect(25, 450, ((data.length)*50)+45, 27);
        	barChartFrame.fillRect(18, 75, 27, 403);
        	barChartFrame.setColor(Color.WHITE);
        	int[] x = {18, 45, 45, (data.length)*50+70, (data.length)*50+70, 18};
        	int[] y = {75, 75, 450, 450, 477, 477};
        	barChartFrame.drawPolygon(x, y, 6);
    	}
    	// Side Bar Display
    	int num = 14;
    	for (int y = 100; y != 475; y+=25)
    	{
    		barChartFrame.setColor(Color.BLACK);
    		barChartFrame.drawLine(50, y, 35, y);
    		barChartFrame.setColor(Color.WHITE);
    		barChartFrame.drawString(num+"", 25, y+5);
    		num -= 1;
    	}
    	// Pillars
    	int i = 0;
    	for (int x = 70; i != data.length;x += 50)
    	{
    		barChartFrame.setColor(RGBColor.get_random());
    		barChartFrame.fillRect(x, (450 - (data[i] * 25)), 30, (data[i] * 25)+1);
    		barChartFrame.setColor(Color.BLACK);
    		barChartFrame.drawRect(x, (450 - (data[i] * 25)), 30, (data[i] * 25)+1);
    		barChartFrame.setColor(Color.WHITE);
    		barChartFrame.drawString(data[i]+"", x +12, 470);
    		i++;
    	}
    }
}
