package core;

import java.awt.Rectangle;


abstract class ObjectsGame{
	
	protected double x,y;
	
	public ObjectsGame(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Rectangle getBounds() {
		return new Rectangle();
	}

	public void update() {
		
	}
	

	

	
}
