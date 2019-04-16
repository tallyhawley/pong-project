package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;		//keeps track of what keys are pressed

	public PaddleTestTwo()
	{
		//set up all game variables

		//instantiate a Ball
		ball = new Ball();
		
		
		//instantiate a left Paddle
		leftPaddle = new Paddle(40,300, 25, 75, Color.cyan);
		
		
		
		//instantiate a right Paddle
		
		
		rightPaddle = new Paddle(735, 300, 25, 75, Color.pink);


		keys = new boolean[5];


		//set up the Canvas
		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{	
		window.clearRect(0, 0, 800, 600);
		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);

		if(!(ball.getX()>=10 && ball.getX()<=770))
		{
			ball.setxSpeed(-ball.getxSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=550))
		{
			ball.setySpeed(-ball.getySpeed());
		}
		
		// check left paddle collision
		if(ball.didCollideRight(leftPaddle) || ball.didCollideRight(leftPaddle)) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		if(ball.didCollideTop((leftPaddle)) || ball.didCollideBottom(leftPaddle)){
			ball.setySpeed(-ball.getySpeed());
		}
		
		//check right paddle collision
		if(ball.didCollideRight(rightPaddle) || ball.didCollideRight(rightPaddle)) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		if(ball.didCollideTop((rightPaddle)) || ball.didCollideBottom(rightPaddle)){
			ball.setySpeed(-ball.getySpeed());
		}
		
		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(window);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
		//no code needed here
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}		
}