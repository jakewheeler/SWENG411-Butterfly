package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuBar;

/**
 *
 * @author Jake
 */

// Setting FileMenuBar = CustomFileMenu() successfully changes the background to black. I couldn't figure out how to change the font color.
// I'll leave this file here if anyone wants to mess with it.
public class CustomFileMenu extends JMenuBar
{
    private Color BGColor;

    public CustomFileMenu()
    {
      BGColor = new Color(51, 51, 51);
    }
    
    public void setColor(Color color)
    {
        this.BGColor = color;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(BGColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }
    
}
