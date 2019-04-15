package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block{
	
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
      speed =5;
   }


   //add the other Paddle constructors

   public Paddle(int x, int y) {
	   super(x,y);
	   speed = 5;
   }

   public Paddle(int x, int y, int w, int h) {
	   super(x,y,w,h);
	   speed = 5;
   }
   
   public Paddle(int x, int y, int s) {
	   super(x,y);
	   speed = s;
   }
   
   public Paddle(int x, int y, int w, int h, int s) {
	   super(x,y,w,h);
	   speed = s;
   }
   
   public Paddle(int x, int y, int w, int h, Color c) {
	   super(x,y,w,h,c);
	   speed = 5;
   }

   public Paddle(int x, int y, int w, int h, Color c, int s) {
	   super(x,y,w,h,c);
	   speed = s;
   }

   public void moveUpAndDraw(Graphics window)
   {	
	   if(this.getY() >= speed) {
		   this.setY(this.getY() - speed);
		   this.draw(window);
	   }
   }

   public void moveDownAndDraw(Graphics window)
   {
	   if(this.getY() <= 600-(this.getHeight()) - 25) {
		   this.setY(this.getY() + speed);
		   this.draw(window);
	   }
   }

   //add get methods
   	
   public int getSpeed() {
	   return speed;
   }
   
   //add a toString() method
   
   public String toString() {
	   return getX() + " , " + getY() + " , " + getWidth() + " , " + getHeight() + " , " + getColor() + " , " + speed;
   }
}