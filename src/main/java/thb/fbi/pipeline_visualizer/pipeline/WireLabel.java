/**
 * @author 'SIN
 */
package thb.fbi.pipeline_visualizer.pipeline;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;


public class WireLabel extends JComponent {

    public int x[];
    public int y[];
    public Color color;
    BasicStroke stroke = new BasicStroke(1.0f);
    BasicStroke strokeHard = new BasicStroke(2.5f);

    public WireLabel(int x[],int y[])
    {
        this.x = x;
        this.y = y;
        this.color = Color.BLUE;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(stroke);
        g2.setColor(this.color);
        g2.drawPolyline(x, y, x.length<=y.length ? x.length : y.length );
    }
    public void hardStroke()
    {
        this.stroke = this.strokeHard;
    }
    public void normalStroke()
    {
        this.stroke = new BasicStroke(1.0f);
    }
}
