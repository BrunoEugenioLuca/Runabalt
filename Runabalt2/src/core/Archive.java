package core;

import java.awt.Rectangle;

public class Archive extends ObjectsGame{

	
		
	public Archive(double x, double y) {
		super(x, y);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX(),(int)getY(), 32, 32);
	}

	
	
}
