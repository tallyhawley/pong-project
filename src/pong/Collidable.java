package pong;

public interface Collidable {
	boolean didCollideLeft(Object o);
	boolean didCollideRight(Object o);
	boolean didCollideTop(Object o);
	boolean didCollideBottom(Object o);
}
