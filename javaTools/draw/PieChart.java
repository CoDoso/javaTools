package javaTools.draw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javaTools.generate.RGBColor;
import javaTools.draw.Window;

@SuppressWarnings({ "serial", "unused" })
public class PieChart extends JFrame {
    
    private int[] data;
    private String background;
	/** <b><u>+ Draw a Pie-Chart of your Data! +</u></b><br>
	 *@param data ( int[] ) The Data that you want to be visualized !
	 */
    public PieChart(int[] data) {
        this.data = data;
        this.background = null;
        setSize(500, 600);
        setLocation(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PieChart");
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
        	};
    }
    @Override
    public void paint(Graphics pieChartFrame) {
        super.paint(pieChartFrame);
        int slice_start = 0;
        int total = 0;
        for (int value : data)
            total += value;
        
        if (background != null)
        	Window.fillBackground(pieChartFrame, background, 500, 500);
        
        // Value Text Container
        pieChartFrame.setColor(Color.LIGHT_GRAY);
        pieChartFrame.fillRect(0, 500, 500, 100);
        pieChartFrame.setColor(Color.GRAY);
        pieChartFrame.fillRect(0, 495, 500, 5);
        
        int i = 1;
        // PieChart
        for (int value : data) {
        	pieChartFrame.setColor(RGBColor.get_random());
        	if (i <= 5)
            	pieChartFrame.fillRect(i*80, 520, 15, 15);
            else 
            	pieChartFrame.fillRect((i-5)*80, 560, 15, 15);
            int slice_size = ((int)((double) value / total * 360 )+1);
            pieChartFrame.fillArc(10, 35, 460, 440, slice_start, slice_size);
            
            // Text Display
            pieChartFrame.setColor(Color.BLACK);
            if (i <= 5) 
            {
            	pieChartFrame.drawRect(i*80, 520, 15, 15);
            	pieChartFrame.drawString(value+"", (i*80)+25, 532);
            }
            else
            {
            	pieChartFrame.drawRect((i-5)*80, 560, 15, 15);
            	pieChartFrame.drawString(value+"", ((i-5)*80)+25, 572);
            }
            pieChartFrame.drawArc(10, 35, 460, 440, slice_start, slice_size);
            slice_start += slice_size;
            i++;
        }
        // Chart Box
        pieChartFrame.drawRect(0, 5, 500, 495);
        pieChartFrame.drawRect(0, 495, 500, 105);
    }
}
