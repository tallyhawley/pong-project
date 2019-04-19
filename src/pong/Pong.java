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

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	private Wall leftWall;
	private Wall rightWall;
	private Wall topWall;
	private Wall bottomWall;


	public Pong()
	{
		//set up all variables related to the game
		
		//instantiate a Ball (TODO UNCOMMENT WHICHEVER VERSION OF THE BALL YOU ARE TESTING
		ball = new Ball();
//		ball = new BlinkyBall();
//		ball = new SpeedUpBall();
				
		//instantiate a left Paddle
		leftPaddle = new Paddle(40,300, 25, 75, Color.cyan);
				
		//instantiate a right Paddle
		rightPaddle = new Paddle(735, 300, 25, 75, Color.pink);
				
		leftScore = 0;
		rightScore = 0;
		
		leftWall = new Wall(0,0,3,600);
		rightWall = new Wall(797,0,3,600);
		topWall = new Wall(0,0, 800, 1);
		bottomWall = new Wall(0, 580, 800, 3);
		
		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.clearRect(0, 0, 800, 600);
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("left score: " + leftScore + " | right score: " + rightScore, 325, 550);

		//see if ball hits left wall or right wall
//		if(!(ball.getX()>=3 && ball.getX()<=780))
//		{
//			if(ball.getX() <= 10) rightScore++;
//			else leftScore++;
//			ball = new Ball();				// TODO UNCOMMENT WHICHEVER VERSION OF THE BALL YOU ARE TESTING
////			ball = new BlinkyBall();
////			ball = new SpeedUpBall();
//		}
		
		if(ball.didCollideLeft(rightWall)) {
			leftScore++;
			ball = new Ball();				// TODO UNCOMMENT WHICHEVER VERSION OF THE BALL YOU ARE TESTING
//			ball = new BlinkyBall();
//			ball = new SpeedUpBall();
		}
		
		if(ball.didCollideRight(leftWall)) {
			rightScore++;
			ball = new Ball();				// TODO UNCOMMENT WHICHEVER VERSION OF THE BALL YOU ARE TESTING
//			ball = new BlinkyBall();
//			ball = new SpeedUpBall();
		}

		//see if the ball hits the top or bottom wall 
//		if(!(ball.getY()>=10 && ball.getY()<=550))
//		{
//			ball.setySpeed(-ball.getySpeed());
//		}
		
		if(ball.didCollideBottom(topWall)) {
			ball.setySpeed(-ball.getySpeed());
		}
		
		if(ball.didCollideTop(bottomWall)) {
			ball.setySpeed(-ball.getySpeed());
		}

		//see if the ball hits the left paddle
		if(ball.didCollideLeft(leftPaddle) || ball.didCollideRight(leftPaddle)) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		if(ball.didCollideTop((leftPaddle)) || ball.didCollideBottom(leftPaddle)){
			ball.setySpeed(-ball.getySpeed());
		}
		
		//see if the ball hits the right paddle
		if(ball.didCollideRight(rightPaddle) || ball.didCollideLeft(rightPaddle)) {
			ball.setxSpeed(-ball.getxSpeed());
		}
		if(ball.didCollideTop(rightPaddle) || ball.didCollideBottom(rightPaddle)){
			ball.setySpeed(-ball.getySpeed());
		}

		//see if the paddles need to be moved
		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'K' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'K' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
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