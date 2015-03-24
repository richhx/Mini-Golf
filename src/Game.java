/**
 *  This class plays a simulation of mini golf. It intializes
 *	the graphics and lets user control input from mouse.
 *	Game continues to play until user closes frame.
 *  Author: Richard Huang, Sean McEntee		Date: May 31, 2013
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Game
{
	private JFrame frame;		//frame to play game in
	private GolfPanel panel;	//panel that handles graphics and levels
	private Ball ball;			//ball that user controls throughout game
	
	public static void main(String[] args)
	{
		Game golf = new Game();		//woo!
	}
	
	/* Constructor */
	public Game()
	{
		init();
		play();
	}
	
	/* Methods */
	//gets the image && creates the frame and panel
	public void init()
	{
		try 
		{
			Image ballPic = ImageIO.read(new File("img\\ball_small.png"));
			Image background = ImageIO.read(new File("img\\background.png"));
			ball = new Ball(ballPic, 150, 300);
			panel = new GolfPanel(background, ball);
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		
		frame = new JFrame("Mini Golf");
		frame.setSize(720, 720);
		frame.add(panel);
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//plays the game!
	public void play()
	{
		final int FRICTION = 80;	//friction constant
		double xMod = 0, yMod = 0; 	//number velocity will be reduced by every shot		
		long previousUpdate = System.currentTimeMillis();	
			
		while(true)
		{
			long current = System.currentTimeMillis();
			if(current - 30 > previousUpdate) //controls update speed
			{
				previousUpdate = current; //resets timer
				if (ball.stopped() && panel.getShoot())
				{
					double xV, yV;
					//constant that converts pixels to velocity
					final double CONSTANT = -.032; 
					
					//calculates new velocity of ball based on distance from last click
					//to the center of the ball
					double xPower = panel.getXPower();
					xV = CONSTANT * xPower;
					double yPower = panel.getYPower();
					yV = CONSTANT * yPower;
					
					ball.setVelocity(xV, yV);
					xMod = Math.abs(xV / FRICTION);
					yMod = Math.abs(yV / FRICTION);
				}
				ball.move(xMod, yMod);

				//hit detection
				for (Wall wall: panel.getWalls())
				{
					//limits collision checking so that it only occurs
					//when the ball and wall are near each other
					if (Math.abs(ball.getX() - wall.getX()) <= 200)
						ball.collide(wall);
				}
				panel.repaint();		//updates graphics
				panel.setShoot(false);	//waits for next shot
			}
		}
	}
}