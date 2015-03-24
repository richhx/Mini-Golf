/**
 *  This class represents a wall, which acts as a boundary for the map. It 
 *	is represented by an image onscreen and if a ball touches it, the ball
 *	changes direction. 
 *  Author: Sean McEntee	Date: May 14, 2013
 */

 public class Wall 
 {
 	/*ATTRIBUTES*/
 	private int x;				//x coordinate
 	private int y;				//y coordinate
 	private ImageIcon icon;		//image of wall
 	private Rectangle bounds;	//area occupied by wall
 	
 	/*CONSTRUCTORS*/
 	public Wall (Image myIcon, int myX, int myY){}
 	
 	/*METHODS*/
 	//returns the area occupied by the wall's image in the form of a Rectangle
 	public Rectangle getBounds(){}
 }
 	