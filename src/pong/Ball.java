package pong;


import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200, 20, 20, Color.gray);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	
	public Ball(int x, int y) {
		super(x,y, 20, 20, Color.gray);
		xSpeed = 3;
		ySpeed = 1;
	}
	
	public Ball(int x, int y, int xs, int ys) {
		super(x,y, 20, 20, Color.gray);
		xSpeed = xs;
		ySpeed = ys;
	}
	
   //add the set methods
   
	public void setxSpeed(int xs) {
		xSpeed = xs;
	}
	
	public void setySpeed(int ys) {
		ySpeed = ys;
	}

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location


      setX(getX()+xSpeed);
      setY(getY() + ySpeed);

		//draw the ball at its new location
      draw(window);
   }
   
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Ball b = (Ball) obj;
		
		return (b.getWidth() == getWidth()) && (getHeight() == b.getHeight()) && (getxSpeed() == b.getxSpeed()) && (getySpeed() == b.getySpeed());
	}   

   //add the get methods
	
	public int getxSpeed() {
		return xSpeed;
	}
	
	public int getySpeed() {
		return ySpeed;
	}

   //add a toString() method
	public String toString() {
		return super.toString() + " , " + xSpeed + " , " + ySpeed;
	}

@Override
public boolean didCollideLeft(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean didCollideRight(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean didCollideTop(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean didCollideBottom(Object o) {
	// TODO Auto-generated method stub
	return false;
}
}