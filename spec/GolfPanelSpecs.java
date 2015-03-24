/**
 *	This class is a type of panel that responds to clicking. It has a background image and 
 *	a ball.
 *  Author: Sean McEntee		Date: May 20, 2013
 */
 
public class GolfPanel extends JPanel implements MouseListener
{
	/*ATTRIBUTES*/
	private Image background;
	private Ball ball;
	private int xDistance;
	private int yDistance;
	
	/*CONSTRUCTOR*/
	public GolfPanel(Image myBackground, Ball myBall){}

	/*METHODS*/
	//returns x distance from cursor at last click
	public int getXDist(){}
	
	//returns y distance from cursor at last click
	public int getYDist(){}
	
	//paints the ball and background
  	public void paintComponent(Graphics g) {}
	
	//Methods required by Mouse Listener; not in use
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    //gets the distance from the mouse when clicked
    public void mouseClicked(MouseEvent e) {}
}