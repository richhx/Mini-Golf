/**
 *  This class is a JPanel that is adapted to play 2D Mini Golf. It paints all 
 *	the aspects of the game such as the background, "power" line, ball, hole, 
 *  and level. The GolfPanel class also contains the levels that the user will 
 *  play after reaching the hole. The user controls the ball through the mouse.
 *  The user can only shoot when the ball's velocity is zero. The user wins the 
 *  game when he passes all the levels.
 *  Author: Sean McEntee, Richard Huang		Date: May 31, 2013
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class GolfPanel extends JPanel implements MouseListener, MouseMotionListener
{
	private static final int NUM_LEVELS = 4; 	// number of levels
		
	private Image background;	
	private Line2D line;			//direction and power of shot
	private Ball ball;				//ball in the game
	private ArrayList<Level> levels;//available levels
	private int index;				//what level on
	private int xDistance;			//x distance from last release
	private int yDistance;			//y distance from last release
	private int xPressDist;			//x distance from first press
	private int yPressDist;			//y distance from first press
	private boolean shoot;			//holds if user can shoot ball
	private boolean click;			//holds if line can be drawn
	
	/* Constructor */
	public GolfPanel(Image myBackground, Ball myBall)
	{
		background = myBackground;
		line = new Line2D.Double();
		ball = myBall;
		levels = new ArrayList<Level>();
		for(int i = 1; i <= NUM_LEVELS; i++)		//adds the levels
		{
			String hole = "levels/" + i;
			levels.add(new Level(hole));
		}
		index = 0;
		xDistance = 0;
		yDistance = 0;
		xPressDist = 0;
		yPressDist = 0;
		click = false;
		shoot = false;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	//returns if can shoot
	public boolean getShoot()
	{
		return shoot;
	}
	
	//sets if can shoot
	public void setShoot(boolean myShoot)
	{
		shoot = myShoot;
	}
	
	//returns power in x direction
    public int getXPower()
   	{
    	return xDistance - xPressDist;
    }
	
	//returns power in y direction
	public int getYPower()
   	{
  		return yDistance - yPressDist;
   	}

	//returns the level the user is on
	public Level getCurrentLevel()
	{
		return levels.get(index);
	}

	//returns the walls in the current level
   	public ArrayList<Wall> getWalls()
   	{
    	return getCurrentLevel().getWalls();
   	}
	
	//This paints the background and the components of the level
  	public void paintComponent(Graphics g) 
  	{
		Level level = getCurrentLevel();
  		Graphics2D g2 = (Graphics2D)g;
  		g2.setColor(Color.YELLOW);
  		Hole hole = level.getHole();
  		String strokes = "Strokes " + level.getStrokes();
  		
  		g.drawImage(background, 0, 0, null);//background
  		for (Wall wall : level.getWalls())	//walls
    		g.drawImage(wall.getImage(), wall.getX(), wall.getY(), null);
		g.drawImage(hole.getImage(), hole.getX(), hole.getY(), null);			//hole
    	g.drawImage(ball.getImage(), (int)ball.getX(), (int)ball.getY(), null);	//ball
		g2.drawString(strokes, 10, 15);	//strokes

		if(ball.stopped() && click)		
		{
			g2.setColor(Color.BLACK);	//power && direction line
			g2.draw(line);
		}
		
		if(level.levelOver(ball))		//deals with level over
		{
			//score based on strokes
			int numStrokes = level.getStrokes();
			JFrame box = new JFrame("Score");
			JTextField word = new JTextField();
			word.setEditable(false);
			
			if(numStrokes == 1)	
				word.setText("\t        Hole in One!");
			else if(numStrokes == 2)
				word.setText("\t        Birdie!");
			else if(numStrokes == 3)
				word.setText("\t        Par!");
			else if(numStrokes == 4)
				word.setText("\t        Bogey!");
			else	
				word.setText("\t   Great Scott, you're bad!");
				
			box.add(word);
			box.setLocationRelativeTo(null);
			box.setSize(300, 100);
			box.setVisible(true);	
			
			//message when win game
			if(index == 3)
			{
				ball.setPosition(0,0);
				ball.setVelocity(0,0);
				JFrame over = new JFrame("All Holes Complete!");
				JTextField congrats = new JTextField("\t Congratulations!");
				congrats.setEditable(false);
				over.add(congrats);
				over.setSize(300, 100);
				over.setVisible(true);	
				over.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			//if game not over, go to next level
			else
			{
				ball.setPosition(150, 300);
				ball.setVelocity(0, 0);
				index++;
			}
		}
  	}
	
	//Methods required by Mouse Listener && MouseMotionListener; not in use
   	public void mouseEntered(MouseEvent e) {}
  	public void mouseExited(MouseEvent e) {}
   	public void mouseClicked(MouseEvent e) {}
   	public void mouseMoved(MouseEvent e) {}
    
    //sets variables when mouse pressed
    public void mousePressed(MouseEvent e)
	{	
    	click = true;			//allows line to be drawn
		xPressDist = e.getX();
		yPressDist = e.getY();
   	}
   	
    //sets variables when mouse released
    public void mouseReleased(MouseEvent e) 
   	{
		shoot = true;	//allows ball to move
    	click = false;	//does not allow line to be drawn
    	if(ball.stopped())
   			getCurrentLevel().addStroke();
   	}
    
    //sets position of mouse and sets line
	public void mouseDragged(MouseEvent e)
	{
		xDistance = e.getX();
		yDistance = e.getY();
		int ballX = (int)ball.getX();
		int ballY = (int)ball.getY();
		
		//makes points
		Point ball = new Point(ballX + 10, ballY + 10);
		Point power = new Point(ballX + getXPower(), ballY + getYPower());
		line = new Line2D.Double(ball, power);
	}
}