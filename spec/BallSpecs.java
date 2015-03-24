/**
 *  This class represents a ball, which travels across the screen with a
 *  decreasing velocity and collides with walls, changing how it moves.  
 *  Author: Sean McEntee	Date: May 14, 2013
 */
 
 public class Ball 
 {
 	/*ATTRIBUTES*/
 	private int xVel;				//velocity in x direction
 	private int yVel;				//velocity in y direction
 	private int x;	 				//position on x 
 	private int y;	 				//position on y
 	private ImageIcon icon;			//perceived image
 	private final int FRICTION;		//amount velocity slows every move
 	
 	/*CONSTRUCTORS*/
 	public Ball(Image myIcon, int myX, int myY){}
 	
 	/*METHODS*/
 	public int getX(){}
 	public int getY(){} 
 	public int getXVel(){}
 	public int getYVel(){} 	
 
 	//returns if ball is not moving
 	public boolean stopped(){}
 	
 	//changes xVel and yVel attributes
 	public void setVelocity(int xV, int yV){}
 	
 	//moves the ball and reduces its velocity at a rate specified parameters
 	public void move(int xMod, int yMod){}
 	
 	//handles collision with a wall, adjusting the ball's velocity accordingly
 	public void collide(Wall wall){}	
 			
 	//detects whether the collision was horizontal or vertical based
 	//the shape of the overlapping area
 	public boolean horizontalCollision(Rectangle ball, Wall wall){}
 	
 	//returns the area occupied by the ball's image in the form of a Rectangle
 	public Rectangle getBounds(){}
 	
 	//returns the image representing the image
 	public Image getImage(){}
 }