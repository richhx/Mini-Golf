/**
 *  This class acts as a barrier that changes the direction of the ball.
 *  Author: Sean McEntee	Date: May 31, 2013
 */
 
 import java.awt.*;
 import javax.swing.*;
 
 public class Wall 
 {
 	
 	private int x;				//x coordinate
 	private int y;				//y coordinate
 	private ImageIcon icon;		//image of wall
 	private Rectangle bounds;	//area occupied by wall
 	
 	/* Constructor */
 	public Wall (Image myIcon, int myX, int myY)
 	{
 		x = myX;
 		y = myY;
 		icon = new ImageIcon(myIcon);
 		bounds = new Rectangle(x, y, icon.getIconWidth(), icon.getIconHeight());
 	}
 	
 	//returns the area occupied by the wall's image in the form of a Rectangle
 	public Rectangle getBounds()
 	{
 		return bounds;
 	}
 	
 	//returns the x location of the wall
 	public int getX()
 	{
 		return x;
 	}
 	
 	//returns the y location of the wall
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