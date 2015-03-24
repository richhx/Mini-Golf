/*
 *  This class represents the level. It contains the locations of the walls and hole.
 *  Author: Aryan Zaferani	Date: May 31, 2013
 */
 
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Level
{
	private ArrayList<Wall> walls;
	private Hole hole;
	private int strokes;
//	public Player audioPlayer = null;
		
	/* Constructor */
	public Level(String num)
	{
		walls = new ArrayList<Wall>();
		strokes = 0;
		String levelCode = "";
		
		//loads the level through a file
		try
		{
			Image wall = ImageIO.read(new File("img\\wall_small.png"));
			Image wall2 = ImageIO.read(new File("img\\wall_small2.png"));
			Image wall3 = ImageIO.read(new File("img\\wall_smaller.png"));
			Image wall4 = ImageIO.read(new File("img\\wall_smaller2.png"));
			Image holeIcon = ImageIO.read(new File("img\\hole_small.png"));
			
			Scanner input = new Scanner(new File(num));
			hole = new Hole(holeIcon, input.nextInt(), input.nextInt());
			//loads walls, type 1 for vertical, 2 for horizontal, 3 for half vertical, 4, half horizontal 
			while(input.hasNext())
			{
				int type = input.nextInt();
				if (type == 1)
					walls.add(new Wall(wall, input.nextInt(),input.nextInt()));
				else if (type == 2)
					walls.add(new Wall(wall2, input.nextInt(),input.nextInt()));
				else if (type == 3)
					walls.add(new Wall(wall3, input.nextInt(),input.nextInt()));
				else if(type ==4)
					walls.add(new Wall(wall4, input.nextInt(),input.nextInt()));
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	/* Methods */
	//adds one to number of strokes taken by user
	public void addStroke()
	{
		strokes++;
	}
	
	//returns number of strokes
	public int getStrokes()
	{
		return strokes;
	}
	
	//returns ArrayList of walls in the level
	public ArrayList<Wall> getWalls()
	{
		return walls;
	}
	
	//returns hole in the level
	public Hole getHole()
	{
		return hole;
	}
	
	//returns if level is over
	public boolean levelOver(Ball ball)
	{
		if(ball.getXVel() <= 20 && ball.getYVel() <= 20 &&
		   hole.getBounds().intersects(ball.getBounds()))
			return true;	
		else
			return false;
	}
}