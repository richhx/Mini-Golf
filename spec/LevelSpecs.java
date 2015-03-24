/**
 *  This class represents the level. It contains the locations of the walls and hole.
 *  Author: Aryan Zaferani	Date: May 20, 2013
 */

public class Level
{
	/*ATTRIBUTES*/
	private ArrayList<Wall> walls;
	private Hole hole;
	private int strokes;
	private final int PAR = 3;
	
	/*CONSTRUCTOR*/
	public Level(){}
	
	/*METHODS*/
	//This method adds 1 to the number of strokes taken in the level
	public void addStroke(){}
	
	//This method returns if level is over when ball occupies the hole's area
	public boolean levelOver(){}
}