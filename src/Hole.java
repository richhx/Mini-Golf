/**
 *  This class represents a hole, which is represented by an image 
 *  and acts as the way to end a level.
 *  Author: Richard Huang	Date: May 31, 2013
 */
 
import java.awt.*;
import javax.swing.*;

public class Hole
{
	private int x;
	private int y;
	private ImageIcon icon;
	private Rectangle bounds;
	
	/* Constructor */
	public Hole(Image myIcon, int myX, int myY)
	{
		icon = new ImageIcon(myIcon);
		x = myX;
		y = myY;
		bounds = new Rectangle(x + 5, y + 5, icon.getIconWidth() - 10, icon.getIconHeight() - 10);
	}
	
	//returns area occupied by hole
	public Rectangle getBounds()
	{
		return bounds;
	} 
	
	//returns x location of hole	
 	public int getX()
 	{
 		return x;
 	}
 	
 	//returns y location of hole
  	public int getY()
 	{
 		return y;
 	}
 	
	//returns image used for repainting
  	public Image getImage()
 	{
 		return icon.getImage();
 	}
}