import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * DrawPanel.java
 *
 * Put description here.
 *
 * @author Joel Swanson
 * @version 0.1
 */

public class DrawPanel extends JPanel 
{
    private int diameter;
    private int x;
    private int y;
    
    DrawPanel(int x, int y, int diameter)
    {
        this.diameter = diameter;
        this.x=x;
        this.y=y;
    }
    
    public void setDiameter(int diameter)
    {
        this.diameter = diameter;
    }
    
    public void moveCircle (int dx, int dy)
    {
        x+=dx;
        y+=dy;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int radius = diameter/2;
        g2d.fillOval(x-radius,y-radius,diameter,diameter);
        
    }
}
