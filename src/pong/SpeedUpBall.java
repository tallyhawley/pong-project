package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();

   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);

   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {

	   super(x,y);
	   setxSpeed(xSpd);
	   setySpeed(ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {

	   super(x,y,wid,ht,xSpd,ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col,xSpd,ySpd);
   }

   public void setxSpeed( int xSpd )
   {
	   if(xSpd < 0) {
		   super.setxSpeed(xSpd - 1);
	   }
	   else super.setxSpeed(xSpd + 1);

   }

   public void setySpeed( int ySpd )
   {	
	   if(ySpd < 0) {
		   super.setySpeed(ySpd - 1);
	   }
	   else super.setySpeed(ySpd + 1);

   }
}
