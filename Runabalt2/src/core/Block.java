package core;

import java.awt.Rectangle;

public class Block extends ObjectsGame {

	public Block(double x, double y) {
		super(x, y);

	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) this.x, (int) this.y, 32, 32);
	}

}
