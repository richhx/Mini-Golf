/**
 *  This class represents a ball, which travels across the screen with a
 *  decreasing velocity. It can collide with walls, changing how it moves.
 *  The ball can be moved by user input from the mouse.  
 *  Author: Sean McEntee	Date: May 31, 2013
 */
 
 import java.awt.*;
 import javax.swing.*;
 
public class Ball 
{
	private double xVel;	//velocity in x direction
	private double yVel;	//velocity in y direction
	private double x;	 	//position on x 
	private double y;	 	//position on y
	private ImageIcon icon;	//perceived image
 
 	/* Constructor */
 	public Ball(Image myIcon, double myX, double myY)
 	{
 		xVel = 0;
 		yVel = 0;
 		x = myX;
 		y = myY;
 		icon = new ImageIcon(myIcon);
 	}
 	
 	/* Methods */
	//sets position of ball
 	public void setPosition(int myX, int myY)
 	{
 		x = myX;
 		y = myY;
 	}

 	//returns x coordinate	
 	public double getX()
 	{
 		return x;
 	}
 	
 	//returns y coordinate
 	public double getY()
 	{
 		return y;
 	}
 	
 	//returns x velocity
 	public double getXVel()
 	{
 		return xVel;
 	}
 	
 	//returns y velocity
  	public double getYVel()
 	{
 		return yVel;
 	}
 	
	//returns image used for repainting
  	public Image getImage()
 	{
 		return icon.getImage();
 	}

 	//returns if ball is not moving
 	public boolean stopped()
 	{
 		return (xVel == 0 && yVel == 0);
 	}
 	
 	//sets x and y velocities to specified values
 	public void setVelocity(double xV, double yV)
 	{
 		xVel = xV;
 		yVel = yV;
 	}
 	
 	//moves the ball and reduces its velocity at a rate specified parameters
 	public void move(double xMod, double yMod)
 	{
 		//change position
 		x += xVel;
 		y += yVel;
 		
 		//adjust x velocity
 		if (xVel < 0)
 			xVel += xMod;
 		else if (xVel > 0)
 			xVel -= xMod; 
 			
 		//if x speed is less than its slow rate, stop it
 		if (xVel <= xMod && xVel >= -1 * xMod)
 			xVel = 0;
 		
 		//adjust y velocity
 		if (yVel < 0)
 			yVel += yMod;
 		else if (yVel > 0)
 			yVel -= yMod; 
 			
 		//if y speed is less than its slow rate, stop it
 		if (yVel <= yMod && yVel >= -1 * yMod)
 			yVel = 0;
 	}
 	
 	//handles collision with a wall, adjusting the ball's velocity accordingly
 	public boolean collide(Wall wall)
 	{
 		Rectangle ballArea = getBounds();
 		Rectangle wallArea = wall.getBounds();
 		if (ballArea.intersects(wallArea))
 		{
 			if (horizontalCollision(ballArea, wall))
 				xVel *= -1;
 			else
 				yVel *= -1;
 			return true;
 		}
 		return false;
 	}	
 		
 	//detects whether the collision was horizontal or vertical based
 	//the shape of the overlapping area
 	public boolean horizontalCollision(Rectangle ball, Wall wall)	
 	{
 		Rectangle overlap = ball.intersection(wall.getBounds());
 		int height = (int)overlap.getHeight();
 		int width = (int)overlap.getWidth();
 		return (height > width);
 	}
 
 	//returns the area occupied by the ball's image in the form of a Rectangle
 	public Rectangle getBounds()
 	{
 		return new Rectangle((int)x, (int)y, icon.getIconWidth(),
 					 icon.getIconHeight());
 	}	
 }