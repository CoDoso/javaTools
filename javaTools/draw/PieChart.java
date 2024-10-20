package javaTools.draw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javaTools.generate.Data;
import javaTools.generate.RGBColor;

@SuppressWarnings("serial")
public class PieChart extends JFrame {
    
    private int[] data;
	/** <b><u>+ Draw a Pie-Chart of your Data! +</u></b><br>
	 *@param data ( int[] ) The Data that you want to be visualized !
	 */
    public PieChart(int[] data) {
        this.data = data;
        setSize(500, 500);
        setLocation(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("PieChart");
        setVisible(true);
        getContentPane().setBackground(new Color(255,255,255));
    }
    @Override
    public void paint(Graphics stift) {
        super.paint(stift);
        int slice_start = Data.random.nextInt(360);
        int total = 0;

        for (int value : data)
            total += value;

        for (int value : data) {
        	stift.setColor(RGBColor.get_random());
            int slice_size = ((int)((double) value / total * 360 )+1);
            stift.fillArc(10, 35, 460, 440, slice_start, slice_size);
            stift.setColor(Color.BLACK);
            stift.drawArc(10, 35, 460, 440, slice_start, slice_size);
            slice_start += slice_size;
        }
    }
}
